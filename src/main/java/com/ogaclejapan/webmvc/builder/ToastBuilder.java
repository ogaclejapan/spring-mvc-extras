package com.ogaclejapan.webmvc.builder;

import com.ogaclejapan.webmvc.model.ToastType;

/**
 * メソッドチェーンでトースト通知データモデルを組み立てるためのインターフェース.
 * @author ogaclejapan
 *
 * @param <T>
 */
public interface ToastBuilder<T> {
	
	/**
	 * メッセージを通知する
	 * @param message 通知するメッセージ
	 * @return <T>
	 */
	T toast(String message);

	/**
	 * メッセージを通知する
	 * @param message 通知するメッセージ
	 * @param type {@link ToastType}
	 * @return <T>
	 */
	T toast(String message, ToastType type);
	
	/**
	 * メッセージを通知する
	 * @param message 通知するメッセージ
	 * @param title <T>
	 * @return
	 */
	T toast(String message, String title);
	
	/**
	 * メッセージを通知する
	 * @param message 通知するメッセージ
	 * @param title 通知のタイトル
	 * @param type {@link ToastType}
	 * @return <T>
	 */
	T toast(String message, String title, ToastType type);

	/**
	 * conditionが真の場合のみメッセージを通知する
	 * @param condition
	 * @return {@link ToastIfBuilder}
	 */
	ToastIfBuilder<T> toastIf(boolean condition);
	
}
