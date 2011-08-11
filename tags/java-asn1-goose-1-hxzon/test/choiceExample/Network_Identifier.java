package choiceExample;

/*
 * Created by JAC (Java Asn1 Compiler)
 */

import com.turkcelltech.jac.*;
import com.chaosinmotion.asn1.Tag;

public class Network_Identifier extends Sequence
{
	/**
	 * if you want to set/fill an element below, just call the setValue(..) method over its instance.
	 *
	 * To encode/decode your object, just call encode(..) decode(..) methods.
	 */
	public OctetString operator_Identifier = new OctetString("operator_Identifier");
	public Network_Element_Identifier network_Element_Identifier = new Network_Element_Identifier("network_Element_Identifier");
	/* end of element declarations */
	
	/**
	* asn.1 SEQUENCE constructor
	*/
	public
	Network_Identifier()
	{
		super();
		setUpElements();
	}

	/**
	* asn.1 SEQUENCE constructor with its name
	*/
	public
	Network_Identifier(String name)
	{
		super(name);
		setUpElements();
	}
	

	protected void
	setUpElements()
	{
		super.addElement(operator_Identifier);
		operator_Identifier.setTaggingMethod(Tag.IMPLICIT);
		operator_Identifier.setTagClass(Tag.CONTEXT);
		operator_Identifier.setTagNumber(0);
		super.addElement(network_Element_Identifier);
		network_Element_Identifier.setOptional(true);
		network_Element_Identifier.setTaggingMethod(Tag.IMPLICIT);
		network_Element_Identifier.setTagClass(Tag.CONTEXT);
		network_Element_Identifier.setTagNumber(1);
	/* end of element setup */
	}


}
