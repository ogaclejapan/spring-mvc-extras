package com.ogaclejapan.webmvc.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;

import com.ogaclejapan.webmvc.model.Alert;
import com.ogaclejapan.webmvc.model.AlertType;
import com.ogaclejapan.webmvc.model.Toast;
import com.ogaclejapan.webmvc.model.ToastType;

/**
 * 応答するモデルを組み立てる内部ビルダー
 * @author ogaclejapan
 *
 * @param <T>
 */
public class WebResponseBuilder<T extends ModelBuilder<T>> implements ModelBuilder<T> {

	private static final Logger logger = LoggerFactory.getLogger(WebResponseBuilder.class);

	private final T parent;
	private final ToastType toastType;
	private final AlertType alertType;
	
	//__/__/__/__/__/__/__/__/__/__/
	// Constructors
	//__/__/__/__/__/__/__/__/__/__/

	public WebResponseBuilder(T builder) {
		this(builder, ToastType.Info, AlertType.Info);
	}

	public WebResponseBuilder(T parent, ToastType toastType, AlertType alertType) {
		this.parent = parent;
		this.toastType = toastType;
		this.alertType = alertType;
	}

	// __/__/__/__/__/__/__/__/__/__/
	// Methods
	// __/__/__/__/__/__/__/__/__/__/

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T data(String key, Object value) {
		addData(key, value);
		return getBuilder();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DataIfBuilder<T> dataIf(boolean condition) {
		return (condition) ? DataIfInternalHandler.applyTo(parent) : DataIfInternalHandler.nullObject(parent);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T toast(String message) {
		return toast(message, toastType);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T toast(String message, ToastType type) {
		return toast(message, null, type);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T toast(String message, String title) {
		return toast(message, title, toastType);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T toast(String message, String title, ToastType type) {
		addToast(message, title, type);
		return getBuilder();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ToastIfBuilder<T> toastIf(boolean condition) {
		return (condition) ? ToastIfInternalHandler.applyTo(parent) : ToastIfInternalHandler.nullObject(parent);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T alert(String message) {
		return alert(message, alertType);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T alert(String message, AlertType type) {
		return alert(message, null, type);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T alert(String message, String title) {
		return alert(message, title, alertType);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T alert(String message, String title, AlertType type) {
		addAlert(message, title, type);
		return getBuilder();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AlertIfBuilder<T> alertIf(boolean condition) {
		return (condition) ? AlertIfInternalHandler.applyTo(parent) : AlertIfInternalHandler.nullObject(parent);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ModelMap getDataModel() {
		return getBuilder().getDataModel();
	}

	protected T getBuilder() {
		return parent;
	}

	protected final void addData(String key, Object value) {
		Assert.notNull(key, "'key' must not be null.");

		final Map<String, Object> data = getDataModel();
		if (data.containsKey(key)) {
			logger.warn("'" + key + "' already exists.");
		}
		data.put(key, value);
	}

	@SuppressWarnings("unchecked")
	protected final void addToast(String message, String title, ToastType type) {
		Assert.notNull(message, "'message' must not be null.");

		final Map<String, Object> data = getDataModel();
		List<Toast> list = (List<Toast>) data.get(TOAST_ATTRIBUTE_NAME);
		if (list == null) {
			list = new ArrayList<>();
			data.put(TOAST_ATTRIBUTE_NAME, list);
		}
		list.add(new Toast(message, title, type));
	}

	@SuppressWarnings("unchecked")
	protected final void addAlert(String message, String title, AlertType type) {
		Assert.notNull(message, "'message' must not be null.");

		final Map<String, Object> data = getDataModel();
		List<Alert> list = (List<Alert>) data.get(ALERT_ATTRIBUTE_NAME);
		if (list == null) {
			list = new ArrayList<>();
			data.put(ALERT_ATTRIBUTE_NAME, list);
		}
		list.add(new Alert(message, title, type));
	}

}
