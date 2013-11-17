package com.ogaclejapan.webmvc.builder;

import org.springframework.web.servlet.ModelAndView;

import com.ogaclejapan.webmvc.model.AlertType;
import com.ogaclejapan.webmvc.model.ToastType;

/**
 * リクエスト処理正常時に返却する{@link ModelAndView}のモデルを組み立てるクラス
 * @author ogaclejapan
 *
 */
public class AcceptModelBuilder extends WebPageModelBuilder<AcceptModelBuilder> {

	private static final ToastType defaultToastType = ToastType.Success;
	private static final AlertType defaultAlertType = AlertType.Success;
	
	//__/__/__/__/__/__/__/__/__/__/
	// Constructors
	//__/__/__/__/__/__/__/__/__/__/

	public AcceptModelBuilder() {
		super();
	}
	
	public AcceptModelBuilder(String viewName) {
		super(viewName);
	}

	//__/__/__/__/__/__/__/__/__/__/
	// Methods
	//__/__/__/__/__/__/__/__/__/__/

	@Override
	public AcceptModelBuilder model(String attributeName, Object attributeValue) {
		addModel(attributeName, attributeValue);
		return this;
	}

	@Override
	public AcceptModelBuilder toast(String message) {
		return toast(message, defaultToastType);
	}

	@Override
	public AcceptModelBuilder toast(String message, ToastType type) {
		return toast(message, null, type);
	}
	
	@Override
	public AcceptModelBuilder toast(String message, String title) {
		return toast(message, title, defaultToastType);
	}

	@Override
	public AcceptModelBuilder toast(String message, String title, ToastType type) {
		addToast(message, title, type);
		return this;
	}

	@Override
	public AcceptModelBuilder alert(String message) {
		return alert(message, defaultAlertType);
	}

	@Override
	public AcceptModelBuilder alert(String message, AlertType type) {
		return alert(message, null, type);
	}
	
	@Override
	public AcceptModelBuilder alert(String message, String title) {
		return alert(message, title, defaultAlertType);
	}

	@Override
	public AcceptModelBuilder alert(String message, String title, AlertType type) {
		addAlert(message, title, type);
		return this;
	}

}
