package org.hxzon.asn1.goose;

import java.util.List;

import org.hxzon.asn1.core.type.base.BerNode;
import org.hxzon.asn1.core.type.ext.BerSequenceOf;

public class GooseDataset extends BerSequenceOf {

	public GooseDataset() {
		super(GooseData.class, false);
	}
	
	public void updateDatasetDisplay(List<String> displays) {
        BerNode[] children = getChildren();
        int minIndex = Math.min(displays.size(), children.length);
        for (int i = 0; i < minIndex; i++) {
            ((GooseData)children[i]).updateDisplay(displays.get(i));
        }
    }

}
