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

package com.chaosinmotion.asn1;

import java.io.IOException;

import org.hxzon.asn1.core.type.ext.IBerConstruct;

/**
 * Each BER object within an ASN.1 stream descends from the BerNode. This contains
 * code for writing the contents of this node
 */
public abstract class BerNode {
	//add by hxzon
	private int typeTag;
	private int fTag;

	protected BerNode(int typeTag) {
		this.typeTag = typeTag;
	}

	public int getTag() {
		return fTag;
	}

	public void setTag(int tag) {
		fTag = tag;
	}

	public int getTypeTag() {
		return typeTag;
	}

	protected void setTypeTag(int tag) {
		fTag = tag;
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
		return Tag.toString(fTag);
	}

	//--------------------------------------------------
	//add by hxzon for offset ,len
	private int tagOffset;//tag offset
	private int totalLen;//total len
	private int lenOffset;
	private int valueOffset;
	private String displayString;
	private String name;
	private IBerConstruct parent;

	public IBerConstruct getParent() {
		return parent;
	}

	public BerNode setParent(IBerConstruct parent) {
		this.parent = parent;
		return this;
	}

	public String getName() {
		return name;
	}

	public BerNode setName(String name) {
		this.name = name;
		return this;
	}

	public String getDisplayString() {
		return displayString;
	}

	public BerNode setDisplayString(String display) {
		this.displayString = display;
		return this;
	}

	public int getTagOffset() {
		return tagOffset;
	}

	protected BerNode setTagOffset(int tagOffset) {
		this.tagOffset = tagOffset;
		return this;
	}

	public int getTotalLen() {
		return totalLen;
	}

	protected BerNode setTotalLen(int totalLen) {
		this.totalLen = totalLen;
		return this;
	}

	public int getLenOffset() {
		return lenOffset;
	}

	protected BerNode setLenOffset(int lenOffset) {
		this.lenOffset = lenOffset;
		return this;
	}

	public int getValueOffset() {
		return valueOffset;
	}

	protected BerNode setValueOffset(int valueOffset) {
		this.valueOffset = valueOffset;
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

	public BerNode init(String name, String display, int tag, BerInputStream stream) {
		this.setTag(tag);
		this.setName(name);
		this.setDisplayString(display);
		this.readValue(stream);
		return this;
	}

	public BerNode init(String name, int tag, BerInputStream stream) {
		return init(name, getDisplayString(), tag, stream);
	}

	public BerNode init(int tag, BerInputStream stream) {
		return init(getName(), tag, stream);
	}
}
