package com.ogaclejapan.webmvc.builder;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

import com.ogaclejapan.webmvc.model.Page;

/**
 * リクエストのフォワード処理時に返却する{@link ModelAndView}のURLを組み立てるクラス
 * 
 * @author ogaclejapan
 * 
 */
public final class ForwardUrlBuilder extends Page implements UrlBuilder<ForwardUrlBuilder> {

	private final WebResponseUrlBuilder<ForwardUrlBuilder> builder;

	// __/__/__/__/__/__/__/__/__/__/
	// Constructors
	// __/__/__/__/__/__/__/__/__/__/

	public ForwardUrlBuilder(InternalResourceView view) {
		super(view);
		this.builder = new WebResponseUrlBuilder<ForwardUrlBuilder>(this, view);
	}

	// __/__/__/__/__/__/__/__/__/__/
	// Methods
	// __/__/__/__/__/__/__/__/__/__/

	@Override
	public ForwardUrlBuilder path(String path) {
		return builder.path(path);
	}

	@Override
	public ForwardUrlBuilder query(String query) {
		return builder.query(query);
	}

	@Override
	public ForwardUrlBuilder queryParam(String name, Object... values) {
		return builder.queryParam(name, values);
	}

	@Override
	public ForwardUrlBuilder fragment(String fragment) {
		return builder.fragment(fragment);
	}

}
