package com.ogaclejapan.webmvc;

import java.io.UnsupportedEncodingException;

import org.springframework.util.Assert;
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriUtils;

/**
 * {@link AbstractUrlBasedView}型のURLを処理するビルダー.
 * 
 * @author ogaclejapan
 * 
 */
public class UrlComponentsBuilder implements UrlBuilder {

	private final Url url;
	private final UriComponentsBuilder urlBuilder;

	// __/__/__/__/__/__/__/__/__/__/
	// Constructors
	// __/__/__/__/__/__/__/__/__/__/

	public UrlComponentsBuilder(Url url) {
		this.url = url;
		this.urlBuilder = UriComponentsBuilder.fromUriString(url.getUrl());
	}

	// __/__/__/__/__/__/__/__/__/__/
	// Methods
	// __/__/__/__/__/__/__/__/__/__/

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UrlBuilder path(String path) {
		return path(path, DEFAULT_ENCODING);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UrlBuilder path(String path, String encoding) {
		addPath(path, encoding);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UrlBuilder query(String query) {
		return query(query, DEFAULT_ENCODING);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UrlBuilder query(String query, String encoding) {
		addQuery(query, encoding);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UrlBuilder queryParam(String name, String value) {
		return queryParam(name, value, DEFAULT_ENCODING);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UrlBuilder queryParam(String name, String value, String encoding) {
		addQueryParam(name, value, encoding);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UrlBuilder fragment(String fragment) {
		return fragment(fragment, DEFAULT_ENCODING);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UrlBuilder fragment(String fragment, String encoding) {
		addFragment(fragment, encoding);
		return this;
	}

	protected void addPath(String path, String encoding) {
		Assert.notNull(path, "'path' must not be null.");
		try {
			reset(urlBuilder.path(UriUtils.encodePath(path, encoding)).build(true).toUriString());
		} catch (UnsupportedEncodingException usee) {
			throw new IllegalStateException(usee);
		}
	}

	protected void addQuery(String query, String encoding) {
		Assert.notNull(query, "'query' must not be null.");
		try {
			reset(urlBuilder.query(UriUtils.encodeQuery(query, encoding)).build(true).toUriString());
		} catch (UnsupportedEncodingException usee) {
			throw new IllegalStateException(usee);
		}
	}

	protected void addQueryParam(String name, String value, String encoding) {
		Assert.notNull(name, "'name' must not be null.");
		try {
			reset(urlBuilder.queryParam(name, UriUtils.encodeQueryParam(value, encoding)).build(true).toUriString());
		} catch (UnsupportedEncodingException usee) {
			throw new IllegalStateException(usee);
		}
	}

	protected void addFragment(String fragment, String encoding) {
		Assert.notNull(fragment, "'fragment' must not be null.");
		try {
			reset(urlBuilder.fragment(UriUtils.encodeFragment(fragment, encoding)).build(true).toUriString());
		} catch (UnsupportedEncodingException usee) {
			throw new IllegalStateException(usee);
		}
	}

	private void reset(String url) {
		this.url.setUrl(url);
	}

}
