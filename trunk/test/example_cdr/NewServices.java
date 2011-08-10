package example_cdr;

/*
 * Created by JAC (Java Asn1 Compiler)
 */
 
import com.turkcelltech.jac.OctetString;


public class NewServices extends OctetString
{
	/**
	* To set your object you can call the  method: "setValue(byte[] array)"  Also it will be automatically set to "initialized" after setting the value.
	* To encode/decode your object, just call encode(..) decode(..) methods.
	*/
	
	/**
	* constructor to create "uninitialized" object.
	*/
	public
	NewServices()
	{
		super();
	}

	/**
	* constructor to create "uninitialized" object.
	*/
	public
	NewServices(String name)
	{
		super(name);
	}
	
	/**
	* constructor to create "initialized" object.
	*/
	public
	NewServices(byte[] value)
	{
		super(value);
	}
	
	/**
	* constructor to create "initialized" object with its name.
	*/
	public
	NewServices(String name, byte[] value)
	{
		super(name, value);
	}
}
