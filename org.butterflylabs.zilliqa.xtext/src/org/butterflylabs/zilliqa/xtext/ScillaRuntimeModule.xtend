/*
 * generated by Xtext 2.16.0
 */
package org.butterflylabs.zilliqa.xtext

import com.google.inject.Binder
import com.google.inject.name.Names
import org.butterflylabs.zilliqa.xtext.scoping.ScillaImportUriGlobalScopeProvider
import org.butterflylabs.zilliqa.xtext.scoping.ScillaImportedNamespaceAwareLocalScopeProvider
import org.eclipse.xtext.scoping.IGlobalScopeProvider
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
class ScillaRuntimeModule extends AbstractScillaRuntimeModule {

	override void configureIScopeProviderDelegate(Binder binder) {
  		binder.bind(IScopeProvider).
  		annotatedWith(Names.named(AbstractDeclarativeScopeProvider.NAMED_DELEGATE))
  		.to(ScillaImportedNamespaceAwareLocalScopeProvider);
  	}
  	
	override Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider()
	{
    	return typeof(ScillaImportUriGlobalScopeProvider)
	}	
	
}
