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

/**
 * Each BER object within an ASN.1 stream descends from the BerNode. This contains
 * code for writing the contents of this node
 * 
 * <p><p>This class is created by William Woody and modified and optimized by Fatih Batuk for using it by the Arc project
 */
public abstract class BerNode {
	/*
	 * This is the main Tag Number of the asn.1 object
	 */
	private int fTag;

	/**
	 * added by Fatih Batuk
	 * To check the initialized status of the asn.1 object..
	 * <p>If not initialized, do not write it to byte array when encoding the object
	 * @author Fatih Batuk
	 */
	public boolean isInitialized = true; // default true

	/**
	 * added by Fatih Batuk
	 * To check the optional status of the asn.1 object..
	 * <p>If an object is not optional and not initialized, then exception shoul have thrown.
	 * (But not supported yet.) 
	 * @author Fatih Batuk
	 */
	public boolean isOptional = false; // default false

	/**
	 * These 3 variable is necessary to define tagging method, tagging class and tagging number
	 * <p> of the asn.1 object (surely if they are defined in the asn.1 protocol)
	 * @author Fatih Batuk
	 */
	private int taggingMethod = Tag.IMPLICIT; //IMPICIT or EXPLICIT : default is IMPLICIT
	private int tagClass = Tag.UNIVERSAL; // default is UNIVERSAL   

	/**
	 * name of the object
	 * @author Fatih Batuk
	 */
	private String name;

	protected BerNode(int tag) {
		fTag = tag;
	}

	/**
	 * added by Fatih Batuk
	 * @param value
	 */
	public void setInitializedStatus(boolean value) {
		isInitialized = value;
	}

	/**
	 *<p><p>To make the object initialized..
	 *
	 *@author Fatih Batuk
	 */
	public void true_() {
		isInitialized = true;
	}

	/**
	 * To make the object uninitialized.. So it will not be printed to byte array during encoding.
	 * 
	 *@author Fatih Batuk
	 */
	public void false_() {
		isInitialized = false;
	}

	/**
	 * Get the tag representing this object
	 * @return
	 */
	public int getTag() {
		return fTag;
	}

	/**
	 * Change the tag of this object to the specified value
	 * @param tag
	 */
	public BerNode setTag(int tag) {
		fTag = tag;
		return this;
	}

	/**
	 * @return name of the object
	 * @author Fatih Batuk
	 */
	public String getName() {
		return name;
	}

	/**
	* @author Fatih Batuk
	*/
	public BerNode setName(String name_) {
		name = name_;
		return this;
	}

	/**
	 * Handle writing the contents of this node to the output stream provided
	 * @param stream
	 * @throws IOException 
	 */
	public abstract void writeElement(BerOutputStream stream) throws IOException;

	public abstract void readElement(BerInputStream in) throws IOException;

	/**
	 * String representation
	 */
	public String getType() {
		return "BerNode";
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getType()).append(",").append(Tag.toString(getTag())).append(getValueAsString()).append(",").append("offset=").append(getTagOffset()).append(",len=").append(getTotalLen());
		return sb.toString();
	}

	/**
	 * setting Tagging class : APPLICATION, CONTEXT or PRIVATE
	 * @param tagClass int
	 * @author Fatih Batuk
	 */
	public BerNode setTagClass(int tagClass) //APPLICATION, CONTEXT or  PRIVATE
	{
		this.tagClass = tagClass;
		return this;
	}

	/**
	 * sets tagging method to IMPLICIT or EXPLICIT
	 * @param method int
	 * @author Fatih Batuk
	 */
	public BerNode setTaggingMethod(int method) {
		this.taggingMethod = method;
		return this;
	}

	/**
	 * returns tagging method : IMPLICIT or EXPLICIT
	 * @return
	 * @author Fatih Batuk
	 */
	public int getTaggingMethod() {
		return taggingMethod;
	}

	/**
	 * returns tagging class : UNIVERSAL, APPLICATION, CONTEXT or  PRIVATE
	 * @return
	 * @author Fatih Batuk
	 */
	public int getTagClass() {
		return tagClass;
	}

	/**
	 *setting the Tag Number 
	 *<p> This tag number will be put in "OR" operation by "tagClass" to set the exact "Tag" Value
	 * @param tagNumber int
	 * @author Fatih Batuk
	 */
	public BerNode setTagNumber(int tagNumber_) {
		setTag(tagClass | tagNumber_);
		return this;
	}

	/**
	 * To set the asn.1 object status : OPTIONAL or not..
	 * @param flag boolean
	 * @author Fatih Batuk
	 */
	public BerNode setOptional(boolean flag) {
		isOptional = flag;
		return this;
	}

	//--------------------------------------------------
	//add by hxzon for offset ,len
	private int tagOffset;//tag offset
	private int totalLen;//total len
	private int lenOffset;
	private int valueOffset;
	private String displayString;

	public String getDisplayString() {
		return displayString;
	}

	public BerNode setDisplayString(String displayString) {
		this.displayString = displayString;
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

	public BerNode init(String name, String displayString, int tag, BerInputStream stream) {
		this.setTag(tag);
		this.setName(name);
		this.setDisplayString(displayString);
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
