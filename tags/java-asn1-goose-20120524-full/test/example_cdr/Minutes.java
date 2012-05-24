package example_cdr;

/*
 * Created by JAC (Java Asn1 Compiler)
 */
 
import com.turkcelltech.jac.ASN1Integer;


public class Minutes extends ASN1Integer
{
	/**
	* If you have any constraint below, you must obey to the constraints.
	* If you do not consider the constraints when setting your element, you will get exception.
	*
	* To set your object, you can call setValue(..) method. Also it will be automatically set to "initialized" after setting the value.
	* To encode/decode your object, just call encode(..) decode(..) methods
	*/
	
	public static final long  first = 0;
	public static final long  last = 59;
	/* end of range constraint constants */
	
	/**
	* asn.1 INTEGER constructor to create "uninitialized" object.
	* setValue() method can be called to set the value of the integer.
	*/
	public
	Minutes()
	{
		super("min",first,"max",last);
	}

	/**
	* asn.1 INTEGER constructor to create "uninitialized" object.
	* setValue() method can be called to set the value of the integer.
	*/
	public
	Minutes(String name)
	{
		super("min",first,"max",last);
		setName(name);
	}
	
	/**
	* asn.1 INTEGER constructor to create "initialized" object.
	*/
	public
	Minutes(long value)
	{
		super("min",first,"max",last);
		setValue(value);
	}
	
	/**
	* constructor to build ASN1Integer with its value and name.
	*/
	public
	Minutes(String name, long value)
	{
		super("min",first,"max",last);
		setValue(value);
		setName(name);
	}
}
