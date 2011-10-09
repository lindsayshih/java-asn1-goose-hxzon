package org.hxzon.asn1.acse;

import org.hxzon.asn1.core.type.BerSequence;

public class EXTERNALt extends BerSequence {
//	-- Workaround for bug in asn2wrs in the .cnf file
//	-- to handle the lack of support for tagged assignments.
//	-- remove that workaround once asn2wrs learns how to handle
//	-- tagged assignments.
//	EXTERNALt  ::=  [UNIVERSAL 8] IMPLICIT SEQUENCE
//	     {
//	      direct-reference  OBJECT IDENTIFIER OPTIONAL,
//	      indirect-reference  INTEGER OPTIONAL,
//	      data-value-descriptor  ObjectDescriptor  OPTIONAL,
//	      encoding  CHOICE
//	                  {single-ASN1-type  [0] ANY,
//	                   octet-aligned     [1] IMPLICIT OCTET STRING,
//	                   arbitrary         [2] IMPLICIT BIT STRING}
//	     }

}
