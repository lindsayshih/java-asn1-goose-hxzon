package org.hxzon.asn1.mms.choice;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerChoice;
import org.hxzon.asn1.mms.common.Identifier;

public class DeleteEventConditionRequest extends BerChoice {
//	DeleteEventCondition-Request ::= CHOICE
//	{
//	specific		[0] IMPLICIT SEQUENCE OF ObjectName,
//	aa-specific		[1] IMPLICIT NULL,
//	domain			[2] IMPLICIT Identifier,
//	vmd			[3] IMPLICIT NULL
//	}
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return Asn1Utils.createBerSequenceOf("specific", "specific", tag, stream, ObjectName.class);
        case Tag.CONTEXT | 1:
            return Asn1Utils.createBerNull("aa-specific", "aa-specific", tag, stream);
        case Tag.CONTEXT | 2:
            return new Identifier().init("domain", "domain", tag, stream);
        case Tag.CONTEXT | 3:
            return Asn1Utils.createBerNull("vmd", "vmd", tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

}
