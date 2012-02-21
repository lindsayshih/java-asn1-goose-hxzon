package org.hxzon.asn1.mms.choice;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerChoice;
import org.hxzon.asn1.mms.InformationReportContainer;
import org.hxzon.asn1.mms.sequence.EventNotification;
import org.hxzon.asn1.mms.sequence.InformationReport;
import org.hxzon.asn1.mms.sequence.UnsolicitedStatus;

public class UnconfirmedService extends BerChoice implements InformationReportContainer {

    public UnconfirmedService() {
        setId("unconfirmedService");
        setName("unconfirmedService");
    }

//	UnconfirmedService ::= CHOICE 
//	{
//	informationReport		[0]	IMPLICIT InformationReport,
//	unsolicitedStatus		[1]	IMPLICIT UnsolicitedStatus,
//	eventNotification 		[2]	IMPLICIT EventNotification
//-- XXX this one is neither in this ASN nor in the IMPORTS
//--	additionalService		[3]	AdditionalUnconfirmedService
//	}
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return new InformationReport().init(tag, stream);
        case Tag.CONTEXT | 1:
            return new UnsolicitedStatus().init(tag, stream);
        case Tag.CONTEXT | 2:
            return new EventNotification().init(tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

    public String getInformationReportId() {
        for (BerNode child : getChildren()) {
            if (child instanceof InformationReportContainer) {
                return ((InformationReportContainer) child).getInformationReportId();
            }
        }
        return null;
    }

    public void updateValueNodes(String[] valueNameStrings) {
        for (BerNode child : getChildren()) {
            if (child instanceof InformationReportContainer) {
                ((InformationReportContainer) child).updateValueNodes(valueNameStrings);
            }
        }
    }
}
