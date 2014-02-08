package com.ogaclejapan.webmvc;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DataModelBuilderTest {

	DataModelBuilder builder = null;
	Page page = null;

	@Before
	public void setUp() throws Exception {
		page = new Page();
		builder = new DataModelBuilder(page);
	}

	@Test
	public void data_指定したkeyにvalueが格納されること() {
		builder.data("key1", "foo").data("key2", "bar");

		assertThat((String)page.get("key1"), is("foo"));
		assertThat((String)page.get("key2"), is("bar"));
	}
	
	@Test
	public void data_指定したkeyが既に存在する場合はvalueが上書きされること() {
		builder.data("key1", "foo").data("key1", "bar");
		
		assertThat((String)page.get("key1"), is("bar"));
	}

	@Test
	public void dataIf_conditionが真の場合はthenハンドラが処理されること() {
		builder.dataIf(true, new DataIfHandler() {
			@Override
			public void call(DataBuilder builder) {
				builder.data("key1", "foo");
			}
		});
		
		assertThat((String)page.get("key1"), is("foo"));
	}
	
	@Test
	public void dataIf_conditionが偽でotherwiseハンドラを省略した場合はthenが処理されないこと() {
		builder.dataIf(false, new DataIfHandler() {
			@Override
			public void call(DataBuilder builder) {
				builder.data("key1", "foo");
			}
		});
		
		assertThat((String)page.get("key1"), is(nullValue()));
	}
	
	@Test
	public void dataIf_conditionが偽でotherwiseハンドラを指定している場合はotherwiseハンドラが処理されること() {
		builder.dataIf(false, DataIfHandler.NULL, new DataIfHandler() {
			@Override
			public void call(DataBuilder builder) {
				builder.data("key1", "foo");
			}
		});
		
		assertThat((String)page.get("key1"), is("foo"));
	}
}
