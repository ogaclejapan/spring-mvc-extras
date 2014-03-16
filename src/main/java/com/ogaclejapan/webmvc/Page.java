package com.ogaclejapan.webmvc;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractUrlBasedView;

/**
 * {@link ModelAndView}をラップしたページの戻り値
 * @author ogaclejapan
 *
 */
public class Page extends ModelAndView implements Context, Url {

	//__/__/__/__/__/__/__/__/__/__/
	// Constructors
	//__/__/__/__/__/__/__/__/__/__/

	public Page() {
		super();
	}
	
	public Page(String viewName) {
		super(viewName);
	}
	
	public Page(String viewName, ModelMap model) {
		super(viewName, model);
	}
	
	public Page(ModelMap model) {
		this((String)null, model);
	}

	public Page(View view) {
		super(view);
	}

	//__/__/__/__/__/__/__/__/__/__/
	// Methods
	//__/__/__/__/__/__/__/__/__/__/

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void put(String key, Object value) {
		addObject(key, value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object get(String key) {
		return getModelMap().get(key);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasValue(String key) {
		return this.getModelMap().containsKey(key);
	}

	@Override
	public void setUrl(String url) {
		View view = getView();
		if (view instanceof AbstractUrlBasedView) {
			((AbstractUrlBasedView)view).setUrl(url);
		} else {
			throw new IllegalStateException("Can not be set the url.");
		}
	}

	@Override
	public String getUrl() {
		View view = getView();
		if (view instanceof AbstractUrlBasedView) {
			return ((AbstractUrlBasedView)view).getUrl();
		}
		throw new IllegalStateException("Can not be get the url.");
	}
	
}
