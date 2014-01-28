package com.ogaclejapan.webmvc.builder;

import org.springframework.http.HttpStatus;

/**
 * {@link Exception}内の返却モデルをメソッドチェーンで組み立てるためのインタフェース
 * @author ogaclejapan
 *
 * @param <T>
 * @see ModelBuilder
 */
public interface ExceptionModelBuilder<T> extends ModelBuilder<T> {
	
	static final String STATUS_ATTRIBUTE_NAME = "__status";
	
	/**
	 * レスポンスとして返却するHTTPステータスコードを設定する
	 * @param status {@link HttpStatus}
	 * @return <T>
	 */
	T status(HttpStatus status);
	
	/**
	 * 設定されたHttpステータスコードを取得する
	 * @return {@link HttpStatus}
	 */
	HttpStatus getStatus();

}
