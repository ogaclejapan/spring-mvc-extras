package com.ogaclejapan.webmvc.builder;

/**
 * データ追加の条件ハンドラ
 * @author ogaclejapan
 *
 */
abstract class DataIfInternalHandler {

	/**
	 * builderにデータを追加するbuilderを返します
	 * @param builder
	 * @return
	 */
	static <T extends DataBuilder<T>> DataIfBuilder<T> applyTo(T builder) {
		return new ApplyHandler<T>(builder);
	}

	/**
	 * なにもしないbuilderを返します
	 * @param builder
	 * @return
	 */
	static <T extends DataBuilder<T>> DataIfBuilder<T> nullObject(T builder) {
		return new NullHandler<T>(builder);
	}

	//__/__/__/__/__/__/__/__/__/__/
	// Types
	//__/__/__/__/__/__/__/__/__/__/

	/**
	 * {@link DataBuilder}にデータを追加するハンドラ
	 * @author ogaclejapan
	 *
	 * @param <T>
	 */
	static class ApplyHandler<T extends DataBuilder<T>> implements DataIfBuilder<T> {

		private final T builder;

		private ApplyHandler(T builder) {
			this.builder = builder;
		}

		@Override
		public T then(String key, Object value) {
			return builder.data(key, value);
		}

	}

	/**
	 * 何も処理しないハンドラ
	 * <p>コンストラクタで受け取ったbuilderをそのまま返します
	 * 
	 * @author ogaclejapan
	 *
	 * @param <T>
	 */
	static class NullHandler<T> implements DataIfBuilder<T> {

		private final T builder;

		private NullHandler(T builder) {
			this.builder = builder;
		}

		@Override
		public T then(String key, Object value) {
			return builder;
		}

	}

}
