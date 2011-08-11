package examples;


import com.turkcelltech.jac.*;
import com.chaosinmotion.asn1.Tag;

public class Cloud extends Set
{
	public OctetString speed = new OctetString("speed");
	public ASN1Boolean isBlue = new ASN1Boolean("isBlue");
	/* end of element declarations */

	/**
	*  added by Fatih Batuk
	*/
	public
	Cloud()
	{
		super();
		setUpElements();
	}
	
	public
	Cloud(String name)
	{
		super(name);
		setUpElements();
	}

	protected void
	setUpElements()
	{
		super.addElement(speed);
		super.addElement(isBlue);
		isBlue.setTagClass(Tag.CONTEXT);
		isBlue.setTagNumber(5);
	/* end of element setup */
	}
}
