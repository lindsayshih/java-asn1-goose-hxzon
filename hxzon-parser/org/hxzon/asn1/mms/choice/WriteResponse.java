package org.hxzon.asn1.mms.choice;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.BerChoice;
import org.hxzon.asn1.mms.common.DataAccessError;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.Tag;

public class WriteResponse extends BerChoice {
//	Write-Response ::= SEQUENCE OF CHOICE
//	{
//	failure		[0] IMPLICIT DataAccessError,
//	success		[1] IMPLICIT NULL
//	}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new DataAccessError().init("failure", "failure", tag, stream);
		case Tag.CONTEXT | 1:
			return Asn1Utils.createBerNull("success", "success", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
