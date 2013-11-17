package com.ogaclejapan.webmvc.builder;


/**
 * URLのパスとクエリー文字列をメソッドチェーンで組み立てるためのインタフェース
 * @author ogaclejapan
 *
 */
public interface UrlBuilder<T> {
	
	/**
	 * パス文字列を追加する
	 * @param path
	 * @return
	 */
	T path(String path);
	
	/**
	 * クエリー文字列を追加する
	 * @param query {@code 'key=value'}
	 * @return
	 */
	T query(String query);

	/**
	 * クエリー文字列を追加する
	 * @param name
	 * @param values
	 * @return
	 */
	T queryParam(String name, Object... values);
	
	/**
	 * フラグメントを追加する
	 * @param fragment
	 * @return
	 */
	T fragment(String fragment);
	
}
