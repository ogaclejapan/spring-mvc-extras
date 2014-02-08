package com.ogaclejapan.webmvc;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UrlComponentsBuilderTest {

	static class MockUrl implements Url {

		private String url;

		public MockUrl(String url) {
			this.url = url;
		}

		@Override
		public void setUrl(String url) {
			this.url = url;
		}

		@Override
		public String getUrl() {
			return url;
		}

	}

	MockUrl url = null;
	UrlComponentsBuilder builder = null;

	@Before
	public void setUp() throws Exception {
		url = new MockUrl("http://ogaclejapan.com");
		builder = new UrlComponentsBuilder(url);
	}

	@Test
	public void path_指定したpathがURLに追加されること() {
		builder.path("hoge");
		assertThat(url.getUrl(), is("http://ogaclejapan.com/hoge"));
	}
	
	@Test
	public void query_指定したqueryがURLに追加されること() {
		builder.query("hoge=age");
		assertThat(url.getUrl(), is("http://ogaclejapan.com?hoge=age"));
	}
	
	@Test
	public void queryParam_指定したqueryパラメータがURLに追加されること() {
		builder.queryParam("hoge", "age");
		assertThat(url.getUrl(), is("http://ogaclejapan.com?hoge=age"));
	}
	
	@Test
	public void fragment_指定したフラグメントがURLに追加されること() {
		builder.fragment("hoge");
		assertThat(url.getUrl(), is("http://ogaclejapan.com#hoge"));
	}

}
