package com.ogaclejapan.webmvc;

import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;

/**
 * 任意の{@link HttpStatus}で応答を破棄する{@link Entity}型モデルのビルダー.
 * 
 * @author ogaclejapan
 * 
 */
public final class RejectEntityBuilder extends Entity implements ResponseModelChain<RejectEntityBuilder> {

	private static final ToastType toastType = ToastType.warning;
	private static final AlertType alertType = AlertType.warning;

	private final ResponseModelBuilder<RejectEntityBuilder> builder;

	// __/__/__/__/__/__/__/__/__/__/
	// Constructors
	// __/__/__/__/__/__/__/__/__/__/

	public RejectEntityBuilder() {
		super(HttpStatus.BAD_REQUEST);
		this.builder = initBuilder();
	}

	public RejectEntityBuilder(HttpStatus status) {
		super(status);
		this.builder = initBuilder();
	}
	
	public RejectEntityBuilder(HttpStatus status, ModelMap model) {
		super(status, model);
		this.builder = initBuilder();
	}

	// __/__/__/__/__/__/__/__/__/__/
	// Methods
	// __/__/__/__/__/__/__/__/__/__/

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RejectEntityBuilder data(String key, Object value) {
		return builder.data(key, value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RejectEntityBuilder dataIf(boolean condition, DataIfHandler then) {
		return builder.dataIf(condition, then);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RejectEntityBuilder dataIf(boolean condition, DataIfHandler then, DataIfHandler otherwise) {
		return builder.dataIf(condition, then, otherwise);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RejectEntityBuilder toast(String message) {
		return builder.toast(message);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RejectEntityBuilder toast(String message, ToastType type) {
		return builder.toast(message, type);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RejectEntityBuilder toast(String message, String title) {
		return builder.toast(message, title);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RejectEntityBuilder toast(String message, String title, ToastType type) {
		return builder.toast(message, title, type);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RejectEntityBuilder toastIf(boolean condition, ToastIfHandler then) {
		return builder.toastIf(condition, then);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RejectEntityBuilder toastIf(boolean condition, ToastIfHandler then, ToastIfHandler otherwise) {
		return builder.toastIf(condition, then, otherwise);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RejectEntityBuilder alert(String message) {
		return builder.alert(message);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RejectEntityBuilder alert(String message, AlertType type) {
		return builder.alert(message, type);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RejectEntityBuilder alert(String message, String title) {
		return builder.alert(message, title);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RejectEntityBuilder alert(String message, String title, AlertType type) {
		return builder.alert(message, title, type);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RejectEntityBuilder alertIf(boolean condition, AlertIfHandler then) {
		return builder.alertIf(condition, then);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RejectEntityBuilder alertIf(boolean condition, AlertIfHandler then, AlertIfHandler otherwise) {
		return builder.alertIf(condition, then, otherwise);
	}

	private ResponseModelBuilder<RejectEntityBuilder> initBuilder() {
		return new ResponseModelBuilder<RejectEntityBuilder>(this, toastType, alertType);
	}
}
