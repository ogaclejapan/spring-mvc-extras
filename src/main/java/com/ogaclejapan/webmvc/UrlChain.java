package com.ogaclejapan.webmvc;

/**
 * メソッドチェーンでURLを処理するインタフェース.
 * @author ogaclejapan
 *
 * @param <T>
 */
public interface UrlChain<T> {
	
	/**
	 * 任意のパス文字列をURLに加える
	 * @param path
	 * @return <T>
	 */
	T path(String path);
	
	/**
	 * 任意のクエリー文字列をURLに加える
	 * @param query {@code 'key=value'}
	 * @return <T>
	 */
	T query(String query);

	/**
	 * 任意のクエリー文字列をURLに加える
	 * @param name パラメータ名
	 * @param values 値
	 * @return <T>
	 */
	T queryParam(String name, Object... values);
	
	/**
	 * 任意のフラグメントをURLに加える
	 * @param fragment フラグメント名
	 * @return <T>
	 */
	T fragment(String fragment);

}
