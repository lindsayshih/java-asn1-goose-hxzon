package org.hxzon.asn1.core.type.ext;

import java.io.IOException;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.BerOutputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.base.BerNode;

public class BerChoice extends BerNode implements FakeBerConstruct {
    private boolean _hasTag = false;
    private BerNode _realNode;

    public BerChoice() {
        super(Tag.NoTag);
    }

    public BerChoice init(int tag, BerInputStream stream) {
//		return init(tag, stream, false);
        throw new UnsupportedOperationException("please use init(int tag, BerInputStream stream, boolean hasTag)");
    }

    public BerChoice init(String name, String displayString, int tag, BerInputStream stream) {
//		return init(name, displayString, tag, stream, false);
        throw new UnsupportedOperationException("please use init(String name, String displayString, int tag, BerInputStream stream, boolean hasTag)");
    }

    public BerChoice init(int tag, BerInputStream stream, boolean hasTag) {
        return this.init(getId(), getName(), tag, stream, hasTag);
    }

    public BerChoice init(String name, String displayString, int tag, BerInputStream stream, boolean hasTag) {
        this._hasTag = hasTag;//must before super.init()
        super.init(name, displayString, tag, stream);
        if (!hasTag) {
            setTag(Tag.NoTag);
        }
        this.reInit();
        return this;
    }

    public String getAsn1TypeDesc() {
        return "BerChoice";
    }

    public boolean hasTag() {
        return _hasTag;
    }

    @Override
    protected void readValue(BerInputStream stream) {
        super.setTagOffset(stream.getTagOffset());
        int childTag = getTag();
        if (_hasTag) {
            try {
                stream.readBerLength();//choice's length
                childTag = stream.readBerTag();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        _realNode = create(childTag, stream);
        _realNode.setParent(this);
        super.setTotalLen(stream.getTagOffset() - super.getTagOffset() + stream.getTotalLen());
        _realNode.setId(this.getId() + "-" + _realNode.getId());
    }

    public BerNode getRealNode() {
        return _realNode;
    }

    public BerNode getLastRealNode() {
        //if real node is a choice,and no tag
        if (_realNode instanceof BerChoice && !((BerChoice) _realNode).hasTag()) {
            return ((BerChoice) _realNode).getLastRealNode();
        }
        return _realNode;
    }

    public String getValueAsString() {
        return "";
    }

//	
//	public String getName(){
//		return super.getName()+":"+fValue.getName();
//	}

    public BerNode create(int tag, BerInputStream stream) {
        return Asn1Utils.createUnknown(tag, stream);
    }

    @Override
    public String toString() {
        return _realNode.toString();
    }

    @Override
    public void writeElement(BerOutputStream stream) throws IOException {

    }

    public BerNode[] getChildren() {
        return new BerNode[] { _realNode };
    }

    public boolean remove(BerNode o) {
        _realNode = null;
        return true;
    }

}
