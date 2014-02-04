package com.ogaclejapan.webmvc;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

/**
 * {@link ModelAndView}をラップしたページの戻り値
 * @author ogaclejapan
 *
 */
public class Page extends ModelAndView implements Context {

	//__/__/__/__/__/__/__/__/__/__/
	// Constructors
	//__/__/__/__/__/__/__/__/__/__/

	public Page() {
		super();
	}

	public Page(String viewName) {
		super(viewName);
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
	

}
