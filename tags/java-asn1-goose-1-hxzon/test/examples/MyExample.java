package examples;
/*
 */

import com.turkcelltech.jac.*;

public class MyExample extends SetOf
{
	public
	MyExample(String name)
	{
		super(name, new ASN1Integer("ASN1Integer"));
	}
	
	public
	MyExample()
	{
		super(new ASN1Integer("ASN1Integer"));
	}
}
