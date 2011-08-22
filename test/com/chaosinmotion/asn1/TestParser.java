/*  TestParser.java
 *
 *  Created on Jun 5, 2006 by William Edward Woody
 */

package com.chaosinmotion.asn1;

import java.io.IOException;

public class TestParser extends BerParser
{
    private static final int ExampleProtocolMessage = BerParser.START;
    private static final int RlcGeneralBroadcastInformation = 1;
    private static final int RlcFrequencyList = 2;
    private static final int PairOfCarrierFrequencies = 3;
    
    public BerNode create(int tag, int state, BerInputStream stream) throws IOException
    {
        switch (state) {
            case ExampleProtocolMessage:
                // Application 0 == RlcGeneralBroadcastInformation
                // Application 1 == RlcFrequencyList
                if (tag == (Tag.APPLICATION | 0)) {
                    return new BerSequence(tag,RlcGeneralBroadcastInformation,this,stream);
                } else if (tag == (Tag.APPLICATION | 1)) {
                    return new BerSequence(tag,RlcFrequencyList,this,stream);
                } else {
                    throw new AsnEncodingException("Unknown tag: " + tag);
                }
                
            case RlcGeneralBroadcastInformation:
            case RlcFrequencyList:
            case PairOfCarrierFrequencies:
                // All contents are primitive. If they weren't, we'd use the state
                // information to sort out what the tag actually is.
                throw new AsnEncodingException("Unknown tag: " + tag);
                
            default:
                throw new AsnEncodingException("Unknown state: " + state);
        }
    }
}


