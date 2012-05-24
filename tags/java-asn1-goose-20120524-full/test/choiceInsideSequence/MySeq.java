package choiceInsideSequence;

/*
 * Created by JAC (Java Asn1 Compiler)
 */

import com.turkcelltech.jac.*;
import com.chaosinmotion.asn1.Tag;

public class MySeq extends Sequence
{
	/**
	 * if you want to set/fill an element below, just call the setValue(..) method over its instance.
	 *
	 * To encode/decode your object, just call encode(..) decode(..) methods.
	 */
	public MyChoice myChoice = new MyChoice("myChoice");
	public OctetString someElement = new OctetString("someElement");
	/* end of element declarations */
	
	/**
	* asn.1 SEQUENCE constructor
	*/
	public
	MySeq()
	{
		super();
		setUpElements();
	}

	/**
	* asn.1 SEQUENCE constructor with its name
	*/
	public
	MySeq(String name)
	{
		super(name);
		setUpElements();
	}
	

	protected void
	setUpElements()
	{
		super.addElement(myChoice);
		myChoice.setTaggingMethod(Tag.IMPLICIT);
		myChoice.setTagClass(Tag.CONTEXT);
		myChoice.setTagNumber(1);
		super.addElement(someElement);
		someElement.setTaggingMethod(Tag.IMPLICIT);
		someElement.setTagClass(Tag.CONTEXT);
		someElement.setTagNumber(2);
	/* end of element setup */
	}


}
