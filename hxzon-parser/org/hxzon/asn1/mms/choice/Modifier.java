package org.hxzon.asn1.mms.choice;

import org.hxzon.asn1.Asn1Utils;
import org.hxzon.asn1.BerChoice;
import org.hxzon.asn1.mms.sequence.AttachToEventCondition;
import org.hxzon.asn1.mms.sequence.AttachToSemaphore;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.Tag;

public class Modifier extends BerChoice {

	public Modifier() {
	}

//	Modifier ::= CHOICE
//	{
//	attach-To-Event-Condition	[0]	IMPLICIT AttachToEventCondition,
//	attach-To-Semaphore			[1]	IMPLICIT AttachToSemaphore
//	}

	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
		case Tag.CONTEXT | 0:
			return new AttachToEventCondition().init("attach-To-Event-Condition", "attach-To-Event-Condition", tag, stream);
		case Tag.CONTEXT | 1:
			return new AttachToSemaphore().init("attach-To-Semaphore", "attach-To-Semaphore", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}
}
