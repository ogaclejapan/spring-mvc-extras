package com.ogaclejapan.webmvc;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AlertModelBuilderTest {

	Page page = null;
	AlertModelBuilder builder = null;
	
	@Before
	public void setUp() throws Exception {
		page = new Page();
		builder = new AlertModelBuilder(page, AlertType.Warning);
	}

	@Test
	public void alert_messageのみ指定した場合はtitleとtypeがデフォルト値であること() {
		builder.alert("hoge");
		
		List<Alert> actuals = getActuals();
		assertThat(actuals.get(0).getMessage(), is("hoge"));
		assertThat(actuals.get(0).getTitle(), is(nullValue()));
		assertThat(actuals.get(0).getType(), is(AlertType.Warning));
	}
	
	@Test
	public void alert_messageとtypeを指定した場合はtitleのみがデフォルト値であること() {
		builder.alert("hoge", AlertType.Error);
		
		List<Alert> actuals = getActuals();
		assertThat(actuals.get(0).getMessage(), is("hoge"));
		assertThat(actuals.get(0).getTitle(), is(nullValue()));
		assertThat(actuals.get(0).getType(), is(AlertType.Error));
	}
	
	@Test
	public void alert_messageとtitleを指定した場合はtypeのみがデフォルト値であること() {
		builder.alert("hoge", "foo");
		
		List<Alert> actuals = getActuals();
		assertThat(actuals.get(0).getMessage(), is("hoge"));
		assertThat(actuals.get(0).getTitle(), is("foo"));
		assertThat(actuals.get(0).getType(), is(AlertType.Warning));
	}
	
	@Test
	public void alert_messageとtitleとtypeを指定した場合はすべて指定した値であること() {
		builder.alert("hoge", "foo", AlertType.Info);
		
		List<Alert> actuals = getActuals();
		assertThat(actuals.get(0).getMessage(), is("hoge"));
		assertThat(actuals.get(0).getTitle(), is("foo"));
		assertThat(actuals.get(0).getType(), is(AlertType.Info));
	}
	
	@Test
	public void alert_２つ以上の通知を設定できること() {
		builder.alert("hoge").alert("age");
		
		List<Alert> actuals = getActuals();
		assertThat(actuals.size(), is(2));
		assertThat(actuals.get(0).getMessage(), is("hoge"));
		assertThat(actuals.get(1).getMessage(), is("age"));
	}
	
	@Test
	public void alertIf_conditionが真の場合はthenハンドラが実行されること() {
		builder.alertIf(true, new AlertIfHandler() {
			@Override
			public void call(AlertBuilder builder) {
				builder.alert("called then");
			}
		});
		
		assertThat(getActuals().get(0).getMessage(), is("called then"));
	}
	
	@Test
	public void alertIf_conditionが偽の場合でotherwiseが指定されていない場合はthenハンドラが実行されないこと() {
		builder.alertIf(false, new AlertIfHandler() {
			
			@Override
			public void call(AlertBuilder builder) {
				builder.alert("called then");
			}
		});
		
		assertThat(getActuals(), is(nullValue()));
	}
	
	@Test
	public void alertIf_conditionが偽の場合でotherwiseが指定されている場合はotherwiseハンドラが実行されること() {
		builder.alertIf(false, AlertIfHandler.NULL, new AlertIfHandler() {
			@Override
			public void call(AlertBuilder builder) {
				builder.alert("called otherwise");
			}
		});
		
		assertThat(getActuals().get(0).getMessage(), is("called otherwise"));
	}
	
	@SuppressWarnings("unchecked")
	private List<Alert> getActuals() {
		return (List<Alert>)page.get(AlertBuilder.ALERT_ATTRIBUTE_NAME);
	}

}
