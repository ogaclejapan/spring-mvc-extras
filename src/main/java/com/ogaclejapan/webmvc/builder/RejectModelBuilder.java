package com.ogaclejapan.webmvc.builder;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.ogaclejapan.webmvc.model.AlertType;
import com.ogaclejapan.webmvc.model.ToastType;

/**
 * リクエスト処理破棄時に返却する{@link ModelAndView}のモデルを組み立てるクラス
 * 
 * @author ogaclejapan
 * 
 */
public final class RejectModelBuilder extends ModelAndView implements ModelBuilder<RejectModelBuilder> {

	private final WebResponseBuilder<RejectModelBuilder> builder = new WebResponseBuilder<RejectModelBuilder>(this,
			ToastType.Warning, AlertType.Warning);

	// __/__/__/__/__/__/__/__/__/__/
	// Constructors
	// __/__/__/__/__/__/__/__/__/__/

	public RejectModelBuilder() {
		super();
	}

	// __/__/__/__/__/__/__/__/__/__/
	// Methods
	// __/__/__/__/__/__/__/__/__/__/

	@Override
	public RejectModelBuilder data(String key, Object value) {
		return builder.data(key, value);
	}

	@Override
	public DataIfBuilder<RejectModelBuilder> dataIf(boolean condition) {
		return builder.dataIf(condition);
	}

	@Override
	public RejectModelBuilder toast(String message) {
		return builder.toast(message);
	}

	@Override
	public RejectModelBuilder toast(String message, ToastType type) {
		return builder.toast(message, type);
	}

	@Override
	public RejectModelBuilder toast(String message, String title) {
		return builder.toast(message, title);
	}

	@Override
	public RejectModelBuilder toast(String message, String title, ToastType type) {
		return builder.toast(message, title, type);
	}

	@Override
	public ToastIfBuilder<RejectModelBuilder> toastIf(boolean condition) {
		return builder.toastIf(condition);
	}

	@Override
	public RejectModelBuilder alert(String message) {
		return builder.alert(message);
	}

	@Override
	public RejectModelBuilder alert(String message, AlertType type) {
		return builder.alert(message, type);
	}

	@Override
	public RejectModelBuilder alert(String message, String title) {
		return builder.alert(message, title);
	}

	@Override
	public RejectModelBuilder alert(String message, String title, AlertType type) {
		return builder.alert(message, title, type);
	}

	@Override
	public AlertIfBuilder<RejectModelBuilder> alertIf(boolean condition) {
		return builder.alertIf(condition);
	}

	@Override
	public ModelMap getDataModel() {
		return getModelMap();
	}

}
