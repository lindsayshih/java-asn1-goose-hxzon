package org.hxzon.asn1.osipresentation;

import com.chaosinmotion.asn1.BerOctetString;

public class SimplyEncodedData extends BerOctetString {

	public SimplyEncodedData(){
		setName("simply encoded data");
		setDisplayString("simply encoded data");
	}
//	--  Subclause 8.4 defines when each of the two alternatives shall be used.
//	Simply-encoded-data ::= OCTET STRING

}
