package com.ogaclejapan.webmvc;

import org.springframework.web.servlet.ModelAndView;

import com.ogaclejapan.webmvc.builder.AcceptModelBuilder;
import com.ogaclejapan.webmvc.builder.ForwardUrlBuilder;
import com.ogaclejapan.webmvc.builder.RedirectUrlBuilder;
import com.ogaclejapan.webmvc.builder.RejectModelBuilder;
import com.ogaclejapan.webmvc.util.WebPageUtils;

/**
 * {@link ModelAndView}で返却する処理をメソッドチェーンで記述できるWebページ用のコントローラー
 * <p>このクラスのメソッドは{@link ModelAndView}を戻り値とすることを前提としている
 * @author ogaclejapan
 * @see WebPageUtils
 */
public abstract class WebPageController {

	//__/__/__/__/__/__/__/__/__/__/
	// Methods
	//__/__/__/__/__/__/__/__/__/__/

	/**
	 * リクエストを受け入れる
	 * @return
	 * @see #ok(String)
	 */
	protected AcceptModelBuilder ok() {
		return WebPageUtils.ok();
	}
	
	/**
	 * リクエストを受け入れる
	 * @param viewName 描画するビュー名
	 * @return
	 * @see #ok()
	 */
	protected AcceptModelBuilder ok(String viewName) {
		return WebPageUtils.ok(viewName);
	}
	
	/**
	 * リクエストを破棄する
	 * @return 
	 */
	protected RejectModelBuilder reject() {
		return WebPageUtils.reject();
	}
	
	/**
	 * リクエストをurlにフォワードする
	 * @param url
	 * @return
	 * @see #redirect(String)
	 * @see #redirect301(String)
	 */
	protected ForwardUrlBuilder forward(String url) {
		return WebPageUtils.forward(url);
	}
	
	/**
	 * リクエストをurlに302リダイレクトする
	 * @param url
	 * @return
	 * @see #redirect301(String)
	 */
	protected RedirectUrlBuilder redirect(String url) {
		return WebPageUtils.redirect(url);
	}
	
	/**
	 * リクエストをurlに301リダイレクトする
	 * @param url
	 * @return
	 * @see #redirect(String)
	 */
	protected RedirectUrlBuilder redirect301(String url) {
		return WebPageUtils.redirect301(url);
	}
	
}
