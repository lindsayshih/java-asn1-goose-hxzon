package org.hxzon.asn1.osipresentation;

import org.hxzon.asn1.core.type.BerInteger;

public class PresentationContextIdentifier extends BerInteger {

    public PresentationContextIdentifier() {
        setId("presentation context identifier");
        setName("presentation context identifier");
    }
//	--Presentation-context-identifier ::= INTEGER(1..127, ..., 128..MAX)
//	Presentation-context-identifier ::= INTEGER

}
