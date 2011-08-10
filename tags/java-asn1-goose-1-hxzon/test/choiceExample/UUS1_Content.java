package choiceExample;

/*
 * Created by JAC (Java Asn1 Compiler)
 */

import com.turkcelltech.jac.*;
import com.chaosinmotion.asn1.Tag;

public class UUS1_Content extends Sequence
{
	/**
	 * if you want to set/fill an element below, just call the setValue(..) method over its instance.
	 *
	 * To encode/decode your object, just call encode(..) decode(..) methods.
	 */
	public ObjectID domainID = new ObjectID("domainID");
	public LawfulInterceptionIdentifier lawfullInterceptionIdentifier = new LawfulInterceptionIdentifier("lawfullInterceptionIdentifier");
	public CommunicationIdentifier communicationIdentifier = new CommunicationIdentifier("communicationIdentifier");
	public CC_Link_Identifier cC_Link_Identifier = new CC_Link_Identifier("cC_Link_Identifier");
	public Direction_Indication direction_Indication = new Direction_Indication("direction_Indication");
	public OctetString bearer_capability = new OctetString("bearer_capability");
	public Service_Information service_Information = new Service_Information("service_Information");
	/* end of element declarations */
	
	/**
	* asn.1 SEQUENCE constructor
	*/
	public
	UUS1_Content()
	{
		super();
		setUpElements();
	}

	/**
	* asn.1 SEQUENCE constructor with its name
	*/
	public
	UUS1_Content(String name)
	{
		super(name);
		setUpElements();
	}
	

	protected void
	setUpElements()
	{
		super.addElement(domainID);
		domainID.setOptional(true);
		domainID.setTaggingMethod(Tag.IMPLICIT);
		domainID.setTagClass(Tag.CONTEXT);
		domainID.setTagNumber(0);
		super.addElement(lawfullInterceptionIdentifier);
		lawfullInterceptionIdentifier.setTaggingMethod(Tag.IMPLICIT);
		lawfullInterceptionIdentifier.setTagClass(Tag.CONTEXT);
		lawfullInterceptionIdentifier.setTagNumber(1);
		super.addElement(communicationIdentifier);
		communicationIdentifier.setTaggingMethod(Tag.IMPLICIT);
		communicationIdentifier.setTagClass(Tag.CONTEXT);
		communicationIdentifier.setTagNumber(2);
		super.addElement(cC_Link_Identifier);
		cC_Link_Identifier.setOptional(true);
		cC_Link_Identifier.setTaggingMethod(Tag.IMPLICIT);
		cC_Link_Identifier.setTagClass(Tag.CONTEXT);
		cC_Link_Identifier.setTagNumber(3);
		super.addElement(direction_Indication);
		direction_Indication.setTaggingMethod(Tag.IMPLICIT);
		direction_Indication.setTagClass(Tag.CONTEXT);
		direction_Indication.setTagNumber(4);
		super.addElement(bearer_capability);
		bearer_capability.setOptional(true);
		bearer_capability.setTaggingMethod(Tag.IMPLICIT);
		bearer_capability.setTagClass(Tag.CONTEXT);
		bearer_capability.setTagNumber(5);
		super.addElement(service_Information);
		service_Information.setOptional(true);
		service_Information.setTaggingMethod(Tag.IMPLICIT);
		service_Information.setTagClass(Tag.CONTEXT);
		service_Information.setTagNumber(7);
	/* end of element setup */
	}


}
