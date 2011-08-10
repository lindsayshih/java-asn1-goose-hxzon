package examples;


import com.turkcelltech.jac.*;
import com.chaosinmotion.asn1.Tag;

public class AirRecord extends Sequence
{
	public ASN1Boolean hot = new ASN1Boolean("hot");
	public ASN1Integer degree = new ASN1Integer("degree");
	public Cloud cloud = new Cloud("cloud");
	public EnumExample domain = new EnumExample("domain");
	/* end of element declarations */
	
	/**
	*  added by Fatih Batuk
	*/
	public
	AirRecord()
	{
		super();
		setUpElements();
	}

	public
	AirRecord(String name)
	{
		super(name);
		setUpElements();
	}

	protected void
	setUpElements()
	{
		super.addElement(hot);
		hot.setOptional(true);
		hot.setTagClass(Tag.CONTEXT);
		hot.setTagNumber(0);
		super.addElement(degree);
		super.addElement(cloud);
		cloud.setOptional(true);
		cloud.setTagClass(Tag.CONTEXT);
		cloud.setTagNumber(1);
		super.addElement(domain);
		domain.setOptional(true);
	/* end of element setup */
	}


}
