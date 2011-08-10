package integerTypeExamples;


/*
 * Created by JAC (Java Asn1 Compiler)
 */
 
import com.turkcelltech.jac.ASN1Integer;
//import com.chaosinmotion.asn1.Tag;

//look at the "integerExamples.asn" file

public class Integer_different_constraint_3 extends ASN1Integer
{
	/**
	* If you have any constraint below, you must obey to the constraints.
	* If you do not consider the constraints when setting your element, you will get exception.
	*
	* To set your object, you can call setValue(..) method. 
	* To encode/decode your object, just call encode(..) decode(..) methods
	*/
	
	public static final long  noHotBilling = 0;
	public static final long  hotBilling = 1;
	public static final long  commonBilling = 23;
	/* end of range constraint constants */
	
	/**
	* asn.1 INTEGER constructor to create "uninitialized" object.
	* setValue() method can be called to set the value of the integer.
	*/
	public
	Integer_different_constraint_3()
	{
		super();
	}

	/**
	* asn.1 INTEGER constructor to create "uninitialized" object.
	* setValue() method can be called to set the value of the integer.
	*/
	public
	Integer_different_constraint_3(String name)
	{
		super();
		setName(name);
	}
	
	/**
	* asn.1 INTEGER constructor to create "initialized" object.
	*/
	public
	Integer_different_constraint_3(long value)
	{
		super();
		setValue(value);
	}
	
	/**
	* constructor to build ASN1Integer with its value and name.
	*/
	public
	Integer_different_constraint_3(String name, long value)
	{
		super();
		setValue(value);
		setName(name);
	}
	
	/*
	* range constraint setter methods
	*/
	
	public void setTo_noHotBilling_0() {
		setValue(noHotBilling);
	}

	public void setTo_hotBilling_1() {
		setValue(hotBilling);
	}

	public void setTo_commonBilling_23() {
		setValue(commonBilling);
	}

	/* end of setters */
}
