package org.hxzon.asn1.mms.choice;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerChoice;


public class CSRequestDetail extends BerChoice {

	public CSRequestDetail() {
		setName("cs-request-detail");
		setDisplayString("cs-request-detail");
	}

//	CS-Request-Detail ::= CHOICE {
//		-- see ISO 9506-2
//		-- XXX can not handle empty choice
//		-- XXX fix me later
//				foo INTEGER
//			}
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}
}
