package com.ogaclejapan.webmvc.builder;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.ogaclejapan.webmvc.model.AlertType;
import com.ogaclejapan.webmvc.model.Page;
import com.ogaclejapan.webmvc.model.ToastType;

/**
 * リクエスト処理破棄時に返却する{@link ModelAndView}のモデルを組み立てるクラス
 * 
 * @author ogaclejapan
 * 
 */
public final class RejectPageBuilder extends Page implements ModelBuilder<RejectPageBuilder> {

	private final WebResponseBuilder<RejectPageBuilder> builder = new WebResponseBuilder<RejectPageBuilder>(this,
			ToastType.Warning, AlertType.Warning);

	// __/__/__/__/__/__/__/__/__/__/
	// Constructors
	// __/__/__/__/__/__/__/__/__/__/

	public RejectPageBuilder() {
		super();
	}

	// __/__/__/__/__/__/__/__/__/__/
	// Methods
	// __/__/__/__/__/__/__/__/__/__/

	@Override
	public RejectPageBuilder data(String key, Object value) {
		return builder.data(key, value);
	}

	@Override
	public DataIfBuilder<RejectPageBuilder> dataIf(boolean condition) {
		return builder.dataIf(condition);
	}

	@Override
	public RejectPageBuilder toast(String message) {
		return builder.toast(message);
	}

	@Override
	public RejectPageBuilder toast(String message, ToastType type) {
		return builder.toast(message, type);
	}

	@Override
	public RejectPageBuilder toast(String message, String title) {
		return builder.toast(message, title);
	}

	@Override
	public RejectPageBuilder toast(String message, String title, ToastType type) {
		return builder.toast(message, title, type);
	}

	@Override
	public ToastIfBuilder<RejectPageBuilder> toastIf(boolean condition) {
		return builder.toastIf(condition);
	}

	@Override
	public RejectPageBuilder alert(String message) {
		return builder.alert(message);
	}

	@Override
	public RejectPageBuilder alert(String message, AlertType type) {
		return builder.alert(message, type);
	}

	@Override
	public RejectPageBuilder alert(String message, String title) {
		return builder.alert(message, title);
	}

	@Override
	public RejectPageBuilder alert(String message, String title, AlertType type) {
		return builder.alert(message, title, type);
	}

	@Override
	public AlertIfBuilder<RejectPageBuilder> alertIf(boolean condition) {
		return builder.alertIf(condition);
	}

	@Override
	public ModelMap getDataModel() {
		return getModelMap();
	}

}
