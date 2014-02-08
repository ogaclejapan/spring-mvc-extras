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
	 * 任意のパス文字列をURLに加える
	 * @param path
	 * @param encoding URLエンコードする文字コード
	 * @return <T>
	 */
	T path(String path, String encoding);
	
	/**
	 * 任意のクエリー文字列をURLに加える
	 * @param query {@code 'key=value'}
	 * @return <T>
	 */
	T query(String query);
	
	/**
	 * 任意のクエリー文字列をURLに加える
	 * @param query
	 * @param encoding URLエンコードする文字コード
	 * @return
	 */
	T query(String query, String encoding);

	/**
	 * 任意のクエリー文字列をURLに加える
	 * @param name パラメータ名
	 * @param value 値
	 * @return <T>
	 */
	T queryParam(String name, String value);
	
	/**
	 * 任意のクエリー文字列をURLに加える
	 * @param name パラメータ名
	 * @param value 値
	 * @param encoding URLエンコードする文字コード
	 * @return <T>
	 */
	T queryParam(String name, String value, String encoding);
	
	/**
	 * 任意のフラグメントをURLに加える
	 * @param fragment フラグメント名
	 * @return <T>
	 */
	T fragment(String fragment);
	
	/**
	 * 任意のフラグメントをURLに加える
	 * @param fragment フラグメント名
	 * @param encoding URLエンコードする文字コード
	 * @return <T>
	 */
	T fragment(String fragment, String encoding);

}
