package com.ogaclejapan.webmvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;

/**
 * {@link Context}型のトースト通知モデルを処理するビルダー.
 * @author ogaclejapan
 *
 */
public class ToastModelBuilder implements ToastBuilder {

	private final Context model;
	private final ToastType defaultType;

	//__/__/__/__/__/__/__/__/__/__/
	// Constructors
	//__/__/__/__/__/__/__/__/__/__/

	public ToastModelBuilder(Context model, ToastType defaultType) {
		this.model = model;
		this.defaultType = defaultType;
	}

	//__/__/__/__/__/__/__/__/__/__/
	// Methods
	//__/__/__/__/__/__/__/__/__/__/

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ToastBuilder toast(String message) {
		return toast(message, defaultType);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ToastBuilder toast(String message, ToastType type) {
		return toast(message, null, type);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ToastBuilder toast(String message, String title) {
		return toast(message, title, defaultType);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ToastBuilder toast(String message, String title, ToastType type) {
		addToast(message, title, type);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ToastBuilder toastIf(boolean condition, ToastIfHandler then) {
		return toastIf(condition, then, ToastIfHandler.NULL);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ToastBuilder toastIf(boolean condition, ToastIfHandler then, ToastIfHandler otherwise) {
		if (condition) {
			then.call(this);
		} else {
			otherwise.call(this);
		}
		return this;
	}

	@SuppressWarnings("unchecked")
	protected final void addToast(String message, String title, ToastType type) {
		Assert.notNull(message, "'message' must not be null.");

		List<Toast> list = (List<Toast>) model.get(TOAST_ATTRIBUTE_NAME);
		if (list == null) {
			list = new ArrayList<>();
			model.put(TOAST_ATTRIBUTE_NAME, list);
		}
		list.add(new Toast(message, title, type));
	}

}
