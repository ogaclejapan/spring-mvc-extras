package com.ogaclejapan.webmvc;

import org.springframework.http.HttpStatus;

/**
 * {@link HttpStatus#OK}で応答する{@link Page}型モデルのビルダー.
 * 
 * @author ogaclejapan
 * 
 */
public final class AcceptPageBuilder extends Page implements ResponseModelChain<AcceptPageBuilder> {

	private static final ToastType toastType = ToastType.success;
	private static final AlertType alertType = AlertType.success;

	private final ResponseModelBuilder<AcceptPageBuilder> builder;

	// __/__/__/__/__/__/__/__/__/__/
	// Constructors
	// __/__/__/__/__/__/__/__/__/__/

	public AcceptPageBuilder() {
		super();
		this.builder = new ResponseModelBuilder<AcceptPageBuilder>(this, toastType, alertType);
	}

	public AcceptPageBuilder(String viewName) {
		super(viewName);
		this.builder = new ResponseModelBuilder<AcceptPageBuilder>(this, toastType, alertType);
	}

	// __/__/__/__/__/__/__/__/__/__/
	// Methods
	// __/__/__/__/__/__/__/__/__/__/

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AcceptPageBuilder data(String key, Object value) {
		return builder.data(key, value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AcceptPageBuilder dataIf(boolean condition, DataIfHandler then) {
		return builder.dataIf(condition, then);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AcceptPageBuilder dataIf(boolean condition, DataIfHandler then, DataIfHandler otherwise) {
		return builder.dataIf(condition, then, otherwise);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AcceptPageBuilder toast(String message) {
		return builder.toast(message);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AcceptPageBuilder toast(String message, ToastType type) {
		return builder.toast(message, type);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AcceptPageBuilder toast(String message, String title) {
		return builder.toast(message, title);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AcceptPageBuilder toast(String message, String title, ToastType type) {
		return builder.toast(message, title, type);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AcceptPageBuilder toastIf(boolean condition, ToastIfHandler then) {
		return builder.toastIf(condition, then);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AcceptPageBuilder toastIf(boolean condition, ToastIfHandler then, ToastIfHandler otherwise) {
		return builder.toastIf(condition, then, otherwise);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AcceptPageBuilder alert(String message) {
		return builder.alert(message);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AcceptPageBuilder alert(String message, AlertType type) {
		return builder.alert(message, type);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AcceptPageBuilder alert(String message, String title) {
		return builder.alert(message, title);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AcceptPageBuilder alert(String message, String title, AlertType type) {
		return builder.alert(message, title, type);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AcceptPageBuilder alertIf(boolean condition, AlertIfHandler then) {
		return builder.alertIf(condition, then);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AcceptPageBuilder alertIf(boolean condition, AlertIfHandler then, AlertIfHandler otherwise) {
		return builder.alertIf(condition, then, otherwise);
	}

}
