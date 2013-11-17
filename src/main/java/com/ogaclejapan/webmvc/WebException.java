package com.ogaclejapan.webmvc;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;

import com.ogaclejapan.webmvc.builder.ExceptionModelBuilder;
import com.ogaclejapan.webmvc.model.Alert;
import com.ogaclejapan.webmvc.model.AlertType;
import com.ogaclejapan.webmvc.model.Toast;
import com.ogaclejapan.webmvc.model.ToastType;

/**
 * 例外時に返却するモデルをメソッドチェーンで組み立てる例外クラス
 * @author ogaclejapan
 *
 */
@SuppressWarnings("serial")
public class WebException extends Exception implements ExceptionModelBuilder<WebException> {
	
	private static final Logger logger = LoggerFactory.getLogger(WebException.class);
	
	private static final ToastType defaultToastType = ToastType.Error;
	private static final AlertType defaultAlertType = AlertType.Error; 

	private final ModelMap model = new ModelMap();
	private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
	
	//__/__/__/__/__/__/__/__/__/__/
	// Constructors
	//__/__/__/__/__/__/__/__/__/__/

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

	//__/__/__/__/__/__/__/__/__/__/
	// Methods
	//__/__/__/__/__/__/__/__/__/__/

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WebException model(String attributeName, Object attributeValue) {
		addModel(attributeName, attributeValue);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */	
	@Override
	public WebException toast(String message) {		
		return toast(message, defaultToastType);
	}

	/**
	 * {@inheritDoc}
	 */	
	@Override
	public WebException toast(String message, ToastType type) {
		return toast(message, null, type);
	}
	
	/**
	 * {@inheritDoc}
	 */	
	@Override
	public WebException toast(String message, String title) {
		return toast(message, title, defaultToastType);
	}

	/**
	 * {@inheritDoc}
	 */	
	@Override
	public WebException toast(String message, String title, ToastType type) {
		addToast(message, title, type);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */	
	@Override
	public WebException alert(String message) {
		return alert(message, defaultAlertType);
	}

	/**
	 * {@inheritDoc}
	 */	
	@Override
	public WebException alert(String message, AlertType type) {
		return alert(message, null, type);
	}
	
	/**
	 * {@inheritDoc}
	 */	
	@Override
	public WebException alert(String message, String title) {
		return alert(message, title, defaultAlertType);
	}

	/**
	 * {@inheritDoc}
	 */	
	@Override
	public WebException alert(String message, String title, AlertType type) {
		addAlert(message, title, type);
		return this;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public WebException status(HttpStatus status) {
		addStatus(status);
		return this;
	}

	public HttpStatus getStatus() {
		return status;
	}
	
	public ModelMap getModel() {
		return model;
	}
	
	protected ModelMap getModelMap() {
		return model;
	}
	
	protected void addModel(String attributeName, Object attributeValue) {
		if (getModelMap().containsKey(attributeName)) {
			logger.warn("Key '" + attributeName + "' already exists.");
		}
		getModelMap().put(attributeName, attributeValue);
	}
	
	@SuppressWarnings("unchecked")
	protected void addToast(String message, String title, ToastType type) {
		List<Toast> list = (List<Toast>)getModelMap().get(TOAST_ATTRIBUTE_NAME);
		if (list == null) {
			list = new ArrayList<>();
			getModelMap().put(TOAST_ATTRIBUTE_NAME, list);
		}
		list.add(new Toast(message, title, type));
	}
	
	@SuppressWarnings("unchecked")
	protected void addAlert(String message, String title, AlertType type) {
		List<Alert> list = (List<Alert>)getModelMap().get(ALERT_ATTRIBUTE_NAME);
		if (list == null) {
			list = new ArrayList<>();
			getModelMap().put(ALERT_ATTRIBUTE_NAME, list);
		}
		list.add(new Alert(message, title, type));
	}

	protected void addStatus(HttpStatus status) {
		this.status = status;
	}

}
