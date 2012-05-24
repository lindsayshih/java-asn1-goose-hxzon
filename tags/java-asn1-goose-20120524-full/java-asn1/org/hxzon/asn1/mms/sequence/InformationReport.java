package org.hxzon.asn1.mms.sequence;

import java.util.ArrayList;
import java.util.List;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.BerSequence;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerSequenceOf;
import org.hxzon.asn1.mms.InformationReportContainer;
import org.hxzon.asn1.mms.choice.AccessResult;
import org.hxzon.asn1.mms.choice.Data;
import org.hxzon.asn1.mms.choice.VariableAccessSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InformationReport extends BerSequence implements InformationReportContainer {
    private static Logger logger = LoggerFactory.getLogger(InformationReport.class);

    private BerNode reportIdNode;
    private List<BerNode> valueNodes;

    public InformationReport() {
        setId("information report");
        setName("信息报告");
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
            return Asn1Utils.createBerSequenceOf("listOfAccessResult", "访问结果集", tag, stream, AccessResult.class, false);
        default:
            return new VariableAccessSpecification().init(tag, stream, false);
        }
    }

    public void reInit() {
        for (BerNode node : getChildren()) {
            if ("listOfAccessResult".equals(node.getId())) {
                int index = 0;
                BerSequenceOf seqOf = (BerSequenceOf) node;
                BerNode successDataRealNode = getAccessResult_Success_RealNode(seqOf, index);
                successDataRealNode.setId("reportId");
                successDataRealNode.setName("报告标志");
                reportIdNode = successDataRealNode;
                index++;
                successDataRealNode = getAccessResult_Success_RealNode(seqOf, index);
                successDataRealNode.setId("reportedOptFields");
                successDataRealNode.setName("报告所含字段");
                String bitString = successDataRealNode.getValueAsString().replace(" ", "");
                if (bitString.charAt(1) == '1') {
                    index++;
                    successDataRealNode = getAccessResult_Success_RealNode(seqOf, index);
                    successDataRealNode.setId("seqNum");
                    successDataRealNode.setName("顺序编号");
                }
                if (bitString.charAt(2) == '1') {
                    index++;
                    successDataRealNode = getAccessResult_Success_RealNode(seqOf, index);
                    successDataRealNode.setId("timeOfEntry");
                    successDataRealNode.setName("条目时间");
                }
                if (bitString.charAt(4) == '1') {
                    index++;
                    successDataRealNode = getAccessResult_Success_RealNode(seqOf, index);
                    successDataRealNode.setId("DataSet");
                    successDataRealNode.setName("数据集名称");
                }
                if (bitString.charAt(6) == '1') {
                    index++;
                    successDataRealNode = getAccessResult_Success_RealNode(seqOf, index);
                    successDataRealNode.setId("bufOverflow");
                    successDataRealNode.setName("缓冲溢出");
                }
                if (bitString.charAt(7) == '1') {
                    index++;
                    successDataRealNode = getAccessResult_Success_RealNode(seqOf, index);
                    successDataRealNode.setId("entryId");
                    successDataRealNode.setName("条目标识");
                }
                if (bitString.charAt(9) == '1') {
                    successDataRealNode = getAccessResult_Success_RealNode(seqOf, index);
                    successDataRealNode.setId("subSeqNum");
                    successDataRealNode.setName("子序号");
                    index++;
                    successDataRealNode = getAccessResult_Success_RealNode(seqOf, index);
                    successDataRealNode.setId("moreSegmentFollow");
                    successDataRealNode.setName("有后续数据段");
                }
                //
                index++;
                successDataRealNode = getAccessResult_Success_RealNode(seqOf, index);
                successDataRealNode.setId("inclusionBitstring");
                successDataRealNode.setName("包含位串");
                int datasetNum = 0;
                String inclusionBitString = successDataRealNode.getValueAsString();
                for (char c : inclusionBitString.toCharArray()) {
                    datasetNum += (c == '1' ? 1 : 0);
                }
                if (bitString.charAt(5) == '1') {
                    for (int i = 0; i < datasetNum; i++) {
                        index++;
                        if (index >= seqOf.size()) {
                            logger.error("index " + index + " out of range:" + seqOf.size());
                            break;
                        }
                        successDataRealNode = getAccessResult_Success_RealNode(seqOf, index);
                        successDataRealNode.setId("dataReferences");
                        successDataRealNode.setName("数据集引用");
                    }
                }
                //
                valueNodes = new ArrayList<BerNode>(datasetNum);
                for (int i = 0; i < datasetNum; i++) {
                    index++;
                    if (index >= seqOf.size()) {
                        logger.error("index " + index + " out of range:" + seqOf.size());
                        break;
                    }
                    successDataRealNode = getAccessResult_Success_RealNode(seqOf, index);
                    successDataRealNode.setId("values");
                    successDataRealNode.setName("值");
                    valueNodes.add(successDataRealNode);
                }
                //
                if (bitString.charAt(3) == '1') {
                    for (int i = 0; i < datasetNum; i++) {
                        index++;
                        if (index >= seqOf.size()) {
                            logger.error("index " + index + " out of range:" + seqOf.size());
                            break;
                        }
                        successDataRealNode = getAccessResult_Success_RealNode(seqOf, index);
                        successDataRealNode.setId("reasonCodes");
                        successDataRealNode.setName("原因代码");
                    }
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

    public String getInformationReportId() {
        return reportIdNode.getValueAsString();
    }

    public void updateValueNodes(String[] valueNameStrings) {
        int min = Math.min(valueNameStrings.length - 1, valueNodes.size());
        for (int i = 0; i < min; i++) {
            valueNodes.get(i).setDisplayString(valueNameStrings[i]);
        }
        reportIdNode.setDisplayString("报告标志:" + valueNameStrings[valueNameStrings.length - 1] + reportIdNode.getValueAsString());
    }

}
