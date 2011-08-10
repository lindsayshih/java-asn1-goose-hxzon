package example_cdr;

/*
 * Created by JAC (Java Asn1 Compiler)
 */

import com.turkcelltech.jac.Enumerated;


public class MesgReplyPath extends Enumerated
{
	/**
	* To set your ENUMERATED type, just call one of the "setTo_elementName()" methods.
	* To encode/decode your object, just call encode(..) decode(..) methods
	*/
	
	public static final int  request_ = 1;

	public void setTo_request_1() {
		setValue(request_);
	}

	public static final int  response_ = 2;

	public void setTo_response_2() {
		setValue(response_);
	}

	/* end of enumerated constants */

	/**
	* constructs empty ENUMERATED object
	*/
	public
	MesgReplyPath()
	{
		super();
	}
	
	/**
	* constructs empty ENUMERATED object with its name.
	*/
	public
	MesgReplyPath(String name)
	{
		super(name);
	}
	
	/**
	* if you want to set your ENUMERATED to a different undefined value, use this constructor.
	*/
	public
	MesgReplyPath(long value)
	{
		super(value);
	}
	
	/**
	* if you want to set your ENUMERATED to a different undefined value, use this constructor.
	*/
	public
	MesgReplyPath(String name, long value)
	{
		super(name, value);
	}
}
