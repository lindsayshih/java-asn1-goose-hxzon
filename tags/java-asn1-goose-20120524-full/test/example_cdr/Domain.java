package example_cdr;

/*
 * Created by JAC (Java Asn1 Compiler)
 */

import com.turkcelltech.jac.Enumerated;


public class Domain extends Enumerated
{
	/**
	* To set your ENUMERATED type, just call one of the "setTo_elementName()" methods.
	* To encode/decode your object, just call encode(..) decode(..) methods
	*/
	
	public static final int  turkcell_ = 0;

	public void setTo_turkcell_0() {
		setValue(turkcell_);
	}

	public static final int  kktcell_ = 1;

	public void setTo_kktcell_1() {
		setValue(kktcell_);
	}

	public static final int  roamer_ = 2;

	public void setTo_roamer_2() {
		setValue(roamer_);
	}

	/* end of enumerated constants */

	/**
	* constructs empty ENUMERATED object
	*/
	public
	Domain()
	{
		super();
	}
	
	/**
	* constructs empty ENUMERATED object with its name.
	*/
	public
	Domain(String name)
	{
		super(name);
	}
	
	/**
	* if you want to set your ENUMERATED to a different undefined value, use this constructor.
	*/
	public
	Domain(long value)
	{
		super(value);
	}
	
	/**
	* if you want to set your ENUMERATED to a different undefined value, use this constructor.
	*/
	public
	Domain(String name, long value)
	{
		super(name, value);
	}
}
