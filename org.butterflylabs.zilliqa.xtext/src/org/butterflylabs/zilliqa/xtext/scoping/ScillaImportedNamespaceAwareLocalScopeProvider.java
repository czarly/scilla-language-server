package org.butterflylabs.zilliqa.xtext.scoping;

import java.util.Collections;
import java.util.List;

import org.butterflylabs.zilliqa.xtext.scilla.Import;
import org.butterflylabs.zilliqa.xtext.scilla.Scilla;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;

import com.google.common.collect.Lists;

public class ScillaImportedNamespaceAwareLocalScopeProvider extends ImportedNamespaceAwareLocalScopeProvider {
	@Override
	protected List<ImportNormalizer> internalGetImportedNamespaceResolvers(final EObject context, boolean ignoreCase) {
		if (!(context instanceof Scilla))
			return Collections.emptyList();
		Scilla file = (Scilla) context;
		List<ImportNormalizer> importedNamespaceResolvers = Lists.newArrayList();
		
		// import empty namespace
		// importedNamespaceResolvers.add(createImportedNamespaceResolver("default.*", ignoreCase));
		
		// add the import statements
		EList<Import> imports = file.getImports();
				
		// This is to import the whole namespace without having to add the wildcard to the import
		for (Import imp : imports) {
			String value = imp.getImportedNamespace();
			ImportNormalizer resolver = createImportedNamespaceResolver(value + ".*", ignoreCase);
			if (resolver != null)
				importedNamespaceResolvers.add(resolver);
		} 
		
		// add the default variables (even if they are not global but they have to be recognized
		// so global is a workaround for now
		
		String value = "ImplicitVariables.*";
		ImportNormalizer resolver = createImportedNamespaceResolver(value, ignoreCase);
		
		if (resolver != null)
			importedNamespaceResolvers.add(resolver);
		
		// then add types from own package
		/*if (file.getPackage() != null
				&& !Strings.isEmpty(file.getPackage().getName())) {
			importedNamespaceResolvers.add(
			// construct ImportNormalizer with wildCard set to true
			// ImportNormalizer constructor has this form:
			// ImportNormalizer(QualifiedName importedNamespace, boolean
			// wildCard, boolean ignoreCase)
			// https://github.com/eclipse/xtext/blob/master/plugins/org.eclipse.xtext/src/org/eclipse/xtext/scoping/impl/ImportNormalizer.java
					new ImportNormalizer(qualifiedNameConverter
							.toQualifiedName(file.getPackage().getName()),
							true, ignoreCase));
			// add <package>.config
			ImportNormalizer resolver = createImportedNamespaceResolver(file
					.getPackage().getName() + ".config.*", ignoreCase);
			if (resolver != null)
				importedNamespaceResolvers.add(resolver);
		}*/
		return importedNamespaceResolvers;
	}
}
