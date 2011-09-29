package org.hxzon.asn1.core.type.ext;

import java.io.IOException;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.BerOutputStream;
import org.hxzon.asn1.core.parse.BerParser;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.parse.ext.Asn1Utils;
import org.hxzon.asn1.core.type.base.BerNode;

public class BerChoice extends BerNode implements FakeBerConstruct {
    private boolean hasTag = false;
    private BerNode realNode;

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
        return this.init(getName(), getDisplayString(), tag, stream, hasTag);
    }

    public BerChoice init(String name, String displayString, int tag, BerInputStream stream, boolean hasTag) {
        this.hasTag = hasTag;//must before super.init()
        super.init(name, displayString, tag, stream);
        if (!hasTag) {
            setTag(Tag.NoTag);
        }
        return this;
    }

    public String getAsn1TypeDesc() {
        return "BerChoice";
    }

    public boolean hasTag() {
        return hasTag;
    }

    @Override
    protected void readValue(BerInputStream stream) {
        super.setTagOffset(stream.getTagOffset());
        int childTag = getTag();
        if (hasTag) {
            try {
                stream.readBerLength();//choice's length
                childTag = stream.readBerTag();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        realNode = create(childTag, stream);
        realNode.setParent(this);
        super.setTotalLen(stream.getTagOffset() - super.getTagOffset() + stream.getTotalLen());
        realNode.setName(this.getName() + "-" + realNode.getName());
    }

    public BerNode getRealNode() {
        return realNode;
    }

    public BerNode getLastRealNode() {
        //if real node is a choice,and no tag
        if (realNode instanceof BerChoice && !((BerChoice) realNode).hasTag()) {
            return ((BerChoice) realNode).getLastRealNode();
        }
        return realNode;
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
        return realNode.toString();
    }

    @Override
    public void writeElement(BerOutputStream stream) throws IOException {

    }

    public BerNode[] getChildren() {
        return new BerNode[] { realNode };
    }

    public boolean remove(BerNode o) {
        realNode = null;
        return true;
    }

    public BerChoice init(String name, String displayString, int tag, BerInputStream stream, int state, BerParser parser) {
        setTag(tag);
        setName(name);
        setDisplayString(displayString);
        readValue(stream, state, parser);
        return this;
    }

    protected void readValue(BerInputStream stream, int state, BerParser parser) {
        super.setTagOffset(stream.getTagOffset());
        realNode = parser.create(getTag(), stream, state);
        super.setTotalLen(stream.getTagOffset() - super.getTagOffset() + stream.getTotalLen());
        realNode.setName(this.getName() + "-" + realNode.getName());
    }
}
