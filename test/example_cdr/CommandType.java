package example_cdr;

/*
 * Created by JAC (Java Asn1 Compiler)
 */

import com.turkcelltech.jac.Enumerated;


public class CommandType extends Enumerated
{
	/**
	* To set your ENUMERATED type, just call one of the "setTo_elementName()" methods.
	* To encode/decode your object, just call encode(..) decode(..) methods
	*/
	
	public static final int  phase1cmdinqm_ = 0;

	public void setTo_phase1cmdinqm_0() {
		setValue(phase1cmdinqm_);
	}

	public static final int  phase1cmddelm_ = 1;

	public void setTo_phase1cmddelm_1() {
		setValue(phase1cmddelm_);
	}

	public static final int  gsmcmdcenq_ = 2;

	public void setTo_gsmcmdcenq_2() {
		setValue(gsmcmdcenq_);
	}

	public static final int  gsmcmdcdel_ = 3;

	public void setTo_gsmcmdcdel_3() {
		setValue(gsmcmdcdel_);
	}

	public static final int  gsmcmdcesr_ = 4;

	public void setTo_gsmcmdcesr_4() {
		setValue(gsmcmdcesr_);
	}

	public static final int  gsmcmdccsr_ = 5;

	public void setTo_gsmcmdccsr_5() {
		setValue(gsmcmdccsr_);
	}

	public static final int  phase1cmdmodm_ = 6;

	public void setTo_phase1cmdmodm_6() {
		setValue(phase1cmdmodm_);
	}

	public static final int  gsmcmdssdl_ = 7;

	public void setTo_gsmcmdssdl_7() {
		setValue(gsmcmdssdl_);
	}

	/* end of enumerated constants */

	/**
	* constructs empty ENUMERATED object
	*/
	public
	CommandType()
	{
		super();
	}
	
	/**
	* constructs empty ENUMERATED object with its name.
	*/
	public
	CommandType(String name)
	{
		super(name);
	}
	
	/**
	* if you want to set your ENUMERATED to a different undefined value, use this constructor.
	*/
	public
	CommandType(long value)
	{
		super(value);
	}
	
	/**
	* if you want to set your ENUMERATED to a different undefined value, use this constructor.
	*/
	public
	CommandType(String name, long value)
	{
		super(name, value);
	}
}
