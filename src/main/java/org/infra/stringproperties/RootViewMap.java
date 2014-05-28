package org.infra.stringproperties;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * Map view of a StringPropertiesRoot
 */
public class RootViewMap implements Map<String, String> {
	private final StringPropertiesRoot properties;

	public RootViewMap(final StringProperties properties) {
		this.properties = properties.getRootView();
	}

	@Override
	public int size() {
		return properties.size();
	}

	@Override
	public boolean isEmpty() {
		return properties.isEmpty();
	}

	@Override
	public boolean containsKey(final Object key) {
		if (key instanceof String)
			return (properties.getProperty((String) key) != null);
		throw new IllegalArgumentException("key must be String");
	}

	@Override
	public String get(final Object key) {
		if (key instanceof String)
			return properties.getProperty((String) key);
		throw new IllegalArgumentException("key must be String");
	}

	@Override
	public String put(final String key, final String value) {
		return properties.setProperty(key, value);
	}

	@Override
	public String remove(final Object key) {
		if (key instanceof String)
			return properties.removeProperty((String) key);
		throw new IllegalArgumentException("key must be String");
	}

	@Override
	public void putAll(final Map<? extends String, ? extends String> m) {
		properties.putAll(m);
	}

	@Override
	public void clear() {
		properties.clear();
	}

	@Override
	public Set<String> keySet() {
		return properties.stringPropertyNames();
	}

	@Override
	public boolean containsValue(final Object value) {
		if (value instanceof String) {
			synchronized (properties.map) {
				return properties.map.containsValue(value);
			}
		}
		throw new IllegalArgumentException("value must be String");
	}

	@Override
	public Collection<String> values() {
		synchronized (properties.map) {
			return Collections.unmodifiableCollection(properties.map.values());
		}
	}

	@Override
	public Set<Map.Entry<String, String>> entrySet() {
		synchronized (properties.map) {
			return Collections.unmodifiableSet(properties.map.entrySet());
		}
	}

	@Override
	public String toString() {
		synchronized (properties.map) {
			return properties.map.toString();
		}
	}
}
