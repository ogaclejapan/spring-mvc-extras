package com.ogaclejapan.webmvc;


/**
 * メソッドチェーンでアラート通知データモデルを組み立てるためのインターフェース.
 * 
 * @author ogaclejapan
 * 
 */
public interface AlertBuilder extends AlertChain<AlertBuilder> {

	/**
	 * アラート通知モデルを格納する属性名
	 */
	static final String ALERT_ATTRIBUTE_NAME = "__alert";

}
