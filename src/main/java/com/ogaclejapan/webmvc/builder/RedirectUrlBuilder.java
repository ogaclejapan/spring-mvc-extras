package com.ogaclejapan.webmvc.builder;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * リクエストのリダイレクト処理時に返却する{@link ModelAndView}のURLを組み立てるクラス
 * @author ogaclejapan
 *
 */
public class RedirectUrlBuilder extends WebPageUrlBuilder<RedirectUrlBuilder> {
	
	//__/__/__/__/__/__/__/__/__/__/
	// Constructors
	//__/__/__/__/__/__/__/__/__/__/

	public RedirectUrlBuilder(RedirectView view) {
		super(view);
	}
	
	//__/__/__/__/__/__/__/__/__/__/
	// Methods
	//__/__/__/__/__/__/__/__/__/__/

	@Override
	public RedirectUrlBuilder path(String path) {
		addPath(path);
		return this;
	}

	@Override
	public RedirectUrlBuilder query(String query) {
		addQuery(query);
		return this;
	}

	@Override
	public RedirectUrlBuilder queryParam(String name, Object... values) {
		addQueryParam(name, values);
		return this;
	}

	@Override
	public RedirectUrlBuilder fragment(String fragment) {
		addFragment(fragment);
		return this;
	}
	
}
