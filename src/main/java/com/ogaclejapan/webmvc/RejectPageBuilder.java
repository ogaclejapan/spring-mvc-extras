package com.ogaclejapan.webmvc;

import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;

/**
 * {@link HttpStatus#OK}で応答を破棄する{@link Page}型モデルのビルダー.
 * 
 * @author ogaclejapan
 * 
 */
public final class RejectPageBuilder extends Page implements ResponseModelChain<RejectPageBuilder> {

	private static final ToastType toastType = ToastType.warning;
	private static final AlertType alertType = AlertType.warning;

	private final ResponseModelBuilder<RejectPageBuilder> builder;

	// __/__/__/__/__/__/__/__/__/__/
	// Constructors
	// __/__/__/__/__/__/__/__/__/__/

	public RejectPageBuilder() {
		super();
		this.builder = initBuilder();
	}

	public RejectPageBuilder(String viewName) {
		super(viewName);
		this.builder = initBuilder();
	}
	
	public RejectPageBuilder(String viewName, ModelMap model) {
		super(viewName, model);
		this.builder = initBuilder();
	}
	
	public RejectPageBuilder(ModelMap model) {
		super(model);
		this.builder = initBuilder();
	}
	
	// __/__/__/__/__/__/__/__/__/__/
	// Methods
	// __/__/__/__/__/__/__/__/__/__/

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RejectPageBuilder data(String key, Object value) {
		return builder.data(key, value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RejectPageBuilder dataIf(boolean condition, DataIfHandler then) {
		return builder.dataIf(condition, then);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RejectPageBuilder dataIf(boolean condition, DataIfHandler then, DataIfHandler otherwise) {
		return builder.dataIf(condition, then, otherwise);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RejectPageBuilder toast(String message) {
		return builder.toast(message);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RejectPageBuilder toast(String message, ToastType type) {
		return builder.toast(message, type);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RejectPageBuilder toast(String message, String title) {
		return builder.toast(message, title);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RejectPageBuilder toast(String message, String title, ToastType type) {
		return builder.toast(message, title, type);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RejectPageBuilder toastIf(boolean condition, ToastIfHandler then) {
		return builder.toastIf(condition, then);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RejectPageBuilder toastIf(boolean condition, ToastIfHandler then, ToastIfHandler otherwise) {
		return builder.toastIf(condition, then, otherwise);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RejectPageBuilder alert(String message) {
		return builder.alert(message);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RejectPageBuilder alert(String message, AlertType type) {
		return builder.alert(message, type);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RejectPageBuilder alert(String message, String title) {
		return builder.alert(message, title);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RejectPageBuilder alert(String message, String title, AlertType type) {
		return builder.alert(message, title, type);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RejectPageBuilder alertIf(boolean condition, AlertIfHandler then) {
		return builder.alertIf(condition, then);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RejectPageBuilder alertIf(boolean condition, AlertIfHandler then, AlertIfHandler otherwise) {
		return builder.alertIf(condition, then, otherwise);
	}
	
	private ResponseModelBuilder<RejectPageBuilder> initBuilder() {
		return new ResponseModelBuilder<RejectPageBuilder>(this, toastType, alertType);
	}

}
