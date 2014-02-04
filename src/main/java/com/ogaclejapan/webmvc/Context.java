package com.ogaclejapan.webmvc;

/**
 * モデルを操作するためのインタフェース.
 * @author ogaclejapan
 *
 */
public interface Context {
	
	/**
	 * モデルに任意のオブジェクトを加える
	 * @param key
	 * @param value
	 */
	void put(String key, Object value);
	
	/**
	 * key属性に格納されているオブジェクトを取得する
	 * @param key
	 * @return
	 */
	Object get(String key);
	
	/**
	 * key属性のオブジェクトがモデル内に存在するかどうか
	 * @param key
	 * @return 既に存在する場合のみtrueを返す
	 */
	boolean hasValue(String key);

}
