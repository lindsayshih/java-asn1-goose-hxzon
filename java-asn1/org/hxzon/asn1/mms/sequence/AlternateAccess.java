package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.mms.choice.ObjectName;
import org.hxzon.asn1.mms.choice.VariableSpecification;
import org.hxzon.asn1.mms.common.DataAccessError;

public class AlternateAccess extends BerSequence {
    public AlternateAccess() {
        setName("alternate access");
    }

//	AlternateAccess ::= SEQUENCE OF CHOICE
//	{
//	unnamed	AlternateAccessSelection,
//	named		[5] IMPLICIT SEQUENCE 
//		{
//		componentName	[0] IMPLICIT Identifier,
//		accesst		AlternateAccessSelection
//		}
//	}

//	AlternateAccessSelection ::= CHOICE 
//    {
//    selectAlternateAccess    [0] IMPLICIT SEQUENCE 
//       {
//       accessSelection CHOICE 
//          {
//          component    [0] IMPLICIT Identifier,
//          index        [1] IMPLICIT Unsigned32,
//          indexRange   [2] IMPLICIT SEQUENCE 
//             {
//             lowIndex            [0] IMPLICIT Unsigned32,
//             numberOfElements    [1] IMPLICIT Unsigned32},
//             allElements         [3] IMPLICIT NULL
//             },
//          alternateAccess  AlternateAccess
//          },
//    selectAccess CHOICE 
//       {
//       component    [1] IMPLICIT Identifier,
//       index        [2] IMPLICIT Unsigned32,
//       indexRange   [3] IMPLICIT SEQUENCE 
//          {
//          lowIndex          [0] IMPLICIT Unsigned32,
//          nmberOfElements  [1] IMPLICIT Unsigned32
//          },
//       allElements  [4] IMPLICIT NULL
//       }
//   }

//	Identifier ::= VisibleString
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return new DataAccessError().init(tag, stream);
        case Tag.CONTEXT | 1:
            return new ObjectName().init(tag, stream, true);//, true
        default:
            return new VariableSpecification().init(tag, stream);//, false
        }
    }
}
