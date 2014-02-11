package com.ogaclejapan.webmvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;

/**
 * {@link Context}型のアラート通知モデルを処理するビルダー.
 * @author ogaclejapan
 *
 */
public class AlertModelBuilder implements AlertBuilder {

	private final Context model;
	private final AlertType defaultType;

	//__/__/__/__/__/__/__/__/__/__/
	// Constructors
	//__/__/__/__/__/__/__/__/__/__/

	public AlertModelBuilder(Context model, AlertType defaultType) {
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
	public AlertBuilder alert(String message) {
		return alert(message, defaultType);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AlertBuilder alert(String message, AlertType type) {
		return alert(message, null, type);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AlertBuilder alert(String message, String title) {
		return alert(message, title, defaultType);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AlertBuilder alert(String message, String title, AlertType type) {
		addAlert(message, title, type);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AlertBuilder alertIf(boolean condition, AlertIfHandler then) {
		return alertIf(condition, then, AlertIfHandler.NULL);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AlertBuilder alertIf(boolean condition, AlertIfHandler then, AlertIfHandler otherwise) {
		if (condition) {
			then.apply(this);
		} else {
			otherwise.apply(this);
		}
		return this;
	}

	@SuppressWarnings("unchecked")
	protected final void addAlert(String message, String title, AlertType type) {
		Assert.notNull(message, "'message' must not be null.");

		List<Alert> list = (List<Alert>) model.get(ALERT_ATTRIBUTE_NAME);
		if (list == null) {
			list = new ArrayList<>();
			model.put(ALERT_ATTRIBUTE_NAME, list);
		}
		list.add(new Alert(message, title, type));
	}

}
