package org.infra.stringproperties.example;

import org.infra.stringproperties.StringProperties;

/**
 * Example of View and SubViews (a subset of keys)
 */
public class Example1 {
	public static void main(final String[] args) throws Throwable {
		StringProperties p = new StringProperties();
		// Use SubView: view1
		StringProperties v1 = p.getSubView("view1");
		v1.setProperty("msg", "Test Message");
		// Use SubView: view2
		StringProperties v2 = p.getSubView("view2");
		v2.setProperty("msg", "Another Test Message");
		// Get Keys
		System.out.println(v1.getProperty("msg"));
		System.out.println(v2.getProperty("msg"));
		// Equivalent using full key name
		System.out.println(p.getProperty("view1.msg"));
		System.out.println(p.getProperty("view2.msg"));
		// You can get the Root View of a SubView
		v2.getRootView().list(System.out);
	}
}
