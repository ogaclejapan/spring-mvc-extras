package com.ogaclejapan.webmvc;

import org.springframework.http.HttpStatus;

/**
 * {@link HttpStatus#OK}で応答する{@link Entity}型モデルのビルダー.
 * 
 * @author ogaclejapan
 * 
 */
public final class AcceptEntityBuilder extends Entity implements ResponseModelChain<AcceptEntityBuilder> {

	private static final ToastType toastType = ToastType.Success;
	private static final AlertType alertType = AlertType.Success;

	private final ResponseModelBuilder<AcceptEntityBuilder> builder;

	// __/__/__/__/__/__/__/__/__/__/
	// Constructors
	// __/__/__/__/__/__/__/__/__/__/

	public AcceptEntityBuilder() {
		super(HttpStatus.OK);
		this.builder = new ResponseModelBuilder<AcceptEntityBuilder>(this, toastType, alertType);
	}

	// __/__/__/__/__/__/__/__/__/__/
	// Methods
	// __/__/__/__/__/__/__/__/__/__/

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AcceptEntityBuilder data(String key, Object value) {
		return builder.data(key, value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AcceptEntityBuilder dataIf(boolean condition, DataIfHandler then) {
		return builder.dataIf(condition, then);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AcceptEntityBuilder dataIf(boolean condition, DataIfHandler then, DataIfHandler elze) {
		return builder.dataIf(condition, then, elze);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AcceptEntityBuilder toast(String message) {
		return builder.toast(message);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AcceptEntityBuilder toast(String message, ToastType type) {
		return builder.toast(message, type);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AcceptEntityBuilder toast(String message, String title) {
		return builder.toast(message, title);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AcceptEntityBuilder toast(String message, String title, ToastType type) {
		return builder.toast(message, title, type);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AcceptEntityBuilder toastIf(boolean condition, ToastIfHandler then) {
		return builder.toastIf(condition, then);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AcceptEntityBuilder toastIf(boolean condition, ToastIfHandler then, ToastIfHandler elze) {
		return builder.toastIf(condition, then, elze);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AcceptEntityBuilder alert(String message) {
		return builder.alert(message);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AcceptEntityBuilder alert(String message, AlertType type) {
		return builder.alert(message, type);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AcceptEntityBuilder alert(String message, String title) {
		return builder.alert(message, title);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AcceptEntityBuilder alert(String message, String title, AlertType type) {
		return builder.alert(message, title, type);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AcceptEntityBuilder alertIf(boolean condition, AlertIfHandler then) {
		return builder.alertIf(condition, then);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AcceptEntityBuilder alertIf(boolean condition, AlertIfHandler then, AlertIfHandler elze) {
		return builder.alertIf(condition, then, elze);
	}

}
