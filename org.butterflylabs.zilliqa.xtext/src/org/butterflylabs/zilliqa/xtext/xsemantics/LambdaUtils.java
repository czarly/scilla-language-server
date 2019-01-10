package org.butterflylabs.zilliqa.xtext.xsemantics;

import org.butterflylabs.zilliqa.xtext.scilla.AddressType;
import org.butterflylabs.zilliqa.xtext.scilla.ArrowType;
import org.butterflylabs.zilliqa.xtext.scilla.BNumType;
import org.butterflylabs.zilliqa.xtext.scilla.BoolType;
//import org.butterflylabs.zilliqa.xtext.scilla.ElementaryType;
import org.butterflylabs.zilliqa.xtext.scilla.HashType;
import org.butterflylabs.zilliqa.xtext.scilla.Int128Type;
import org.butterflylabs.zilliqa.xtext.scilla.Int256Type;
import org.butterflylabs.zilliqa.xtext.scilla.Int32Type;
import org.butterflylabs.zilliqa.xtext.scilla.Int64Type;
import org.butterflylabs.zilliqa.xtext.scilla.ListType;
import org.butterflylabs.zilliqa.xtext.scilla.MapType;
import org.butterflylabs.zilliqa.xtext.scilla.MessageType;
import org.butterflylabs.zilliqa.xtext.scilla.NatType;
import org.butterflylabs.zilliqa.xtext.scilla.OptionType;
import org.butterflylabs.zilliqa.xtext.scilla.PairType;
import org.butterflylabs.zilliqa.xtext.scilla.PubKeyType;
import org.butterflylabs.zilliqa.xtext.scilla.ScillaFactory;
import org.butterflylabs.zilliqa.xtext.scilla.StringType;
import org.butterflylabs.zilliqa.xtext.scilla.Type;
import org.butterflylabs.zilliqa.xtext.scilla.TypeVariable;
import org.butterflylabs.zilliqa.xtext.scilla.TypeVariableDeclaration;
import org.butterflylabs.zilliqa.xtext.scilla.Uint128Type;
import org.butterflylabs.zilliqa.xtext.scilla.Uint256Type;
import org.butterflylabs.zilliqa.xtext.scilla.Uint32Type;
import org.butterflylabs.zilliqa.xtext.scilla.Uint64Type;


public class LambdaUtils {

	protected int counter = 0;

	public void resetCounter() {
		counter = 0;
	}

	public TypeVariable createTypeVariable(String name) {
		TypeVariable typeVariable = ScillaFactory.eINSTANCE.createTypeVariable();
		TypeVariableDeclaration declaration = ScillaFactory.eINSTANCE.createTypeVariableDeclaration();
		declaration.setName(name);
		typeVariable.setSymbol(declaration);
		return typeVariable;
	}

	public TypeVariable createFreshTypeVariable() {
		return createTypeVariable("X" + ++counter);
	}

	public ArrowType createFreshArrowType() {
		return createArrowType(createFreshTypeVariable(), createFreshTypeVariable());
	}

	public ArrowType createArrowType(Type left, Type right) {
		ArrowType arrowType = ScillaFactory.eINSTANCE.createArrowType();
		arrowType.setLeft(left);
		arrowType.setRight(right);
		return arrowType;
	}
	
	public ListType createFreshListType() {
		return createListType(createFreshTypeVariable());
	}
	
	public MapType createFreshMapType() {
		return createMapType(createFreshTypeVariable(), createFreshTypeVariable());
	}
	
	public PairType createFreshPairType() {
		return createPairType(createFreshTypeVariable(), createFreshTypeVariable());
	}
	
	public OptionType createFreshOptionType() {
		return createOptionType(createFreshTypeVariable());
	}
	
	public ListType createListType(Type parameter) {
		ListType listType = ScillaFactory.eINSTANCE.createListType();
		listType.setParameter(parameter);
		return listType;
	}

	public OptionType createOptionType(Type parameter) {
		OptionType optionType = ScillaFactory.eINSTANCE.createOptionType();
		optionType.setParameter(parameter);
		return optionType;
	}
	
	public PairType createPairType(Type left, Type right) {
		PairType pairType = ScillaFactory.eINSTANCE.createPairType();
		pairType.setLeftType(left);
		pairType.setRightType(right);
		return pairType; 
	}
	
	public MapType createMapType(Type key, Type value) {
		MapType mapType = ScillaFactory.eINSTANCE.createMapType();
		mapType.setKeyType(key);
		mapType.setValueType(value);
		return mapType;
	}
	
	public Uint32Type createUint32Type() {
		return ScillaFactory.eINSTANCE.createUint32Type();
	}
	
	public Uint64Type createUint64Type() {
		return ScillaFactory.eINSTANCE.createUint64Type();
	}
	
	public Uint128Type createUint128Type() {
		return ScillaFactory.eINSTANCE.createUint128Type();
	}
	
	public Uint256Type createUint256Type() {
		return ScillaFactory.eINSTANCE.createUint256Type();
	}
	
	public Int32Type createInt32Type() {
		return ScillaFactory.eINSTANCE.createInt32Type();
	}
	
	public Int64Type createInt64Type() {
		return ScillaFactory.eINSTANCE.createInt64Type();
	}
	
	public Int128Type createInt128Type() {
		return ScillaFactory.eINSTANCE.createInt128Type();
	}
	
	public Int256Type createInt256Type() {
		return ScillaFactory.eINSTANCE.createInt256Type();
	}
	
	public MessageType createMessageType() {
		return ScillaFactory.eINSTANCE.createMessageType();
	}

	public StringType createStringType() {
		return ScillaFactory.eINSTANCE.createStringType();
	}

	public HashType createHashType() {
		return ScillaFactory.eINSTANCE.createHashType();
	}

	public AddressType createAddressType() {
		return ScillaFactory.eINSTANCE.createAddressType();
	}
	
	public BNumType createBNumType() {
		return ScillaFactory.eINSTANCE.createBNumType();
	}

	public PubKeyType createPubKeyType() {
		return ScillaFactory.eINSTANCE.createPubKeyType();
	}

	public BoolType createBoolType() {
		return ScillaFactory.eINSTANCE.createBoolType();
	}

	public NatType createNatType() {
		return ScillaFactory.eINSTANCE.createNatType();
	}

	




}
