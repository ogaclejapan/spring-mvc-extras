package com.ogaclejapan.webmvc.util;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.RedirectView;

import com.ogaclejapan.webmvc.AcceptPageBuilder;
import com.ogaclejapan.webmvc.ForwardUrlBuilder;
import com.ogaclejapan.webmvc.RedirectUrlBuilder;
import com.ogaclejapan.webmvc.RejectPageBuilder;
import com.ogaclejapan.webmvc.WebException;

/**
 * {@link ModelAndView}を拡張して返却モデルをメソッドチェーンで記述できるWebページ用ユーティリティ
 * @author ogaclejapan
 *
 */
public abstract class WebPageUtils {
	
	//__/__/__/__/__/__/__/__/__/__/
	// Static Methods
	//__/__/__/__/__/__/__/__/__/__/
	
	/**
	 * リクエスト要求を受け入れる
	 * @return {@link AcceptPageBuilder}
	 * @see #ok(String)
	 */
	public static AcceptPageBuilder ok() {
		return new AcceptPageBuilder();
	}
	
	/**
	 * リクエスト要求を受け入れる
	 * @param viewName 描画するビュー名
	 * @return {@link AcceptPageBuilder}
	 * @see #ok()
	 */
	public static AcceptPageBuilder ok(String viewName) {
		if (!StringUtils.hasText(viewName)) {
			throw new IllegalArgumentException("'viewName' must be not empty.");
		}
		return new AcceptPageBuilder(viewName);
	}
	
	/**
	 * リクエスト要求を破棄する
	 * @return {@link RejectPageBuilder}
	 * @see #reject(String)
	 */
	public static RejectPageBuilder reject() {
		return new RejectPageBuilder();
	}
	
	/**
	 * リクエスト要求を破棄する
	 * @param viewName 描画するビュー名
	 * @return {@link RejectPageBuilder}
	 * @see #reject()
	 */
	public static RejectPageBuilder reject(String viewName) {
		if (!StringUtils.hasText(viewName)) {
			throw new IllegalArgumentException("'viewName' must be not empty.");
		}
		return new RejectPageBuilder(viewName);
	}
	
	/**
	 * リクエスト要求を破棄する
	 * @param e {@link WebException}
	 * @return {@link RejectPageBuilder}
	 * @see #reject(String, WebException)
	 */
	public static RejectPageBuilder reject(WebException e) {
		return new RejectPageBuilder(e.getModelMap());
	}
	
	/**
	 * リクエスト要求を破棄する
	 * @param viewName 描画するビュー名
	 * @param e {@link WebException}
	 * @return {@link RejectPageBuilder}
	 * @see #reject(WebException)
	 */
	public static RejectPageBuilder reject(String viewName, WebException e) {
		return new RejectPageBuilder(viewName, e.getModelMap());
	}
	
	/**
	 * リクエスト要求をフォワード転送する
	 * @param url 転送先パス
	 * @return {@link RedirectUrlBuilder}
	 * @see #redirect(String)
	 * @see #redirect301(String)
	 */
	public static ForwardUrlBuilder forward(String url) {
		if (!StringUtils.hasText(url)) {
			throw new IllegalArgumentException("'url' must be not empty");
		}
		return new ForwardUrlBuilder(new InternalResourceView(url));
	}
	
	/**
	 * リクエスト要求を302リダイレクト転送する
	 * @param url 転送先URL
	 * @return {@link RedirectUrlBuilder}
	 * @see #redirect301(String)
	 */
	public static RedirectUrlBuilder redirect(String url) {
		return redirect(url, RedirectType.Temporarily);
	}
	
	/**
	 * リクエスト要求を301リダイレクト転送する
	 * @param url 転送先URL
	 * @return {@link RedirectUrlBuilder}
	 * @see #redirect(String)
	 */
	public static RedirectUrlBuilder redirect301(String url) {
		return redirect(url, RedirectType.Permanently);
	}
	
	private static RedirectUrlBuilder redirect(String url, RedirectType type) {
		if (!StringUtils.hasText(url)) {
			throw new IllegalArgumentException("'url' must be not empty");
		}
		final boolean contextRelative = url.startsWith("/");
		RedirectView view = new RedirectView(url, contextRelative);
		view.setStatusCode(type.status());
		return new RedirectUrlBuilder(view);
	}
	

	//__/__/__/__/__/__/__/__/__/__/
	// Types
	//__/__/__/__/__/__/__/__/__/__/

	/**
	 * リダイレクト転送タイプ値
	 * @author ogaclejapan
	 *
	 */
	static enum RedirectType {

		/** 恒久的なリダイレクト {@link HttpStatus#MOVED_PERMANENTLY} */
		Permanently(HttpStatus.MOVED_PERMANENTLY),
		
		/** 一時的なリダイレクト {@link HttpStatus#FOUND} */
		Temporarily(HttpStatus.FOUND);

		private final HttpStatus status;

		private RedirectType(HttpStatus status) {
			this.status = status;
		}

		public HttpStatus status() {
			return status;
		}
	}
}
