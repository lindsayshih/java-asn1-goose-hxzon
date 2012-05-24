package example_cdr;

/*
 * Created by JAC (Java Asn1 Compiler)
 */

import com.turkcelltech.jac.*;
import com.chaosinmotion.asn1.Tag;

public class SummaryRecord extends Sequence
{
	/**
	 * if you want to set/fill an element below, just call the setValue(..) method over its instance.
	 *
	 * To encode/decode your object, just call encode(..) decode(..) methods.
	 */
	public AddressInformation origAddress = new AddressInformation("origAddress");
	public AddressString origAddressGSM = new AddressString("origAddressGSM");
	public AddressInformation recipAddress = new AddressInformation("recipAddress");
	public AddressString recipAddressGSM = new AddressString("recipAddressGSM");
	public Status status = new Status("status");
	public RangeVSMSC vsmscid = new RangeVSMSC("vsmscid");
	public TypeVSMSC vsmsctype = new TypeVSMSC("vsmsctype");
	public AddressInformation dgtiAddress = new AddressInformation("dgtiAddress");
	public AddressString dgtiAddressGSM = new AddressString("dgtiAddressGSM");
	public C7PointCode destPointCode = new C7PointCode("destPointCode");
	public AddressInformation ogtiAddress = new AddressInformation("ogtiAddress");
	public AddressString ogtiAddressGSM = new AddressString("ogtiAddressGSM");
	public C7PointCode origPointCode = new C7PointCode("origPointCode");
	public TransparentPid transparentPid = new TransparentPid("transparentPid");
	public IMSI intlMobileSubId = new IMSI("intlMobileSubId");
	public AddressInformation callingLineId = new AddressInformation("callingLineId");
	public AddressString callingLineIdGSM = new AddressString("callingLineIdGSM");
	public IMSI origIntlMobileSubId = new IMSI("origIntlMobileSubId");
	public IA5String billid = new IA5String("billid");
	public PrepaidPrimSer ppPser = new PrepaidPrimSer("ppPser");
	public UdLength totalUdLength = new UdLength("totalUdLength");
	public Time submissionTimeFirst = new Time("submissionTimeFirst");
	public Date submissionDateFirst = new Date("submissionDateFirst");
	public Time submissionTimeLast = new Time("submissionTimeLast");
	public Date submissionDateLast = new Date("submissionDateLast");
	public Time deliveryTimeFirst = new Time("deliveryTimeFirst");
	public Date deliveryDateFirst = new Date("deliveryDateFirst");
	public Time deliveryTimeLast = new Time("deliveryTimeLast");
	public Date deliveryDateLast = new Date("deliveryDateLast");
	public CmReference cmReferenceNr = new CmReference("cmReferenceNr");
	public CmNumber segmentsTotal = new CmNumber("segmentsTotal");
	public CmNumber segmentsAccepted = new CmNumber("segmentsAccepted");
	public CmNumber segmentsDelivered = new CmNumber("segmentsDelivered");
	public CmNumber segmentsDuplicate = new CmNumber("segmentsDuplicate");
	public CmNumber segmentsReplaced = new CmNumber("segmentsReplaced");
	public EmsBitString textFormatting = new EmsBitString("textFormatting");
	public EmsBytesCompressed bytesCompressedData = new EmsBytesCompressed("bytesCompressedData");
	public EmsNumber predefinedAnimations = new EmsNumber("predefinedAnimations");
	public EmsNumber userDefinedAnimations = new EmsNumber("userDefinedAnimations");
	public EmsNumber predefinedSounds = new EmsNumber("predefinedSounds");
	public EmsNumber userDefinedSounds = new EmsNumber("userDefinedSounds");
	public EmsNumber blackWhitePictures = new EmsNumber("blackWhitePictures");
	public EmsNumber standardWvg = new EmsNumber("standardWvg");
	public EmsNumber characterSizeWvg = new EmsNumber("characterSizeWvg");
	public EmsNumber greyscalePictures = new EmsNumber("greyscalePictures");
	public EmsNumber colourPictures = new EmsNumber("colourPictures");
	public EmsNumber businessCards = new EmsNumber("businessCards");
	public EmsNumber calendarEntries = new EmsNumber("calendarEntries");
	public EmsNumber polyphonicMelodies = new EmsNumber("polyphonicMelodies");
	public EmsPortNumbers8 bit8PortNumberDest = new EmsPortNumbers8("bit8PortNumberDest");
	public EmsPortNumbers16 bit16PortNumberDest = new EmsPortNumbers16("bit16PortNumberDest");
	public BooleanServicesCM boolSer = new BooleanServicesCM("boolSer");
	public AddressInformation recipAltAddress = new AddressInformation("recipAltAddress");
	public IA5String serviceType = new IA5String("serviceType");
	public DeliveryAttempts totalAttempts = new DeliveryAttempts("totalAttempts");
	public MessageError segmError = new MessageError("segmError");
	/* end of element declarations */
	
	/**
	* asn.1 SEQUENCE constructor
	*/
	public
	SummaryRecord()
	{
		super();
		setUpElements();
	}

	/**
	* asn.1 SEQUENCE constructor with its name
	*/
	public
	SummaryRecord(String name)
	{
		super(name);
		setUpElements();
	}
	

	protected void
	setUpElements()
	{
		super.addElement(origAddress);
		origAddress.setOptional(true);
		origAddress.setTaggingMethod(Tag.IMPLICIT);
		origAddress.setTagClass(Tag.CONTEXT);
		origAddress.setTagNumber(0);
		super.addElement(origAddressGSM);
		origAddressGSM.setOptional(true);
		origAddressGSM.setTaggingMethod(Tag.IMPLICIT);
		origAddressGSM.setTagClass(Tag.CONTEXT);
		origAddressGSM.setTagNumber(1);
		super.addElement(recipAddress);
		recipAddress.setOptional(true);
		recipAddress.setTaggingMethod(Tag.IMPLICIT);
		recipAddress.setTagClass(Tag.CONTEXT);
		recipAddress.setTagNumber(2);
		super.addElement(recipAddressGSM);
		recipAddressGSM.setOptional(true);
		recipAddressGSM.setTaggingMethod(Tag.IMPLICIT);
		recipAddressGSM.setTagClass(Tag.CONTEXT);
		recipAddressGSM.setTagNumber(3);
		super.addElement(status);
		status.setOptional(true);
		status.setTaggingMethod(Tag.IMPLICIT);
		status.setTagClass(Tag.CONTEXT);
		status.setTagNumber(4);
		super.addElement(vsmscid);
		vsmscid.setOptional(true);
		vsmscid.setTaggingMethod(Tag.IMPLICIT);
		vsmscid.setTagClass(Tag.CONTEXT);
		vsmscid.setTagNumber(5);
		super.addElement(vsmsctype);
		vsmsctype.setOptional(true);
		vsmsctype.setTaggingMethod(Tag.IMPLICIT);
		vsmsctype.setTagClass(Tag.CONTEXT);
		vsmsctype.setTagNumber(6);
		super.addElement(dgtiAddress);
		dgtiAddress.setOptional(true);
		dgtiAddress.setTaggingMethod(Tag.IMPLICIT);
		dgtiAddress.setTagClass(Tag.CONTEXT);
		dgtiAddress.setTagNumber(7);
		super.addElement(dgtiAddressGSM);
		dgtiAddressGSM.setOptional(true);
		dgtiAddressGSM.setTaggingMethod(Tag.IMPLICIT);
		dgtiAddressGSM.setTagClass(Tag.CONTEXT);
		dgtiAddressGSM.setTagNumber(8);
		super.addElement(destPointCode);
		destPointCode.setOptional(true);
		destPointCode.setTaggingMethod(Tag.IMPLICIT);
		destPointCode.setTagClass(Tag.CONTEXT);
		destPointCode.setTagNumber(9);
		super.addElement(ogtiAddress);
		ogtiAddress.setOptional(true);
		ogtiAddress.setTaggingMethod(Tag.IMPLICIT);
		ogtiAddress.setTagClass(Tag.CONTEXT);
		ogtiAddress.setTagNumber(10);
		super.addElement(ogtiAddressGSM);
		ogtiAddressGSM.setOptional(true);
		ogtiAddressGSM.setTaggingMethod(Tag.IMPLICIT);
		ogtiAddressGSM.setTagClass(Tag.CONTEXT);
		ogtiAddressGSM.setTagNumber(11);
		super.addElement(origPointCode);
		origPointCode.setOptional(true);
		origPointCode.setTaggingMethod(Tag.IMPLICIT);
		origPointCode.setTagClass(Tag.CONTEXT);
		origPointCode.setTagNumber(12);
		super.addElement(transparentPid);
		transparentPid.setOptional(true);
		transparentPid.setTaggingMethod(Tag.IMPLICIT);
		transparentPid.setTagClass(Tag.CONTEXT);
		transparentPid.setTagNumber(13);
		super.addElement(intlMobileSubId);
		intlMobileSubId.setOptional(true);
		intlMobileSubId.setTaggingMethod(Tag.IMPLICIT);
		intlMobileSubId.setTagClass(Tag.CONTEXT);
		intlMobileSubId.setTagNumber(14);
		super.addElement(callingLineId);
		callingLineId.setOptional(true);
		callingLineId.setTaggingMethod(Tag.IMPLICIT);
		callingLineId.setTagClass(Tag.CONTEXT);
		callingLineId.setTagNumber(15);
		super.addElement(callingLineIdGSM);
		callingLineIdGSM.setOptional(true);
		callingLineIdGSM.setTaggingMethod(Tag.IMPLICIT);
		callingLineIdGSM.setTagClass(Tag.CONTEXT);
		callingLineIdGSM.setTagNumber(16);
		super.addElement(origIntlMobileSubId);
		origIntlMobileSubId.setOptional(true);
		origIntlMobileSubId.setTaggingMethod(Tag.IMPLICIT);
		origIntlMobileSubId.setTagClass(Tag.CONTEXT);
		origIntlMobileSubId.setTagNumber(17);
		super.addElement(billid);
		billid.setOptional(true);
		billid.setTaggingMethod(Tag.IMPLICIT);
		billid.setTagClass(Tag.CONTEXT);
		billid.setTagNumber(18);
		super.addElement(ppPser);
		ppPser.setOptional(true);
		ppPser.setTaggingMethod(Tag.IMPLICIT);
		ppPser.setTagClass(Tag.CONTEXT);
		ppPser.setTagNumber(19);
		super.addElement(totalUdLength);
		totalUdLength.setOptional(true);
		totalUdLength.setTaggingMethod(Tag.IMPLICIT);
		totalUdLength.setTagClass(Tag.CONTEXT);
		totalUdLength.setTagNumber(20);
		super.addElement(submissionTimeFirst);
		submissionTimeFirst.setOptional(true);
		submissionTimeFirst.setTaggingMethod(Tag.IMPLICIT);
		submissionTimeFirst.setTagClass(Tag.CONTEXT);
		submissionTimeFirst.setTagNumber(21);
		super.addElement(submissionDateFirst);
		submissionDateFirst.setOptional(true);
		submissionDateFirst.setTaggingMethod(Tag.IMPLICIT);
		submissionDateFirst.setTagClass(Tag.CONTEXT);
		submissionDateFirst.setTagNumber(22);
		super.addElement(submissionTimeLast);
		submissionTimeLast.setOptional(true);
		submissionTimeLast.setTaggingMethod(Tag.IMPLICIT);
		submissionTimeLast.setTagClass(Tag.CONTEXT);
		submissionTimeLast.setTagNumber(23);
		super.addElement(submissionDateLast);
		submissionDateLast.setOptional(true);
		submissionDateLast.setTaggingMethod(Tag.IMPLICIT);
		submissionDateLast.setTagClass(Tag.CONTEXT);
		submissionDateLast.setTagNumber(24);
		super.addElement(deliveryTimeFirst);
		deliveryTimeFirst.setOptional(true);
		deliveryTimeFirst.setTaggingMethod(Tag.IMPLICIT);
		deliveryTimeFirst.setTagClass(Tag.CONTEXT);
		deliveryTimeFirst.setTagNumber(25);
		super.addElement(deliveryDateFirst);
		deliveryDateFirst.setOptional(true);
		deliveryDateFirst.setTaggingMethod(Tag.IMPLICIT);
		deliveryDateFirst.setTagClass(Tag.CONTEXT);
		deliveryDateFirst.setTagNumber(26);
		super.addElement(deliveryTimeLast);
		deliveryTimeLast.setOptional(true);
		deliveryTimeLast.setTaggingMethod(Tag.IMPLICIT);
		deliveryTimeLast.setTagClass(Tag.CONTEXT);
		deliveryTimeLast.setTagNumber(27);
		super.addElement(deliveryDateLast);
		deliveryDateLast.setOptional(true);
		deliveryDateLast.setTaggingMethod(Tag.IMPLICIT);
		deliveryDateLast.setTagClass(Tag.CONTEXT);
		deliveryDateLast.setTagNumber(28);
		super.addElement(cmReferenceNr);
		cmReferenceNr.setOptional(true);
		cmReferenceNr.setTaggingMethod(Tag.IMPLICIT);
		cmReferenceNr.setTagClass(Tag.CONTEXT);
		cmReferenceNr.setTagNumber(29);
		super.addElement(segmentsTotal);
		segmentsTotal.setOptional(true);
		segmentsTotal.setTaggingMethod(Tag.IMPLICIT);
		segmentsTotal.setTagClass(Tag.CONTEXT);
		segmentsTotal.setTagNumber(30);
		super.addElement(segmentsAccepted);
		segmentsAccepted.setOptional(true);
		segmentsAccepted.setTaggingMethod(Tag.IMPLICIT);
		segmentsAccepted.setTagClass(Tag.CONTEXT);
		segmentsAccepted.setTagNumber(31);
		super.addElement(segmentsDelivered);
		segmentsDelivered.setOptional(true);
		segmentsDelivered.setTaggingMethod(Tag.IMPLICIT);
		segmentsDelivered.setTagClass(Tag.CONTEXT);
		segmentsDelivered.setTagNumber(32);
		super.addElement(segmentsDuplicate);
		segmentsDuplicate.setOptional(true);
		segmentsDuplicate.setTaggingMethod(Tag.IMPLICIT);
		segmentsDuplicate.setTagClass(Tag.CONTEXT);
		segmentsDuplicate.setTagNumber(33);
		super.addElement(segmentsReplaced);
		segmentsReplaced.setOptional(true);
		segmentsReplaced.setTaggingMethod(Tag.IMPLICIT);
		segmentsReplaced.setTagClass(Tag.CONTEXT);
		segmentsReplaced.setTagNumber(34);
		super.addElement(textFormatting);
		textFormatting.setOptional(true);
		textFormatting.setTaggingMethod(Tag.IMPLICIT);
		textFormatting.setTagClass(Tag.CONTEXT);
		textFormatting.setTagNumber(35);
		super.addElement(bytesCompressedData);
		bytesCompressedData.setOptional(true);
		bytesCompressedData.setTaggingMethod(Tag.IMPLICIT);
		bytesCompressedData.setTagClass(Tag.CONTEXT);
		bytesCompressedData.setTagNumber(36);
		super.addElement(predefinedAnimations);
		predefinedAnimations.setOptional(true);
		predefinedAnimations.setTaggingMethod(Tag.IMPLICIT);
		predefinedAnimations.setTagClass(Tag.CONTEXT);
		predefinedAnimations.setTagNumber(37);
		super.addElement(userDefinedAnimations);
		userDefinedAnimations.setOptional(true);
		userDefinedAnimations.setTaggingMethod(Tag.IMPLICIT);
		userDefinedAnimations.setTagClass(Tag.CONTEXT);
		userDefinedAnimations.setTagNumber(38);
		super.addElement(predefinedSounds);
		predefinedSounds.setOptional(true);
		predefinedSounds.setTaggingMethod(Tag.IMPLICIT);
		predefinedSounds.setTagClass(Tag.CONTEXT);
		predefinedSounds.setTagNumber(39);
		super.addElement(userDefinedSounds);
		userDefinedSounds.setOptional(true);
		userDefinedSounds.setTaggingMethod(Tag.IMPLICIT);
		userDefinedSounds.setTagClass(Tag.CONTEXT);
		userDefinedSounds.setTagNumber(40);
		super.addElement(blackWhitePictures);
		blackWhitePictures.setOptional(true);
		blackWhitePictures.setTaggingMethod(Tag.IMPLICIT);
		blackWhitePictures.setTagClass(Tag.CONTEXT);
		blackWhitePictures.setTagNumber(41);
		super.addElement(standardWvg);
		standardWvg.setOptional(true);
		standardWvg.setTaggingMethod(Tag.IMPLICIT);
		standardWvg.setTagClass(Tag.CONTEXT);
		standardWvg.setTagNumber(42);
		super.addElement(characterSizeWvg);
		characterSizeWvg.setOptional(true);
		characterSizeWvg.setTaggingMethod(Tag.IMPLICIT);
		characterSizeWvg.setTagClass(Tag.CONTEXT);
		characterSizeWvg.setTagNumber(43);
		super.addElement(greyscalePictures);
		greyscalePictures.setOptional(true);
		greyscalePictures.setTaggingMethod(Tag.IMPLICIT);
		greyscalePictures.setTagClass(Tag.CONTEXT);
		greyscalePictures.setTagNumber(44);
		super.addElement(colourPictures);
		colourPictures.setOptional(true);
		colourPictures.setTaggingMethod(Tag.IMPLICIT);
		colourPictures.setTagClass(Tag.CONTEXT);
		colourPictures.setTagNumber(45);
		super.addElement(businessCards);
		businessCards.setOptional(true);
		businessCards.setTaggingMethod(Tag.IMPLICIT);
		businessCards.setTagClass(Tag.CONTEXT);
		businessCards.setTagNumber(46);
		super.addElement(calendarEntries);
		calendarEntries.setOptional(true);
		calendarEntries.setTaggingMethod(Tag.IMPLICIT);
		calendarEntries.setTagClass(Tag.CONTEXT);
		calendarEntries.setTagNumber(47);
		super.addElement(polyphonicMelodies);
		polyphonicMelodies.setOptional(true);
		polyphonicMelodies.setTaggingMethod(Tag.IMPLICIT);
		polyphonicMelodies.setTagClass(Tag.CONTEXT);
		polyphonicMelodies.setTagNumber(48);
		super.addElement(bit8PortNumberDest);
		bit8PortNumberDest.setOptional(true);
		bit8PortNumberDest.setTaggingMethod(Tag.IMPLICIT);
		bit8PortNumberDest.setTagClass(Tag.CONTEXT);
		bit8PortNumberDest.setTagNumber(49);
		super.addElement(bit16PortNumberDest);
		bit16PortNumberDest.setOptional(true);
		bit16PortNumberDest.setTaggingMethod(Tag.IMPLICIT);
		bit16PortNumberDest.setTagClass(Tag.CONTEXT);
		bit16PortNumberDest.setTagNumber(50);
		super.addElement(boolSer);
		boolSer.setOptional(true);
		boolSer.setTaggingMethod(Tag.IMPLICIT);
		boolSer.setTagClass(Tag.CONTEXT);
		boolSer.setTagNumber(51);
		super.addElement(recipAltAddress);
		recipAltAddress.setOptional(true);
		recipAltAddress.setTaggingMethod(Tag.IMPLICIT);
		recipAltAddress.setTagClass(Tag.CONTEXT);
		recipAltAddress.setTagNumber(52);
		super.addElement(serviceType);
		serviceType.setOptional(true);
		serviceType.setTaggingMethod(Tag.IMPLICIT);
		serviceType.setTagClass(Tag.CONTEXT);
		serviceType.setTagNumber(53);
		super.addElement(totalAttempts);
		totalAttempts.setOptional(true);
		totalAttempts.setTaggingMethod(Tag.IMPLICIT);
		totalAttempts.setTagClass(Tag.CONTEXT);
		totalAttempts.setTagNumber(54);
		super.addElement(segmError);
		segmError.setOptional(true);
		segmError.setTaggingMethod(Tag.IMPLICIT);
		segmError.setTagClass(Tag.CONTEXT);
		segmError.setTagNumber(55);
	/* end of element setup */
	}


}
