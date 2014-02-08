package com.ogaclejapan.webmvc;

/**
 * URLを参照／設定することができるインタフェース.
 * @author ogaclejapan
 *
 */
public interface Url {

	/**
	 * URLを設定する
	 * @param url
	 */
	void setUrl(String url);
	
	/**
	 * URLを取得する
	 * @return
	 */
	String getUrl();
}
