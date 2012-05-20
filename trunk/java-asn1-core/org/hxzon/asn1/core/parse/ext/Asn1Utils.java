package org.hxzon.asn1.core.parse.ext;

import java.util.Iterator;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.type.BerBMPString;
import org.hxzon.asn1.core.type.BerBitString;
import org.hxzon.asn1.core.type.BerBoolean;
import org.hxzon.asn1.core.type.BerCharacterString;
import org.hxzon.asn1.core.type.BerEmbeddedPDV;
import org.hxzon.asn1.core.type.BerEnumerated;
import org.hxzon.asn1.core.type.BerExternal;
import org.hxzon.asn1.core.type.BerGeneralString;
import org.hxzon.asn1.core.type.BerGeneralTime;
import org.hxzon.asn1.core.type.BerGraphicsString;
import org.hxzon.asn1.core.type.BerIA5String;
import org.hxzon.asn1.core.type.BerInteger;
import org.hxzon.asn1.core.type.BerNull;
import org.hxzon.asn1.core.type.BerNumericString;
import org.hxzon.asn1.core.type.BerOID;
import org.hxzon.asn1.core.type.BerObjectDescriptor;
import org.hxzon.asn1.core.type.BerOctetString;
import org.hxzon.asn1.core.type.BerPrintableString;
import org.hxzon.asn1.core.type.BerReal;
import org.hxzon.asn1.core.type.BerRelativeOID;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.BerSet;
import org.hxzon.asn1.core.type.BerTeletexString;
import org.hxzon.asn1.core.type.BerUTCTime;
import org.hxzon.asn1.core.type.BerUTF8String;
import org.hxzon.asn1.core.type.BerUniversalString;
import org.hxzon.asn1.core.type.BerVideoTextString;
import org.hxzon.asn1.core.type.BerVisibleString;
import org.hxzon.asn1.core.type.base.BerConstruct;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerChoice;
import org.hxzon.asn1.core.type.ext.BerSequenceOf;
import org.hxzon.asn1.core.type.ext.FakeBerInteger;
import org.hxzon.asn1.core.type.ext.FakeBerNode;
import org.hxzon.asn1.core.type.ext.TimeOfDay;
import org.hxzon.asn1.core.type.ext.UnknownBerNode;
import org.hxzon.asn1.core.type.ext.UtcTime;
import org.hxzon.asn1.mms.common.FloatingPoint;

public class Asn1Utils {

    public static String printBerNode(BerNode node) {
        StringBuffer buffer = new StringBuffer();

        buffer.append(node.getId()).append(":");
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
            break;
        case Tag.UNIVERSAL | Tag.BMPSTRING:
            node = new BerBMPString();
            break;
        case Tag.UNIVERSAL | Tag.BOOLEAN:
            node = new BerBoolean();
            break;
        case Tag.UNIVERSAL | Tag.CHARACTERSTRING:
            node = new BerCharacterString();
            break;
        case Tag.UNIVERSAL | Tag.EMBEDDEDPDV:
            node = new BerEmbeddedPDV();
            break;
        case Tag.UNIVERSAL | Tag.ENUMERATED:
            node = new BerEnumerated();
            break;
        case Tag.UNIVERSAL | Tag.EXTERNAL:
            node = new BerExternal();
            break;
        case Tag.UNIVERSAL | Tag.GENERALSTRING:
            node = new BerGeneralString();
            break;
        case Tag.UNIVERSAL | Tag.GENERALTIME:
            node = new BerGeneralTime();
            break;
        case Tag.UNIVERSAL | Tag.GRAPHICSTRING:
            node = new BerGraphicsString();
            break;
        case Tag.UNIVERSAL | Tag.IA5STRING:
            node = new BerIA5String();
            break;
        case Tag.UNIVERSAL | Tag.INTEGER:
            node = new BerInteger();
            break;
        case Tag.UNIVERSAL | Tag.NULL:
            node = new BerNull();
            break;
        case Tag.UNIVERSAL | Tag.NUMERICSTRING:
            node = new BerNumericString();
            break;
        case Tag.UNIVERSAL | Tag.OBJECTDESCRIPTOR:
            node = new BerObjectDescriptor();
            break;
        case Tag.UNIVERSAL | Tag.OBJECTID:
            node = new BerOID();
            break;
        case Tag.UNIVERSAL | Tag.OCTETSTRING:
            node = new BerOctetString();
            break;
        case Tag.UNIVERSAL | Tag.PRINTABLESTRING:
            node = new BerPrintableString();
            break;
        case Tag.UNIVERSAL | Tag.REAL:
            node = new BerReal();
            break;
        case Tag.UNIVERSAL | Tag.RELATIVEOID:
            node = new BerRelativeOID();
            break;
        case Tag.UNIVERSAL | Tag.SEQUENCE:
            node = new BerSequence();
            break;
        case Tag.UNIVERSAL | Tag.SET:
            node = new BerSet();
            break;
        case Tag.UNIVERSAL | Tag.TELETEXSTRING:
            node = new BerTeletexString();
            break;
        case Tag.UNIVERSAL | Tag.UNIVERSALSTRING:
            node = new BerUniversalString();
            break;
        case Tag.UNIVERSAL | Tag.UTCTIME:
            node = new BerUTCTime();
            break;
        case Tag.UNIVERSAL | Tag.UTF8STRING:
            node = new BerUTF8String();
            break;
        case Tag.UNIVERSAL | Tag.VIDEOTEXTSTRING:
            node = new BerVideoTextString();
            break;
        case Tag.UNIVERSAL | Tag.VISIBLESTRING:
            node = new BerVisibleString();
            break;
        default:
            node = new UnknownBerNode(tag);
            break;
        }
        return node.init(tag, stream).setName("unknown " + Tag.toString(tag));
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

    public static BerNode createFloatPoint(String name, String display, int tag, BerInputStream stream) {
        return new FloatingPoint().init(name, display, tag, stream);
    }

    public static BerNode createBerSequenceOf(String name, String display, int tag, BerInputStream stream, Class<? extends BerNode> clazz) {
        return new BerSequenceOf(clazz).init(name, display, tag, stream);
    }

    public static BerNode createBerSequenceOf(String name, String display, int tag, BerInputStream stream, Class<? extends BerChoice> clazz, boolean choiceChildHasTag) {
        return new BerSequenceOf(clazz, choiceChildHasTag).init(name, display, tag, stream);
    }

    public static BerNode createBerIecUtcTime(String name, String display, int tag, BerInputStream stream) {
        return new UtcTime().init(name, display, tag, stream);
    }

    public static BerNode createBerIecTimeOfDay(String name, String display, int tag, BerInputStream stream) {
        return new TimeOfDay().init(name, display, tag, stream);
    }

    public static BerNode createFakeBerInteger(String name, String display, long value, int offset, int len) {
        FakeBerNode node = new FakeBerInteger(value);
        node.setId(name);
        node.setName(display);
        node.setTagOffset(offset);
        node.setTotalLen(len);
        return node;
    }

//	private static boolean notAddChoiceNode = true;
//
//	public static void setNotAddChoiceNode(boolean b) {
//		notAddChoiceNode = b;
//	}
//
//	public static boolean isNotAddChoiceNode() {
//		return notAddChoiceNode;
//	}
}
