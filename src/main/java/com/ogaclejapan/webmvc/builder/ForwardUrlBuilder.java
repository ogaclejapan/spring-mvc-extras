package com.ogaclejapan.webmvc.builder;

import org.springframework.web.servlet.ModelAndView;

/**
 * リクエストのフォワード処理時に返却する{@link ModelAndView}のURLを組み立てるクラス
 * @author ogaclejapan
 *
 */
public class ForwardUrlBuilder extends WebResponseUrlBuilder<ForwardUrlBuilder> {

	private static final String PREFIX = "forward"; 
	
	//__/__/__/__/__/__/__/__/__/__/
	// Constructors
	//__/__/__/__/__/__/__/__/__/__/
	
	public ForwardUrlBuilder(String url) {
		super(PREFIX, url);
	}
	
	//__/__/__/__/__/__/__/__/__/__/
	// Methods
	//__/__/__/__/__/__/__/__/__/__/

	@Override
	public ForwardUrlBuilder path(String path) {
		addPath(path);
		return this;
	}

	@Override
	public ForwardUrlBuilder query(String query) {
		addQuery(query);
		return this;
	}

	@Override
	public ForwardUrlBuilder queryParam(String name, Object... values) {
		addQueryParam(name, values);
		return this;
	}

	@Override
	public ForwardUrlBuilder fragment(String fragment) {
		addFragment(fragment);
		return this;
	}

}
