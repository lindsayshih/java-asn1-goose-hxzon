package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.common.FileName;
import org.hxzon.asn1.mms.common.Identifier;


public class RequestDomainUploadRequest extends BerSequence {
//	RequestDomainUpload-Request ::= SEQUENCE
//	{
//	domainName	[0] IMPLICIT Identifier,
//	fileName	[1] IMPLICIT FileName
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new Identifier().init("domainName", "domainName", tag, stream);
		case Tag.CONTEXT | 1:
			return new FileName().init("fileName", "fileName", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
