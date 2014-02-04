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
	public ForwardUrlBuilder query(String query) {
		return builder.query(query);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ForwardUrlBuilder queryParam(String name, Object... values) {
		return builder.queryParam(name, values);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ForwardUrlBuilder fragment(String fragment) {
		return builder.fragment(fragment);
	}

}
