package com.ogaclejapan.webmvc;

/**
 * メソッドチェーンでデータモデルを処理するインタフェース.
 * @author ogaclejapan
 *
 * @param <T>
 */
public interface DataChain<T> {
	
	/**
	 * 任意のデータをモデルに加える
	 * @param key データを特定するためのキー属性名
	 * @param value 任意のデータ
	 * @return <T>
	 */
	T data(String key, Object value);
	
	/**
	 * 条件に一致する場合のみデータモデルを{@link DataIfHandler}で処理する
	 * @param condition trueの場合のみ処理される
	 * @param then 条件によりデータモデルを処理する{@link DataIfHandler}
	 * @return <T>
	 */
	T dataIf(boolean condition, DataIfHandler then);
	
	/**
	 * 条件によりデータモデルを次の{@link DataIfHandler then}, {@link DataIfHandler elze}どちらかで処理する
	 * @param condition どちらの処理を実行するか判断するための条件
	 * @param then conditionがtrueの場合に実行される{@link DataIfHandler}
	 * @param otherwise conditionがfalseの場合に実行される{@link DataIfHandler}
	 * @return <T>
	 */
	T dataIf(boolean condition, DataIfHandler then, DataIfHandler otherwise);

}
