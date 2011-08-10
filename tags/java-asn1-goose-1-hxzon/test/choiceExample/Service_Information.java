package choiceExample;

/*
 * Created by JAC (Java Asn1 Compiler)
 */
 
import com.turkcelltech.jac.*;
import com.chaosinmotion.asn1.Tag;

public class Service_Information extends Set
{
	/* 
	 * if you want to set/fill an element below, just call the setValue() method over its instance.
	 * To encode/decode your object, just call encode(..) decode(..) methods.
	 */
	public OctetString high_layer_capability = new OctetString("high_layer_capability");
	public OctetString tMR = new OctetString("tMR");
	public OctetString bearerServiceCode = new OctetString("bearerServiceCode");
	public OctetString teleServiceCode = new OctetString("teleServiceCode");
	/* end of element declarations */

	/**
	* asn.1 SET constructor
	*/
	public
	Service_Information()
	{
		super();
		setUpElements();
	}
	
	/**
	* asn.1 SET constructor with name
	*/
	public
	Service_Information(String name)
	{
		super(name);
		setUpElements();
	}
	

	protected void
	setUpElements()
	{
		super.addElement(high_layer_capability);
		high_layer_capability.setOptional(true);
		high_layer_capability.setTaggingMethod(Tag.IMPLICIT);
		high_layer_capability.setTagClass(Tag.CONTEXT);
		high_layer_capability.setTagNumber(0);
		super.addElement(tMR);
		tMR.setOptional(true);
		tMR.setTaggingMethod(Tag.IMPLICIT);
		tMR.setTagClass(Tag.CONTEXT);
		tMR.setTagNumber(1);
		super.addElement(bearerServiceCode);
		bearerServiceCode.setOptional(true);
		bearerServiceCode.setTaggingMethod(Tag.IMPLICIT);
		bearerServiceCode.setTagClass(Tag.CONTEXT);
		bearerServiceCode.setTagNumber(2);
		super.addElement(teleServiceCode);
		teleServiceCode.setOptional(true);
		teleServiceCode.setTaggingMethod(Tag.IMPLICIT);
		teleServiceCode.setTagClass(Tag.CONTEXT);
		teleServiceCode.setTagNumber(3);
	/* end of element setup */
	}
}
