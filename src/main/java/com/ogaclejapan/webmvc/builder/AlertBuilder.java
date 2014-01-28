package com.ogaclejapan.webmvc.builder;

import com.ogaclejapan.webmvc.model.AlertType;

/**
 * メソッドチェーンでアラート通知データモデルを組み立てるためのインターフェース.
 * @author ogaclejapan
 *
 * @param <T>
 */
public interface AlertBuilder<T> {
	
	/**
	 * メッセージを通知する
	 * @param message 通知するメッセージ
	 * @return <T>
	 */
	T alert(String message);
	
	/**
	 * メッセージを通知する
	 * @param message 通知するメッセージ
	 * @param type {@link AlertType}
	 * @return <T>
	 */
	T alert(String message, AlertType type);
	
	/**
	 * メッセージを通知する
	 * @param message 通知するメッセージ
	 * @param title 通知のタイトル
	 * @return
	 */
	T alert(String message, String title);
	
	/**
	 * メッセージを通知する
	 * @param message 通知するメッセージ
	 * @param title 通知のタイトル
	 * @param type {@link AlertType}
	 * @return
	 */
	T alert(String message, String title, AlertType type);
	

	/**
	 * conditionが真の場合のみメッセージを通知する
	 * @param condition
	 * @return {@link AlertIfBuilder}
	 */
	AlertIfBuilder<T> alertIf(boolean condition);

}
