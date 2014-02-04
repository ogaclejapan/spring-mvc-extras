package com.ogaclejapan.webmvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;

/**
 * {@link ResponseEntity}のモデルを{@link ModelMap}型に設定したApiの戻り値
 * 
 * @author ogaclejapan
 * 
 */
public class Entity extends ResponseEntity<ModelMap> implements Context {

	private final ModelMap model;

	// __/__/__/__/__/__/__/__/__/__/
	// Constrcutors
	// __/__/__/__/__/__/__/__/__/__/

	public Entity(HttpStatus statusCode) {
		this(new ModelMap(), statusCode);
	}

	private Entity(ModelMap body, HttpStatus statusCode) {
		super(body, statusCode);
		this.model = body;
	}

	// __/__/__/__/__/__/__/__/__/__/
	// Methods
	// __/__/__/__/__/__/__/__/__/__/

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void put(String key, Object value) {
		model.put(key, value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object get(String key) {
		return model.get(key);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasValue(String key) {
		return model.containsKey(key);
	}

}
