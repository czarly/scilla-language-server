package org.butterflylabs.zilliqa.xtext.scoping;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedHashSet;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider;

public class ScillaImportUriGlobalScopeProvider extends ImportUriGlobalScopeProvider {
	private void addStandardLibrary(LinkedHashSet<URI> temp, String library) {
		URL url = this.getClass().getClassLoader().getResource("stdlib/" + library + ".scilla");
		URI uri;
		try {
			uri = URI.createURI(url.toURI().toString());
			temp.add(uri);

		} catch (URISyntaxException e) {
			e.printStackTrace();
		}		
	}
	
	@Override
	protected LinkedHashSet<URI> getImportedUris(Resource resource) {
		LinkedHashSet<URI> temp = super.getImportedUris(resource);
		
		addStandardLibrary(temp, "ImplicitVariables");
		
		addStandardLibrary(temp, "BoolUtils");
		addStandardLibrary(temp, "IntUtils");
		addStandardLibrary(temp, "ListUtils");
		addStandardLibrary(temp, "NatUtils");
		addStandardLibrary(temp, "PairUtils");
		
		// 
				
		/*temp.add(URI.createURI("classpath:BoolUtils.scilla"));
		temp.add(URI.createURI("classpath:IntUtils.scilla"));*/
		
		// here you can add implicit imports
		return temp;
	}
}
