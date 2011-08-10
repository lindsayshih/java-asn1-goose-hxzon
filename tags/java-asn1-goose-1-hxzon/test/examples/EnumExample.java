package examples;


import com.turkcelltech.jac.*;

public class EnumExample extends Enumerated
{
	
	public static final int  delivered_ = 0;

	public void setTo_delivered_0() {
		setValue(delivered_);
	}

	public static final int  expired_ = 1;

	public void setTo_expired_1() {
		setValue(expired_);
	}
	
	public
	EnumExample()
	{
		super();
	}

	public
	EnumExample(String name)
	{
		super(name);
	}
	
	public
	EnumExample(long value)
	{
		super(value);
	}
	
	public
	EnumExample(String name, long value)
	{
		super(name, value);
	}
}
