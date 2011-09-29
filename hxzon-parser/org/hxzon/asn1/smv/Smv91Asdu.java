package org.hxzon.asn1.smv;

import java.util.ArrayList;
import java.util.List;

import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.FakeBerConstruct;
import org.hxzon.asn1.core.type.ext.FakeBerNode;
import org.hxzon.util.BytesUtil;

public class Smv91Asdu extends FakeBerNode implements FakeBerConstruct {
    private List<BerNode> fList;
    private int datasetLen;//	数据集长度44,2
    private int lnName;//	LNName  逻辑节点名    ,1
    private int datasetName;//DataSetName 数据集名,1
    //
    private int ldName;//LDName 逻辑设备名,2
    private int v1;//额定相电流200
    private int v2;//额定中性点电流0
    private int v3;//额定相电压1100
    private int tdr;//Tdr（额定延时时间）
    private int channel1;//通道1的采样值
    private int channel2;//通道2的采样值
    private int channel3;//通道3的采样值
    private int channel4;//通道4的采样值
    private int channel5;//通道5的采样值
    private int channel6;//通道6的采样值
    private int channel7;//通道7的采样值
    private int channel8;//通道8的采样值
    private int channel9;//通道9的采样值
    private int channel10;//通道10的采样值
    private int channel11;//通道11的采样值
    private int channel12;//通道12的采样值
    private int state1;//状态字1
    private int state2;//状态字2
    private int smvCount;//采样计数器
    //
    private int smvRate;//采样率,1
    private int version;//配置版本号,1

    public Smv91Asdu(Smv91Pdu pdu, int offset) {
        setName("asdu");
        setDisplayString("asdu");
        this.setTagOffset(pdu.getValueOffset() + offset);
        this.setTotalLen(46);
        this.setValueOffset(pdu.getValueOffset());
        init(pdu, offset);
    }

    private void init(Smv91Pdu pdu, int offset) {
        byte[] data = pdu.getValue();
        fList = new ArrayList<BerNode>(25);
        BerNode node;
        offset += 0;
        int len = 2;
        datasetLen = (int) BytesUtil.toSigned(data, offset, len);
        node = Asn1Utils.createFakeBerInteger("datasetLen", "数据集长度", datasetLen, this.getValueOffset() + offset, len);
        fList.add(node);
        offset += len;
        len = 1;
        lnName = (int) BytesUtil.toSigned(data, offset, len);
        node = Asn1Utils.createFakeBerInteger("lnName", "逻辑节点名", lnName, this.getValueOffset() + offset, len);
        fList.add(node);
        offset += 1;
        len = 1;
        datasetName = (int) BytesUtil.toSigned(data, offset, len);
        node = Asn1Utils.createFakeBerInteger("datasetName", "数据集名", datasetName, this.getValueOffset() + offset, len);
        fList.add(node);
        offset += 1;
        //
        len = 2;
        ldName = (int) BytesUtil.toSigned(data, offset, len);
        node = Asn1Utils.createFakeBerInteger("ldName", "逻辑设备名", ldName, this.getValueOffset() + offset, len);
        fList.add(node);
        offset += len;
        v1 = (int) BytesUtil.toSigned(data, offset, len);
        node = Asn1Utils.createFakeBerInteger("v1", "额定相电流", v1, this.getValueOffset() + offset, len);
        fList.add(node);
        offset += len;
        v2 = (int) BytesUtil.toSigned(data, offset, len);
        node = Asn1Utils.createFakeBerInteger("v2", "额定中性点电流", v2, this.getValueOffset() + offset, len);
        fList.add(node);
        offset += len;
        v3 = (int) BytesUtil.toSigned(data, offset, len);
        node = Asn1Utils.createFakeBerInteger("v3", "额定相电压", v3, this.getValueOffset() + offset, len);
        fList.add(node);
        offset += len;
        tdr = (int) BytesUtil.toSigned(data, offset, len);
        node = Asn1Utils.createFakeBerInteger("tdr", "额定延时时间", tdr, this.getValueOffset() + offset, len);
        fList.add(node);
        offset += len;
        channel1 = (int) BytesUtil.toSigned(data, offset, len);
        node = Asn1Utils.createFakeBerInteger("channel1", "通道1的采样值", channel1, this.getValueOffset() + offset, len);
        fList.add(node);
        offset += len;
        channel2 = (int) BytesUtil.toSigned(data, offset, len);
        node = Asn1Utils.createFakeBerInteger("channel2", "通道2的采样值", channel2, this.getValueOffset() + offset, len);
        fList.add(node);
        offset += len;
        channel3 = (int) BytesUtil.toSigned(data, offset, len);
        node = Asn1Utils.createFakeBerInteger("channel3", "通道3的采样值", channel3, this.getValueOffset() + offset, len);
        fList.add(node);
        offset += len;
        channel4 = (int) BytesUtil.toSigned(data, offset, len);
        node = Asn1Utils.createFakeBerInteger("channel4", "通道4的采样值", channel4, this.getValueOffset() + offset, len);
        fList.add(node);
        offset += len;
        channel5 = (int) BytesUtil.toSigned(data, offset, len);
        node = Asn1Utils.createFakeBerInteger("channel5", "通道5的采样值", channel5, this.getValueOffset() + offset, len);
        fList.add(node);
        offset += len;
        channel6 = (int) BytesUtil.toSigned(data, offset, len);
        node = Asn1Utils.createFakeBerInteger("channel6", "通道6的采样值", channel6, this.getValueOffset() + offset, len);
        fList.add(node);
        offset += len;
        channel7 = (int) BytesUtil.toSigned(data, offset, len);
        node = Asn1Utils.createFakeBerInteger("channel7", "通道7的采样值", channel7, this.getValueOffset() + offset, len);
        fList.add(node);
        offset += len;
        channel8 = (int) BytesUtil.toSigned(data, offset, len);
        node = Asn1Utils.createFakeBerInteger("channel8", "通道8的采样值", channel8, this.getValueOffset() + offset, len);
        fList.add(node);
        offset += len;
        channel9 = (int) BytesUtil.toSigned(data, offset, len);
        node = Asn1Utils.createFakeBerInteger("channel9", "通道9的采样值", channel9, this.getValueOffset() + offset, len);
        fList.add(node);
        offset += len;
        channel10 = (int) BytesUtil.toSigned(data, offset, len);
        node = Asn1Utils.createFakeBerInteger("channel10", "通道10的采样值", channel10, this.getValueOffset() + offset, len);
        fList.add(node);
        offset += len;
        channel11 = (int) BytesUtil.toSigned(data, offset, len);
        node = Asn1Utils.createFakeBerInteger("channel11", "通道11的采样值", channel11, this.getValueOffset() + offset, len);
        fList.add(node);
        offset += len;
        channel12 = (int) BytesUtil.toSigned(data, offset, len);
        node = Asn1Utils.createFakeBerInteger("channel12", "通道12的采样值", channel12, this.getValueOffset() + offset, len);
        fList.add(node);
        offset += len;
        state1 = (int) BytesUtil.toSigned(data, offset, len);
        node = Asn1Utils.createFakeBerInteger("state1", "状态1", state1, this.getValueOffset() + offset, len);
        fList.add(node);
        offset += len;
        state2 = (int) BytesUtil.toSigned(data, offset, len);
        node = Asn1Utils.createFakeBerInteger("state2", "状态2", state2, this.getValueOffset() + offset, len);
        fList.add(node);
        offset += len;
        smvCount = (int) BytesUtil.toSigned(data, offset, len);
        node = Asn1Utils.createFakeBerInteger("smvCount", "采样计数", smvCount, this.getValueOffset() + offset, len);
        fList.add(node);
        offset += len;
        //
        len = 1;
        smvRate = (int) BytesUtil.toSigned(data, offset, len);
        node = Asn1Utils.createFakeBerInteger("smvRate", "采样率", smvRate, this.getValueOffset() + offset, len);
        fList.add(node);
        offset += len;
        version = (int) BytesUtil.toSigned(data, offset, len);
        node = Asn1Utils.createFakeBerInteger("version", "配置版本", version, this.getValueOffset() + offset, len);
        fList.add(node);
    }

    @Override
    public BerNode[] getChildren() {
        return fList.toArray(new BerNode[fList.size()]);
    }

    public boolean remove(BerNode o) {
        return fList.remove(o);
    }

    @Override
    public String getValueAsString() {
        return "";
    }
}
