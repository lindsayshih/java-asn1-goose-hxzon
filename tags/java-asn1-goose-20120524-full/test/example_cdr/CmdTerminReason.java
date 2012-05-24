package example_cdr;

/*
 * Created by JAC (Java Asn1 Compiler)
 */

import com.turkcelltech.jac.Enumerated;


public class CmdTerminReason extends Enumerated
{
	/**
	* To set your ENUMERATED type, just call one of the "setTo_elementName()" methods.
	* To encode/decode your object, just call encode(..) decode(..) methods
	*/
	
	public static final int  notaccepted_ = 0;

	public void setTo_notaccepted_0() {
		setValue(notaccepted_);
	}

	public static final int  accepted_ = 1;

	public void setTo_accepted_1() {
		setValue(accepted_);
	}

	public static final int  notfound_ = 2;

	public void setTo_notfound_2() {
		setValue(notfound_);
	}

	public static final int  tmpnotavail_ = 3;

	public void setTo_tmpnotavail_3() {
		setValue(tmpnotavail_);
	}

	/* end of enumerated constants */

	/**
	* constructs empty ENUMERATED object
	*/
	public
	CmdTerminReason()
	{
		super();
	}
	
	/**
	* constructs empty ENUMERATED object with its name.
	*/
	public
	CmdTerminReason(String name)
	{
		super(name);
	}
	
	/**
	* if you want to set your ENUMERATED to a different undefined value, use this constructor.
	*/
	public
	CmdTerminReason(long value)
	{
		super(value);
	}
	
	/**
	* if you want to set your ENUMERATED to a different undefined value, use this constructor.
	*/
	public
	CmdTerminReason(String name, long value)
	{
		super(name, value);
	}
}
