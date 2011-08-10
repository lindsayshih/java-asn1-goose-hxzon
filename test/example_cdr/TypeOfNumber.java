package example_cdr;

/*
 * Created by JAC (Java Asn1 Compiler)
 */

import com.turkcelltech.jac.Enumerated;


public class TypeOfNumber extends Enumerated
{
	/**
	* To set your ENUMERATED type, just call one of the "setTo_elementName()" methods.
	* To encode/decode your object, just call encode(..) decode(..) methods
	*/
	
	public static final int  unknown_ = 0;

	public void setTo_unknown_0() {
		setValue(unknown_);
	}

	public static final int  international_ = 1;

	public void setTo_international_1() {
		setValue(international_);
	}

	public static final int  national_ = 2;

	public void setTo_national_2() {
		setValue(national_);
	}

	public static final int  network_ = 3;

	public void setTo_network_3() {
		setValue(network_);
	}

	public static final int  short_ = 4;

	public void setTo_short_4() {
		setValue(short_);
	}

	public static final int  alpha_ = 5;

	public void setTo_alpha_5() {
		setValue(alpha_);
	}

	public static final int  abbreviated_ = 6;

	public void setTo_abbreviated_6() {
		setValue(abbreviated_);
	}

	public static final int  reserved7_ = 7;

	public void setTo_reserved7_7() {
		setValue(reserved7_);
	}

	/* end of enumerated constants */

	/**
	* constructs empty ENUMERATED object
	*/
	public
	TypeOfNumber()
	{
		super();
	}
	
	/**
	* constructs empty ENUMERATED object with its name.
	*/
	public
	TypeOfNumber(String name)
	{
		super(name);
	}
	
	/**
	* if you want to set your ENUMERATED to a different undefined value, use this constructor.
	*/
	public
	TypeOfNumber(long value)
	{
		super(value);
	}
	
	/**
	* if you want to set your ENUMERATED to a different undefined value, use this constructor.
	*/
	public
	TypeOfNumber(String name, long value)
	{
		super(name, value);
	}
}
