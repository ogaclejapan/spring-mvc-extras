package com.ogaclejapan.webmvc;

import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;

/**
 * メソッドチェーンで例外モデルを処理する例外クラス.
 * 
 * @author ogaclejapan
 * 
 */
@SuppressWarnings("serial")
public final class WebException extends Exception implements Context, ResponseModelChain<WebException> {

	private static final ToastType toastType = ToastType.Error;
	private static final AlertType alertType = AlertType.Error;

	private final ModelMap model = new ModelMap();
	private final ResponseModelBuilder<WebException> builder;
	
	private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

	// __/__/__/__/__/__/__/__/__/__/
	// Constructors
	// __/__/__/__/__/__/__/__/__/__/

	public WebException() {
		super();
		this.builder = new ResponseModelBuilder<WebException>(this, toastType, alertType);
	}

	public WebException(String message, Throwable cause) {
		super(message, cause);
		this.builder = new ResponseModelBuilder<WebException>(this, toastType, alertType);
	}

	public WebException(String message) {
		super(message);
		this.builder = new ResponseModelBuilder<WebException>(this, toastType, alertType);
	}

	public WebException(Throwable cause) {
		super(cause);
		this.builder = new ResponseModelBuilder<WebException>(this, toastType, alertType);
	}

	// __/__/__/__/__/__/__/__/__/__/
	// Methods
	// __/__/__/__/__/__/__/__/__/__/

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WebException data(String key, Object value) {
		return builder.data(key, value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WebException dataIf(boolean condition, DataIfHandler then) {
		return builder.dataIf(condition, then);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WebException dataIf(boolean condition, DataIfHandler then, DataIfHandler elze) {
		return builder.dataIf(condition, then, elze);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WebException toast(String message) {
		return builder.toast(message);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WebException toast(String message, ToastType type) {
		return builder.toast(message, type);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WebException toast(String message, String title) {
		return builder.toast(message, title);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WebException toast(String message, String title, ToastType type) {
		return builder.toast(message, title, type);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WebException toastIf(boolean condition, ToastIfHandler then) {
		return builder.toastIf(condition, then);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WebException toastIf(boolean condition, ToastIfHandler then, ToastIfHandler elze) {
		return builder.toastIf(condition, then, elze);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WebException alert(String message) {
		return builder.alert(message);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WebException alert(String message, AlertType type) {
		return builder.alert(message, type);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WebException alert(String message, String title) {
		return builder.alert(message, title);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WebException alert(String message, String title, AlertType type) {
		return builder.alert(message, title, type);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WebException alertIf(boolean condition, AlertIfHandler then) {
		return builder.alertIf(condition, then);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WebException alertIf(boolean condition, AlertIfHandler then, AlertIfHandler elze) {
		return builder.alertIf(condition, then, elze);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void put(String key, Object value) {
		model.addAttribute(key, value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object get(String key) {
		return model.get(key);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasValue(String key) {
		return model.containsKey(key);
	}
	
	/**
	 * 応答する{@link HttpStatus}コードを設定する
	 * @param status
	 */
	public void status(HttpStatus status) {
		this.status = status;
	}
	
	/**
	 * 応答する{@link HttpStatus}コードを取得する
	 * @return 
	 */
	public HttpStatus getStatus() {
		return status;
	}
	
	/**
	 * 例外モデルを取得する
	 * @return {@link ModelMap}
	 */
	public ModelMap getModelMap() {
		return model;
	}

}
