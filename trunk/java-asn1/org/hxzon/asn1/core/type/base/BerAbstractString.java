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

package org.hxzon.asn1.core.type.base;

import java.io.IOException;

import org.hxzon.asn1.core.parse.BerInputStream;
import org.hxzon.asn1.core.parse.BerOutputStream;
import org.hxzon.asn1.core.parse.Tag;
import org.hxzon.util.BytesUtil;

/**
 * Represents an abstract string. This is the base of the limited syntax strings
 * that are part of the BER encoding standard. Because strings are limited in
 * syntax--they basically use 7-bit character encoding--it is safe to use the
 * Java String syntax to represent the strings.
 */
public abstract class BerAbstractString extends BerNode {
    private String fValue;

    protected static final int ASCII = 0x0001; // A-Z a-z
    protected static final int NUMBER = 0x0002; // 0-9
    protected static final int HEXASCII = 0x0004; // A-F a-f
    protected static final int MINUS = 0x0008; // -
    protected static final int PUNCT = 0x0010; // ' ( ) + , - . / : ? sp

    public BerAbstractString(int typeTag) {
        super(typeTag);
    }

    /**
     * Write this BER element to the output stream
     * Comment
     * @param stream
     * @throws IOException
     * @see org.hxzon.asn1.core.type.base.BerNode#writeElement(org.hxzon.asn1.core.parse.BerOutputStream)
     */
    public void writeElement(BerOutputStream stream) throws IOException {
        byte[] b = fValue.getBytes("UTF-8");
        stream.writeBerTag(getTag() | (stream.isComplexOctetString(b.length) ? Tag.CONSTRUCTED : 0));
        stream.writeOctetString(b, 0, b.length);
    }

    /**
     * Return the value of this boolean object
     * @return
     */
    public String getValue() {
        return fValue;
    }

    public void setValue(String fValue) {
        this.fValue = fValue;
    }

    private static boolean isValidChar(char c, int charSet) {
        if (0 != (charSet & ASCII)) {
            if ((c >= 'A') && (c <= 'Z'))
                return true;
            if ((c >= 'a') && (c <= 'z'))
                return true;
        }
        if (0 != (charSet & NUMBER)) {
            if ((c >= '0') && (c <= '9'))
                return true;
        }
        if (0 != (charSet & HEXASCII)) {
            if ((c >= 'A') && (c <= 'F'))
                return true;
            if ((c >= 'a') && (c <= 'f'))
                return true;
        }
        if (0 != (charSet & MINUS)) {
            if (c == '-')
                return true;
        }
        if (0 != (charSet & PUNCT)) {
            if ("'()+,./:? ".indexOf(c) != -1)
                return true;
        }
        return false;
    }

    /**
     * Validate the string against the character sets specified.
     * @param str
     * @param charSet Character set constants defined above
     * @return
     */
    protected static boolean validateString(String str, int charSet) {
        int len = str.length();
        int i;

        for (i = 0; i < len; ++i) {
            if (!isValidChar(str.charAt(i), charSet))
                return false;
        }
        return true;
    }

    //add by hxzon
    protected void readValue(BerInputStream stream) {
        try {
            fValue = BytesUtil.toUTF8String(stream.readOctetString(0 == (getTag() & Tag.CONSTRUCTED)));
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
