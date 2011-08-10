package org.hxzon.asn1.osipresentation;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.BerChoice;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.Tag;

public class UserData extends BerChoice {
	public UserData() {
		setName("user data");
		setDisplayString("user data");
	}
//	User-data ::= CHOICE {
//		  simply-encoded-data  [APPLICATION 0] IMPLICIT Simply-encoded-data,
//		  fully-encoded-data   [APPLICATION 1] IMPLICIT Fully-encoded-data,
//		  ...
//		}
	
//	--  See 8.4.1.
//	--Fully-encoded-data ::= SEQUENCE SIZE (1, ..., 2..MAX) OF PDV-list
//	Fully-encoded-data ::= SEQUENCE OF PDV-list


	@Override
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.APPLICATION | 0:
			return new SimplyEncodedData().init(tag, stream);
		case Tag.UNIVERSAL | Tag.SEQUENCE://only one
			return new PdvList().init(tag, stream);
		case Tag.APPLICATION | 1:
			return Asn1Utils.createBerSequenceOf("fully encoded data", "fully encoded data", tag, stream, PdvList.class);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
