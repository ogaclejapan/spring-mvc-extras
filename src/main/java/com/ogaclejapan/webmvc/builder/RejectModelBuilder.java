package com.ogaclejapan.webmvc.builder;

import org.springframework.web.servlet.ModelAndView;

import com.ogaclejapan.webmvc.model.AlertType;
import com.ogaclejapan.webmvc.model.ToastType;

/**
 * リクエスト処理破棄時に返却する{@link ModelAndView}のモデルを組み立てるクラス
 * @author ogaclejapan
 *
 */
public class RejectModelBuilder extends WebPageModelBuilder<RejectModelBuilder> {

	private static final ToastType defaultToastType = ToastType.Warning;
	private static final AlertType defaultAlertType = AlertType.Warning;
	
	//__/__/__/__/__/__/__/__/__/__/
	// Constructors
	//__/__/__/__/__/__/__/__/__/__/

	public RejectModelBuilder() {
		super();
	}
	
	//__/__/__/__/__/__/__/__/__/__/
	// Methods
	//__/__/__/__/__/__/__/__/__/__/

	@Override
	public RejectModelBuilder model(String attributeName, Object attributeValue) {
		addModel(attributeName, attributeValue);
		return this;
	}

	@Override
	public RejectModelBuilder toast(String message) {
		return toast(message, defaultToastType);
	}

	@Override
	public RejectModelBuilder toast(String message, ToastType type) {
		return toast(message, null, type);
	}
	
	@Override
	public RejectModelBuilder toast(String message, String title) {
		return toast(message, title, defaultToastType);
	}

	@Override
	public RejectModelBuilder toast(String message, String title, ToastType type) {
		addToast(message, title, type);
		return this;
	}

	@Override
	public RejectModelBuilder alert(String message) {
		return alert(message, defaultAlertType);
	}

	@Override
	public RejectModelBuilder alert(String message, AlertType type) {
		return alert(message, null, type);
	}
	
	@Override
	public RejectModelBuilder alert(String message, String title) {
		return alert(message, title, defaultAlertType);
	}

	@Override
	public RejectModelBuilder alert(String message, String title, AlertType type) {
		addAlert(message, title, type);
		return this;
	}

}
