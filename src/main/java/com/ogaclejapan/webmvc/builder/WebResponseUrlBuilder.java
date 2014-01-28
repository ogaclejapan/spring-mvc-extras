package com.ogaclejapan.webmvc.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * {@link ModelAndView}のリダイレクト処理をメソッドチェーンで組み立てるベースクラス
 * @author ogaclejapan
 *
 * @param <T>
 */
public abstract class WebResponseUrlBuilder<T> extends ModelAndView implements UrlBuilder<T> {
	
	private static final Logger logger = LoggerFactory.getLogger(WebResponseUrlBuilder.class);
	
	private static final String VIEWNAME_FORMAT = "%s:%s";
	
	private final UriComponentsBuilder urlBuilder;
	private String prefix = null;
	
	//__/__/__/__/__/__/__/__/__/__/
	// Constructors
	//__/__/__/__/__/__/__/__/__/__/

	public WebResponseUrlBuilder(String prefix, String url) {
		super(String.format(VIEWNAME_FORMAT, prefix, url));
		this.prefix = prefix;
		this.urlBuilder = UriComponentsBuilder.fromUriString(url);
	}
	
	public WebResponseUrlBuilder(RedirectView view) {
		super(view);
		this.urlBuilder = UriComponentsBuilder.fromUriString(view.getUrl());
	}
	
	//__/__/__/__/__/__/__/__/__/__/
	// Methods
	//__/__/__/__/__/__/__/__/__/__/

	@Override
	public abstract T path(String path);

	@Override
	public abstract T query(String query);

	@Override
	public abstract T queryParam(String name, Object... values);

	@Override
	public abstract T fragment(String fragment);
	
	protected void addPath(String path) {
		urlBuilder.path(path);
		resetUrl();
	}
	
	protected void addQuery(String query) {
		urlBuilder.query(query);
		resetUrl();
	}
	
	protected void addQueryParam(String name, Object... values) {
		urlBuilder.queryParam(name, values);
		resetUrl();
	}
	
	protected void addFragment(String fragment) {
		urlBuilder.fragment(fragment);
		resetUrl();
	}
	
	private void resetUrl() {
		final String url = urlBuilder.build(true).toUriString();
		if (prefix != null) {
			setViewName(String.format("%s:%s", prefix, url));
		} else {
			View view = getView();
			if (view != null && view instanceof RedirectView) {
				((RedirectView)view).setUrl(url);
			} else {
				logger.error("Could not reset url.");
			}
		}
	}

}
