package example_cdr;

/*
 * Created by JAC (Java Asn1 Compiler)
 */

import com.turkcelltech.jac.*;
import com.chaosinmotion.asn1.Tag;

public class CommandRecord extends Sequence
{
	/**
	 * if you want to set/fill an element below, just call the setValue(..) method over its instance.
	 *
	 * To encode/decode your object, just call encode(..) decode(..) methods.
	 */
	public CommandType commandType = new CommandType("commandType");
	public AddressInformation origAddress = new AddressInformation("origAddress");
	public AddressString origAddressGSM = new AddressString("origAddressGSM");
	public AddressInformation recipAddress = new AddressInformation("recipAddress");
	public AddressString recipAddressGSM = new AddressString("recipAddressGSM");
	public RangeVSMSC vsmscid = new RangeVSMSC("vsmscid");
	public TypeVSMSC vsmsctype = new TypeVSMSC("vsmsctype");
	public AddressInformation ogtiAddress = new AddressInformation("ogtiAddress");
	public AddressString ogtiAddressGSM = new AddressString("ogtiAddressGSM");
	public C7PointCode origPointCode = new C7PointCode("origPointCode");
	public Date orglSubmitDate = new Date("orglSubmitDate");
	public Time orglSubmitTime = new Time("orglSubmitTime");
	public IMSI intlMobileSubId = new IMSI("intlMobileSubId");
	public AddressInformation callingLineId = new AddressInformation("callingLineId");
	public AddressString callingLineIdGSM = new AddressString("callingLineIdGSM");
	public IA5String consolidation = new IA5String("consolidation");
	public IA5String billid = new IA5String("billid");
	public SmeReference smeReference = new SmeReference("smeReference");
	public IA5String smsContentDcs = new IA5String("smsContentDcs");
	public SMSSTRING smsContents = new SMSSTRING("smsContents");
	public MsgRef messageReference = new MsgRef("messageReference");
	public IA5String serviceType = new IA5String("serviceType");
	public GSMTPDCS tpDCS = new GSMTPDCS("tpDCS");
	/* end of element declarations */
	
	/**
	* asn.1 SEQUENCE constructor
	*/
	public
	CommandRecord()
	{
		super();
		setUpElements();
	}

	/**
	* asn.1 SEQUENCE constructor with its name
	*/
	public
	CommandRecord(String name)
	{
		super(name);
		setUpElements();
	}
	

	protected void
	setUpElements()
	{
		super.addElement(commandType);
		commandType.setOptional(true);
		commandType.setTaggingMethod(Tag.IMPLICIT);
		commandType.setTagClass(Tag.CONTEXT);
		commandType.setTagNumber(0);
		super.addElement(origAddress);
		origAddress.setOptional(true);
		origAddress.setTaggingMethod(Tag.IMPLICIT);
		origAddress.setTagClass(Tag.CONTEXT);
		origAddress.setTagNumber(1);
		super.addElement(origAddressGSM);
		origAddressGSM.setOptional(true);
		origAddressGSM.setTaggingMethod(Tag.IMPLICIT);
		origAddressGSM.setTagClass(Tag.CONTEXT);
		origAddressGSM.setTagNumber(2);
		super.addElement(recipAddress);
		recipAddress.setOptional(true);
		recipAddress.setTaggingMethod(Tag.IMPLICIT);
		recipAddress.setTagClass(Tag.CONTEXT);
		recipAddress.setTagNumber(3);
		super.addElement(recipAddressGSM);
		recipAddressGSM.setOptional(true);
		recipAddressGSM.setTaggingMethod(Tag.IMPLICIT);
		recipAddressGSM.setTagClass(Tag.CONTEXT);
		recipAddressGSM.setTagNumber(4);
		super.addElement(vsmscid);
		vsmscid.setOptional(true);
		vsmscid.setTaggingMethod(Tag.IMPLICIT);
		vsmscid.setTagClass(Tag.CONTEXT);
		vsmscid.setTagNumber(6);
		super.addElement(vsmsctype);
		vsmsctype.setOptional(true);
		vsmsctype.setTaggingMethod(Tag.IMPLICIT);
		vsmsctype.setTagClass(Tag.CONTEXT);
		vsmsctype.setTagNumber(7);
		super.addElement(ogtiAddress);
		ogtiAddress.setOptional(true);
		ogtiAddress.setTaggingMethod(Tag.IMPLICIT);
		ogtiAddress.setTagClass(Tag.CONTEXT);
		ogtiAddress.setTagNumber(8);
		super.addElement(ogtiAddressGSM);
		ogtiAddressGSM.setOptional(true);
		ogtiAddressGSM.setTaggingMethod(Tag.IMPLICIT);
		ogtiAddressGSM.setTagClass(Tag.CONTEXT);
		ogtiAddressGSM.setTagNumber(9);
		super.addElement(origPointCode);
		origPointCode.setOptional(true);
		origPointCode.setTaggingMethod(Tag.IMPLICIT);
		origPointCode.setTagClass(Tag.CONTEXT);
		origPointCode.setTagNumber(10);
		super.addElement(orglSubmitDate);
		orglSubmitDate.setOptional(true);
		orglSubmitDate.setTaggingMethod(Tag.IMPLICIT);
		orglSubmitDate.setTagClass(Tag.CONTEXT);
		orglSubmitDate.setTagNumber(11);
		super.addElement(orglSubmitTime);
		orglSubmitTime.setOptional(true);
		orglSubmitTime.setTaggingMethod(Tag.IMPLICIT);
		orglSubmitTime.setTagClass(Tag.CONTEXT);
		orglSubmitTime.setTagNumber(12);
		super.addElement(intlMobileSubId);
		intlMobileSubId.setOptional(true);
		intlMobileSubId.setTaggingMethod(Tag.IMPLICIT);
		intlMobileSubId.setTagClass(Tag.CONTEXT);
		intlMobileSubId.setTagNumber(13);
		super.addElement(callingLineId);
		callingLineId.setOptional(true);
		callingLineId.setTaggingMethod(Tag.IMPLICIT);
		callingLineId.setTagClass(Tag.CONTEXT);
		callingLineId.setTagNumber(14);
		super.addElement(callingLineIdGSM);
		callingLineIdGSM.setOptional(true);
		callingLineIdGSM.setTaggingMethod(Tag.IMPLICIT);
		callingLineIdGSM.setTagClass(Tag.CONTEXT);
		callingLineIdGSM.setTagNumber(15);
		super.addElement(consolidation);
		consolidation.setOptional(true);
		consolidation.setTaggingMethod(Tag.IMPLICIT);
		consolidation.setTagClass(Tag.CONTEXT);
		consolidation.setTagNumber(16);
		super.addElement(billid);
		billid.setOptional(true);
		billid.setTaggingMethod(Tag.IMPLICIT);
		billid.setTagClass(Tag.CONTEXT);
		billid.setTagNumber(17);
		super.addElement(smeReference);
		smeReference.setOptional(true);
		smeReference.setTaggingMethod(Tag.IMPLICIT);
		smeReference.setTagClass(Tag.CONTEXT);
		smeReference.setTagNumber(18);
		super.addElement(smsContentDcs);
		smsContentDcs.setOptional(true);
		smsContentDcs.setTaggingMethod(Tag.IMPLICIT);
		smsContentDcs.setTagClass(Tag.CONTEXT);
		smsContentDcs.setTagNumber(19);
		super.addElement(smsContents);
		smsContents.setOptional(true);
		smsContents.setTaggingMethod(Tag.IMPLICIT);
		smsContents.setTagClass(Tag.CONTEXT);
		smsContents.setTagNumber(20);
		super.addElement(messageReference);
		messageReference.setOptional(true);
		messageReference.setTaggingMethod(Tag.IMPLICIT);
		messageReference.setTagClass(Tag.CONTEXT);
		messageReference.setTagNumber(21);
		super.addElement(serviceType);
		serviceType.setOptional(true);
		serviceType.setTaggingMethod(Tag.IMPLICIT);
		serviceType.setTagClass(Tag.CONTEXT);
		serviceType.setTagNumber(22);
		super.addElement(tpDCS);
		tpDCS.setOptional(true);
		tpDCS.setTaggingMethod(Tag.IMPLICIT);
		tpDCS.setTagClass(Tag.CONTEXT);
		tpDCS.setTagNumber(23);
	/* end of element setup */
	}


}
