package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class FileOpenResponse extends BerSequence {
//	FileOpen-Response ::= SEQUENCE {
//		frsmID		[0] IMPLICIT Integer32,
//		fileAttributes	[1] IMPLICIT FileAttributes
//		}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return Asn1Utils.createBerInteger32("frsmID", "frsmID", tag, stream);
		case Tag.CONTEXT | 1:
			return new FileAttributes().init("fileAttributes", "fileAttributes", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
