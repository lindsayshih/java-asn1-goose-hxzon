package air;

/*
 * Created by JavaAsn1Compiler (by Fatih Batuk)
 */

import com.turkcelltech.jac.*;
import com.chaosinmotion.asn1.Tag;

public class IntSeq extends SequenceOf
{
	/**
	* To add elements to your SequenceOf object, just call the addElemet(..) method.
	* You can only add an element to your SequenceOf object if it is 
	* an instance of the elementType defined in below constructors.
	* After adding an element your object will be automatically set to "initialized".
	*
	* To encode/decode your object, just call encode(..) decode(..) methods
	*/
	
	/**
	* Uninitialized SEQUENCE OF constructor 
	*/
	public
	IntSeq()
	{
		super(new ASN1Integer("ASN1Integer"));
	}
	
	/**
	* Uninitialized SEQUENCE OF constructor with name
	*/
	public
	IntSeq(String name)
	{
		super(name, new ASN1Integer("ASN1Integer"));
	}
}
