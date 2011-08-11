package example_cdr;

/*
 * Created by JAC (Java Asn1 Compiler)
 */

import com.turkcelltech.jac.*;
import com.chaosinmotion.asn1.Tag;

public class Period extends Sequence
{
	/**
	 * if you want to set/fill an element below, just call the setValue(..) method over its instance.
	 *
	 * To encode/decode your object, just call encode(..) decode(..) methods.
	 */
	public HoursPeriod hours = new HoursPeriod("hours");
	public Minutes minutes = new Minutes("minutes");
	/* end of element declarations */
	
	/**
	* asn.1 SEQUENCE constructor
	*/
	public
	Period()
	{
		super();
		setUpElements();
	}

	/**
	* asn.1 SEQUENCE constructor with its name
	*/
	public
	Period(String name)
	{
		super(name);
		setUpElements();
	}
	

	protected void
	setUpElements()
	{
		super.addElement(hours);
		hours.setOptional(true);
		hours.setTaggingMethod(Tag.IMPLICIT);
		hours.setTagClass(Tag.CONTEXT);
		hours.setTagNumber(0);
		super.addElement(minutes);
		minutes.setOptional(true);
		minutes.setTaggingMethod(Tag.IMPLICIT);
		minutes.setTagClass(Tag.CONTEXT);
		minutes.setTagNumber(1);
	/* end of element setup */
	}


}
