package choiceExample;

/*
 * Created by JAC (Java Asn1 Compiler)
 */
 
import com.turkcelltech.jac.OctetString;
//import com.chaosinmotion.asn1.Tag;

public class LawfulInterceptionIdentifier extends OctetString
{
	/**
	* To set your object you can call the  method: "setValue(byte[] array)"  
	* To encode/decode your object, just call encode(..) decode(..) methods.
	*/
	
	/**
	* constructor to create "uninitialized" object.
	*/
	public
	LawfulInterceptionIdentifier()
	{
		super();
	}

	/**
	* constructor to create "uninitialized" object.
	*/
	public
	LawfulInterceptionIdentifier(String name)
	{
		super(name);
	}
	
	/**
	* constructor to create "initialized" object.
	*/
	public
	LawfulInterceptionIdentifier(byte[] value)
	{
		super(value);
	}
	
	/**
	* constructor to create "initialized" object with its name.
	*/
	public
	LawfulInterceptionIdentifier(String name, byte[] value)
	{
		super(name, value);
	}
}
