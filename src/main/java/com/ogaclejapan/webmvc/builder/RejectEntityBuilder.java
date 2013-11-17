package com.ogaclejapan.webmvc.builder;

import org.springframework.http.HttpStatus;

import com.ogaclejapan.webmvc.model.AlertType;
import com.ogaclejapan.webmvc.model.ApiEntity;
import com.ogaclejapan.webmvc.model.ToastType;

/**
 * リクエスト処理破棄時に返却する{@link ApiEntity}のモデルを組み立てるクラス
 * @author ogaclejapan
 *
 */
public class RejectEntityBuilder extends WebApiEntityBuilder<RejectEntityBuilder> {

	private static final ToastType defaultToastType = ToastType.Warning;
	private static final AlertType defaultAlertType = AlertType.Warning;
	
	//__/__/__/__/__/__/__/__/__/__/
	// Constructors
	//__/__/__/__/__/__/__/__/__/__/

	public RejectEntityBuilder() {
		this(HttpStatus.BAD_REQUEST);
	}
	
	public RejectEntityBuilder(HttpStatus statusCode) {
		super(statusCode);
	}

	//__/__/__/__/__/__/__/__/__/__/
	// Methods
	//__/__/__/__/__/__/__/__/__/__/

	@Override
	public RejectEntityBuilder model(String attributeName, Object attributeValue) {
		addModel(attributeName, attributeValue);
		return this;
	}

	@Override
	public RejectEntityBuilder toast(String message) {
		return toast(message, defaultToastType);
	}

	@Override
	public RejectEntityBuilder toast(String message, ToastType type) {
		return toast(message, null, type);
	}

	@Override
	public RejectEntityBuilder toast(String message, String title) {
		return toast(message, title, defaultToastType);
	}

	@Override
	public RejectEntityBuilder toast(String message, String title, ToastType type) {
		addToast(message, title, type);
		return this;
	}

	@Override
	public RejectEntityBuilder alert(String message) {
		return alert(message, defaultAlertType);
	}

	@Override
	public RejectEntityBuilder alert(String message, AlertType type) {
		return alert(message, null, type);
	}

	@Override
	public RejectEntityBuilder alert(String message, String title) {
		return alert(message, title, defaultAlertType);
	}

	@Override
	public RejectEntityBuilder alert(String message, String title, AlertType type) {
		addAlert(message, title, type);
		return this;
	}

}
