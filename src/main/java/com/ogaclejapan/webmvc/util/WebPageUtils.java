package com.ogaclejapan.webmvc.util;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ogaclejapan.webmvc.builder.AcceptModelBuilder;
import com.ogaclejapan.webmvc.builder.ForwardUrlBuilder;
import com.ogaclejapan.webmvc.builder.RedirectUrlBuilder;
import com.ogaclejapan.webmvc.builder.RejectModelBuilder;

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
	 * リクエストを受け入れる
	 * @return
	 * @see #ok(String)
	 */
	public static AcceptModelBuilder ok() {
		return new AcceptModelBuilder();
	}
	
	/**
	 * リクエストを受け入れる
	 * @param viewName 描画するビュー名
	 * @return
	 * @see #ok()
	 */
	public static AcceptModelBuilder ok(String viewName) {
		if (!StringUtils.hasText(viewName)) {
			throw new IllegalArgumentException("'viewName' must be not empty.");
		}
		return new AcceptModelBuilder(viewName);
	}
	
	/**
	 * リクエストを破棄する
	 * @return 
	 */
	public static RejectModelBuilder reject() {
		return new RejectModelBuilder();
	}
	
	/**
	 * リクエストをurlにフォワードする
	 * @param url
	 * @return
	 * @see #redirect(String)
	 * @see #redirect301(String)
	 */
	public static ForwardUrlBuilder forward(String url) {
		if (!StringUtils.hasText(url)) {
			throw new IllegalArgumentException("'url' must be not empty");
		}
		return new ForwardUrlBuilder(url);
	}
	
	/**
	 * リクエストをurlに302リダイレクトする
	 * @param url
	 * @return
	 * @see #redirect301(String)
	 */
	public static RedirectUrlBuilder redirect(String url) {
		return redirect(url, RedirectType.Temporarily);
	}
	
	/**
	 * リクエストをurlに301リダイレクトする
	 * @param url
	 * @return
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
	 * リダイレクト処理のタイプ値
	 * @author ogaclejapan
	 *
	 */
	static enum RedirectType {

		/** 恒久的なリダイレクト {@link HttpStatus#MOVED_PERMANENTLY} */
		Permanently(HttpStatus.MOVED_PERMANENTLY),
		
		/** 一時的なリダイレクト {@link HttpStatus#MOVED_TEMPORARILY} */
		Temporarily(HttpStatus.MOVED_TEMPORARILY);

		private final HttpStatus status;

		private RedirectType(HttpStatus status) {
			this.status = status;
		}

		public HttpStatus status() {
			return status;
		}
	}
}
