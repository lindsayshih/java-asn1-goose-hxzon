package org.hxzon.ui.util;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.hxzon.util.DebugUtil;

public abstract class ListSelectionAction implements ListSelectionListener {
    private int minIndex = -1;
    private int maxIndex = -1;

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            ListSelectionModel lsm = (ListSelectionModel) e.getSource();
//			int row1=e.getFirstIndex();
//			int row2=e.getLastIndex();
//			System.out.println(row1+","+row2);
            if (lsm.isSelectionEmpty()) {
                whenSelect(e.getSource(), -1);
            } else {
                // Find out which indexes are selected.
                int minIndex = lsm.getMinSelectionIndex();
                int maxIndex = lsm.getMaxSelectionIndex();
                if (minIndex == this.minIndex && maxIndex == this.maxIndex) {
                    return;
                }
                this.minIndex = minIndex;
                this.maxIndex = maxIndex;
                for (int i = minIndex; i <= maxIndex; i++) {
                    if (lsm.isSelectedIndex(i)) {
                        whenSelect(e.getSource(), i);
                        if (selectOne()) {
                            break;
                        }
                        DebugUtil.debug("select" + i);
                    }
                }
            }

        }
    }

    public abstract void whenSelect(Object source, int i);

    public abstract boolean selectOne();
}
