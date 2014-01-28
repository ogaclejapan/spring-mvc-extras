package com.ogaclejapan.webmvc.builder;

import com.ogaclejapan.webmvc.model.AlertType;

/**
 * アラート通知の条件ハンドラ
 * @author ogaclejapan
 *
 */
abstract class AlertIfInternalHandler {

	/**
	 * builderにアラート通知を加えるbuilderを返します
	 * @param builder
	 * @return
	 */
	static <T extends AlertBuilder<T>> AlertIfBuilder<T> applyTo(T builder) {
		return new ApplyHandler<T>(builder);
	}

	/**
	 * 何もしないbuilderを返します
	 * @param builder
	 * @return
	 */
	static <T extends AlertBuilder<T>> AlertIfBuilder<T> nullObject(T builder) {
		return new NullHandler<T>(builder);
	}

	//__/__/__/__/__/__/__/__/__/__/
	// Types
	//__/__/__/__/__/__/__/__/__/__/
	
	/**
	 * {@link AlertBuilder}オブジェクトにアラート通知をするハンドラ
	 * @author ogaclejapan
	 *
	 * @param <T>
	 */
	static class ApplyHandler<T extends AlertBuilder<T>> implements AlertIfBuilder<T> {

		private final T builder;

		private ApplyHandler(T builder) {
			this.builder = builder;
		}

		@Override
		public T then(String message) {
			return builder.alert(message);
		}

		@Override
		public T then(String message, AlertType type) {
			return builder.alert(message, type);
		}

		@Override
		public T then(String message, String title) {
			return builder.alert(message, title);
		}

		@Override
		public T then(String message, String title, AlertType type) {
			return builder.alert(message, title, type);
		}

	}

	/**
	 * 何もしないハンドラ
	 * <p>コンストラクタで受け取ったbuilderをそのまま返します
	 * 
	 * @author ogaclejapan
	 *
	 * @param <T>
	 */
	static class NullHandler<T> implements AlertIfBuilder<T> {

		private T builder;

		private NullHandler(T builder) {
			this.builder = builder;
		}

		@Override
		public T then(String message) {
			return builder;
		}

		@Override
		public T then(String message, AlertType type) {
			return builder;
		}

		@Override
		public T then(String message, String title) {
			return builder;
		}

		@Override
		public T then(String message, String title, AlertType type) {
			return builder;
		}

	}

}
