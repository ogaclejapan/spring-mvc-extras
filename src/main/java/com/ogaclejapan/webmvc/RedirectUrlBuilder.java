package com.ogaclejapan.webmvc;

import org.springframework.web.servlet.view.RedirectView;

/**
 * リダイレクト転送で応答するURLモデルのビルダー.
 * 
 * @author ogaclejapan
 * 
 */
public final class RedirectUrlBuilder extends Page implements UrlChain<RedirectUrlBuilder> {

	private final ResponseUrlBuilder<RedirectUrlBuilder> builder;

	// __/__/__/__/__/__/__/__/__/__/
	// Constructors
	// __/__/__/__/__/__/__/__/__/__/

	public RedirectUrlBuilder(RedirectView view) {
		super(view);
		this.builder = new ResponseUrlBuilder<RedirectUrlBuilder>(this);
	}

	// __/__/__/__/__/__/__/__/__/__/
	// Methods
	// __/__/__/__/__/__/__/__/__/__/

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RedirectUrlBuilder path(String path) {
		return builder.path(path);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RedirectUrlBuilder path(String path, String encoding) {
		return builder.path(path, encoding);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RedirectUrlBuilder query(String query) {
		return builder.query(query);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RedirectUrlBuilder query(String query, String encoding) {
		return builder.query(query, encoding);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RedirectUrlBuilder queryParam(String name, String value) {
		return builder.queryParam(name, value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RedirectUrlBuilder queryParam(String name, String value, String encoding) {
		return builder.queryParam(name, value, encoding);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RedirectUrlBuilder fragment(String fragment) {
		return builder.fragment(fragment);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RedirectUrlBuilder fragment(String fragment, String encoding) {
		return builder.fragment(fragment, encoding);
	}

}
