package org.hxzon.asn1.goose;

import org.hxzon.asn1.Asn1Utils;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class GooseDataset extends BerSequence {
	public GooseDataset() {
	}

//  TimeOfDay ::= OCTET STRING -- (SIZE (4 | 6))
//  FloatingPoint ::= OCTET STRING
//  Data ::= CHOICE {
//  -- context tag 0 is reserved for AccessResult
//  array    [1] IMPLICIT SEQUENCE OF Data,
//  structure   [2] IMPLICIT SEQUENCE OF Data,
//  boolean    [3] IMPLICIT BOOLEAN,
//  bit-string   [4] IMPLICIT BIT STRING,
//  integer    [5] IMPLICIT INTEGER,
//  unsigned   [6] IMPLICIT INTEGER,
//  floating-point [7] IMPLICIT FloatingPoint,
//  real   [8] IMPLICIT REAL,
//  octet-string [9] IMPLICIT OCTET STRING,
//  visible-string [10] IMPLICIT VisibleString,
//  binary-time   [12] IMPLICIT TimeOfDay,
//  bcd     [13] IMPLICIT INTEGER,
//  booleanArray [14] IMPLICIT BIT STRING
//  }

	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 1:
			return Asn1Utils.createBerSequenceOf("array", "array", tag, stream, GooseDataset.class);
		case Tag.CONTEXT | 2:
			return Asn1Utils.createBerSequenceOf("structure", "structure", tag, stream, GooseDataset.class);
		case Tag.CONTEXT | 3:
			return Asn1Utils.createBerBoolean("boolean", "boolean", tag, stream);
		case Tag.CONTEXT | 4:
			return Asn1Utils.createBerOctetString("bit-string", "bit-string", tag, stream);
		case Tag.CONTEXT | 5:
			return Asn1Utils.createBerIntegerX("integer", "integer", tag, stream);
		case Tag.CONTEXT | 6:
			return Asn1Utils.createBerUnsignedX("unsigned", "unsigned", tag, stream);//unsigned
		case Tag.CONTEXT | 7:
			return Asn1Utils.createBerOctetString("floating-point", "floating-point", tag, stream);
		case Tag.CONTEXT | 8:
			return Asn1Utils.createBerReal("real", "real", tag, stream);
		case Tag.CONTEXT | 9:
			return Asn1Utils.createBerOctetString("octet-string", "octet-string", tag, stream);
		case Tag.CONTEXT | 10:
			return Asn1Utils.createBerVisibleString("visible-string", "visible-string", tag, stream);
		case Tag.CONTEXT | 12:
			return Asn1Utils.createBerIecUtcTime("binary-time", "binary-time", tag, stream);
		case Tag.CONTEXT | 13:
			return Asn1Utils.createBerIntegerX("bcd", "bcd", tag, stream);
		case Tag.CONTEXT | 14:
			return Asn1Utils.createBerBitString("booleanArray", "booleanArray", tag, stream);
		case Tag.CONTEXT | 17:
			return Asn1Utils.createBerIecUtcTime("utc-time", "utc-time", tag, stream);
		case Tag.CONTEXT | 18:
			return Asn1Utils.createBerUtf8String("utf8-string", "utf8-string", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

}
