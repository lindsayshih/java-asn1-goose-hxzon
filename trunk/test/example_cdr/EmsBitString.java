package example_cdr;

/*
 * Created by JAC (Java Asn1 Compiler)
 */
 
import com.turkcelltech.jac.OctetString;


public class EmsBitString extends OctetString
{
	/**
	* To set your object you can call the  method: "setValue(byte[] array)"  Also it will be automatically set to "initialized" after setting the value.
	* To encode/decode your object, just call encode(..) decode(..) methods.
	*/
	
	/**
	* constructor to create "uninitialized" object.
	*/
	public
	EmsBitString()
	{
		super();
	}

	/**
	* constructor to create "uninitialized" object.
	*/
	public
	EmsBitString(String name)
	{
		super(name);
	}
	
	/**
	* constructor to create "initialized" object.
	*/
	public
	EmsBitString(byte[] value)
	{
		super(value);
	}
	
	/**
	* constructor to create "initialized" object with its name.
	*/
	public
	EmsBitString(String name, byte[] value)
	{
		super(name, value);
	}
}
