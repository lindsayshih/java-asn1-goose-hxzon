package org.hxzon.asn1.smv;

import java.util.List;

import org.hxzon.asn1.Asn1Utils;

import com.chaosinmotion.asn1.BerInputStream;
import com.chaosinmotion.asn1.BerInteger;
import com.chaosinmotion.asn1.BerNode;
import com.chaosinmotion.asn1.BerSequence;
import com.chaosinmotion.asn1.Tag;

public class Smv92Asdu extends BerSequence {
//	private static final Logger logger=LoggerFactory.getLogger(Smv92Asdu.class);
	public Smv92Asdu() {
		setName("asdu");
		setDisplayString("asdu");
	}

//      -- $Id: sv.asn 33058 2010-06-02 19:01:16Z jake $
//      IEC61850 DEFINITIONS ::= BEGIN
	//
//      SampledValues ::= CHOICE {
//          savPdu  [APPLICATION 0] IMPLICIT SavPdu,
//          ...
//      }
	//
//      SavPdu ::= SEQUENCE {
//          noASDU  [0] IMPLICIT INTEGER(0..65535),
//          seqASDU [2] IMPLICIT SEQUENCE OF ASDU
//      }
	//
//      ASDU ::= SEQUENCE {
//          svID        [0] IMPLICIT VisibleString,
//          smpCnt      [2] IMPLICIT INTEGER(0..65535),
//          confRef     [3] IMPLICIT INTEGER(0..4294967295),
//          smpSynch    [5] IMPLICIT INTEGER{none(0),local(1),global(2)},
//          seqData     [7] IMPLICIT Data,
//          ...
//      }
	//
//      Data ::= OCTET STRING
	//
//      END
	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
//		case Tag.UNIVERSAL | 16:
//			return new Smv92Asdu().init(tag, stream);
		case Tag.CONTEXT | 0:
			return Asn1Utils.createBerVisibleString("svID", "采样值ID", tag, stream);
		case Tag.CONTEXT | 2:
			return Asn1Utils.createBerInteger16("sample count", "采样计数", tag, stream);
		case Tag.CONTEXT | 3:
			return Asn1Utils.createBerInteger32("confRef", "配置版本", tag, stream);
		case Tag.CONTEXT | 5:
			return new SmvSynchInteger().init("sample synch", "采样同步", tag, stream);
		case Tag.CONTEXT | 7:
			return new Smv92AsduData().init("seqData", "asdu数据集", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);
		}
	}

	public void updateAsduDataDisplay(List<String> displays) {
		for (BerNode child : getChildren()) {
			if (child instanceof Smv92AsduData) {
				((Smv92AsduData) child).updateDataDisplay(displays);
				break;//only one
			}
		}
	}

	public static class SmvSynchInteger extends BerInteger {
		public String getValueAsString() {
			switch ((int) getValue()) {
			case 0:
				return "none(0)";
			case 1:
				return "local(1)";
			case 2:
				return "global(2)";
			default:
				return "";
			}
		}
	}

}
