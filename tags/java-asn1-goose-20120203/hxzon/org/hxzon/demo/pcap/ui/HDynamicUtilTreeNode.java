package org.hxzon.demo.pcap.ui;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

public class HDynamicUtilTreeNode extends DefaultMutableTreeNode {
    protected boolean hasChildren;
    /** Value to create children with. */
    protected Object childValue;
    /** Have the children been loaded yet? */
    protected boolean loadedChildren;
    public HDynamicUtilTreeNode(Object value, Object children) {
        super(value);
        loadedChildren = false;
        childValue = children;
        if (children != null) {
            if (children instanceof Collection) {
                setAllowsChildren(true);
            } else if (children instanceof Object[]) {
                setAllowsChildren(true);
            } else if (children instanceof char[]) {
                setAllowsChildren(true);
            } else if (children instanceof byte[]) {
                setAllowsChildren(true);
            } else if (children instanceof short[]) {
                setAllowsChildren(true);
            } else if (children instanceof int[]) {
                setAllowsChildren(true);
            } else if (children instanceof long[]) {
                setAllowsChildren(true);
            } else if (children instanceof float[]) {
                setAllowsChildren(true);
            } else if (children instanceof double[]) {
                setAllowsChildren(true);
            } else if (children instanceof boolean[]) {
                setAllowsChildren(true);
            } else if (children instanceof Map) {
                setAllowsChildren(true);
            } else {
                setAllowsChildren(false);
            }
        } else {
            setAllowsChildren(false);
        }
    }
    public static void createChildren(DefaultMutableTreeNode parent, Object children) {
        if (children instanceof Collection) {
            for (Object o : (Collection) children)
                parent.add(new HDynamicUtilTreeNode(o, o));
        } else if (children instanceof Object[]) {
            for (Object o : (Object[]) children)
                parent.add(new HDynamicUtilTreeNode(o, o));
        } else if (children instanceof char[]) {
            for (Object o : (char[]) children)
                parent.add(new HDynamicUtilTreeNode(o, o));
        } else if (children instanceof byte[]) {
            for (Object o : (byte[]) children)
                parent.add(new HDynamicUtilTreeNode(o, o));
        } else if (children instanceof short[]) {
            for (Object o : (short[]) children)
                parent.add(new HDynamicUtilTreeNode(o, o));
        } else if (children instanceof int[]) {
            for (Object o : (int[]) children)
                parent.add(new HDynamicUtilTreeNode(o, o));
        } else if (children instanceof long[]) {
            for (Object o : (long[]) children)
                parent.add(new HDynamicUtilTreeNode(o, o));
        } else if (children instanceof float[]) {
            for (Object o : (float[]) children)
                parent.add(new HDynamicUtilTreeNode(o, o));
        } else if (children instanceof double[]) {
            for (Object o : (double[]) children)
                parent.add(new HDynamicUtilTreeNode(o, o));
        } else if (children instanceof boolean[]) {
            for (Object o : (boolean[]) children)
                parent.add(new HDynamicUtilTreeNode(o, o));
        } else if (children instanceof Map) {
            Set<Map.Entry> set = (Set<Map.Entry>) (((Map) children).entrySet());
            for (Map.Entry o : set) {
                parent.add(new HDynamicUtilTreeNode(o.getKey(), o.getValue()));
            }
        }
    }
    protected void loadChildren() {
        loadedChildren = true;
        createChildren(this, childValue);
    }
    public boolean isLeaf() {
        return !getAllowsChildren();
    }
    public int getChildCount() {
        if (!loadedChildren)
            loadChildren();
        return super.getChildCount();
    }
    public TreeNode getChildAt(int index) {
        if (!loadedChildren)
            loadChildren();
        return super.getChildAt(index);
    }
    public Enumeration children() {
        if (!loadedChildren)
            loadChildren();
        return super.children();
    }
}
