package com.ogaclejapan.webmvc;


/**
 * メソッドチェーンでトースト通知モデルを処理するインタフェース.
 * @author ogaclejapan
 *
 * @param <T>
 */
public interface ToastChain<T> {
	
	/**
	 * 任意のメッセージをトースト通知モデルに加える
	 * @param message 通知するメッセージ
	 * @return <T>
	 */
	T toast(String message);

	/**
	 * 任意のメッセージをトースト通知モデルに加える
	 * @param message 通知するメッセージ
	 * @param type {@link ToastType 重要度}
	 * @return <T>
	 */
	T toast(String message, ToastType type);
	
	/**
	 * 任意のメッセージをトースト通知モデルに加える
	 * @param message 通知するメッセージ
	 * @param title 通知するタイトル
	 * @return <T>
	 */
	T toast(String message, String title);
	
	/**
	 * 任意のメッセージをトースト通知モデルに加える
	 * @param message 通知するメッセージ
	 * @param title 通知するタイトル
	 * @param type {@link ToastType 重要度}
	 * @return <T>
	 */
	T toast(String message, String title, ToastType type);

	/**
	 * 条件に一致する場合のみトースト通知モデルを{@link ToastIfHandler}で処理する
	 * @param condition condition trueの場合のみ処理される
	 * @param then 条件によりアラート通知モデルを処理する{@link ToastIfHandler}
	 * @return <T>
	 */
	T toastIf(boolean condition, ToastIfHandler then);
	
	/**
	 * 条件によりトースト通知モデルを次の{@link ToastIfHandler then}, {@link ToastIfHandler elze}どちらかで処理する
	 * @param condition どちらの処理を実行するか判断するための条件
	 * @param then conditionがtrueの場合に実行される{@link ToastIfHandler}
	 * @param elze conditionがfalseの場合に実行される{@link ToastIfHandler}
	 * @return <T>
	 */
	T toastIf(boolean condition, ToastIfHandler then, ToastIfHandler elze);

}
