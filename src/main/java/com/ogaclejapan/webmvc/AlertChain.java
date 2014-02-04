package com.ogaclejapan.webmvc;


/**
 * メソッドチェーンでアラート通知モデルを処理するインタフェース.
 * @author ogaclejapan
 *
 * @param <T>
 */
public interface AlertChain<T> {
	
	/**
	 * 任意のメッセージをアラート通知モデルに加える
	 * @param message 通知するメッセージ
	 * @return <T>
	 */
	T alert(String message);
	
	/**
	 * 任意のメッセージをアラート通知モデルに加える
	 * @param message 通知するメッセージ
	 * @param type {@link AlertType 重要度}
	 * @return <T>
	 */
	T alert(String message, AlertType type);
	
	/**
	 * 任意のメッセージをアラート通知モデルに加える
	 * @param message 通知するメッセージ
	 * @param title 通知するタイトル
	 * @return <T>
	 */
	T alert(String message, String title);
	
	/**
	 * 任意のメッセージをアラート通知モデルに加える
	 * @param message 通知するメッセージ
	 * @param title 通知するタイトル
	 * @param type {@link AlertType 重要度}
	 * @return <T>
	 */
	T alert(String message, String title, AlertType type);
	

	/**
	 * 条件に一致する場合のみアラート通知モデルを{@link AlertIfHandler}で処理する
	 * @param condition trueの場合のみ処理される
	 * @param then 条件によりアラート通知モデルを処理する{@link AlertIfHandler}
	 * @return <T>
	 */
	T alertIf(boolean condition, AlertIfHandler then);

	/**
	 * 条件によりアラート通知モデルを次の{@link AlertIfHandler then}, {@link AlertIfHandler elze}どちらかで処理する
	 * @param condition どちらの処理を実行するか判断するための条件
	 * @param then conditionがtrueの場合に実行される{@link AlertIfHandler}
	 * @param elze conditionがfalseの場合に実行される{@link AlertIfHandler}
	 * @return <T>
	 */
	T alertIf(boolean condition, AlertIfHandler then, AlertIfHandler elze);
	

}
