package com.ogaclejapan.webmvc;


/**
 * メソッドチェーンでURLを組み立てるためのインターフェース.
 * @author ogaclejapan
 *
 */
public interface UrlBuilder extends UrlChain<UrlBuilder> {
	
	static final String DEFAULT_ENCODING = "UTF-8";
	
}
