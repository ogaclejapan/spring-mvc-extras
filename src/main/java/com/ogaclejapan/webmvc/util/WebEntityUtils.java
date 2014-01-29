package com.ogaclejapan.webmvc.util;

import org.springframework.http.HttpStatus;

import com.ogaclejapan.webmvc.builder.AcceptEntityBuilder;
import com.ogaclejapan.webmvc.builder.RejectEntityBuilder;
import com.ogaclejapan.webmvc.model.Entity;

/**
 * {@link Entity}を拡張して返却モデルをメソッドチェーンで記述できるAPI用ユーティリティ
 * @author ogaclejapan
 *
 */
public abstract class WebEntityUtils {

	/**
	 * リクエストを受け入れる
	 * @return
	 */
	public static AcceptEntityBuilder ok() {
		return new AcceptEntityBuilder();
	}
	
	/**
	 * リクエストを破棄する
	 * @return
	 */
	public static RejectEntityBuilder reject() {
		return new RejectEntityBuilder();
	}
	
	/**
	 * リクエストを破棄する
	 * @param status
	 * @return
	 */
	public static RejectEntityBuilder reject(HttpStatus status) {
		return new RejectEntityBuilder(status);
	}
}
