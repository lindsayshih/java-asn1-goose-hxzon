package air;

/*
 * Created by JavaAsn1Compiler (by Fatih Batuk)
 */

import com.turkcelltech.jac.*;
import com.chaosinmotion.asn1.Tag;

public class AirRecord2 extends Sequence
{
	/**
	 * if you want to set/fill an element below, just call the setValue(..) method over its instance.

	 * To encode/decode your object, just call encode(..) decode(..) methods.
	 */
	public ASN1Boolean hot = new ASN1Boolean("hot");
	public ASN1Integer degree = new ASN1Integer("degree");
	public Cloud2 cloud = new Cloud2("cloud");
	public City2 location = new City2("location");
	public Minutes2 time = new Minutes2("time");
	/* end of element declarations */
	

	public
	AirRecord2(boolean initializedStatus)
	{
		super();
		setUpElements();
	}


	public
	AirRecord2(String name)
	{
		super(name);
		setUpElements();
	}

	protected void
	setUpElements()
	{
		super.addElement(hot);
		hot.setOptional(true);
		hot.setTaggingMethod(Tag.IMPLICIT);
		hot.setTagClass(Tag.CONTEXT);
		hot.setTagNumber(0);
		super.addElement(degree);
		degree.setTaggingMethod(Tag.EXPLICIT);
		degree.setTagClass(Tag.CONTEXT);
		degree.setTagNumber(1);
		super.addElement(cloud);
		super.addElement(location);
		location.setTaggingMethod(Tag.IMPLICIT);
		location.setTagClass(Tag.PRIVATE);
		location.setTagNumber(1);
		super.addElement(time);
		time.setTaggingMethod(Tag.IMPLICIT);
		time.setTagClass(Tag.APPLICATION);
		time.setTagNumber(8);
	/* end of element setup */
	}


}
