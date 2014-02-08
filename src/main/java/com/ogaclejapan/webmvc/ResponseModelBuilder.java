package com.ogaclejapan.webmvc;


/**
 * {@link Context}型のモデルで応答するベースビルダー.
 * @author ogaclejapan
 *
 * @param <T>
 */
public class ResponseModelBuilder<T extends Context> implements DataChain<T>, ToastChain<T>, AlertChain<T> {
	
	private final T model;
	private final DataBuilder dataBuilder;
	private final ToastBuilder toastBuilder;
	private final AlertBuilder alertBuilder;
	
	//__/__/__/__/__/__/__/__/__/__/
	// Constructors
	//__/__/__/__/__/__/__/__/__/__/

	public ResponseModelBuilder(T model, ToastType toastType, AlertType alertType) {
		this.model = model;
		this.dataBuilder = new DataModelBuilder(model);
		this.toastBuilder = new ToastModelBuilder(model, toastType);
		this.alertBuilder = new AlertModelBuilder(model, alertType);
	}
	
	//__/__/__/__/__/__/__/__/__/__/
	// Methods
	//__/__/__/__/__/__/__/__/__/__/

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T data(String key, Object value) {
		dataBuilder.data(key, value);
		return model;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public T dataIf(boolean condition, DataIfHandler then) {
		dataBuilder.dataIf(condition, then);
		return model;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public T dataIf(boolean condition, DataIfHandler then, DataIfHandler otherwise) {
		dataBuilder.dataIf(condition, then, otherwise);
		return model;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T toast(String message) {
		toastBuilder.toast(message);
		return model;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T toast(String message, ToastType type) {
		toastBuilder.toast(message, type);
		return model;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T toast(String message, String title) {
		toastBuilder.toast(message, title);
		return model;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T toast(String message, String title, ToastType type) {
		toastBuilder.toast(message, title, type);
		return model;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public T toastIf(boolean condition, ToastIfHandler then) {
		toastBuilder.toastIf(condition, then);
		return model;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public T toastIf(boolean condition, ToastIfHandler then, ToastIfHandler otherwise) {
		toastBuilder.toastIf(condition, then, otherwise);
		return model;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T alert(String message) {
		alertBuilder.alert(message);
		return model;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T alert(String message, AlertType type) {
		alertBuilder.alert(message, type);
		return model;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T alert(String message, String title) {
		alertBuilder.alert(message, title);
		return model;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T alert(String message, String title, AlertType type) {
		alertBuilder.alert(message, title, type);
		return model;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public T alertIf(boolean condition, AlertIfHandler then) {
		alertBuilder.alertIf(condition, then);
		return model;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public T alertIf(boolean condition, AlertIfHandler then, AlertIfHandler otherwise) {
		alertBuilder.alertIf(condition, then, otherwise);
		return model;
	}

}
