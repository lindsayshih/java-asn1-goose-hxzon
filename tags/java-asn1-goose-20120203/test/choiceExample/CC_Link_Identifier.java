package choiceExample;

/*
 * Created by JAC (Java Asn1 Compiler)
 */
 
import com.turkcelltech.jac.OctetString;
//import com.chaosinmotion.asn1.Tag;

public class CC_Link_Identifier extends OctetString
{
	/**
	* To set your object you can call the  method: "setValue(byte[] array)"  
	* To encode/decode your object, just call encode(..) decode(..) methods.
	*/
	
	/**
	* constructor to create "uninitialized" object.
	*/
	public
	CC_Link_Identifier()
	{
		super();
	}

	/**
	* constructor to create "uninitialized" object.
	*/
	public
	CC_Link_Identifier(String name)
	{
		super(name);
	}
	
	/**
	* constructor to create "initialized" object.
	*/
	public
	CC_Link_Identifier(byte[] value)
	{
		super(value);
	}
	
	/**
	* constructor to create "initialized" object with its name.
	*/
	public
	CC_Link_Identifier(String name, byte[] value)
	{
		super(name, value);
	}
}
