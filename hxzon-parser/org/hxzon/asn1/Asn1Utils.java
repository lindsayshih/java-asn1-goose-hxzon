package org.hxzon.asn1;

import java.util.Iterator;

import org.hxzon.asn1.goose.GooseUtcTime;

import com.chaosinmotion.asn1.BerBMPString;
import com.chaosinmotion.asn1.BerBitString;
import com.chaosinmotion.asn1.BerBoolean;
import com.chaosinmotion.asn1.BerCharacterString;
import com.chaosinmotion.asn1.BerConstruct;
import com.chaosinmotion.asn1.BerEmbeddedPDV;
import com.chaosinmotion.asn1.BerEnumerated;
import com.chaosinmotion.asn1.BerExternal;
import com.chaosinmotion.asn1.BerGeneralString;
import com.chaosinmotion.asn1.BerGeneralTime;
import com.chaosinmotion.asn1.BerGraphicsString;
import com.chaosinmotion.asn1.BerIA5String;
import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerInteger;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerNull;
import com.chaosinmotion.asn1.BerNumericString;
import com.chaosinmotion.asn1.BerOID;
import com.chaosinmotion.asn1.BerObjectDescriptor;
import com.chaosinmotion.asn1.BerOctetString;
import com.chaosinmotion.asn1.BerPrintableString;
import com.chaosinmotion.asn1.BerReal;
import com.chaosinmotion.asn1.BerRelativeOID;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.BerSet;
import com.chaosinmotion.asn1.BerTeletexString;
import com.chaosinmotion.asn1.BerUTCTime;
import com.chaosinmotion.asn1.BerUTF8String;
import com.chaosinmotion.asn1.BerUniversalString;
import com.chaosinmotion.asn1.BerVideoTextString;
import com.chaosinmotion.asn1.BerVisibleString;
import com.chaosinmotion.asn1.Tag;

public class Asn1Utils {

	public static String printBerNode(BerNode node) {
		StringBuffer buffer = new StringBuffer();

		buffer.append(node.getName()).append(":");
		if (node instanceof BerConstruct) {
			buffer.append(Tag.toString(node.getTag())).append("{");
			Iterator<BerNode> it = (Iterator<BerNode>) ((BerConstruct) node).iterator();
			while (it.hasNext()) {
				buffer.append('\n');
				buffer.append(printBerNode(it.next()));
				if (it.hasNext()) {
					buffer.append(';');
				}
			}
			buffer.append("}");
		} else {
			buffer.append(node.toString());
		}
		return buffer.toString();
	}

	public static BerNode createUnknown(int tag, BerInputStream stream) {
		BerNode node = null;
		switch (tag) {
		case Tag.UNIVERSAL | Tag.BITSTRING:
			node = new BerBitString();
		case Tag.UNIVERSAL | Tag.BMPSTRING:
			node = new BerBMPString();
		case Tag.UNIVERSAL | Tag.BOOLEAN:
			node = new BerBoolean();
		case Tag.UNIVERSAL | Tag.CHARACTERSTRING:
			node = new BerCharacterString();
		case Tag.UNIVERSAL | Tag.EMBEDDEDPDV:
			node = new BerEmbeddedPDV();
		case Tag.UNIVERSAL | Tag.ENUMERATED:
			node = new BerEnumerated();
		case Tag.UNIVERSAL | Tag.EXTERNAL:
			node = new BerExternal();
		case Tag.UNIVERSAL | Tag.GENERALSTRING:
			node = new BerGeneralString();
		case Tag.UNIVERSAL | Tag.GENERALTIME:
			node = new BerGeneralTime();
		case Tag.UNIVERSAL | Tag.GRAPHICSTRING:
			node = new BerGraphicsString();
		case Tag.UNIVERSAL | Tag.IA5STRING:
			node = new BerIA5String();
		case Tag.UNIVERSAL | Tag.INTEGER:
			node = new BerInteger();
		case Tag.UNIVERSAL | Tag.NULL:
			node = new BerNull();
		case Tag.UNIVERSAL | Tag.NUMERICSTRING:
			node = new BerNumericString();
		case Tag.UNIVERSAL | Tag.OBJECTDESCRIPTOR:
			node = new BerObjectDescriptor();
		case Tag.UNIVERSAL | Tag.OBJECTID:
			node = new BerOID();
		case Tag.UNIVERSAL | Tag.OCTETSTRING:
			node = new BerOctetString();
		case Tag.UNIVERSAL | Tag.PRINTABLESTRING:
			node = new BerPrintableString();
		case Tag.UNIVERSAL | Tag.REAL:
			node = new BerReal();
		case Tag.UNIVERSAL | Tag.RELATIVEOID:
			node = new BerRelativeOID();
		case Tag.UNIVERSAL | Tag.SEQUENCE:
			node = new BerSequence();
		case Tag.UNIVERSAL | Tag.SET:
			node = new BerSet();
		case Tag.UNIVERSAL | Tag.TELETEXSTRING:
			node = new BerTeletexString();
		case Tag.UNIVERSAL | Tag.UNIVERSALSTRING:
			node = new BerUniversalString();
		case Tag.UNIVERSAL | Tag.UTCTIME:
			node = new BerUTCTime();
		case Tag.UNIVERSAL | Tag.UTF8STRING:
			node = new BerUTF8String();
		case Tag.UNIVERSAL | Tag.VIDEOTEXTSTRING:
			node = new BerVideoTextString();
		case Tag.UNIVERSAL | Tag.VISIBLESTRING:
			node = new BerVisibleString();
		default:
			node = new UnknownBerNode(tag);
		}
		return node.init(tag, stream).setDisplayString("unknown " + Tag.toString(tag));
	}

	public static BerNode createBerOID(String name, String display, int tag, BerInputStream stream) {
		return new BerOID().init(name, display, tag, stream);
	}

//	public static BerNode createBerUnsigned(String name, String display, int tag, BerInputStream stream) {
//		return new BerInteger().init(name, display, tag, stream);
//	}

	public static BerNode createBerUnsignedX(String name, String display, int tag, BerInputStream stream) {
		return new BerInteger().limitBitLength(64, true).init(name, display, tag, stream);
	}

	public static BerNode createBerUnsigned8(String name, String display, int tag, BerInputStream stream) {
		return new BerInteger().limitBitLength(8, true).init(name, display, tag, stream);
	}

	public static BerNode createBerUnsigned16(String name, String display, int tag, BerInputStream stream) {
		return new BerInteger().limitBitLength(16, true).init(name, display, tag, stream);
	}

	public static BerNode createBerUnsigned32(String name, String display, int tag, BerInputStream stream) {
		return new BerInteger().limitBitLength(32, true).init(name, display, tag, stream);
	}

//	public static BerNode createBerInteger(String name, String display, int tag, BerInputStream stream) {
//		return new BerInteger().init(name, display, tag, stream);
//	}

//	public static BerNode createBerInteger(String name, String display, int tag, BerInputStream stream, int bitLen) {
//		return new BerInteger().limitBitLength(bitLen).init(name, display, tag, stream);
//	}

	public static BerNode createBerIntegerX(String name, String display, int tag, BerInputStream stream) {
		return new BerInteger().limitBitLength(64).init(name, display, tag, stream);
	}

	public static BerNode createBerInteger8(String name, String display, int tag, BerInputStream stream) {
		return new BerInteger().limitBitLength(8).init(name, display, tag, stream);
	}

	public static BerNode createBerInteger16(String name, String display, int tag, BerInputStream stream) {
		return new BerInteger().limitBitLength(16).init(name, display, tag, stream);
	}

	public static BerNode createBerInteger32(String name, String display, int tag, BerInputStream stream) {
		return new BerInteger().limitBitLength(32).init(name, display, tag, stream);
	}

	public static BerNode createBerNull(String name, String display, int tag, BerInputStream stream) {
		return new BerNull().init(name, display, tag, stream);
	}

	public static BerNode createBerBoolean(String name, String display, int tag, BerInputStream stream) {
		return new BerBoolean().init(name, display, tag, stream);
	}

	public static BerNode createBerVisibleString(String name, String display, int tag, BerInputStream stream) {
		return new BerVisibleString().init(name, display, tag, stream);
	}
	
	public static BerNode createBerUtf8String(String name, String display, int tag, BerInputStream stream) {
		return new BerUTF8String().init(name, display, tag, stream);
	}

	public static BerNode createBerOctetString(String name, String display, int tag, BerInputStream stream) {
		return new BerOctetString().init(name, display, tag, stream);
	}

	public static BerNode createBerBitString(String name, String display, int tag, BerInputStream stream) {
		return new BerBitString().init(name, display, tag, stream);
	}

	public static BerNode createBerReal(String name, String display, int tag, BerInputStream stream) {
		return new BerReal().init(name, display, tag, stream);
	}

	public static BerNode createBerSequenceOf(String name, String display, int tag, BerInputStream stream, Class<? extends BerNode> clazz) {
		return new BerSequenceOf(clazz).init(name, display, tag, stream);
	}

	public static BerNode createBerSequenceOf(String name, String display, int tag, BerInputStream stream, Class<? extends BerNode> clazz, boolean choiceChildHasTag) {
		return new BerSequenceOf(clazz, choiceChildHasTag).init(name, display, tag, stream);
	}

	public static BerNode createBerIecUtcTime(String name, String display, int tag, BerInputStream stream) {
		return new GooseUtcTime().init(name, display, tag, stream);
	}

	public static BerNode createFakeBerInteger(String name, String display, long value, int offset, int len) {
		FakeBerNode node = new FakeBerInteger(value);
		node.setName(name);
		node.setDisplayString(display);
		node.setTagOffset(offset);
		node.setTotalLen(len);
		return node;
	}

	private static boolean notAddChoiceNode = true;

	public static void setNotAddChoiceNode(boolean b) {
		notAddChoiceNode = b;
	}

	public static boolean isNotAddChoiceNode() {
		return notAddChoiceNode;
	}
}
