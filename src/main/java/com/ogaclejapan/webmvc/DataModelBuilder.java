package com.ogaclejapan.webmvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * {@link Context}型のデータモデルを処理するビルダー.
 * @author ogaclejapan
 *
 */
public class DataModelBuilder implements DataBuilder {

	private static final Logger logger = LoggerFactory.getLogger(DataModelBuilder.class);

	private final Context model;
	
	//__/__/__/__/__/__/__/__/__/__/
	// Constructors
	//__/__/__/__/__/__/__/__/__/__/

	public DataModelBuilder(Context model) {
		this.model = model;
	}

	//__/__/__/__/__/__/__/__/__/__/
	// Methods
	//__/__/__/__/__/__/__/__/__/__/
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public DataBuilder data(String key, Object value) {
		addData(key, value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DataBuilder dataIf(boolean condition, DataIfHandler then) {
		return dataIf(condition, then, DataIfHandler.NULL);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DataBuilder dataIf(boolean condition, DataIfHandler then, DataIfHandler otherwise) {
		if (condition) {
			then.call(this);
		} else {
			otherwise.call(this);
		}
		return this;
	}

	protected void addData(String key, Object value) {
		Assert.notNull(key, "'key' must not be null.");

		if (model.hasValue(key)) {
			logger.warn("'" + key + "' already exists.");
		}
		model.put(key, value);

	}

}
