package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.common.ParameterSupportOptions;
import org.hxzon.asn1.mms.common.ServiceSupportOptions;

public class InitRequestDetail extends BerSequence {
//	InitRequestDetail ::= SEQUENCE
//	{
//	proposedVersionNumber			[0] IMPLICIT Integer16,
//	proposedParameterCBB			[1] IMPLICIT ParameterSupportOptions,
//	servicesSupportedCalling		[2] IMPLICIT ServiceSupportOptions
//	}
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return Asn1Utils.createBerInteger16("proposedVersionNumber", "proposedVersionNumber", tag, stream);
        case Tag.CONTEXT | 1:
            return new ParameterSupportOptions().init("proposedParameterCBB", "proposedParameterCBB", tag, stream);
        case Tag.CONTEXT | 2:
            return new ServiceSupportOptions().init("servicesSupportedCalling", "servicesSupportedCalling", tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

}
