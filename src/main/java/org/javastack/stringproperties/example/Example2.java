package org.javastack.stringproperties.example;

import org.javastack.stringproperties.StringProperties;

/**
 * Example of PlaceHolders
 */
public class Example2 {
	public static void main(final String[] args) throws Throwable {
		StringProperties p = new StringProperties();
		p.setProperty("state", "awake");
		p.setProperty("msg", "Hi ${user.name}, are you ${state}?");
		System.out.println(p.getPropertyEval("msg"));
	}
}
