package com.ogaclejapan.webmvc;

/**
 * 条件によりアラート通知モデルを処理するハンドラ.
 * @author ogaclejapan
 *
 */
public interface AlertIfHandler {
	
	/**
	 * 何も処理しないnullオブジェクト
	 */
	public static final AlertIfHandler NULL = new AlertIfHandler() {
		@Override
		public void call(AlertBuilder builder) { }
	};
	
	/**
	 * アラート通知モデルを処理する
	 * <p>条件に一致する場合に呼び出される
	 * @param builder 
	 */
	void call(AlertBuilder builder);

}
