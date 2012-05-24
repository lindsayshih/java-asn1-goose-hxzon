package examples;

/* */

import com.turkcelltech.jac.*;
import com.chaosinmotion.asn1.Tag;

public class MiddleSeq extends Sequence
{
	public ASN1Integer status = new ASN1Integer("status");
	public ASN1Integer location = new ASN1Integer("location");
	/* end of element declarations */

	public
	MiddleSeq()
	{
		super();
		setUpElements();
	}
	public
	MiddleSeq(String name)
	{
		super(name);
		setUpElements();
	}

	protected void
	setUpElements()
	{
		super.addElement(status);
		status.setTagClass(Tag.CONTEXT);
		status.setTagNumber(22);
		super.addElement(location);
		location.setTagClass(Tag.APPLICATION);
		location.setTagNumber(11);
	/* end of element setup */
	}
	
}
