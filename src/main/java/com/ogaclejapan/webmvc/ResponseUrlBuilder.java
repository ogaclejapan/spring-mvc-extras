package com.ogaclejapan.webmvc;

import java.nio.charset.Charset;

/**
 * URLで応答を返すベースビルダー.
 * 
 * @author ogaclejapan
 * 
 * @param <T>
 */
public class ResponseUrlBuilder<T extends Page> implements UrlChain<T> {

	private final T page;
	private final UrlBuilder urlBuilder;

	// __/__/__/__/__/__/__/__/__/__/
	// Constructors
	// __/__/__/__/__/__/__/__/__/__/

	public ResponseUrlBuilder(T page) {
		this.page = page;
		this.urlBuilder = new UrlComponentsBuilder(page);
	}

	// __/__/__/__/__/__/__/__/__/__/
	// Methods
	// __/__/__/__/__/__/__/__/__/__/

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T path(String path) {
		urlBuilder.path(path);
		return page;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T path(String path, String encoding) {
		urlBuilder.path(path, encoding);
		return page;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T query(String query) {
		urlBuilder.query(query);
		return page;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T query(String query, String encoding) {
		urlBuilder.query(query, encoding);
		return page;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T queryParam(String name, String value) {
		urlBuilder.queryParam(name, value);
		return page;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T queryParam(String name, String value, String encoding) {
		urlBuilder.queryParam(name, value, encoding);
		return page;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T fragment(String fragment) {
		urlBuilder.fragment(fragment);
		return page;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T fragment(String fragment, String encoding) {
		urlBuilder.fragment(fragment, encoding);
		return page;
	}

}
