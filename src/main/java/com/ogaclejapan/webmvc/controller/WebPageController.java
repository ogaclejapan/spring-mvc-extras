package com.ogaclejapan.webmvc.controller;

import com.ogaclejapan.webmvc.AcceptPageBuilder;
import com.ogaclejapan.webmvc.ForwardUrlBuilder;
import com.ogaclejapan.webmvc.Page;
import com.ogaclejapan.webmvc.RedirectUrlBuilder;
import com.ogaclejapan.webmvc.RejectPageBuilder;
import com.ogaclejapan.webmvc.WebException;
import com.ogaclejapan.webmvc.util.WebPageUtils;

/**
 * メソッドチェーンで{@link Page}型モデルを処理するページ用のコントローラー.
 * <p>このコントローラでは{@link Page}型モデルを戻り値として使用することを前提としている
 * @author ogaclejapan
 * @see WebPageUtils
 */
public abstract class WebPageController {

	//__/__/__/__/__/__/__/__/__/__/
	// Methods
	//__/__/__/__/__/__/__/__/__/__/

	/**
	 * リクエスト要求を受け入れる
	 * @return {@link AcceptPageBuilder}
	 * @see #ok(String)
	 */
	protected AcceptPageBuilder ok() {
		return WebPageUtils.ok();
	}
	
	/**
	 * リクエスト要求を受け入れる
	 * @param viewName 描画するビュー名
	 * @return {@link AcceptPageBuilder}
	 * @see #ok()
	 */
	protected AcceptPageBuilder ok(String viewName) {
		return WebPageUtils.ok(viewName);
	}
	
	/**
	 * リクエスト要求を破棄する
	 * @return {@link RejectPageBuilder}
	 * @see #reject(String)
	 */
	protected RejectPageBuilder reject() {
		return WebPageUtils.reject();
	}
	
	/**
	 * リクエスト要求を破棄する
	 * @param viewName 描画するビュー名
	 * @return {@link RejectPageBuilder}
	 * @see #reject()
	 */
	protected RejectPageBuilder reject(String viewName) {
		return WebPageUtils.reject(viewName);
	}
	
	/**
	 * リクエスト要求を破棄する
	 * @param e {@link WebException}
	 * @return {@link RejectPageBuilder}
	 * @see #reject(String, WebException)
	 */
	protected RejectPageBuilder reject(WebException e) {
		 return WebPageUtils.reject(e);
	}
	
	/**
	 * リクエスト要求を破棄する
	 * @param viewName 描画するビュー名
	 * @param e {@link WebException}
	 * @return {@link RejectPageBuilder}
	 * @see #reject(WebException)
	 */
	protected RejectPageBuilder reject(String viewName, WebException e) {
		return WebPageUtils.reject(viewName, e);
	}
	
	/**
	 * リクエスト要求をフォワード転送する
	 * @param url 転送先パス
	 * @return {@link ForwardUrlBuilder}
	 * @see #redirect(String)
	 * @see #redirect301(String)
	 */
	protected ForwardUrlBuilder forward(String url) {
		return WebPageUtils.forward(url);
	}
	
	/**
	 * リクエスト要求を302リダイレクト転送する
	 * @param url 転送先URL
	 * @return {@link RedirectUrlBuilder}
	 * @see #redirect301(String)
	 */
	protected RedirectUrlBuilder redirect(String url) {
		return WebPageUtils.redirect(url);
	}
	
	/**
	 * リクエスト要求を301リダイレクト転送する
	 * @param url 転送先URL
	 * @return {@link RedirectUrlBuilder}
	 * @see #redirect(String)
	 */
	protected RedirectUrlBuilder redirect301(String url) {
		return WebPageUtils.redirect301(url);
	}
	
}
