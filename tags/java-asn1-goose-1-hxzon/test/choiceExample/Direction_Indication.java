package choiceExample;

/*
 * Created by JAC (Java Asn1 Compiler)
 */

import com.turkcelltech.jac.Enumerated;
//import com.chaosinmotion.asn1.Tag;


public class Direction_Indication extends Enumerated
{
	/**
	* To set your ENUMERATED type, just call one of the "setTo_elementName()" methods.
	* To encode/decode your object, just call encode(..) decode(..) methods
	*/
	
	public static final int  mono_mode_ = 0;

	public void setTo_mono_mode_0() {
		setValue(mono_mode_);
	}

	public static final int  cc_from_target_ = 1;

	public void setTo_cc_from_target_1() {
		setValue(cc_from_target_);
	}

	public static final int  cc_from_other_party_ = 2;

	public void setTo_cc_from_other_party_2() {
		setValue(cc_from_other_party_);
	}

	public static final int  direction_unknown_ = 3;

	public void setTo_direction_unknown_3() {
		setValue(direction_unknown_);
	}

	/* end of enumerated constants */

	/**
	* constructs empty ENUMERATED object
	*/
	public
	Direction_Indication()
	{
		super();
	}
	
	/**
	* constructs empty ENUMERATED object with its name.
	*/
	public
	Direction_Indication(String name)
	{
		super(name);
	}
	
	/**
	* if you want to set your ENUMERATED to a different undefined value, use this constructor.
	*/
	public
	Direction_Indication(long value)
	{
		super(value);
	}
	
	/**
	* if you want to set your ENUMERATED to a different undefined value, use this constructor.
	*/
	public
	Direction_Indication(String name, long value)
	{
		super(name, value);
	}
}
