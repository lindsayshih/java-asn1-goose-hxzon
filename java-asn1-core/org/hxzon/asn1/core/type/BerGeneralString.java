/*  BerBoolean.java
 *
 *  Created on Jun 2, 2006 by William Edward Woody
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

package org.hxzon.asn1.core.type;

import java.io.IOException;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.BerOutputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.util.BytesUtil;

/**
 * Represents a generic UTF8 encoded string
 */
public class BerGeneralString extends BerNode {
    private String _fValue;

//    /**
//     * Construct a boolean from the input stream
//     * @param tag
//     * @param stream
//     * @throws IOException
//     */
//    public BerGeneralString(int tag, BerInputStream stream) throws IOException
//    {
//        super(tag);
//        
//        fValue = new String(stream.readOctetString(0 == (tag & Tag.CONSTRUCTED)),"UTF-8");
//    }
    public BerGeneralString() {
        super(Tag.GENERALSTRING);
    }

    /**
     * Write this BER element to the output stream
     * Comment
     * @param stream
     * @throws IOException
     * @see org.hxzon.asn1.core.type.base.BerNode#writeElement(org.hxzon.asn1.core.parse.BerOutputStream)
     */
    public void writeElement(BerOutputStream stream) throws IOException {
        byte[] b = _fValue.getBytes("UTF-8");
        stream.writeBerTag(getTag() | (stream.isComplexOctetString(b.length) ? Tag.CONSTRUCTED : 0));
        stream.writeOctetString(b, 0, b.length);
    }

    /**
     * Return the value of this boolean object
     * @return
     */
    public String getValue() {
        return _fValue;
    }

    public String getAsn1TypeDesc() {
        return "BerGeneralString";
    }

    //add by hxzon
    protected void readValue(BerInputStream stream) {
        try {
            _fValue = BytesUtil.toUTF8String(stream.readOctetString(0 == (getTag() & Tag.CONSTRUCTED)));
            super.setOffsetAndLen(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //add by hxzon
    public String getValueAsString() {
        return getValue();
    }
}
