package com.ogaclejapan.webmvc;

/**
 * 条件によりトースト通知モデルを処理するハンドラ.
 * @author ogaclejapan
 *
 */
public interface ToastIfHandler {
	
	/**
	 * 何も処理しないnullオブジェクト
	 */
	public static final ToastIfHandler NULL = new ToastIfHandler() {
		@Override
		public void call(ToastBuilder builder) { }
	};
	
	/**
	 * トースト通知モデルを処理する
	 * <p>条件に一致する場合に呼び出される
	 * @param builder
	 */
	void call(ToastBuilder builder);

}
