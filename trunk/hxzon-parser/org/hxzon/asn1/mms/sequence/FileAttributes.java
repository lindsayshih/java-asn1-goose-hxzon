package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class FileAttributes extends BerSequence {
//	FileAttributes ::= SEQUENCE {
//		sizeOfFile	[0] IMPLICIT Unsigned32,
//		lastModified	[1] IMPLICIT GeneralizedTime OPTIONAL
//		}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return Asn1Utils.createBerUnsignedInteger("sizeOfFile", "sizeOfFile", tag, stream);
		case Tag.CONTEXT | 1:
			//TODO
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
