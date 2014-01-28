package com.ogaclejapan.webmvc.builder;

import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;

import com.ogaclejapan.webmvc.model.AlertType;
import com.ogaclejapan.webmvc.model.ToastType;

/**
 * 応答例外のモデルを組み立てる内部ビルダー
 * @author ogaclejapan
 *
 * @param <T>
 */
public class WebResponseExceptionBuilder<T extends ExceptionModelBuilder<T>> extends WebResponseBuilder<T> implements ExceptionModelBuilder<T> {

	private final ModelMap model = new ModelMap();
	
	private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

	//__/__/__/__/__/__/__/__/__/__/
	// Constructors
	//__/__/__/__/__/__/__/__/__/__/

	public WebResponseExceptionBuilder(T builder) {
		this(builder, ToastType.Error, AlertType.Error);
	}
	
	public WebResponseExceptionBuilder(T builder, ToastType toastType, AlertType alertType) {
		super(builder, toastType, alertType);
	}
	
	// __/__/__/__/__/__/__/__/__/__/
	// Methods
	// __/__/__/__/__/__/__/__/__/__/

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T status(HttpStatus status) {
		setStatus(status);
		return getBuilder();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HttpStatus getStatus() {
		return status;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ModelMap getDataModel() {
		return model;
	}

	protected void setStatus(HttpStatus status) {
		this.status = status;
	}

}
