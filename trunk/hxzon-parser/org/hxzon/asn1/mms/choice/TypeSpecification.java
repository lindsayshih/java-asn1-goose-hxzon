package org.hxzon.asn1.mms.choice;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerChoice;
import org.hxzon.asn1.mms.common.Identifier;

public class TypeSpecification extends BerChoice {
//	TypeSpecification ::= CHOICE 
//	{
//	typeName		[0] ObjectName,
//	array			[1] IMPLICIT SEQUENCE
//		{
//		packed			[0] IMPLICIT BOOLEAN DEFAULT FALSE,
//		numberOfElements	[1] IMPLICIT Unsigned32,
//		elementType		[2] TypeSpecification
//		},
//	structure		[2] IMPLICIT SEQUENCE
//		{
//		packed			[0] IMPLICIT BOOLEAN DEFAULT FALSE,
//		components		[1] IMPLICIT SEQUENCE OF SEQUENCE
//			{
//			componentName		[0] IMPLICIT Identifier OPTIONAL,
//			componentType		[1] TypeSpecification
//			}
//		},
//	
//	-- Simple Type
//	boolean			[3] IMPLICIT NULL,
//	bit-string		[4] IMPLICIT Integer32,
//	integer			[5] IMPLICIT Unsigned8,
//	unsigned		[6] IMPLICIT Unsigned8,
//	octet-string		[9] IMPLICIT Integer32,
//	visible-string		[10] IMPLICIT Integer32,
//	generalized-time	[11] IMPLICIT NULL,
//	binary-time		[12] IMPLICIT BOOLEAN,
//	bcd			[13] IMPLICIT Unsigned8,
//	objId			[15] IMPLICIT NULL
//	}
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return new ObjectName().init("typeName", "typeName", tag, stream, true);
        case Tag.CONTEXT | 1:
            return new TypeSpecificationArray().init("array", "array", tag, stream);
        case Tag.CONTEXT | 2:
            return new TypeSpecificatStructure().init("structure", "structure", tag, stream);
//			-- Simple Type
//			boolean			[3] IMPLICIT NULL,
//			bit-string		[4] IMPLICIT Integer32,
//			integer			[5] IMPLICIT Unsigned8,
//			unsigned		[6] IMPLICIT Unsigned8,
//			octet-string		[9] IMPLICIT Integer32,
//			visible-string		[10] IMPLICIT Integer32,
//			generalized-time	[11] IMPLICIT NULL,
//			binary-time		[12] IMPLICIT BOOLEAN,
//			bcd			[13] IMPLICIT Unsigned8,
//			objId			[15] IMPLICIT NULL
        case Tag.CONTEXT | 3:
            return Asn1Utils.createBerNull("boolean", "boolean", tag, stream);
        case Tag.CONTEXT | 4:
            //FIXME
            return Asn1Utils.createBerInteger32("bit-string", "bit-string", tag, stream);
//			return Asn1Utils.createBerBitString("bit-string", "bit-string", tag, stream);
        case Tag.CONTEXT | 5:
            return Asn1Utils.createBerUnsigned8("integer", "integer", tag, stream);
        case Tag.CONTEXT | 6:
            return Asn1Utils.createBerUnsigned8("unsigned", "unsigned", tag, stream);
        case Tag.CONTEXT | 9:
            return Asn1Utils.createBerInteger32("octet-string", "octet-string", tag, stream);
        case Tag.CONTEXT | 10:
            return Asn1Utils.createBerInteger32("visible-string", "visible-string", tag, stream);
        case Tag.CONTEXT | 11:
            return Asn1Utils.createBerNull("generalized", "generalized", tag, stream);
        case Tag.CONTEXT | 12:
            return Asn1Utils.createBerBoolean("binary-time", "binary-time", tag, stream);
        case Tag.CONTEXT | 13:
            return Asn1Utils.createBerUnsigned8("bcd", "bcd", tag, stream);
        case Tag.CONTEXT | 15:
            return Asn1Utils.createBerNull("objId", "objId", tag, stream);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

//	array			[1] IMPLICIT SEQUENCE
//	{
//	packed			[0] IMPLICIT BOOLEAN DEFAULT FALSE,
//	numberOfElements	[1] IMPLICIT Unsigned32,
//	elementType		[2] TypeSpecification
//	},
    public static class TypeSpecificationArray extends BerSequence {
        public BerNode create(int tag, BerInputStream stream) {
            switch (tag) {
            case Tag.CONTEXT | 0:
                return Asn1Utils.createBerBoolean("packed", "packed", tag, stream);
            case Tag.CONTEXT | 1:
                return Asn1Utils.createBerUnsigned32("numberOfElements", "numberOfElements", tag, stream);
            case Tag.CONTEXT | 2:
                return new TypeSpecification().init("elementType", "elementType", tag, stream);
            default:
                return Asn1Utils.createUnknown(tag, stream);
            }
        }
    }

//	structure		[2] IMPLICIT SEQUENCE
//	{
//	packed			[0] IMPLICIT BOOLEAN DEFAULT FALSE,
//	components		[1] IMPLICIT SEQUENCE OF SEQUENCE
//		{
//		componentName		[0] IMPLICIT Identifier OPTIONAL,
//		componentType		[1] TypeSpecification
//		}
//	},
    public static class TypeSpecificatStructure extends BerSequence {
        public BerNode create(int tag, BerInputStream stream) {
            switch (tag) {
            case Tag.CONTEXT | 0:
                return Asn1Utils.createBerBoolean("packed", "packed", tag, stream);
            case Tag.CONTEXT | 1:
                return Asn1Utils.createBerSequenceOf("components", "components", tag, stream, TypeSpecificatComponent.class);
            default:
                return Asn1Utils.createUnknown(tag, stream);
            }
        }
    }

    public static class TypeSpecificatComponent extends BerSequence {
        public TypeSpecificatComponent() {
            setName("component");
            setDisplayString("component");
        }

        public BerNode create(int tag, BerInputStream stream) {
            switch (tag) {
            case Tag.CONTEXT | 0:
                return new Identifier().init("componentName", "componentName", tag, stream);
            case Tag.CONTEXT | 1:
                return new TypeSpecification().init("componentType", "componentType", tag, stream, true);
            default:
                return Asn1Utils.createUnknown(tag, stream);
            }
        }
    }

}
