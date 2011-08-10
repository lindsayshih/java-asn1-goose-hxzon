package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.mms.common.FileName;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

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
