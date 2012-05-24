package example_cdr;

/*
 * Created by JAC (Java Asn1 Compiler)
 */

import com.turkcelltech.jac.Enumerated;


public class NumberingPlanIndicator extends Enumerated
{
	/**
	* To set your ENUMERATED type, just call one of the "setTo_elementName()" methods.
	* To encode/decode your object, just call encode(..) decode(..) methods
	*/
	
	public static final int  unknown_ = 0;

	public void setTo_unknown_0() {
		setValue(unknown_);
	}

	public static final int  telephone_ = 1;

	public void setTo_telephone_1() {
		setValue(telephone_);
	}

	public static final int  reserved2_ = 2;

	public void setTo_reserved2_2() {
		setValue(reserved2_);
	}

	public static final int  data_ = 3;

	public void setTo_data_3() {
		setValue(data_);
	}

	public static final int  telex_ = 4;

	public void setTo_telex_4() {
		setValue(telex_);
	}

	public static final int  tcpip_ = 5;

	public void setTo_tcpip_5() {
		setValue(tcpip_);
	}

	public static final int  landmobile_ = 6;

	public void setTo_landmobile_6() {
		setValue(landmobile_);
	}

	public static final int  reserved7_ = 7;

	public void setTo_reserved7_7() {
		setValue(reserved7_);
	}

	public static final int  national_ = 8;

	public void setTo_national_8() {
		setValue(national_);
	}

	public static final int  private_ = 9;

	public void setTo_private_9() {
		setValue(private_);
	}

	public static final int  ermes_ = 10;

	public void setTo_ermes_10() {
		setValue(ermes_);
	}

	public static final int  reserved11_ = 11;

	public void setTo_reserved11_11() {
		setValue(reserved11_);
	}

	public static final int  reserved12_ = 12;

	public void setTo_reserved12_12() {
		setValue(reserved12_);
	}

	public static final int  reserved13_ = 13;

	public void setTo_reserved13_13() {
		setValue(reserved13_);
	}

	public static final int  internet_ = 14;

	public void setTo_internet_14() {
		setValue(internet_);
	}

	public static final int  reserved15_ = 15;

	public void setTo_reserved15_15() {
		setValue(reserved15_);
	}

	/* end of enumerated constants */

	/**
	* constructs empty ENUMERATED object
	*/
	public
	NumberingPlanIndicator()
	{
		super();
	}
	
	/**
	* constructs empty ENUMERATED object with its name.
	*/
	public
	NumberingPlanIndicator(String name)
	{
		super(name);
	}
	
	/**
	* if you want to set your ENUMERATED to a different undefined value, use this constructor.
	*/
	public
	NumberingPlanIndicator(long value)
	{
		super(value);
	}
	
	/**
	* if you want to set your ENUMERATED to a different undefined value, use this constructor.
	*/
	public
	NumberingPlanIndicator(String name, long value)
	{
		super(name, value);
	}
}
