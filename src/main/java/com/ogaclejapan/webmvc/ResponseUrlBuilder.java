package com.ogaclejapan.webmvc;

import org.springframework.web.servlet.view.AbstractUrlBasedView;

/**
 * URLで応答を返すベースビルダー.
 * @author ogaclejapan
 *
 * @param <T>
 */
public class ResponseUrlBuilder<T extends Page> implements UrlChain<T> {
	
	private final T page;
	private final UrlBuilder urlBuilder;
	
	//__/__/__/__/__/__/__/__/__/__/
	// Constructors
	//__/__/__/__/__/__/__/__/__/__/

	public ResponseUrlBuilder(T page) {
		this.page = page;
		this.urlBuilder = new UrlBasedViewBuilder((AbstractUrlBasedView)page.getView());
	}
	
	//__/__/__/__/__/__/__/__/__/__/
	// Methods
	//__/__/__/__/__/__/__/__/__/__/

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
	public T query(String query) {
		urlBuilder.query(query);
		return page;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T queryParam(String name, Object... values) {
		urlBuilder.queryParam(name, values);
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

}
