package example_cdr;

/*
 * Created by JAC (Java Asn1 Compiler)
 */

import com.turkcelltech.jac.Enumerated;


public class CdrType extends Enumerated
{
	/**
	* To set your ENUMERATED type, just call one of the "setTo_elementName()" methods.
	* To encode/decode your object, just call encode(..) decode(..) methods
	*/
	
	public static final int  undefined_ = 0;

	public void setTo_undefined_0() {
		setValue(undefined_);
	}

	public static final int  peer2peer_ = 1;

	public void setTo_peer2peer_1() {
		setValue(peer2peer_);
	}

	public static final int  peer2vasNonALA_ = 2;

	public void setTo_peer2vasNonALA_2() {
		setValue(peer2vasNonALA_);
	}

	public static final int  peer2vasALA_ = 3;

	public void setTo_peer2vasALA_3() {
		setValue(peer2vasALA_);
	}

	public static final int  vas2peer_ = 4;

	public void setTo_vas2peer_4() {
		setValue(vas2peer_);
	}

	public static final int  alpha2peer_ = 5;

	public void setTo_alpha2peer_5() {
		setValue(alpha2peer_);
	}

	public static final int  long2peer_ = 6;

	public void setTo_long2peer_6() {
		setValue(long2peer_);
	}

	/* end of enumerated constants */

	/**
	* constructs empty ENUMERATED object
	*/
	public
	CdrType()
	{
		super();
	}
	
	/**
	* constructs empty ENUMERATED object with its name.
	*/
	public
	CdrType(String name)
	{
		super(name);
	}
	
	/**
	* if you want to set your ENUMERATED to a different undefined value, use this constructor.
	*/
	public
	CdrType(long value)
	{
		super(value);
	}
	
	/**
	* if you want to set your ENUMERATED to a different undefined value, use this constructor.
	*/
	public
	CdrType(String name, long value)
	{
		super(name, value);
	}
}
