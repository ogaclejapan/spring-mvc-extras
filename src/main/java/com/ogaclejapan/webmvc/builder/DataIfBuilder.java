package com.ogaclejapan.webmvc.builder;

/**
 * 条件によりモデルデータをメソッドチェーンで組み立てるインタフェース
 * @author ogaclejapan
 *
 * @param <T>
 * @see DataBuilder#dataIf(boolean)
 * @see DataIfInternalHandler
 */
public interface DataIfBuilder<T> {
	
	/**
	 * モデルにデータを追加する
	 * @param key モデル内のデータを特定するキー名
	 * @param value 追加するデータ値
	 * @return <T>
	 */
	T then(String key, Object value);

}
