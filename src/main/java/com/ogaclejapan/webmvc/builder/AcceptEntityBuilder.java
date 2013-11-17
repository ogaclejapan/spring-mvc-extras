package com.ogaclejapan.webmvc.builder;

import org.springframework.http.HttpStatus;

import com.ogaclejapan.webmvc.model.AlertType;
import com.ogaclejapan.webmvc.model.ApiEntity;
import com.ogaclejapan.webmvc.model.ToastType;

/**
 * リクエスト処理正常時に返却する{@link ApiEntity}を組み立てるクラス
 * @author ogaclejapan
 *
 */
public class AcceptEntityBuilder extends WebApiEntityBuilder<AcceptEntityBuilder> {

	private static final ToastType defaultToastType = ToastType.Success;
	private static final AlertType defaultAlertType = AlertType.Success;
	
	//__/__/__/__/__/__/__/__/__/__/
	// Constructors
	//__/__/__/__/__/__/__/__/__/__/

	public AcceptEntityBuilder() {
		super(HttpStatus.OK);
	}
	
	//__/__/__/__/__/__/__/__/__/__/
	// Methods
	//__/__/__/__/__/__/__/__/__/__/

	@Override
	public AcceptEntityBuilder model(String attributeName, Object attributeValue) {
		addModel(attributeName, attributeValue);
		return this;
	}

	@Override
	public AcceptEntityBuilder toast(String message) {
		return toast(message, defaultToastType);
	}

	@Override
	public AcceptEntityBuilder toast(String message, ToastType type) {
		return toast(message, null, type);
	}

	@Override
	public AcceptEntityBuilder toast(String message, String title) {
		return toast(message, title, defaultToastType);
	}

	@Override
	public AcceptEntityBuilder toast(String message, String title, ToastType type) {
		addToast(message, title, type);
		return this;
	}

	@Override
	public AcceptEntityBuilder alert(String message) {
		return alert(message, defaultAlertType);
	}

	@Override
	public AcceptEntityBuilder alert(String message, AlertType type) {
		return alert(message, null, type);
	}

	@Override
	public AcceptEntityBuilder alert(String message, String title) {
		return alert(message, title, defaultAlertType);
	}

	@Override
	public AcceptEntityBuilder alert(String message, String title, AlertType type) {
		addAlert(message, title, type);
		return this;
	}

}
