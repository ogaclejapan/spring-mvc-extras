package com.ogaclejapan.webmvc.builder;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.ogaclejapan.webmvc.model.AlertType;
import com.ogaclejapan.webmvc.model.ToastType;

/**
 * リクエスト処理正常時に返却する{@link ModelAndView}のモデルを組み立てるクラス
 * 
 * @author ogaclejapan
 * 
 */
public final class AcceptModelBuilder extends ModelAndView implements ModelBuilder<AcceptModelBuilder> {

	private final WebResponseBuilder<AcceptModelBuilder> builder = new WebResponseBuilder<AcceptModelBuilder>(this,
			ToastType.Success, AlertType.Success);;

	// __/__/__/__/__/__/__/__/__/__/
	// Constructors
	// __/__/__/__/__/__/__/__/__/__/

	public AcceptModelBuilder() {
		super();
	}

	public AcceptModelBuilder(String viewName) {
		super(viewName);
	}

	// __/__/__/__/__/__/__/__/__/__/
	// Methods
	// __/__/__/__/__/__/__/__/__/__/

	@Override
	public AcceptModelBuilder data(String key, Object value) {
		return builder.data(key, value);
	}

	@Override
	public DataIfBuilder<AcceptModelBuilder> dataIf(boolean condition) {
		return builder.dataIf(condition);
	}

	@Override
	public AcceptModelBuilder toast(String message) {
		return builder.toast(message);
	}

	@Override
	public AcceptModelBuilder toast(String message, ToastType type) {
		return builder.toast(message, type);
	}

	@Override
	public AcceptModelBuilder toast(String message, String title) {
		return builder.toast(message, title);
	}

	@Override
	public AcceptModelBuilder toast(String message, String title, ToastType type) {
		return builder.toast(message, title, type);
	}

	@Override
	public ToastIfBuilder<AcceptModelBuilder> toastIf(boolean condition) {
		return builder.toastIf(condition);
	}

	@Override
	public AcceptModelBuilder alert(String message) {
		return builder.alert(message);
	}

	@Override
	public AcceptModelBuilder alert(String message, AlertType type) {
		return builder.alert(message, type);
	}

	@Override
	public AcceptModelBuilder alert(String message, String title) {
		return builder.alert(message, title);
	}

	@Override
	public AcceptModelBuilder alert(String message, String title, AlertType type) {
		return builder.alert(message, title, type);
	}

	@Override
	public AlertIfBuilder<AcceptModelBuilder> alertIf(boolean condition) {
		return builder.alertIf(condition);
	}

	@Override
	public ModelMap getDataModel() {
		return getModelMap();
	}

}
