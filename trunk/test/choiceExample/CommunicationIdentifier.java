package choiceExample;

/*
 * Created by JAC (Java Asn1 Compiler)
 */

import com.turkcelltech.jac.*;
import com.chaosinmotion.asn1.Tag;

public class CommunicationIdentifier extends Sequence
{
	/**
	 * if you want to set/fill an element below, just call the setValue(..) method over its instance.
	 *
	 * To encode/decode your object, just call encode(..) decode(..) methods.
	 */
	public OctetString communication_Identity_Number = new OctetString("communication_Identity_Number");
	public Network_Identifier network_Identifier = new Network_Identifier("network_Identifier");
	/* end of element declarations */
	
	/**
	* asn.1 SEQUENCE constructor
	*/
	public
	CommunicationIdentifier()
	{
		super();
		setUpElements();
	}

	/**
	* asn.1 SEQUENCE constructor with its name
	*/
	public
	CommunicationIdentifier(String name)
	{
		super(name);
		setUpElements();
	}
	

	protected void
	setUpElements()
	{
		super.addElement(communication_Identity_Number);
		communication_Identity_Number.setOptional(true);
		communication_Identity_Number.setTaggingMethod(Tag.IMPLICIT);
		communication_Identity_Number.setTagClass(Tag.CONTEXT);
		communication_Identity_Number.setTagNumber(0);
		super.addElement(network_Identifier);
		network_Identifier.setTaggingMethod(Tag.IMPLICIT);
		network_Identifier.setTagClass(Tag.CONTEXT);
		network_Identifier.setTagNumber(1);
	/* end of element setup */
	}


}
