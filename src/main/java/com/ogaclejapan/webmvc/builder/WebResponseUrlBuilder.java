package com.ogaclejapan.webmvc.builder;

import org.springframework.util.Assert;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * {@link ModelAndView}のリダイレクト処理をメソッドチェーンで組み立てるベースクラス
 * 
 * @author ogaclejapan
 * 
 * @param <T>
 */
public class WebResponseUrlBuilder<T extends UrlBuilder<T>> implements UrlBuilder<T> {

	private final T parent;
	private final AbstractUrlBasedView view;
	private final UriComponentsBuilder urlBuilder;

	// __/__/__/__/__/__/__/__/__/__/
	// Constructors
	// __/__/__/__/__/__/__/__/__/__/

	public WebResponseUrlBuilder(T parent, AbstractUrlBasedView view) {
		this.parent = parent;
		this.view = view;
		this.urlBuilder = UriComponentsBuilder.fromUriString(view.getUrl());
	}

	// __/__/__/__/__/__/__/__/__/__/
	// Methods
	// __/__/__/__/__/__/__/__/__/__/

	@Override
	public T path(String path) {
		addPath(path);
		return getBuilder();
	}

	@Override
	public T query(String query) {
		addQuery(query);
		return getBuilder();
	}

	@Override
	public T queryParam(String name, Object... values) {
		addQueryParam(name, values);
		return getBuilder();
	}

	@Override
	public T fragment(String fragment) {
		addFragment(fragment);
		return getBuilder();
	}

	protected T getBuilder() {
		return parent;
	}

	protected void addPath(String path) {
		Assert.notNull(path, "'path' must not be null.");
		reset(urlBuilder.path(path).build(true).toUriString());
	}

	protected void addQuery(String query) {
		Assert.notNull(query, "'query' must not be null.");
		reset(urlBuilder.query(query).build(true).toUriString());
	}

	protected void addQueryParam(String name, Object... values) {
		Assert.notNull(name, "'name' must not be null.");
		reset(urlBuilder.queryParam(name, values).build(true).toUriString());
	}

	protected void addFragment(String fragment) {
		Assert.notNull(fragment, "'fragment' must not be null.");
		reset(urlBuilder.fragment(fragment).build(true).toUriString());
	}

	private void reset(String url) {
		view.setUrl(url);
	}

}
