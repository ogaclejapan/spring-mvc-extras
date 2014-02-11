package com.ogaclejapan.webmvc;

/**
 * 条件によりデータモデルを処理するハンドラ.
 * @author ogaclejapan
 *
 */
public interface DataIfHandler {
	
	/**
	 * 何も処理しないnullオブジェクト
	 */
	public static final DataIfHandler NULL = new DataIfHandler() {
		@Override
		public void apply(DataBuilder builder) { }
	};
	
	/**
	 * データモデルを処理する
	 * <p>条件に一致する場合のみ呼び出される
	 * @param builder
	 */
	void apply(DataBuilder builder);

}
