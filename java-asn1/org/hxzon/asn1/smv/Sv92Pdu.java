package org.hxzon.asn1.smv;

import java.util.List;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerSequenceOf;
import org.hxzon.netprotocol.common.IPacket;
import org.hxzon.netprotocol.common.IPacketPayload;
import org.hxzon.util.BytesUtil;

public class Sv92Pdu extends BerSequence implements IPacketPayload {
    public Sv92Pdu() {
        setName("smv9-2Pdu");
        setDisplayString("9-2采样值");
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
        case Tag.CONTEXT | 0:
            return Asn1Utils.createBerUnsigned16("number of asdu", "asdu条目数", tag, stream);
        case Tag.CONTEXT | 2:
            return Asn1Utils.createBerSequenceOf("seq of asdu", "asdu集", tag, stream, Sv92Asdu.class);
        default:
            return Asn1Utils.createUnknown(tag, stream);
        }
    }

    public void updateSv92AsduDataDisplay(List<String> displays) {
        for (BerNode child : getChildren()) {
            if (child.getTag() == (Tag.CONTEXT | 2)) {
                BerSequenceOf seqOf = (BerSequenceOf) child;
                for (BerNode sv92Asdu : seqOf.getChildren()) {
                    ((Sv92Asdu) sv92Asdu).updateAsduDataDisplay(displays);
                }
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
        return this.getTotalLen();
    }

    @Override
    public int getOffset() {
        return this.getTagOffset();
    }

    @Override
    public byte[] getSrcData() {
        return this.srcPacket.getSrcData();
    }

    public void setSrcData(byte[] srcData) {

    }

    @Override
    public IPacket getSrcPacket() {
        return srcPacket;
    }

    @Override
    public void setSrcPacket(IPacket srcPacket) {
        this.srcPacket = srcPacket;
    }

    public void initBySrcPacket(IPacket srcPacket) {
        this.setSrcPacket(srcPacket);
    }

    public String getProtocolTypeDesc() {
        return "9-2采样值";
    }

}
