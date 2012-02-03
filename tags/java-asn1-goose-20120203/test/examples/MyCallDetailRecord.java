package examples;

/* */

import com.turkcelltech.jac.*;
import com.chaosinmotion.asn1.Tag;

public class MyCallDetailRecord extends Sequence
{
	public ASN1Integer origAddress = new ASN1Integer("origAddress");
	public ASN1Integer recipAddress = new ASN1Integer("recipAddress");
	public MiddleSeq internal = new MiddleSeq("internal");
	public MiddleSeq internal2 = new MiddleSeq("internal2");
	public ASN1Integer origg = new ASN1Integer("origg");
	public MiddleSeq2 internal3 = new MiddleSeq2("internal3");
	public ASN1Integer origg2 = new ASN1Integer("origg2");
	/* end of element declarations */

	public
	MyCallDetailRecord()
	{
		super();
		setUpElements();
	}
	
	public
	MyCallDetailRecord(String name)
	{
		super(name);
		setUpElements();
	}

	protected void
	setUpElements()
	{
		super.addElement(origAddress);
		origAddress.setTaggingMethod(Tag.IMPLICIT);
		origAddress.setTagClass(Tag.CONTEXT);
		origAddress.setTagNumber(0);
		super.addElement(recipAddress);
		recipAddress.setTaggingMethod(Tag.IMPLICIT);
		recipAddress.setTagClass(Tag.APPLICATION);
		recipAddress.setTagNumber(5);
		recipAddress.setOptional(true);
		super.addElement(internal);
		super.addElement(internal2);
		super.addElement(origg);
		origg.setTaggingMethod(Tag.IMPLICIT);
		origg.setTagClass(Tag.CONTEXT);
		origg.setTagNumber(7);
		super.addElement(internal3);
		super.addElement(origg2);
		origg2.setTagClass(Tag.CONTEXT);
		origg2.setTagNumber(10);
		origg2.setTaggingMethod(Tag.EXPLICIT);
	/* end of element setup */
	}

}
