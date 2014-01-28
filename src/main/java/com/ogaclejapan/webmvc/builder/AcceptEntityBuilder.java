package com.ogaclejapan.webmvc.builder;

import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;

import com.ogaclejapan.webmvc.model.AlertType;
import com.ogaclejapan.webmvc.model.ApiEntity;
import com.ogaclejapan.webmvc.model.ToastType;

/**
 * リクエスト処理正常時に返却する{@link ApiEntity}を組み立てるクラス
 * 
 * @author ogaclejapan
 * 
 */
public class AcceptEntityBuilder extends ApiEntity implements ModelBuilder<AcceptEntityBuilder> {

	private final WebResponseBuilder<AcceptEntityBuilder> builder = new WebResponseBuilder<AcceptEntityBuilder>(
			this, ToastType.Success, AlertType.Success);

	// __/__/__/__/__/__/__/__/__/__/
	// Constructors
	// __/__/__/__/__/__/__/__/__/__/

	public AcceptEntityBuilder() {
		super(HttpStatus.OK);
	}

	// __/__/__/__/__/__/__/__/__/__/
	// Methods
	// __/__/__/__/__/__/__/__/__/__/

	@Override
	public AcceptEntityBuilder data(String key, Object value) {
		return builder.data(key, value);
	}

	@Override
	public DataIfBuilder<AcceptEntityBuilder> dataIf(boolean condition) {
		return builder.dataIf(condition);
	}

	@Override
	public AcceptEntityBuilder toast(String message) {
		return builder.toast(message);
	}

	@Override
	public AcceptEntityBuilder toast(String message, ToastType type) {
		return builder.toast(message, type);
	}

	@Override
	public AcceptEntityBuilder toast(String message, String title) {
		return builder.toast(message, title);
	}

	@Override
	public AcceptEntityBuilder toast(String message, String title, ToastType type) {
		return builder.toast(message, title, type);
	}

	@Override
	public ToastIfBuilder<AcceptEntityBuilder> toastIf(boolean condition) {
		return builder.toastIf(condition);
	}

	@Override
	public AcceptEntityBuilder alert(String message) {
		return builder.alert(message);
	}

	@Override
	public AcceptEntityBuilder alert(String message, AlertType type) {
		return builder.alert(message, type);
	}

	@Override
	public AcceptEntityBuilder alert(String message, String title) {
		return builder.alert(message, title);
	}

	@Override
	public AcceptEntityBuilder alert(String message, String title, AlertType type) {
		return builder.alert(message, title, type);
	}

	@Override
	public AlertIfBuilder<AcceptEntityBuilder> alertIf(boolean condition) {
		return builder.alertIf(condition);
	}

	@Override
	public ModelMap getDataModel() {
		return getModelMap();
	}

}
