package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.mms.common.FileName;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class FileRenameRequest extends BerSequence {
//	FileRename-Request ::= SEQUENCE {
//		currentFileName	[0] IMPLICIT FileName,
//		newFileName	[1] IMPLICIT FileName
//		}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new FileName().init("currentFileName", "currentFileName", tag, stream);
		case Tag.CONTEXT | 1:
			return new FileName().init("newFileName", "newFileName", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
