package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.mms.common.FileName;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class FileOpenRequest extends BerSequence {
//	FileOpen-Request ::= SEQUENCE {
//		fileName	[0] IMPLICIT FileName,
//		initialPosition	[1] IMPLICIT Unsigned32
//		}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new FileName().init("fileName", "fileName", tag, stream);
		case Tag.CONTEXT | 1:
			return Asn1Utils.createBerUnsignedInteger("initialPosition", "initialPosition", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
