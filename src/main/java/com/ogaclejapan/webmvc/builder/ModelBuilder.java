package com.ogaclejapan.webmvc.builder;

import org.springframework.ui.ModelMap;

/**
 * モデルをメソッドチェーンで組み立てるためのインターフェース.
 * @author ogaclejapan
 *
 * @param <T>
 */
public interface ModelBuilder<T> extends DataBuilder<T>, AlertBuilder<T>, ToastBuilder<T> {
	
	static final String TOAST_ATTRIBUTE_NAME = "__toast";
	static final String ALERT_ATTRIBUTE_NAME = "__alert";

	
	/**
	 * モデルを取得する
	 * @return
	 */
	ModelMap getDataModel();

}
