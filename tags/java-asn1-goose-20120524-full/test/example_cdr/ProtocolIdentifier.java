package example_cdr;

/*
 * Created by JAC (Java Asn1 Compiler)
 */

import com.turkcelltech.jac.Enumerated;


public class ProtocolIdentifier extends Enumerated
{
	/**
	* To set your ENUMERATED type, just call one of the "setTo_elementName()" methods.
	* To encode/decode your object, just call encode(..) decode(..) methods
	*/
	
	public static final int  plmn_ = 0;

	public void setTo_plmn_0() {
		setValue(plmn_);
	}

	public static final int  globaltitle_ = 24;

	public void setTo_globaltitle_24() {
		setValue(globaltitle_);
	}

	public static final int  faxg3_ = 34;

	public void setTo_faxg3_34() {
		setValue(faxg3_);
	}

	public static final int  faxg4_ = 35;

	public void setTo_faxg4_35() {
		setValue(faxg4_);
	}

	public static final int  ivr_ = 36;

	public void setTo_ivr_36() {
		setValue(ivr_);
	}

	public static final int  ermes_ = 37;

	public void setTo_ermes_37() {
		setValue(ermes_);
	}

	public static final int  menu_ = 56;

	public void setTo_menu_56() {
		setValue(menu_);
	}

	public static final int  pc_ = 57;

	public void setTo_pc_57() {
		setValue(pc_);
	}

	public static final int  tap_ = 58;

	public void setTo_tap_58() {
		setValue(tap_);
	}

	public static final int  smpp_ = 59;

	public void setTo_smpp_59() {
		setValue(smpp_);
	}

	public static final int  wap_ = 60;

	public void setTo_wap_60() {
		setValue(wap_);
	}

	public static final int  ois_ = 61;

	public void setTo_ois_61() {
		setValue(ois_);
	}

	public static final int  vms_ = 62;

	public void setTo_vms_62() {
		setValue(vms_);
	}

	public static final int  smtp_ = 204;

	public void setTo_smtp_204() {
		setValue(smtp_);
	}

	/* end of enumerated constants */

	/**
	* constructs empty ENUMERATED object
	*/
	public
	ProtocolIdentifier()
	{
		super();
	}
	
	/**
	* constructs empty ENUMERATED object with its name.
	*/
	public
	ProtocolIdentifier(String name)
	{
		super(name);
	}
	
	/**
	* if you want to set your ENUMERATED to a different undefined value, use this constructor.
	*/
	public
	ProtocolIdentifier(long value)
	{
		super(value);
	}
	
	/**
	* if you want to set your ENUMERATED to a different undefined value, use this constructor.
	*/
	public
	ProtocolIdentifier(String name, long value)
	{
		super(name, value);
	}
}
