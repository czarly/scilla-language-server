package org.butterflylabs.zilliqa.xtext.scoping


import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import org.butterflylabs.zilliqa.xtext.scilla.ScillaPackage

class ScillaIndex {
	@Inject ResourceDescriptionsProvider rdp
	def getResourceDescription(EObject o) {
		val index = rdp.getResourceDescriptions(o.eResource) index.getResourceDescription(o.eResource.URI)
	}

	def getExportedEObjectDescriptions(EObject o) { 
		o.getResourceDescription.getExportedObjects
	}

	def getExportedVariablesEObjectDescriptions(EObject o) { 
		o.getResourceDescription.getExportedObjectsByType(ScillaPackage.eINSTANCE.variableDeclaration) 
	}
}