package com.ogaclejapan.webmvc;

import org.springframework.http.HttpStatus;

import com.ogaclejapan.webmvc.builder.AcceptEntityBuilder;
import com.ogaclejapan.webmvc.builder.RejectEntityBuilder;
import com.ogaclejapan.webmvc.model.Entity;
import com.ogaclejapan.webmvc.util.WebEntityUtils;

/**
 * {@link Entity}で返却する処理をメソッドチェーンで記述できるAPI用のコントローラー
 * <p>このクラスのメソッドは{@link Entity}を戻り値とすることを前ß提としている 
 * @author ogaclejapan
 * @see WebEntityUtils
 */
public abstract class WebEntityController {
	
	//__/__/__/__/__/__/__/__/__/__/
	// Methods
	//__/__/__/__/__/__/__/__/__/__/

	/**
	 * リクエストを受け入れる
	 * @return
	 */
	protected AcceptEntityBuilder ok() {
		return WebEntityUtils.ok();
	}
	
	/**
	 * リクエストを破棄する
	 * @return
	 * @see #reject(HttpStatus)
	 */
	protected RejectEntityBuilder reject() {
		return WebEntityUtils.reject();
	}
	
	/**
	 * リクエストを破棄する
	 * @param status
	 * @return
	 */
	protected RejectEntityBuilder reject(HttpStatus status) {
		return WebEntityUtils.reject(status);
	}

}
