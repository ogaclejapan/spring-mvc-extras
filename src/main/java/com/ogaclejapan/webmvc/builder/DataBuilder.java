package com.ogaclejapan.webmvc.builder;

/**
 * メソッドチェーンでデータモデルを組み立てるためのインターフェース.
 * @author ogaclejapan
 *
 * @param <T>
 */
public interface DataBuilder<T> {
	
	/**
	 * モデルにデータを追加する
	 * @param key モデル内のデータを特定するキー名
	 * @param value 追加するデータ値
	 * @return <T>
	 */
	T data(String key, Object value);
	
	/**
	 * conditionが真の場合のみモデルにデータを追加する
	 * @param condition
	 * @return {@link DataIfBuilder}
	 */
	DataIfBuilder<T> dataIf(boolean condition);

}
