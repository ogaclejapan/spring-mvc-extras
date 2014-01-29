package com.ogaclejapan.webmvc.builder;

import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;

import com.ogaclejapan.webmvc.model.AlertType;
import com.ogaclejapan.webmvc.model.Entity;
import com.ogaclejapan.webmvc.model.ToastType;

/**
 * リクエスト処理破棄時に返却する{@link Entity}のモデルを組み立てるクラス
 * 
 * @author ogaclejapan
 * 
 */
public final class RejectEntityBuilder extends Entity implements ModelBuilder<RejectEntityBuilder> {

	private final WebResponseBuilder<RejectEntityBuilder> builder = new WebResponseBuilder<RejectEntityBuilder>(
			this, ToastType.Warning, AlertType.Warning);

	// __/__/__/__/__/__/__/__/__/__/
	// Constructors
	// __/__/__/__/__/__/__/__/__/__/

	public RejectEntityBuilder() {
		this(HttpStatus.BAD_REQUEST);
	}

	public RejectEntityBuilder(HttpStatus statusCode) {
		super(statusCode);
	}

	// __/__/__/__/__/__/__/__/__/__/
	// Methods
	// __/__/__/__/__/__/__/__/__/__/

	@Override
	public RejectEntityBuilder data(String key, Object value) {
		return builder.data(key, value);
	}

	@Override
	public DataIfBuilder<RejectEntityBuilder> dataIf(boolean condition) {
		return builder.dataIf(condition);
	}

	@Override
	public RejectEntityBuilder toast(String message) {
		return builder.toast(message);
	}

	@Override
	public RejectEntityBuilder toast(String message, ToastType type) {
		return builder.toast(message, type);
	}

	@Override
	public RejectEntityBuilder toast(String message, String title) {
		return builder.toast(message, title);
	}

	@Override
	public RejectEntityBuilder toast(String message, String title, ToastType type) {
		return builder.toast(message, title, type);
	}

	@Override
	public ToastIfBuilder<RejectEntityBuilder> toastIf(boolean condition) {
		return builder.toastIf(condition);
	}

	@Override
	public RejectEntityBuilder alert(String message) {
		return builder.alert(message);
	}

	@Override
	public RejectEntityBuilder alert(String message, AlertType type) {
		return builder.alert(message, type);
	}

	@Override
	public RejectEntityBuilder alert(String message, String title) {
		return builder.alert(message, title);
	}

	@Override
	public RejectEntityBuilder alert(String message, String title, AlertType type) {
		return builder.alert(message, title, type);
	}

	@Override
	public AlertIfBuilder<RejectEntityBuilder> alertIf(boolean condition) {
		return builder.alertIf(condition);
	}

	@Override
	public ModelMap getDataModel() {
		return getModelMap();
	}

}
