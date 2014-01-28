package com.ogaclejapan.webmvc.builder;

/**
 * 条件によりトースト通知をメソッドチェーンで組み立てるインタフェース
 * @author ogaclejapan
 *
 * @param <T>
 */
public interface ModelIfBuilder<T> {
	
	/**
	 * モデルにデータを追加する
	 * @param key モデル内のデータを特定するキー名
	 * @param value 追加するデータ値
	 * @return
	 */
	T then(String key, Object value);

}
