package com.ogaclejapan.webmvc.builder;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import com.ogaclejapan.webmvc.model.Alert;
import com.ogaclejapan.webmvc.model.AlertType;
import com.ogaclejapan.webmvc.model.Toast;
import com.ogaclejapan.webmvc.model.ToastType;

/**
 * {@link ModelAndView}のモデルをメソッドチェーンで組み立てるベースクラス
 * @author ogaclejapan
 *
 * @param <T>
 */
public abstract class WebPageModelBuilder<T> extends ModelAndView implements ModelBuilder<T> {
	
	private static final Logger logger = LoggerFactory.getLogger(WebPageModelBuilder.class);
	
	//__/__/__/__/__/__/__/__/__/__/
	// Constructors
	//__/__/__/__/__/__/__/__/__/__/

	public WebPageModelBuilder() {
		super();
	}
	
	public WebPageModelBuilder(String viewName) {
		super(viewName);
	}
	
	//__/__/__/__/__/__/__/__/__/__/
	// Methods
	//__/__/__/__/__/__/__/__/__/__/

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract T model(String attributeName, Object attributeValue);

	/**
	 * {@inheritDoc}
	 */	
	@Override
	public abstract T toast(String message);

	/**
	 * {@inheritDoc}
	 */	
	@Override
	public abstract T toast(String message, ToastType type);
	
	/**
	 * {@inheritDoc}
	 */	
	@Override
	public abstract T toast(String message, String title);

	/**
	 * {@inheritDoc}
	 */	
	@Override
	public abstract T toast(String message, String title, ToastType type);

	/**
	 * {@inheritDoc}
	 */	
	@Override
	public abstract T alert(String message);

	/**
	 * {@inheritDoc}
	 */	
	@Override
	public abstract T alert(String message, AlertType type);
	
	/**
	 * {@inheritDoc}
	 */	
	@Override
	public abstract T alert(String message, String title);

	/**
	 * {@inheritDoc}
	 */	
	@Override
	public abstract T alert(String message, String title, AlertType type);
	
	protected void addModel(String attributeName, Object attributeValue) {
		if (getModelMap().containsKey(attributeName)) {
			logger.warn("Key '" + attributeName + "' already exists.");
		}
		addObject(attributeName, attributeValue);
	}
	
	@SuppressWarnings("unchecked")
	protected void addToast(String message, String title, ToastType type) {
		List<Toast> list = (List<Toast>)getModelMap().get(TOAST_ATTRIBUTE_NAME);
		if (list == null) {
			list = new ArrayList<>();
			addObject(TOAST_ATTRIBUTE_NAME, list);
		}
		list.add(new Toast(message, title, type));
	}
	
	@SuppressWarnings("unchecked")
	protected void addAlert(String message, String title, AlertType type) {
		List<Alert> list = (List<Alert>)getModelMap().get(ALERT_ATTRIBUTE_NAME);
		if (list == null) {
			list = new ArrayList<>();
			addObject(ALERT_ATTRIBUTE_NAME, list);
		}
		list.add(new Alert(message, title, type));
	}

}
