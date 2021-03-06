/*
 * generated by Xtext 2.16.0
 */
package org.butterflylabs.zilliqa.xtext.ide

import com.google.inject.Guice
import org.butterflylabs.zilliqa.xtext.ScillaRuntimeModule
import org.butterflylabs.zilliqa.xtext.ScillaStandaloneSetup
import org.eclipse.xtext.util.Modules2

/**
 * Initialization support for running Xtext languages as language servers.
 */
class ScillaIdeSetup extends ScillaStandaloneSetup {

	override createInjector() {
		Guice.createInjector(Modules2.mixin(new ScillaRuntimeModule, new ScillaIdeModule))
	}
	
}
