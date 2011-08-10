package sequenceOfExample;

/*
 * Created by JAC (Java Asn1 Compiler)
 */

import com.turkcelltech.jac.*;
//import com.chaosinmotion.asn1.Tag;

public class Cell_List extends SequenceOf
{
	/**
	* To add elements to your SequenceOf object, just call the addElemet(..) method.
	* You can only add an element to your SequenceOf object if it is 
	* an instance of the elementType defined in below constructors.
	*
	* To encode/decode your object, just call encode(..) decode(..) methods
	*/
	
	/**
	* Uninitialized SEQUENCE OF constructor 
	*/
	public
	Cell_List()
	{
		super(new Cell("Cell"));
	}
	
	/**
	* Uninitialized SEQUENCE OF constructor with name
	*/
	public
	Cell_List(String name)
	{
		super(name, new Cell("Cell"));
	}
}
