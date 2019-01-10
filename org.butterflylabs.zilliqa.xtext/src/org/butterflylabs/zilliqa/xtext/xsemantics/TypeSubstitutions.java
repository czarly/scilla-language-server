package org.butterflylabs.zilliqa.xtext.xsemantics;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.butterflylabs.zilliqa.xtext.scilla.Type;

public class TypeSubstitutions {

	LambdaUtils lambdaUtils = new LambdaUtils();
	protected Map<String, Type> substitutions = new HashMap<String, Type>();

	public void reset() {
		substitutions.clear();
	}

	public void add(String typeVariableName, Type mapped) {
		substitutions.put(typeVariableName, mapped);
	}

	public Type mapped(String typeVariableName) {
		return substitutions.get(typeVariableName);
	}

	public Set<Entry<String, Type>> getSubstitutions() {
		return substitutions.entrySet();
	}

}
