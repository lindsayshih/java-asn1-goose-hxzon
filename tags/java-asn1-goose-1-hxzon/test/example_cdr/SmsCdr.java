package example_cdr;

/*
 * Created by JAC (Java Asn1 Compiler)
 */

import com.turkcelltech.jac.*;
import com.chaosinmotion.asn1.Tag;

public class SmsCdr extends Choice
{
	/**
	* To choose an element below you should call choose(elementName) method
	* and you can make encoding and decoding examples over the chosen object.
	* To encode/decode the chosen object, just call encode(..) decode(..) methods over it.
	*/
	
	public CallDetailRecord callDetailRecord = new CallDetailRecord("callDetailRecord");
	public CommandRecord commandRecord = new CommandRecord("commandRecord");
	public NotificationRecord notificationRecord = new NotificationRecord("notificationRecord");
	public SummaryRecord summaryRecord = new SummaryRecord("summaryRecord");
	/* end of element declarations */
	
	/**
	* constructor without a name
	*/
	public
	SmsCdr()
	{
		super();
		setUpElements();
	}
	
	/**
	* constructor with a name
	*/
	public
	SmsCdr(String name)
	{
		super(name);
		setUpElements();
	}

	protected void
	setUpElements()
	{
		super.addElement(callDetailRecord);
		super.addElement(commandRecord);
		commandRecord.setTaggingMethod(Tag.IMPLICIT);
		commandRecord.setTagClass(Tag.APPLICATION);
		commandRecord.setTagNumber(0);
		super.addElement(notificationRecord);
		notificationRecord.setTaggingMethod(Tag.IMPLICIT);
		notificationRecord.setTagClass(Tag.APPLICATION);
		notificationRecord.setTagNumber(1);
		super.addElement(summaryRecord);
		summaryRecord.setTaggingMethod(Tag.IMPLICIT);
		summaryRecord.setTagClass(Tag.APPLICATION);
		summaryRecord.setTagNumber(2);
	/* end of element setup */
	}
}
