package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.common.FileName;


public class ObtainFileRequest extends BerSequence {
//	ObtainFile-Request ::= SEQUENCE {
//		sourceFileServer	[0] IMPLICIT ApplicationReference OPTIONAL,
//		sourceFile		[1] IMPLICIT FileName,
//		destinationFile		[2] IMPLICIT FileName
//		}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new ApplicationReference().init("sourceFileServer", "sourceFileServer", tag, stream);
		case Tag.CONTEXT | 1:
			return new FileName().init("sourceFile", "sourceFile", tag, stream);
		case Tag.CONTEXT | 2:
			return new FileName().init("destinationFile", "destinationFile", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
