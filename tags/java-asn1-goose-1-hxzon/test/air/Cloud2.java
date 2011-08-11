package air;

/*
 * Created by JavaAsn1Compiler (by Fatih Batuk)
 */
 
import com.turkcelltech.jac.*;
import com.chaosinmotion.asn1.Tag;

public class Cloud2 extends Set
{
	/* 
	 * if you want to set/fill an element below, just call the setValue() method over its instance.
	
	 * To encode/decode your object, just call encode(..) decode(..) methods.
	 */
	public Speed2 speed = new Speed2("speed");
	public ASN1Boolean isBlue = new ASN1Boolean("isBlue");
	public IntSeq parameters = new IntSeq("parameters");
	/* end of element declarations */


	public
	Cloud2()
	{
		super();
		setUpElements();
	}
	
	/**
	* Uninitialized asn.1 SET constructor
	*/
	public
	Cloud2(String name)
	{
		super(name);
		setUpElements();
	}
	

	protected void
	setUpElements()
	{
		super.addElement(speed);
		super.addElement(isBlue);
		super.addElement(parameters);
		parameters.setTaggingMethod(Tag.IMPLICIT);
		parameters.setTagClass(Tag.CONTEXT);
		parameters.setTagNumber(0);
	/* end of element setup */
	}
}
