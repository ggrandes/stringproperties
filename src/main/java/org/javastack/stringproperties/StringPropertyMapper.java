package org.javastack.stringproperties;

import org.javastack.mapexpression.mapper.Mapper;

public class StringPropertyMapper implements Mapper {
	private final StringProperties prop;

	public StringPropertyMapper(final StringProperties prop) {
		this.prop = prop;
	}

	@Override
	public String map(final String propName) {
		return prop.getProperty(propName);
	}
}
