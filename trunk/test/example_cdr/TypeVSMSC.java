package example_cdr;

/*
 * Created by JAC (Java Asn1 Compiler)
 */

import com.turkcelltech.jac.Enumerated;


public class TypeVSMSC extends Enumerated
{
	/**
	* To set your ENUMERATED type, just call one of the "setTo_elementName()" methods.
	* To encode/decode your object, just call encode(..) decode(..) methods
	*/
	
	public static final int  none_ = 0;

	public void setTo_none_0() {
		setValue(none_);
	}

	public static final int  private_ = 1;

	public void setTo_private_1() {
		setValue(private_);
	}

	public static final int  public_ = 2;

	public void setTo_public_2() {
		setValue(public_);
	}

	/* end of enumerated constants */

	/**
	* constructs empty ENUMERATED object
	*/
	public
	TypeVSMSC()
	{
		super();
	}
	
	/**
	* constructs empty ENUMERATED object with its name.
	*/
	public
	TypeVSMSC(String name)
	{
		super(name);
	}
	
	/**
	* if you want to set your ENUMERATED to a different undefined value, use this constructor.
	*/
	public
	TypeVSMSC(long value)
	{
		super(value);
	}
	
	/**
	* if you want to set your ENUMERATED to a different undefined value, use this constructor.
	*/
	public
	TypeVSMSC(String name, long value)
	{
		super(name, value);
	}
}
