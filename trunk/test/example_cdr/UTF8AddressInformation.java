package example_cdr;

/*
 * Created by JAC (Java Asn1 Compiler)
 */

import com.turkcelltech.jac.*;
import com.chaosinmotion.asn1.Tag;

public class UTF8AddressInformation extends Sequence
{
	/**
	 * if you want to set/fill an element below, just call the setValue(..) method over its instance.
	 *
	 * To encode/decode your object, just call encode(..) decode(..) methods.
	 */
	public TypeOfNumber ton = new TypeOfNumber("ton");
	public NumberingPlanIndicator npi = new NumberingPlanIndicator("npi");
	public ProtocolIdentifier pid = new ProtocolIdentifier("pid");
	public UTF8String msisdn = new UTF8String("msisdn");
	/* end of element declarations */
	
	/**
	* asn.1 SEQUENCE constructor
	*/
	public
	UTF8AddressInformation()
	{
		super();
		setUpElements();
	}

	/**
	* asn.1 SEQUENCE constructor with its name
	*/
	public
	UTF8AddressInformation(String name)
	{
		super(name);
		setUpElements();
	}
	

	protected void
	setUpElements()
	{
		super.addElement(ton);
		ton.setOptional(true);
		ton.setTaggingMethod(Tag.IMPLICIT);
		ton.setTagClass(Tag.CONTEXT);
		ton.setTagNumber(0);
		super.addElement(npi);
		npi.setOptional(true);
		npi.setTaggingMethod(Tag.IMPLICIT);
		npi.setTagClass(Tag.CONTEXT);
		npi.setTagNumber(1);
		super.addElement(pid);
		pid.setOptional(true);
		pid.setTaggingMethod(Tag.IMPLICIT);
		pid.setTagClass(Tag.CONTEXT);
		pid.setTagNumber(2);
		super.addElement(msisdn);
		msisdn.setOptional(true);
		msisdn.setTaggingMethod(Tag.IMPLICIT);
		msisdn.setTagClass(Tag.CONTEXT);
		msisdn.setTagNumber(3);
	/* end of element setup */
	}


}
