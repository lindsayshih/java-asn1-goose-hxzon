package org.hxzon.asn1.osipresentation;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.BerChoice;
import org.hxzon.asn1.mms.MmsPdu;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class PdvList extends BerSequence implements UserDataContainer {
//FullyEncodedData
	public PdvList() {
		setName("item");
		setDisplayString("item");
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
			return new PresentationContextIdentifier().init(tag, stream);
		default:
			return new PresentationDataValues().init(tag, stream, false);
		}
	}

	public BerNode[] getUserData() {
		for (BerNode child : getChildren()) {
			if (child instanceof UserDataContainer) {
				return ((UserDataContainer) child).getUserData();
			}
		}
		return null;
	}

	public static class PresentationDataValues extends BerChoice implements UserDataContainer {

		public PresentationDataValues() {
			setName("presentation data values");
			setDisplayString("presentation data values");
		}

//		  presentation-data-values
//	    CHOICE {single-ASN1-type	[0] ANY,
//	--              [0]  ABSTRACT-SYNTAX.&Type
//	--                     (CONSTRAINED BY {
//	                        
//	                        --  Type corresponding to presentation context identifier  }),
//	            octet-aligned     [1] IMPLICIT OCTET STRING,
//	            arbitrary         [2] IMPLICIT BIT STRING}
		@Override
		public BerNode create(int tag, BerInputStream stream) {
			switch (tag) {
			case Tag.CONTEXT | 0:
//				return Asn1Utils.createBerSequenceOf("single-ASN1-type", "single-ASN1-type", tag, stream, MmsPdu.class);
				return new SingleAsn1Type(MmsPdu.class).init("single-ASN1-type", "single-ASN1-type", tag, stream);
			case Tag.CONTEXT | 1:
				return Asn1Utils.createBerOctetString("octet aligned", "octet aligned", tag, stream);
			case Tag.CONTEXT | 2:
				return Asn1Utils.createBerBitString("arbitrary", "arbitrary", tag, stream);
			default:
				return Asn1Utils.createUnknown(tag, stream);
			}
		}

		public BerNode[] getUserData() {
			BerNode child = this.getRealNode();
			if (child instanceof UserDataContainer) {
				//single asn1 type
				return ((UserDataContainer) child).getUserData();
			}
			return new BerNode[] { child };
		}

	}
}
