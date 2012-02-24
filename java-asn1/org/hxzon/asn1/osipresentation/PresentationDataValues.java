package org.hxzon.asn1.osipresentation;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerChoice;
import org.hxzon.asn1.core.type.ext.UnknownBerNode;
import org.hxzon.asn1.mms.MmsPdu;

public class PresentationDataValues extends BerChoice implements UserDataContainer {

    private long _contextValue = 0;

    public PresentationDataValues(long contextValue) {
        setId("presentation data values");
        setName("presentation data values");
        _contextValue = contextValue;
    }

//    presentation-data-values
//  CHOICE {single-ASN1-type    [0] ANY,
//--              [0]  ABSTRACT-SYNTAX.&Type
//--                     (CONSTRAINED BY {
//                      
//                      --  Type corresponding to presentation context identifier  }),
//          octet-aligned     [1] IMPLICIT OCTET STRING,
//          arbitrary         [2] IMPLICIT BIT STRING}
    @Override
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            if (_contextValue == 3) {
                return new SingleAsn1Type(MmsPdu.class).init("single-ASN1-type", "single-ASN1-type", tag, stream);
            } else {
                return new SingleAsn1Type(UnknownBerNode.class).init("single-ASN1-type", "single-ASN1-type", tag, stream);
            }
        case Tag.CONTEXT | 1:
            return Asn1Utils.createBerOctetString("octet aligned", "octet aligned", tag, stream);
        case Tag.CONTEXT | 2:
            return Asn1Utils.createBerBitString("arbitrary", "arbitrary", tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

    public BerNode[] getUserData() {
        BerNode child = this.getRealNode();
        if (child instanceof UserDataContainer) {
            //single asn1 type
            return ((UserDataContainer) child).getUserData();
        }
        //octet-aligned,arbitrary,unknown
        return new BerNode[] { child };
    }

}
