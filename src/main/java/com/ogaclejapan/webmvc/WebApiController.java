package com.ogaclejapan.webmvc;

import org.springframework.http.HttpStatus;

import com.ogaclejapan.webmvc.builder.AcceptEntityBuilder;
import com.ogaclejapan.webmvc.builder.RejectEntityBuilder;
import com.ogaclejapan.webmvc.model.ApiEntity;
import com.ogaclejapan.webmvc.util.WebApiUtils;

/**
 * {@link ApiEntity}で返却する処理をメソッドチェーンで記述できるAPI用のコントローラー
 * <p>このクラスのメソッドは{@link ApiEntity}を戻り値とすることを前ß提としている 
 * @author ogaclejapan
 * @see WebApiUtils
 */
public abstract class WebApiController {
	
	//__/__/__/__/__/__/__/__/__/__/
	// Methods
	//__/__/__/__/__/__/__/__/__/__/

	/**
	 * リクエストを受け入れる
	 * @return
	 */
	protected AcceptEntityBuilder ok() {
		return WebApiUtils.ok();
	}
	
	/**
	 * リクエストを破棄する
	 * @return
	 * @see #reject(HttpStatus)
	 */
	protected RejectEntityBuilder reject() {
		return WebApiUtils.reject();
	}
	
	/**
	 * リクエストを破棄する
	 * @param status
	 * @return
	 */
	protected RejectEntityBuilder reject(HttpStatus status) {
		return WebApiUtils.reject(status);
	}

}
