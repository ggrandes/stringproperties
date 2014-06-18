package org.javastack.stringproperties;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.Map;
import java.util.Properties;

/**
 * Root View of StringProperties
 * 
 * @see StringProperties
 */
public class StringPropertiesRoot extends StringProperties {
	/**
	 * Constructor of a RootView of a StringProperties
	 * 
	 * @see StringProperties#StringProperties()
	 * @see StringProperties#getRootView()
	 */
	public StringPropertiesRoot() {
		super();
	}

	StringPropertiesRoot(final StringProperties source, final String rootPrefix) {
		super(source, rootPrefix);
	}

	/**
	 * Get a Map View of StringPropertiesRoot
	 * @return
	 */
	public RootViewMap getRootViewAsMap() {
		return new RootViewMap(this);
	}

	// Import / Export Legacy Properties

	public void putAll(final Properties p) {
		synchronized (map) {
			for (final String key : p.stringPropertyNames()) {
				map.put(key, p.getProperty(key));
			}
		}
	}

	public Properties toProperties() {
		synchronized (map) {
			final Properties p = new Properties();
			for (final Map.Entry<String, String> e : map.entrySet()) {
				p.setProperty(e.getKey(), e.getValue());
			}
			return p;
		}
	}

	// LOAD

	public void load(final InputStream inStream) throws IOException {
		synchronized (map) {
			persist.load(inStream);
		}
	}

	public void load(final StringReader reader) {
		synchronized (map) {
			try {
				persist.load(reader);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	// STORE

	public void store(final OutputStream out, final String comments) throws IOException {
		// Persist over OutputStream is preferred over Writer (this escape unicode characters)
		synchronized (map) {
			persist.store(out, comments);
		}
	}

	// From interface Map<String, String>

	public void clear() {
		synchronized (map) {
			map.clear();
		}
	}

	public void putAll(final Map<? extends String, ? extends String> m) {
		synchronized (map) {
			map.putAll(m);
		}
	}

	public int size() {
		synchronized (map) {
			return map.size();
		}
	}

	public boolean isEmpty() {
		return (size() == 0);
	}
}
