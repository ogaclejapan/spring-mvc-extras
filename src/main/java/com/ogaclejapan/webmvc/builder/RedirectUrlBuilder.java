package com.ogaclejapan.webmvc.builder;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ogaclejapan.webmvc.model.Page;

/**
 * リクエストのリダイレクト処理時に返却する{@link ModelAndView}のURLを組み立てるクラス
 * 
 * @author ogaclejapan
 * 
 */
public final class RedirectUrlBuilder extends Page implements UrlBuilder<RedirectUrlBuilder> {

	private final WebResponseUrlBuilder<RedirectUrlBuilder> builder;

	// __/__/__/__/__/__/__/__/__/__/
	// Constructors
	// __/__/__/__/__/__/__/__/__/__/

	public RedirectUrlBuilder(RedirectView view) {
		super(view);
		this.builder = new WebResponseUrlBuilder<RedirectUrlBuilder>(this, view);
	}

	// __/__/__/__/__/__/__/__/__/__/
	// Methods
	// __/__/__/__/__/__/__/__/__/__/

	@Override
	public RedirectUrlBuilder path(String path) {
		return builder.path(path);
	}

	@Override
	public RedirectUrlBuilder query(String query) {
		return builder.query(query);
	}

	@Override
	public RedirectUrlBuilder queryParam(String name, Object... values) {
		return builder.queryParam(name, values);
	}

	@Override
	public RedirectUrlBuilder fragment(String fragment) {
		return builder.fragment(fragment);
	}

}
