package air;

/*
 * Created by JavaAsn1Compiler (by Fatih Batuk)
 */

import com.turkcelltech.jac.Enumerated;

public class City2 extends Enumerated
{
	/**
	* To set your ENUMERATED type, just call one of the "setTo_elementName()" methods.
	* To encode/decode your object, just call encode(..) decode(..) methods
	*/
	
	public static final int  istanbul_ = 1;

	public void setTo_istanbul_1() {
		setValue(istanbul_);
	}

	public static final int  ankara_ = 2;

	public void setTo_ankara_2() {
		setValue(ankara_);
	}

	public static final int  izmir_ = 5;

	public void setTo_izmir_5() {
		setValue(izmir_);
	}

	/* end of enumerated constants */

	/**
	* constructs empty ENUMERATED object
	*/
	public
	City2()
	{
		super();
	}
	
	/**
	* constructs empty ENUMERATED object with its name.
	*/
	public
	City2(String name)
	{
		super(name);
	}
	
	/**
	* if you want to set your ENUMERATED to a different undefined value, use this constructor.
	*/
	public
	City2(long value)
	{
		super(value);
	}
	
	/**
	* if you want to set your ENUMERATED to a different undefined value, use this constructor.
	*/
	public
	City2(String name, long value)
	{
		super(name, value);
	}
}
