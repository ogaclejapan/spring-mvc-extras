package com.ogaclejapan.webmvc;

import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;

import com.ogaclejapan.webmvc.builder.AlertIfBuilder;
import com.ogaclejapan.webmvc.builder.DataIfBuilder;
import com.ogaclejapan.webmvc.builder.ExceptionModelBuilder;
import com.ogaclejapan.webmvc.builder.WebResponseExceptionBuilder;
import com.ogaclejapan.webmvc.builder.ToastIfBuilder;
import com.ogaclejapan.webmvc.model.AlertType;
import com.ogaclejapan.webmvc.model.ToastType;

/**
 * 例外時に返却するモデルをメソッドチェーンで組み立てる例外クラス
 * 
 * @author ogaclejapan
 * 
 */
@SuppressWarnings("serial")
public final class WebException extends Exception implements ExceptionModelBuilder<WebException> {

	private final WebResponseExceptionBuilder<WebException> builder = new WebResponseExceptionBuilder<WebException>(
			this);

	// __/__/__/__/__/__/__/__/__/__/
	// Constructors
	// __/__/__/__/__/__/__/__/__/__/

	public WebException() {
		super();
	}

	public WebException(String message, Throwable cause) {
		super(message, cause);
	}

	public WebException(String message) {
		super(message);
	}

	public WebException(Throwable cause) {
		super(cause);
	}

	// __/__/__/__/__/__/__/__/__/__/
	// Methods
	// __/__/__/__/__/__/__/__/__/__/

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WebException data(String attributeName, Object attributeValue) {
		return builder.data(attributeName, attributeValue);
	}

	@Override
	public DataIfBuilder<WebException> dataIf(boolean condition) {
		return builder.dataIf(condition);
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
	public ToastIfBuilder<WebException> toastIf(boolean condition) {
		return builder.toastIf(condition);
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
	public AlertIfBuilder<WebException> alertIf(boolean condition) {
		return builder.alertIf(condition);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WebException status(HttpStatus status) {
		return builder.status(status);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ModelMap getDataModel() {
		return builder.getDataModel();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HttpStatus getStatus() {
		return builder.getStatus();
	}

}
