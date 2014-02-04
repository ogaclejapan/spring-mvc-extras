package com.ogaclejapan.webmvc;


/**
 * メソッドチェーンでトースト通知データモデルを組み立てるためのインターフェース.
 * @author ogaclejapan
 *
 */
public interface ToastBuilder extends ToastChain<ToastBuilder> {
	
	/**
	 * トースト通知モデルを格納する属性名
	 */
	static final String TOAST_ATTRIBUTE_NAME = "__toast";
	
}
