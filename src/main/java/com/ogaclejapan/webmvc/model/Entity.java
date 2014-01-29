package com.ogaclejapan.webmvc.model;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;

/**
 * {@link ResponseEntity}のモデルを{@link ModelMap}型に設定したApiの戻り値
 * @author ogaclejapan
 *
 */
public class Entity extends ResponseEntity<ModelMap> {
	
	private final ModelMap model;
	
	//__/__/__/__/__/__/__/__/__/__/
	// Constrcutors
	//__/__/__/__/__/__/__/__/__/__/

	public Entity(HttpStatus statusCode) {
		this(new ModelMap(), statusCode);
	}

	private Entity(ModelMap body, HttpStatus statusCode) {
		super(body, statusCode);
		this.model = body;
	}
	
	//__/__/__/__/__/__/__/__/__/__/
	// Methods
	//__/__/__/__/__/__/__/__/__/__/

	public Entity addObject(String attributeName, Object attributeValue) {
		getModelMap().addAttribute(attributeName, attributeValue);
		return this;
	}
	
	public Entity addAllObjects(Map<String, ?> modelMap) {
		getModelMap().addAllAttributes(modelMap);
		return this;
	}
	
	protected ModelMap getModelMap() {
		return model;
	}

}
