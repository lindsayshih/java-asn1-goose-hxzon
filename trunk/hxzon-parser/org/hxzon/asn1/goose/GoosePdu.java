package org.hxzon.asn1.goose;

import java.util.List;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.netprotocol.common.IPacket;
import org.hxzon.netprotocol.common.IPacketPayload;
import org.hxzon.util.BytesUtil;

public class GoosePdu extends BerSequence implements IPacketPayload {

	public GoosePdu() {
		setName("goosePdu");
		setDisplayString("goose pdu");
	}

	//  IECGoosePdu ::= SEQUENCE {
	//  gocbRef     [0] IMPLICIT VisibleString,
	//  timeAllowedtoLive [1] IMPLICIT INTEGER,
	//  datSet     [2] IMPLICIT VisibleString,
	//  goID     [3] IMPLICIT VisibleString OPTIONAL,
	//  t      [4] IMPLICIT UtcTime,
	//  stNum     [5] IMPLICIT INTEGER,
	//  sqNum     [6] IMPLICIT INTEGER,
	//  test     [7] IMPLICIT BOOLEAN DEFAULT FALSE,
	//  confRev     [8] IMPLICIT INTEGER,
	//  ndsCom     [9] IMPLICIT BOOLEAN DEFAULT FALSE,
	//  numDatSetEntries [10] IMPLICIT INTEGER,
	//  allData     [11] IMPLICIT SEQUENCE OF Data --,
	//  -- security    [12] ANY OPTIONAL
//	          -- reserved for digital signature
	//  }
	//  UtcTime ::= OCTET STRING -- format and size defined in 8.1.3.6.

	public BerNode create(int tag, BerInputStream stream) {
		switch (tag) {
//		case Tag.APPLICATION | 1:
//			return new GoosePdu().init("goose pdu","Goose Pdu",tag,  stream);
		case Tag.CONTEXT | 0:
			return Asn1Utils.createBerVisibleString("gocbRef", "控制块引用", tag, stream);
		case Tag.CONTEXT | 1:
			return Asn1Utils.createBerIntegerX("timeAllowedtoLive", "生存时间", tag, stream);
		case Tag.CONTEXT | 2:
			return Asn1Utils.createBerVisibleString("datSet", "数据集引用", tag, stream);
		case Tag.CONTEXT | 3:
			return Asn1Utils.createBerVisibleString("goID", "Goose应用标识", tag, stream);
		case Tag.CONTEXT | 4:
			return Asn1Utils.createBerIecUtcTime("t", "事件时间", tag, stream);
		case Tag.CONTEXT | 5:
			return Asn1Utils.createBerIntegerX("stNum", "状态计数", tag, stream);
		case Tag.CONTEXT | 6:
			return Asn1Utils.createBerIntegerX("qtNum", "序列计数", tag, stream);
		case Tag.CONTEXT | 7:
			return Asn1Utils.createBerBoolean("test", "测试", tag, stream);
		case Tag.CONTEXT | 8:
			return Asn1Utils.createBerIntegerX("confRev", "版本", tag, stream);
		case Tag.CONTEXT | 9:
			return Asn1Utils.createBerBoolean("ndsCom", "ndsCom", tag, stream);
		case Tag.CONTEXT | 10:
			return Asn1Utils.createBerIntegerX("numDatSetEntries", "数据集条目数", tag, stream);
		case Tag.CONTEXT | 11:
			return new GooseDataset().init("dataset", "数据集", tag, stream);
		default:
			return Asn1Utils.createUnknown(tag, stream);

		}
	}

	public void updateGooseDatasetDisplay(List<String> displays) {
		for (BerNode child : getChildren()) {
			if (child instanceof GooseDataset) {
				((GooseDataset) child).updateDatasetDisplay(displays);
				break;
			}
		}
	}

	private IPacket srcPacket;

	@Override
	public byte[] getData() {
		return BytesUtil.copyBytes(getSrcData(), getOffset(), getLength());
	}

	@Override
	public int getLength() {
		return super.getTotalLen();
	}

	@Override
	public int getOffset() {
		return super.getTagOffset();
	}

	@Override
	public byte[] getSrcData() {
		return srcPacket.getSrcData();
	}

	@Override
	public IPacket getSrcPacket() {
		return srcPacket;
	}

	@Override
	public void setSrcPacket(IPacket srcPacket) {
		this.srcPacket = srcPacket;
	}

	public String getProtocolTypeDesc() {
		return getSrcPacket().getProtocolTypeDesc();
	}

}
