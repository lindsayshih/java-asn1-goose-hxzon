package org.hxzon.asn1.mms.sequence;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerSequenceOf;
import org.hxzon.asn1.mms.choice.AccessResult;
import org.hxzon.asn1.mms.choice.Data;
import org.hxzon.asn1.mms.choice.VariableAccessSpecification;

public class InformationReport extends BerSequence {

    public InformationReport() {
        setName("information report");
        setDisplayString("信息报告");
    }

//	InformationReport ::= SEQUENCE
//	{
//	variableAccessSpecification	VariableAccessSpecification,
//	listOfAccessResult		[0] IMPLICIT SEQUENCE OF AccessResult
//	}

    @Override
    public BerNode create(int tag, BerInputStream stream) {
        switch (tag) {
        case Tag.CONTEXT | 0:
            return Asn1Utils.createBerSequenceOf("listOfAccessResult", "访问结果集", tag, stream, AccessResult.class);
        default:
            return new VariableAccessSpecification().init(tag, stream, false);
        }
    }

    public void reInit() {
        for (BerNode node : getChildren()) {
            if ("listOfAccessResult".equals(node.getName())) {
                int index = 0;
                BerSequenceOf seqOf = (BerSequenceOf) node;
                BerNode successDataRealNode = getAccessResult_Success_RealNode(seqOf, index);
                successDataRealNode.setName("reportId");
                successDataRealNode.setDisplayString("报告标志");
                index++;
                successDataRealNode = getAccessResult_Success_RealNode(seqOf, index);
                successDataRealNode.setName("reportedOptFields");
                successDataRealNode.setDisplayString("报告所含字段");
                String bitString = successDataRealNode.getValueAsString().replace(" ", "");
                if (bitString.charAt(1) == '1') {
                    index++;
                    successDataRealNode = getAccessResult_Success_RealNode(seqOf, index);
                    successDataRealNode.setName("seqNum");
                    successDataRealNode.setDisplayString("顺序编号");
                }
                if (bitString.charAt(2) == '1') {
                    index++;
                    successDataRealNode = getAccessResult_Success_RealNode(seqOf, index);
                    successDataRealNode.setName("timeOfEntry");
                    successDataRealNode.setDisplayString("条目时间");
                }
                if (bitString.charAt(4) == '1') {
                    index++;
                    successDataRealNode = getAccessResult_Success_RealNode(seqOf, index);
                    successDataRealNode.setName("DataSet");
                    successDataRealNode.setDisplayString("数据集名称");
                }
                if (bitString.charAt(6) == '1') {
                    index++;
                    successDataRealNode = getAccessResult_Success_RealNode(seqOf, index);
                    successDataRealNode.setName("bufOverflow");
                    successDataRealNode.setDisplayString("缓冲溢出");
                }
                if (bitString.charAt(7) == '1') {
                    index++;
                    successDataRealNode = getAccessResult_Success_RealNode(seqOf, index);
                    successDataRealNode.setName("entryId");
                    successDataRealNode.setDisplayString("条目标识");
                }
                if (bitString.charAt(9) == '1') {
                    successDataRealNode = getAccessResult_Success_RealNode(seqOf, index);
                    successDataRealNode.setName("subSeqNum");
                    successDataRealNode.setDisplayString("子序号");
                    index++;
                    successDataRealNode = getAccessResult_Success_RealNode(seqOf, index);
                    successDataRealNode.setName("moreSegmentFollow");
                    successDataRealNode.setDisplayString("有后续数据段");
                }
                index++;
                successDataRealNode = getAccessResult_Success_RealNode(seqOf, index);
                successDataRealNode.setName("inclusionBitstring");
                successDataRealNode.setDisplayString("包含位串");
                if (bitString.charAt(5) == '1') {
                    index++;
                    successDataRealNode = getAccessResult_Success_RealNode(seqOf, index);
                    successDataRealNode.setName("dataReferences");
                    successDataRealNode.setDisplayString("数据集引用");
                }
                index++;
                successDataRealNode = getAccessResult_Success_RealNode(seqOf, index);
                successDataRealNode.setName("values");
                successDataRealNode.setDisplayString("值");
                if (bitString.charAt(3) == '1') {
                    index++;
                    successDataRealNode = getAccessResult_Success_RealNode(seqOf, index);
                    successDataRealNode.setName("reasonCodes");
                    successDataRealNode.setDisplayString("原因代码");
                }
            }
        }
    }

    private BerNode getAccessResult_Success_RealNode(BerSequenceOf seqOf, int i) {
        AccessResult accessResult = (AccessResult) seqOf.getChildren()[i];
        BerNode result = accessResult.getChildren()[0];
        if (result instanceof Data) {
            return ((Data) result).getChildren()[0];
        }
        return null;
    }

}
