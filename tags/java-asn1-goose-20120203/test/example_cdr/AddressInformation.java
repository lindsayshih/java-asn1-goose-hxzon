package example_cdr;

/*
 * Created by JAC (Java Asn1 Compiler)
 */

import com.turkcelltech.jac.*;
import com.chaosinmotion.asn1.Tag;

public class AddressInformation extends Sequence
{
	/**
	 * if you want to set/fill an element below, just call the setValue(..) method over its instance.
	 *
	 * To encode/decode your object, just call encode(..) decode(..) methods.
	 */
	public TypeOfNumber ton = new TypeOfNumber("ton");
	public NumberingPlanIndicator npi = new NumberingPlanIndicator("npi");
	public ProtocolIdentifier pid = new ProtocolIdentifier("pid");
	public IA5String msisdn = new IA5String("msisdn");
	public UTF8String msisdnUTF8 = new UTF8String("msisdnUTF8");
	/* end of element declarations */
	
	/**
	* asn.1 SEQUENCE constructor
	*/
	public
	AddressInformation()
	{
		super();
		setUpElements();
	}

	/**
	* asn.1 SEQUENCE constructor with its name
	*/
	public
	AddressInformation(String name)
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
		super.addElement(msisdnUTF8);
		msisdnUTF8.setOptional(true);
		msisdnUTF8.setTaggingMethod(Tag.IMPLICIT);
		msisdnUTF8.setTagClass(Tag.CONTEXT);
		msisdnUTF8.setTagNumber(4);
	/* end of element setup */
	}


}
