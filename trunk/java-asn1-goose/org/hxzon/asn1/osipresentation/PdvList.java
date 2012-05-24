package org.hxzon.asn1.osipresentation;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;

public class PdvList extends BerSequence implements UserDataContainer {
//FullyEncodedData
    private PresentationContextIdentifier contextIdentifier;

    public PdvList() {
        setId("item");
        setName("item");
    }

//	--  contains one or more PDV-list values.
//	--  See 8.4.2.
//	PDV-list ::= SEQUENCE {
//	  transfer-syntax-name             Transfer-syntax-name OPTIONAL,
//	  presentation-context-identifier  Presentation-context-identifier,
//	  presentation-data-values
//	    CHOICE {single-ASN1-type	[0] ANY,
//	--              [0]  ABSTRACT-SYNTAX.&Type
//	--                     (CONSTRAINED BY {
//	                        
//	                        --  Type corresponding to presentation context identifier  }),
//	            octet-aligned     [1] IMPLICIT OCTET STRING,
//	            arbitrary         [2] IMPLICIT BIT STRING}
//	  --  Contains one or more presentation data values from the same
//	  --  presentation context.
//	  --  See 8.4.2.
//	}

    @Override
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.UNIVERSAL | Tag.OBJECTID:
            return new TransferSyntaxName().init(tag, stream);
        case Tag.UNIVERSAL | Tag.INTEGER:
            contextIdentifier = (PresentationContextIdentifier) new PresentationContextIdentifier().init(tag, stream);
            return contextIdentifier;
        default:
            long contextValue = contextIdentifier == null ? 0 : contextIdentifier.getValue();
            return new PresentationDataValues(contextValue).init(tag, stream, false);
        }
    }

    public BerNode[] getUserData() {
        for (BerNode child : getChildren()) {
            if (child instanceof UserDataContainer) {
                return ((UserDataContainer) child).getUserData();
            }
        }
        return new BerNode[0];
    }

}
