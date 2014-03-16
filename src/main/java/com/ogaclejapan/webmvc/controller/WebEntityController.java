package com.ogaclejapan.webmvc.controller;

import org.springframework.http.HttpStatus;

import com.ogaclejapan.webmvc.AcceptEntityBuilder;
import com.ogaclejapan.webmvc.Entity;
import com.ogaclejapan.webmvc.RejectEntityBuilder;
import com.ogaclejapan.webmvc.WebException;
import com.ogaclejapan.webmvc.util.WebEntityUtils;

/**
 * メソッドチェーンで{@link Entity}型モデルを処理するAPI用コントローラー.
 * <p>このコントローラでは{@link Entity}型モデルを戻り値として使用することを前提としている 
 * @author ogaclejapan
 * @see WebEntityUtils
 */
public abstract class WebEntityController {
	
	//__/__/__/__/__/__/__/__/__/__/
	// Methods
	//__/__/__/__/__/__/__/__/__/__/

	/**
	 * リクエスト要求を受け入れる
	 * @return {@link AcceptEntityBuilder}
	 */
	protected AcceptEntityBuilder ok() {
		return WebEntityUtils.ok();
	}
	
	/**
	 * リクエスト要求を破棄する
	 * @return {@link RejectEntityBuilder}
	 * @see #reject(HttpStatus)
	 */
	protected RejectEntityBuilder reject() {
		return WebEntityUtils.reject();
	}
	
	/**
	 * リクエスト要求を破棄する
	 * @param status 応答する{@link HttpStatus}コード
	 * @return {@link RejectEntityBuilder}
	 */
	protected RejectEntityBuilder reject(HttpStatus status) {
		return WebEntityUtils.reject(status);
	}
	
	/**
	 * リクエスト要求を破棄する
	 * @param e {@link WebException}
	 * @return {@link RejectEntityBuilder}
	 */
	protected RejectEntityBuilder reject(WebException e) {
		return WebEntityUtils.reject(e);
	}

}
