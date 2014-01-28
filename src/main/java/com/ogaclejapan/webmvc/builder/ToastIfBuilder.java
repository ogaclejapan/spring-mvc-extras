package com.ogaclejapan.webmvc.builder;

import com.ogaclejapan.webmvc.model.ToastType;

/**
 * 条件によりトースト通知をメソッドチェーンで組み立てるインタフェース
 * @author ogaclejapan
 *
 * @param <T>
 * @see ToastBuilder#toastIf(boolean)
 * @see ToastIfInternalHandler
 */
public interface ToastIfBuilder<T> {
	
	/**
	 * メッセージを通知する
	 * @param message 通知するメッセージ
	 * @return <T>
	 */
	T then(String message);

	/**
	 * メッセージを通知する
	 * @param message 通知するメッセージ
	 * @param type {@link ToastType}
	 * @return <T>
	 */
	T then(String message, ToastType type);
	
	/**
	 * メッセージを通知する
	 * @param message 通知するメッセージ
	 * @param title <T>
	 * @return
	 */
	T then(String message, String title);
	
	/**
	 * メッセージを通知する
	 * @param message 通知するメッセージ
	 * @param title 通知のタイトル
	 * @param type {@link ToastType}
	 * @return <T>
	 */
	T then(String message, String title, ToastType type);

}
