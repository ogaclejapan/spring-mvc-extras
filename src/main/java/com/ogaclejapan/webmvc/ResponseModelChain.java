package com.ogaclejapan.webmvc;

/**
 * メソッドチェーンで応答モデルを処理するインタフェース.
 * @author ogaclejapan
 *
 * @param <T>
 */
public interface ResponseModelChain<T> extends DataChain<T>, ToastChain<T>, AlertChain<T> {

	//Nothing
	
}
