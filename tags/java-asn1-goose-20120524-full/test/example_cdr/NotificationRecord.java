package example_cdr;

/*
 * Created by JAC (Java Asn1 Compiler)
 */

import com.turkcelltech.jac.*;
import com.chaosinmotion.asn1.Tag;

public class NotificationRecord extends Sequence
{
	/**
	 * if you want to set/fill an element below, just call the setValue(..) method over its instance.
	 *
	 * To encode/decode your object, just call encode(..) decode(..) methods.
	 */
	public AddressInformation orglOrigAddress = new AddressInformation("orglOrigAddress");
	public AddressString orglOrigAddressGSM = new AddressString("orglOrigAddressGSM");
	public AddressInformation orglRecipAddress = new AddressInformation("orglRecipAddress");
	public AddressString orglRecipAddressGSM = new AddressString("orglRecipAddressGSM");
	public AddressInformation orglNotifAddress = new AddressInformation("orglNotifAddress");
	public AddressString orglNotifAddressGSM = new AddressString("orglNotifAddressGSM");
	public Date submitDate = new Date("submitDate");
	public Time submitTime = new Time("submitTime");
	public Date orglSubmitDate = new Date("orglSubmitDate");
	public Time orglSubmitTime = new Time("orglSubmitTime");
	public Status status = new Status("status");
	public Date terminDate = new Date("terminDate");
	public Time terminTime = new Time("terminTime");
	public MessageLength lengthOfMessage = new MessageLength("lengthOfMessage");
	public Period validityPeriod = new Period("validityPeriod");
	public RangeVSMSC vsmscid = new RangeVSMSC("vsmscid");
	public TypeVSMSC vsmsctype = new TypeVSMSC("vsmsctype");
	public IA5String consolidation = new IA5String("consolidation");
	public IA5String billid = new IA5String("billid");
	public SmeReference smeReference = new SmeReference("smeReference");
	public IA5String smsContentDcs = new IA5String("smsContentDcs");
	public SMSSTRING smsContents = new SMSSTRING("smsContents");
	public MsgRef messageReference = new MsgRef("messageReference");
	public IA5String recipLASN = new IA5String("recipLASN");
	public IA5String origMsgID = new IA5String("origMsgID");
	public ISRFlags isr = new ISRFlags("isr");
	public BooleanServicesNotif boolSer = new BooleanServicesNotif("boolSer");
	public AddressInformation recipAltAddress = new AddressInformation("recipAltAddress");
	public IA5String serviceType = new IA5String("serviceType");
	public AddressInformation orglDgtiAddress = new AddressInformation("orglDgtiAddress");
	public AddressString orglDgtiAddressGSM = new AddressString("orglDgtiAddressGSM");
	public C7PointCode orglDestPointCode = new C7PointCode("orglDestPointCode");
	public AddressInformation orglOgtiAddress = new AddressInformation("orglOgtiAddress");
	public AddressString orglOgtiAddressGSM = new AddressString("orglOgtiAddressGSM");
	public C7PointCode orglOrigPointCode = new C7PointCode("orglOrigPointCode");
	public DeliveryAttempts deliveryAttempts = new DeliveryAttempts("deliveryAttempts");
	public UTF8AddressInformation orglUntranslOrigAddress = new UTF8AddressInformation("orglUntranslOrigAddress");
	public AddressString orglUntranslOrigAddressGSM = new AddressString("orglUntranslOrigAddressGSM");
	public UTF8AddressInformation orglUntranslRecipAddress = new UTF8AddressInformation("orglUntranslRecipAddress");
	public AddressString orglUntranslRecipAddressGSM = new AddressString("orglUntranslRecipAddressGSM");
	public MessageError msgError = new MessageError("msgError");
	public GSMTPDCS tpDCS = new GSMTPDCS("tpDCS");
	/* end of element declarations */
	
	/**
	* asn.1 SEQUENCE constructor
	*/
	public
	NotificationRecord()
	{
		super();
		setUpElements();
	}

	/**
	* asn.1 SEQUENCE constructor with its name
	*/
	public
	NotificationRecord(String name)
	{
		super(name);
		setUpElements();
	}
	

	protected void
	setUpElements()
	{
		super.addElement(orglOrigAddress);
		orglOrigAddress.setOptional(true);
		orglOrigAddress.setTaggingMethod(Tag.IMPLICIT);
		orglOrigAddress.setTagClass(Tag.CONTEXT);
		orglOrigAddress.setTagNumber(0);
		super.addElement(orglOrigAddressGSM);
		orglOrigAddressGSM.setOptional(true);
		orglOrigAddressGSM.setTaggingMethod(Tag.IMPLICIT);
		orglOrigAddressGSM.setTagClass(Tag.CONTEXT);
		orglOrigAddressGSM.setTagNumber(1);
		super.addElement(orglRecipAddress);
		orglRecipAddress.setOptional(true);
		orglRecipAddress.setTaggingMethod(Tag.IMPLICIT);
		orglRecipAddress.setTagClass(Tag.CONTEXT);
		orglRecipAddress.setTagNumber(2);
		super.addElement(orglRecipAddressGSM);
		orglRecipAddressGSM.setOptional(true);
		orglRecipAddressGSM.setTaggingMethod(Tag.IMPLICIT);
		orglRecipAddressGSM.setTagClass(Tag.CONTEXT);
		orglRecipAddressGSM.setTagNumber(3);
		super.addElement(orglNotifAddress);
		orglNotifAddress.setOptional(true);
		orglNotifAddress.setTaggingMethod(Tag.IMPLICIT);
		orglNotifAddress.setTagClass(Tag.CONTEXT);
		orglNotifAddress.setTagNumber(4);
		super.addElement(orglNotifAddressGSM);
		orglNotifAddressGSM.setOptional(true);
		orglNotifAddressGSM.setTaggingMethod(Tag.IMPLICIT);
		orglNotifAddressGSM.setTagClass(Tag.CONTEXT);
		orglNotifAddressGSM.setTagNumber(5);
		super.addElement(submitDate);
		submitDate.setOptional(true);
		submitDate.setTaggingMethod(Tag.IMPLICIT);
		submitDate.setTagClass(Tag.CONTEXT);
		submitDate.setTagNumber(6);
		super.addElement(submitTime);
		submitTime.setOptional(true);
		submitTime.setTaggingMethod(Tag.IMPLICIT);
		submitTime.setTagClass(Tag.CONTEXT);
		submitTime.setTagNumber(7);
		super.addElement(orglSubmitDate);
		orglSubmitDate.setOptional(true);
		orglSubmitDate.setTaggingMethod(Tag.IMPLICIT);
		orglSubmitDate.setTagClass(Tag.CONTEXT);
		orglSubmitDate.setTagNumber(8);
		super.addElement(orglSubmitTime);
		orglSubmitTime.setOptional(true);
		orglSubmitTime.setTaggingMethod(Tag.IMPLICIT);
		orglSubmitTime.setTagClass(Tag.CONTEXT);
		orglSubmitTime.setTagNumber(9);
		super.addElement(status);
		status.setOptional(true);
		status.setTaggingMethod(Tag.IMPLICIT);
		status.setTagClass(Tag.CONTEXT);
		status.setTagNumber(10);
		super.addElement(terminDate);
		terminDate.setOptional(true);
		terminDate.setTaggingMethod(Tag.IMPLICIT);
		terminDate.setTagClass(Tag.CONTEXT);
		terminDate.setTagNumber(11);
		super.addElement(terminTime);
		terminTime.setOptional(true);
		terminTime.setTaggingMethod(Tag.IMPLICIT);
		terminTime.setTagClass(Tag.CONTEXT);
		terminTime.setTagNumber(12);
		super.addElement(lengthOfMessage);
		lengthOfMessage.setOptional(true);
		lengthOfMessage.setTaggingMethod(Tag.IMPLICIT);
		lengthOfMessage.setTagClass(Tag.CONTEXT);
		lengthOfMessage.setTagNumber(13);
		super.addElement(validityPeriod);
		validityPeriod.setOptional(true);
		validityPeriod.setTaggingMethod(Tag.IMPLICIT);
		validityPeriod.setTagClass(Tag.CONTEXT);
		validityPeriod.setTagNumber(14);
		super.addElement(vsmscid);
		vsmscid.setOptional(true);
		vsmscid.setTaggingMethod(Tag.IMPLICIT);
		vsmscid.setTagClass(Tag.CONTEXT);
		vsmscid.setTagNumber(15);
		super.addElement(vsmsctype);
		vsmsctype.setOptional(true);
		vsmsctype.setTaggingMethod(Tag.IMPLICIT);
		vsmsctype.setTagClass(Tag.CONTEXT);
		vsmsctype.setTagNumber(16);
		super.addElement(consolidation);
		consolidation.setOptional(true);
		consolidation.setTaggingMethod(Tag.IMPLICIT);
		consolidation.setTagClass(Tag.CONTEXT);
		consolidation.setTagNumber(17);
		super.addElement(billid);
		billid.setOptional(true);
		billid.setTaggingMethod(Tag.IMPLICIT);
		billid.setTagClass(Tag.CONTEXT);
		billid.setTagNumber(18);
		super.addElement(smeReference);
		smeReference.setOptional(true);
		smeReference.setTaggingMethod(Tag.IMPLICIT);
		smeReference.setTagClass(Tag.CONTEXT);
		smeReference.setTagNumber(19);
		super.addElement(smsContentDcs);
		smsContentDcs.setOptional(true);
		smsContentDcs.setTaggingMethod(Tag.IMPLICIT);
		smsContentDcs.setTagClass(Tag.CONTEXT);
		smsContentDcs.setTagNumber(20);
		super.addElement(smsContents);
		smsContents.setOptional(true);
		smsContents.setTaggingMethod(Tag.IMPLICIT);
		smsContents.setTagClass(Tag.CONTEXT);
		smsContents.setTagNumber(21);
		super.addElement(messageReference);
		messageReference.setOptional(true);
		messageReference.setTaggingMethod(Tag.IMPLICIT);
		messageReference.setTagClass(Tag.CONTEXT);
		messageReference.setTagNumber(22);
		super.addElement(recipLASN);
		recipLASN.setOptional(true);
		recipLASN.setTaggingMethod(Tag.IMPLICIT);
		recipLASN.setTagClass(Tag.CONTEXT);
		recipLASN.setTagNumber(23);
		super.addElement(origMsgID);
		origMsgID.setOptional(true);
		origMsgID.setTaggingMethod(Tag.IMPLICIT);
		origMsgID.setTagClass(Tag.CONTEXT);
		origMsgID.setTagNumber(24);
		super.addElement(isr);
		isr.setOptional(true);
		isr.setTaggingMethod(Tag.IMPLICIT);
		isr.setTagClass(Tag.CONTEXT);
		isr.setTagNumber(25);
		super.addElement(boolSer);
		boolSer.setOptional(true);
		boolSer.setTaggingMethod(Tag.IMPLICIT);
		boolSer.setTagClass(Tag.CONTEXT);
		boolSer.setTagNumber(26);
		super.addElement(recipAltAddress);
		recipAltAddress.setOptional(true);
		recipAltAddress.setTaggingMethod(Tag.IMPLICIT);
		recipAltAddress.setTagClass(Tag.CONTEXT);
		recipAltAddress.setTagNumber(27);
		super.addElement(serviceType);
		serviceType.setOptional(true);
		serviceType.setTaggingMethod(Tag.IMPLICIT);
		serviceType.setTagClass(Tag.CONTEXT);
		serviceType.setTagNumber(28);
		super.addElement(orglDgtiAddress);
		orglDgtiAddress.setOptional(true);
		orglDgtiAddress.setTaggingMethod(Tag.IMPLICIT);
		orglDgtiAddress.setTagClass(Tag.CONTEXT);
		orglDgtiAddress.setTagNumber(29);
		super.addElement(orglDgtiAddressGSM);
		orglDgtiAddressGSM.setOptional(true);
		orglDgtiAddressGSM.setTaggingMethod(Tag.IMPLICIT);
		orglDgtiAddressGSM.setTagClass(Tag.CONTEXT);
		orglDgtiAddressGSM.setTagNumber(30);
		super.addElement(orglDestPointCode);
		orglDestPointCode.setOptional(true);
		orglDestPointCode.setTaggingMethod(Tag.IMPLICIT);
		orglDestPointCode.setTagClass(Tag.CONTEXT);
		orglDestPointCode.setTagNumber(31);
		super.addElement(orglOgtiAddress);
		orglOgtiAddress.setOptional(true);
		orglOgtiAddress.setTaggingMethod(Tag.IMPLICIT);
		orglOgtiAddress.setTagClass(Tag.CONTEXT);
		orglOgtiAddress.setTagNumber(32);
		super.addElement(orglOgtiAddressGSM);
		orglOgtiAddressGSM.setOptional(true);
		orglOgtiAddressGSM.setTaggingMethod(Tag.IMPLICIT);
		orglOgtiAddressGSM.setTagClass(Tag.CONTEXT);
		orglOgtiAddressGSM.setTagNumber(33);
		super.addElement(orglOrigPointCode);
		orglOrigPointCode.setOptional(true);
		orglOrigPointCode.setTaggingMethod(Tag.IMPLICIT);
		orglOrigPointCode.setTagClass(Tag.CONTEXT);
		orglOrigPointCode.setTagNumber(34);
		super.addElement(deliveryAttempts);
		deliveryAttempts.setOptional(true);
		deliveryAttempts.setTaggingMethod(Tag.IMPLICIT);
		deliveryAttempts.setTagClass(Tag.CONTEXT);
		deliveryAttempts.setTagNumber(35);
		super.addElement(orglUntranslOrigAddress);
		orglUntranslOrigAddress.setOptional(true);
		orglUntranslOrigAddress.setTaggingMethod(Tag.IMPLICIT);
		orglUntranslOrigAddress.setTagClass(Tag.CONTEXT);
		orglUntranslOrigAddress.setTagNumber(36);
		super.addElement(orglUntranslOrigAddressGSM);
		orglUntranslOrigAddressGSM.setOptional(true);
		orglUntranslOrigAddressGSM.setTaggingMethod(Tag.IMPLICIT);
		orglUntranslOrigAddressGSM.setTagClass(Tag.CONTEXT);
		orglUntranslOrigAddressGSM.setTagNumber(37);
		super.addElement(orglUntranslRecipAddress);
		orglUntranslRecipAddress.setOptional(true);
		orglUntranslRecipAddress.setTaggingMethod(Tag.IMPLICIT);
		orglUntranslRecipAddress.setTagClass(Tag.CONTEXT);
		orglUntranslRecipAddress.setTagNumber(38);
		super.addElement(orglUntranslRecipAddressGSM);
		orglUntranslRecipAddressGSM.setOptional(true);
		orglUntranslRecipAddressGSM.setTaggingMethod(Tag.IMPLICIT);
		orglUntranslRecipAddressGSM.setTagClass(Tag.CONTEXT);
		orglUntranslRecipAddressGSM.setTagNumber(39);
		super.addElement(msgError);
		msgError.setOptional(true);
		msgError.setTaggingMethod(Tag.IMPLICIT);
		msgError.setTagClass(Tag.CONTEXT);
		msgError.setTagNumber(40);
		super.addElement(tpDCS);
		tpDCS.setOptional(true);
		tpDCS.setTaggingMethod(Tag.IMPLICIT);
		tpDCS.setTagClass(Tag.CONTEXT);
		tpDCS.setTagNumber(41);
	/* end of element setup */
	}


}
