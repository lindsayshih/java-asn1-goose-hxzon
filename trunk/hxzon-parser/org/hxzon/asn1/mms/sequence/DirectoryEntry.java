package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.mms.common.FileName;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class DirectoryEntry extends BerSequence {
//	DirectoryEntry ::= SEQUENCE {
//		filename		[0] IMPLICIT FileName,
//		fileAttributes		[1] IMPLICIT FileAttributes
//		}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new FileName().init("filename", "filename", tag, stream);
		case Tag.CONTEXT | 1:
			return new FileAttributes().init("fileAttributes", "fileAttributes", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
