package com.ogaclejapan.webmvc.builder;

import org.springframework.web.servlet.ModelAndView;

import com.ogaclejapan.webmvc.model.AlertType;
import com.ogaclejapan.webmvc.model.ToastType;

/**
 * {@link ModelAndView}のモデルをメソッドチェーンで組み立てるためのインターフェース.
 * @author ogaclejapan
 *
 * @param <T>
 */
public interface ModelBuilder<T> {
	
	static final String TOAST_ATTRIBUTE_NAME = "__toast";
	static final String ALERT_ATTRIBUTE_NAME = "__alert";

	
	/**
	 * モデルを追加する
	 * @param attributeName
	 * @param attributeValue
	 * @return
	 */
	T model(String attributeName, Object attributeValue);
	
	/**
	 * Viewのページ描画完了時にトースト形式でメッセージを通知する
	 * @param message
	 * @return
	 */
	T toast(String message);

	/**
	 * Viewのページ描画完了時にトースト形式でメッセージを通知する
	 * @param message
	 * @param type {@link ToastType#code()}の値によって表示色が変わる
	 * @return
	 */
	T toast(String message, ToastType type);
	
	/**
	 * Viewのページ描画完了時にトースト形式でメッセージを通知する
	 * @param message
	 * @param title
	 * @return
	 */
	T toast(String message, String title);
	
	/**
	 * Viewのページ描画完了時にトースト形式でメッセージを通知する
	 * @param message
	 * @param title
	 * @param type {@link ToastType#code()}の値によって表示色が変わる
	 * @return
	 */
	T toast(String message, String title, ToastType type);
	
	/**
	 * Viewのページ描画完了時にアラート形式でメッセージを通知する
	 * @param message
	 * @return
	 */
	T alert(String message);
	
	/**
	 * Viewのページ描画完了時にアラート形式でメッセージを通知する
	 * @param message
	 * @param type {@link AlertType#code()の値によって表示色が変わる
	 * @return
	 */
	T alert(String message, AlertType type);
	
	/**
	 * Viewのページ描画完了時にアラート形式でメッセージを通知する
	 * @param message
	 * @param title
	 * @return
	 */
	T alert(String message, String title);
	
	/**
	 * Viewのページ描画完了時にアラート形式でメッセージを通知する
	 * @param message
	 * @param title
	 * @param type {@link AlertType#code()の値によって表示色が変わる
	 * @return
	 */
	T alert(String message, String title, AlertType type);
	

}
