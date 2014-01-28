package com.ogaclejapan.webmvc.builder;

import com.ogaclejapan.webmvc.model.ToastType;

/**
 * トースト通知の条件ハンドラ
 * @author ogaclejapan
 *
 */
abstract class ToastIfInternalHandler {

	/**
	 * builderにトースト通知を加えるbuilderを返します
	 * @param builder
	 * @return
	 */
	static <T extends ToastBuilder<T>> ToastIfBuilder<T> applyTo(T builder) {
		return new ApplyHandler<T>(builder);
	}

	/**
	 * 何もしないbuilderを返します
	 * @param builder
	 * @return
	 */
	static <T extends ToastBuilder<T>> ToastIfBuilder<T> nullObject(T builder) {
		return new NullHandler<T>(builder);
	}

	/**
	 * {@link ToastBuilder}にトースト通知するハンドラ
	 * @author ogaclejapan
	 *
	 * @param <T>
	 */
	static class ApplyHandler<T extends ToastBuilder<T>> implements ToastIfBuilder<T> {

		private final T builder;

		private ApplyHandler(T builder) {
			this.builder = builder;
		}

		@Override
		public T then(String message) {
			return builder.toast(message);
		}

		@Override
		public T then(String message, ToastType type) {
			return builder.toast(message, type);
		}

		@Override
		public T then(String message, String title) {
			return builder.toast(message, title);
		}

		@Override
		public T then(String message, String title, ToastType type) {
			return builder.toast(message, title, type);
		}

	}

	/**
	 * 何もしないハンドラ
	 * <p>コンストラクタに受け取ったbuilderをそのまま返します
	 * @author ogaclejapan
	 *
	 * @param <T>
	 */
	static class NullHandler<T> implements ToastIfBuilder<T> {

		private final T builder;

		private NullHandler(T builder) {
			this.builder = builder;
		}

		@Override
		public T then(String message) {
			return builder;
		}

		@Override
		public T then(String message, ToastType type) {
			return builder;
		}

		@Override
		public T then(String message, String title) {
			return builder;
		}

		@Override
		public T then(String message, String title, ToastType type) {
			return builder;
		}

	}

}
