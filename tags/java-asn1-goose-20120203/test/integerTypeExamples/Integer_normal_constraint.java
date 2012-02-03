package integerTypeExamples;

/*
 * Created by JAC (Java Asn1 Compiler)
 */
 
import com.turkcelltech.jac.ASN1Integer;
//import com.chaosinmotion.asn1.Tag;

//look at the "integerExamples.asn" file

public class Integer_normal_constraint extends ASN1Integer
{
	/**
	* If you have any constraint below, you must obey to the constraints.
	* If you do not consider the constraints when setting your element, you will get exception.
	*
	* To set your object, you can call setValue(..) method. 
	* To encode/decode your object, just call encode(..) decode(..) methods
	*/
	
	public static final long  min = 1;
	public static final long  max = 200;
	/* end of range constraint constants */
	
	/**
	* asn.1 INTEGER constructor to create "uninitialized" object.
	* setValue() method can be called to set the value of the integer.
	*/
	public
	Integer_normal_constraint()
	{
		super("min",min,"max",max);
	}

	/**
	* asn.1 INTEGER constructor to create "uninitialized" object.
	* setValue() method can be called to set the value of the integer.
	*/
	public
	Integer_normal_constraint(String name)
	{
		super("min",min,"max",max);
		setName(name);
	}
	
	/**
	* asn.1 INTEGER constructor to create "initialized" object.
	*/
	public
	Integer_normal_constraint(long value)
	{
		super("min",min,"max",max);
		setValue(value);
	}
	
	/**
	* constructor to build ASN1Integer with its value and name.
	*/
	public
	Integer_normal_constraint(String name, long value)
	{
		super("min",min,"max",max);
		setValue(value);
		setName(name);
	}
	
	/*
	* range constraint setter methods
	*/
	
	public void setTo_min_1() {
		setValue(min);
	}

	public void setTo_max_200() {
		setValue(max);
	}

	/* end of setters */
}
