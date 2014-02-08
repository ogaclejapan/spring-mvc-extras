package com.ogaclejapan.webmvc;

import org.springframework.web.servlet.view.InternalResourceView;

/**
 * フォワード転送で応答するURLモデルのビルダー.
 * 
 * @author ogaclejapan
 * 
 */
public final class ForwardUrlBuilder extends Page implements UrlChain<ForwardUrlBuilder> {

	private final ResponseUrlBuilder<ForwardUrlBuilder> builder;

	// __/__/__/__/__/__/__/__/__/__/
	// Constructors
	// __/__/__/__/__/__/__/__/__/__/

	public ForwardUrlBuilder(InternalResourceView view) {
		super(view);
		this.builder = new ResponseUrlBuilder<ForwardUrlBuilder>(this);
	}

	// __/__/__/__/__/__/__/__/__/__/
	// Methods
	// __/__/__/__/__/__/__/__/__/__/

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ForwardUrlBuilder path(String path) {
		return builder.path(path);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ForwardUrlBuilder path(String path, String encoding) {
		return builder.path(path, encoding);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ForwardUrlBuilder query(String query) {
		return builder.query(query);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ForwardUrlBuilder query(String query, String encoding) {
		return builder.query(query, encoding);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ForwardUrlBuilder queryParam(String name, String value) {
		return builder.queryParam(name, value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ForwardUrlBuilder queryParam(String name, String value, String encoding) {
		return builder.queryParam(name, value, encoding);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ForwardUrlBuilder fragment(String fragment) {
		return builder.fragment(fragment);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ForwardUrlBuilder fragment(String fragment, String encoding) {
		return builder.fragment(fragment, encoding);
	}

}
