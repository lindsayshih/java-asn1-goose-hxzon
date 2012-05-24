package example_cdr;

/*
 * Created by JAC (Java Asn1 Compiler)
 */

import com.turkcelltech.jac.Enumerated;


public class Status extends Enumerated
{
	/**
	* To set your ENUMERATED type, just call one of the "setTo_elementName()" methods.
	* To encode/decode your object, just call encode(..) decode(..) methods
	*/
	
	public static final int  delivered_ = 0;

	public void setTo_delivered_0() {
		setValue(delivered_);
	}

	public static final int  expired_ = 1;

	public void setTo_expired_1() {
		setValue(expired_);
	}

	public static final int  deleted_ = 2;

	public void setTo_deleted_2() {
		setValue(deleted_);
	}

	public static final int  replaced_ = 3;

	public void setTo_replaced_3() {
		setValue(replaced_);
	}

	public static final int  submitted_ = 4;

	public void setTo_submitted_4() {
		setValue(submitted_);
	}

	public static final int  incompleteSubmission_ = 5;

	public void setTo_incompleteSubmission_5() {
		setValue(incompleteSubmission_);
	}

	public static final int  incompleteDelivery_ = 6;

	public void setTo_incompleteDelivery_6() {
		setValue(incompleteDelivery_);
	}

	public static final int  undeliverable_ = 7;

	public void setTo_undeliverable_7() {
		setValue(undeliverable_);
	}

	public static final int  passedOn_ = 8;

	public void setTo_passedOn_8() {
		setValue(passedOn_);
	}

	public static final int  ppRejected_ = 9;

	public void setTo_ppRejected_9() {
		setValue(ppRejected_);
	}

	/* end of enumerated constants */

	/**
	* constructs empty ENUMERATED object
	*/
	public
	Status()
	{
		super();
	}
	
	/**
	* constructs empty ENUMERATED object with its name.
	*/
	public
	Status(String name)
	{
		super(name);
	}
	
	/**
	* if you want to set your ENUMERATED to a different undefined value, use this constructor.
	*/
	public
	Status(long value)
	{
		super(value);
	}
	
	/**
	* if you want to set your ENUMERATED to a different undefined value, use this constructor.
	*/
	public
	Status(String name, long value)
	{
		super(name, value);
	}
}
