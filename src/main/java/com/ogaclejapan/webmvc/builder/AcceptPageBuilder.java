package com.ogaclejapan.webmvc.builder;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.ogaclejapan.webmvc.model.AlertType;
import com.ogaclejapan.webmvc.model.Page;
import com.ogaclejapan.webmvc.model.ToastType;

/**
 * リクエスト処理正常時に返却する{@link ModelAndView}のモデルを組み立てるクラス
 * 
 * @author ogaclejapan
 * 
 */
public final class AcceptPageBuilder extends Page implements ModelBuilder<AcceptPageBuilder> {

	private final WebResponseBuilder<AcceptPageBuilder> builder = new WebResponseBuilder<AcceptPageBuilder>(this,
			ToastType.Success, AlertType.Success);;

	// __/__/__/__/__/__/__/__/__/__/
	// Constructors
	// __/__/__/__/__/__/__/__/__/__/

	public AcceptPageBuilder() {
		super();
	}

	public AcceptPageBuilder(String viewName) {
		super(viewName);
	}

	// __/__/__/__/__/__/__/__/__/__/
	// Methods
	// __/__/__/__/__/__/__/__/__/__/

	@Override
	public AcceptPageBuilder data(String key, Object value) {
		return builder.data(key, value);
	}

	@Override
	public DataIfBuilder<AcceptPageBuilder> dataIf(boolean condition) {
		return builder.dataIf(condition);
	}

	@Override
	public AcceptPageBuilder toast(String message) {
		return builder.toast(message);
	}

	@Override
	public AcceptPageBuilder toast(String message, ToastType type) {
		return builder.toast(message, type);
	}

	@Override
	public AcceptPageBuilder toast(String message, String title) {
		return builder.toast(message, title);
	}

	@Override
	public AcceptPageBuilder toast(String message, String title, ToastType type) {
		return builder.toast(message, title, type);
	}

	@Override
	public ToastIfBuilder<AcceptPageBuilder> toastIf(boolean condition) {
		return builder.toastIf(condition);
	}

	@Override
	public AcceptPageBuilder alert(String message) {
		return builder.alert(message);
	}

	@Override
	public AcceptPageBuilder alert(String message, AlertType type) {
		return builder.alert(message, type);
	}

	@Override
	public AcceptPageBuilder alert(String message, String title) {
		return builder.alert(message, title);
	}

	@Override
	public AcceptPageBuilder alert(String message, String title, AlertType type) {
		return builder.alert(message, title, type);
	}

	@Override
	public AlertIfBuilder<AcceptPageBuilder> alertIf(boolean condition) {
		return builder.alertIf(condition);
	}

	@Override
	public ModelMap getDataModel() {
		return getModelMap();
	}

}
