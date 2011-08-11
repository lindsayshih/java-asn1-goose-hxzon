package sequenceOfExample;

/*
 * Created by JAC (Java Asn1 Compiler)
 */

import com.turkcelltech.jac.*;
import com.chaosinmotion.asn1.Tag;

public class Cell extends Sequence
{
	/**
	 * if you want to set/fill an element below, just call the setValue(..) method over its instance.
	 *
	 * To encode/decode your object, just call encode(..) decode(..) methods.
	 */
	public OctetString disc = new OctetString("disc");
	public OctetString cell_id = new OctetString("cell_id");
	/* end of element declarations */
	
	/**
	* asn.1 SEQUENCE constructor
	*/
	public
	Cell()
	{
		super();
		setUpElements();
	}

	/**
	* asn.1 SEQUENCE constructor with its name
	*/
	public
	Cell(String name)
	{
		super(name);
		setUpElements();
	}
	

	protected void
	setUpElements()
	{
		super.addElement(disc);
		super.addElement(cell_id);
	/* end of element setup */
	}


}
