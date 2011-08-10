package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.common.FileName;


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
