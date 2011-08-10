package examples;

/* */

import com.turkcelltech.jac.*;
import com.chaosinmotion.asn1.Tag;

public class MySequence extends Sequence
{
	public TaggedTypeExample status = new TaggedTypeExample("status");
	public OctetString location = new OctetString("location");
	/* end of element declarations */

	public
	MySequence()
	{
		super();
		setUpElements();
	}
	public
	MySequence(String name)
	{
		super(name);
		setUpElements();
	}

	protected void
	setUpElements()
	{
		super.addElement(status);
		status.setTagClass(Tag.CONTEXT);
		status.setTagNumber(127);
		status.setTaggingMethod(Tag.EXPLICIT);
		super.addElement(location);
		location.setTagClass(Tag.APPLICATION);
		location.setTagNumber(1);
		location.setOptional(true);
		location.setTaggingMethod(Tag.EXPLICIT);
	/* end of element setup */
	}
	
}
