package com.ogaclejapan.webmvc.builder;

import com.ogaclejapan.webmvc.model.AlertType;

/**
 * 条件によりアラート通知をメソッドチェーンで組み立てるインタフェース
 * @author ogaclejapan
 *
 * @param <T>
 * @see AlertBuilder#alertIf(boolean)
 * @see AlertIfInternalHandler
 */
public interface AlertIfBuilder<T> {
	
	/**
	 * メッセージを通知する
	 * @param message 通知するメッセージ
	 * @return <T>
	 */
	T then(String message);
	
	/**
	 * メッセージを通知する
	 * @param message 通知するメッセージ
	 * @param type {@link AlertType}
	 * @return <T>
	 */
	T then(String message, AlertType type);
	
	/**
	 * メッセージを通知する
	 * @param message 通知するメッセージ
	 * @param title 通知のタイトル
	 * @return
	 */
	T then(String message, String title);
	
	/**
	 * メッセージを通知する
	 * @param message 通知するメッセージ
	 * @param title 通知のタイトル
	 * @param type {@link AlertType}
	 * @return
	 */
	T then(String message, String title, AlertType type);

}
