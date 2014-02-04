package com.ogaclejapan.webmvc;

import org.springframework.util.Assert;
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * {@link AbstractUrlBasedView}型のURLを処理するビルダー.
 * @author ogaclejapan
 *
 */
public class UrlBasedViewBuilder implements UrlBuilder {

	private final AbstractUrlBasedView view;
	private final UriComponentsBuilder urlBuilder;

	//__/__/__/__/__/__/__/__/__/__/
	// Constructors
	//__/__/__/__/__/__/__/__/__/__/

	public UrlBasedViewBuilder(AbstractUrlBasedView view) {
		this.view = view;
		this.urlBuilder = UriComponentsBuilder.fromUriString(view.getUrl());
	}

	//__/__/__/__/__/__/__/__/__/__/
	// Methods
	//__/__/__/__/__/__/__/__/__/__/

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UrlBuilder path(String path) {
		addPath(path);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UrlBuilder query(String query) {
		addQuery(query);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UrlBuilder queryParam(String name, Object... values) {
		addQueryParam(name, values);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UrlBuilder fragment(String fragment) {
		addFragment(fragment);
		return this;
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
