package choiceExample;

/*
 * Created by JAC (Java Asn1 Compiler)
 */

import com.turkcelltech.jac.*;
import com.chaosinmotion.asn1.Tag;

public class Network_Element_Identifier extends Choice
{
	/**
	* To do encoding/decoding, just call encode(..) decode(..) methods over one of the elements below..
	*/
	
	public OctetString e164_Format = new OctetString("e164_Format");
	public OctetString x25_Format = new OctetString("x25_Format");
	public OctetString iP_Format = new OctetString("iP_Format");
	public OctetString dNS_Format = new OctetString("dNS_Format");
	/* end of element declarations */
	
	/**
	* constructor without a name
	*/
	public
	Network_Element_Identifier()
	{
		super();
		setUpElements();
	}
	
	/**
	* constructor with a name
	*/
	public
	Network_Element_Identifier(String name)
	{
		super(name);
		setUpElements();
	}

	protected void
	setUpElements()
	{
		super.addElement(e164_Format);
		e164_Format.setTaggingMethod(Tag.IMPLICIT);
		e164_Format.setTagClass(Tag.CONTEXT);
		e164_Format.setTagNumber(1);
		super.addElement(x25_Format);
		x25_Format.setTaggingMethod(Tag.IMPLICIT);
		x25_Format.setTagClass(Tag.CONTEXT);
		x25_Format.setTagNumber(2);
		super.addElement(iP_Format);
		iP_Format.setTaggingMethod(Tag.IMPLICIT);
		iP_Format.setTagClass(Tag.CONTEXT);
		iP_Format.setTagNumber(3);
		super.addElement(dNS_Format);
		dNS_Format.setTaggingMethod(Tag.IMPLICIT);
		dNS_Format.setTagClass(Tag.CONTEXT);
		dNS_Format.setTagNumber(4);
	/* end of element setup */
	}
}
