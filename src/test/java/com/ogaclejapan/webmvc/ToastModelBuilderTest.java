package com.ogaclejapan.webmvc;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ToastModelBuilderTest {

	Page page = null;
	ToastModelBuilder builder = null;

	@Before
	public void setUp() throws Exception {
		page = new Page();
		builder = new ToastModelBuilder(page, ToastType.Warning);
	}

	@Test
	public void toast_messageのみ指定した場合はtitleとtypeがデフォルト値であること() {
		builder.toast("hoge");

		List<Toast> actuals = getActuals();
		assertThat(actuals.get(0).getMessage(), is("hoge"));
		assertThat(actuals.get(0).getTitle(), is(nullValue()));
		assertThat(actuals.get(0).getType(), is(ToastType.Warning));
	}

	@Test
	public void toast_messageとtypeを指定した場合はtitleのみがデフォルト値であること() {
		builder.toast("hoge", ToastType.Error);

		List<Toast> actuals = getActuals();
		assertThat(actuals.get(0).getMessage(), is("hoge"));
		assertThat(actuals.get(0).getTitle(), is(nullValue()));
		assertThat(actuals.get(0).getType(), is(ToastType.Error));
	}

	@Test
	public void toast_messageとtitleを指定した場合はtypeのみがデフォルト値であること() {
		builder.toast("hoge", "foo");

		List<Toast> actuals = getActuals();
		assertThat(actuals.get(0).getMessage(), is("hoge"));
		assertThat(actuals.get(0).getTitle(), is("foo"));
		assertThat(actuals.get(0).getType(), is(ToastType.Warning));
	}

	@Test
	public void toast_messageとtitleとtypeを指定した場合はすべて指定した値であること() {
		builder.toast("hoge", "foo", ToastType.Info);

		List<Toast> actuals = getActuals();
		assertThat(actuals.get(0).getMessage(), is("hoge"));
		assertThat(actuals.get(0).getTitle(), is("foo"));
		assertThat(actuals.get(0).getType(), is(ToastType.Info));
	}

	@Test
	public void toast_２つ以上の通知を設定できること() {
		builder.toast("hoge").toast("age");

		List<Toast> actuals = getActuals();
		assertThat(actuals.size(), is(2));
		assertThat(actuals.get(0).getMessage(), is("hoge"));
		assertThat(actuals.get(1).getMessage(), is("age"));
	}

	@Test
	public void toastIf_conditionが真の場合はthenハンドラが実行されること() {
		builder.toastIf(true, new ToastIfHandler() {
			@Override
			public void call(ToastBuilder builder) {
				builder.toast("called then");
			}
		});

		assertThat(getActuals().get(0).getMessage(), is("called then"));
	}

	@Test
	public void toastIf_conditionが偽の場合でotherwiseが指定されていない場合はthenハンドラが実行されないこと() {
		builder.toastIf(false, new ToastIfHandler() {

			@Override
			public void call(ToastBuilder builder) {
				builder.toast("called then");
			}
		});

		assertThat(getActuals(), is(nullValue()));
	}

	@Test
	public void toastIf_conditionが偽の場合でotherwiseが指定されている場合はotherwiseハンドラが実行されること() {
		builder.toastIf(false, ToastIfHandler.NULL, new ToastIfHandler() {
			@Override
			public void call(ToastBuilder builder) {
				builder.toast("called otherwise");
			}
		});

		assertThat(getActuals().get(0).getMessage(), is("called otherwise"));
	}

	@SuppressWarnings("unchecked")
	private List<Toast> getActuals() {
		return (List<Toast>) page.get(ToastBuilder.TOAST_ATTRIBUTE_NAME);
	}

}
