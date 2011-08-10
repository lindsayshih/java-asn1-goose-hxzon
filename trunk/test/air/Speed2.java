package air;

/*
 * Created by JavaAsn1Compiler (by Fatih Batuk)
 */
 
import com.turkcelltech.jac.OctetString;

public class Speed2 extends OctetString
{
	/**
	* To set your object you can call the  method: "setValue(byte[] array)"  Also it will be automatically set to "initialized" after setting the value.
	* To encode/decode your object, just call encode(..) decode(..) methods.
	*/
	
	/**
	* constructor to create "uninitialized" object.
	*/
	public
	Speed2()
	{
		super();
	}

	/**
	* constructor to create "uninitialized" object.
	*/
	public
	Speed2(String name)
	{
		super(name);
	}
	
	/**
	* constructor to create "initialized" object.
	*/
	public
	Speed2(byte[] value)
	{
		super(value);
	}
	
	/**
	* constructor to create "initialized" object with its name.
	*/
	public
	Speed2(String name, byte[] value)
	{
		super(name, value);
	}
}
