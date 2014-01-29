package com.ogaclejapan.webmvc.model;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

/**
 * {@link ModelAndView}をラップしたページの戻り値
 * @author ogaclejapan
 *
 */
public class Page extends ModelAndView {

	public Page() {
		super();
	}

	public Page(String viewName) {
		super(viewName);
	}

	public Page(View view) {
		super(view);
	}

}
