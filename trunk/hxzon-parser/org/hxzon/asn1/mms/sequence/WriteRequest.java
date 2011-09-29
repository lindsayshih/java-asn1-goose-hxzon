package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.choice.Data;
import org.hxzon.asn1.mms.choice.VariableAccessSpecification;

public class WriteRequest extends BerSequence {
//	Write-Request ::= SEQUENCE
//	{
//	variableAccessSpecificatn 	VariableAccessSpecification,
//	listOfData			[0] IMPLICIT SEQUENCE OF Data
//	}

    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return Asn1Utils.createBerSequenceOf("listOfData", "listOfData", tag, stream, Data.class);
        default:
            return new VariableAccessSpecification().init(tag, stream, false);
        }
    }

}
