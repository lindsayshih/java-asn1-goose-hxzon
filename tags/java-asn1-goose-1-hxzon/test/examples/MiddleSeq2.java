package examples;


import com.turkcelltech.jac.*;
import com.chaosinmotion.asn1.Tag;

public class MiddleSeq2 extends Sequence
{
	public ASN1Integer status2 = new ASN1Integer("status");
	/* end of element declarations */

	public
	MiddleSeq2()
	{
		super();
		setUpElements();
	}
	
	public
	MiddleSeq2(String name)
	{
		super(name);
		setUpElements();
	}

	protected void
	setUpElements()
	{
		super.addElement(status2);
		status2.setTagClass(Tag.CONTEXT);
		status2.setTagNumber(33);
	/* end of element setup */
	}
}
