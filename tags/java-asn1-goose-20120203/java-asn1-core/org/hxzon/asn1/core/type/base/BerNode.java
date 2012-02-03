/*  BerNode.java
 *
 *  Created on Jun 1, 2006 by William Edward Woody
 */

/*
 * Copyright 2007 William Woody, All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, 
 * are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice, this list 
 * of conditions and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright notice, this 
 * list of conditions and the following disclaimer in the documentation and/or other 
 * materials provided with the distribution.
 * 
 * 3. Neither the name of Chaos In Motion nor the names of its contributors may be used 
 * to endorse or promote products derived from this software without specific prior 
 * written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY 
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES 
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT 
 * SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, 
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED 
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR 
 * BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN 
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN 
 * ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH 
 * DAMAGE.
 * 
 * Contact William Woody at woody@alumni.caltech.edu or at woody@chaosinmotion.com. 
 * Chaos In Motion is at http://www.chaosinmotion.com
 */

package org.hxzon.asn1.core.type.base;

import java.io.IOException;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.BerOutputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.type.ext.IBerConstruct;

/**
 * Each BER object within an ASN.1 stream descends from the BerNode. This contains
 * code for writing the contents of this node
 */
public abstract class BerNode {
    //add by hxzon
    private int _typeTag;
    private int _fTag;

    protected BerNode(int typeTag) {
        this._typeTag = typeTag;
    }

    public int getTag() {
        return _fTag;
    }

    public void setTag(int tag) {
        _fTag = tag;
    }

    public int getTypeTag() {
        return _typeTag;
    }

    protected void setTypeTag(int tag) {
        _fTag = tag;
    }

    /**
     * Handle writing the contents of this node to the output stream provided
     * @param stream
     * @throws IOException 
     */
    public abstract void writeElement(BerOutputStream stream) throws IOException;

    /**
     * String representation
     */
    //change by getType()
//    public abstract String toString();
    public abstract String getAsn1TypeDesc();

    public String getTagDisplay() {
        return Tag.toString(_fTag);
    }

    //--------------------------------------------------
    //add by hxzon for offset ,len
    private int _tagOffset;//tag offset
    private int _totalLen;//total len
    private int _lenOffset;
    private int _valueOffset;
    private String _displayString;
    private String _name;
    private IBerConstruct _parent;

    public IBerConstruct getParent() {
        return _parent;
    }

    public BerNode setParent(IBerConstruct parent) {
        this._parent = parent;
        return this;
    }

    public String getName() {
        return _name;
    }

    public BerNode setName(String name) {
        this._name = name;
        return this;
    }

    public String getDisplayString() {
        return _displayString;
    }

    public BerNode setDisplayString(String display) {
        this._displayString = display;
        return this;
    }

    public int getTagOffset() {
        return _tagOffset;
    }

    protected BerNode setTagOffset(int tagOffset) {
        this._tagOffset = tagOffset;
        return this;
    }

    public int getTotalLen() {
        return _totalLen;
    }

    protected BerNode setTotalLen(int totalLen) {
        this._totalLen = totalLen;
        return this;
    }

    public int getLenOffset() {
        return _lenOffset;
    }

    protected BerNode setLenOffset(int lenOffset) {
        this._lenOffset = lenOffset;
        return this;
    }

    public int getValueOffset() {
        return _valueOffset;
    }

    protected BerNode setValueOffset(int valueOffset) {
        this._valueOffset = valueOffset;
        return this;
    }

    public abstract String getValueAsString();

    protected BerNode setOffsetAndLen(BerInputStream stream) {
        setTotalLen(stream.getTotalLen());
        setTagOffset(stream.getTagOffset());
        setLenOffset(stream.getLenOffset());
        setValueOffset(stream.getValueOffset());
//		setTotalLen(stream.getValueLen()+stream.getValueOffset()-stream.getTagOffset());
        return this;
    }

    //add by hxzon
    protected abstract void readValue(BerInputStream stream);

    public void reInit() {

    }

    public BerNode init(String name, String display, int tag, BerInputStream stream) {
        this.setTag(tag);
        this.setName(name);
        this.setDisplayString(display);
        this.readValue(stream);
        this.reInit();
        return this;
    }

    public BerNode init(String name, int tag, BerInputStream stream) {
        return init(name, getDisplayString(), tag, stream);
    }

    public BerNode init(int tag, BerInputStream stream) {
        return init(getName(), tag, stream);
    }
}
