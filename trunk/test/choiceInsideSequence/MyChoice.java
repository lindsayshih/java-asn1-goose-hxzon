package choiceInsideSequence;

/*
 * Created by JAC (Java Asn1 Compiler)
 */

import com.turkcelltech.jac.*;
import com.chaosinmotion.asn1.Tag;

public class MyChoice extends Choice
{
	/**
	* To do encoding/decoding, just call encode(..) decode(..) methods over one of the elements below..
	*/
	
	public OctetString myString11 = new OctetString("myString11");
	public OctetString myString22 = new OctetString("myString22");
	/* end of element declarations */
	
	/**
	* constructor without a name
	*/
	public
	MyChoice()
	{
		super();
		setUpElements();
	}
	
	/**
	* constructor with a name
	*/
	public
	MyChoice(String name)
	{
		super(name);
		setUpElements();
	}

	protected void
	setUpElements()
	{
		super.addElement(myString11);
		myString11.setTaggingMethod(Tag.EXPLICIT);
		myString11.setTagClass(Tag.APPLICATION);
		myString11.setTagNumber(5);
		super.addElement(myString22);
		myString22.setTaggingMethod(Tag.EXPLICIT);
		myString22.setTagClass(Tag.APPLICATION);
		myString22.setTagNumber(6);
	/* end of element setup */
	}
}
