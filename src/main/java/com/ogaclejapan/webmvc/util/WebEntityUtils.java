package com.ogaclejapan.webmvc.util;

import org.springframework.http.HttpStatus;

import com.ogaclejapan.webmvc.AcceptEntityBuilder;
import com.ogaclejapan.webmvc.Entity;
import com.ogaclejapan.webmvc.RejectEntityBuilder;

/**
 * {@link Entity}を拡張して返却モデルをメソッドチェーンで記述できるAPI用ユーティリティ
 * @author ogaclejapan
 *
 */
public abstract class WebEntityUtils {

	/**
	 * リクエスト要求を受け入れる
	 * @return {@link AcceptEntityBuilder}
	 */
	public static AcceptEntityBuilder ok() {
		return new AcceptEntityBuilder();
	}
	
	/**
	 * リクエスト要求を破棄する
	 * @return {@link RejectEntityBuilder}
	 */
	public static RejectEntityBuilder reject() {
		return new RejectEntityBuilder();
	}
	
	/**
	 * リクエスト要求を破棄する
	 * @param status 応答する{@link HttpStatus}コード
	 * @return {@link RejectEntityBuilder}
	 */
	public static RejectEntityBuilder reject(HttpStatus status) {
		return new RejectEntityBuilder(status);
	}
}
