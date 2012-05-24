package example_cdr;

/*
 * Created by JAC (Java Asn1 Compiler)
 */
 
import com.turkcelltech.jac.*;

public class IMSI extends TBCDSTRING
{
	/**
	* This is a "defined type" class. To initialize your object your should 
	* call setValue() method. You can not initialize it by constructor.
	* To encode/decode your object, just call encode(..) decode(..) methods.
	*/
	
	/**
	* constructor to build uninitialized object
	*/
	public
	IMSI()
	{
		super();
	}
	
	/**
	* constructor to build uninitialized object
	*/
	public
	IMSI(String name)
	{
		super(name);
	}
}
