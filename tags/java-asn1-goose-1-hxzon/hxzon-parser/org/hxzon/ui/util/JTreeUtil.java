package org.hxzon.ui.util;

import java.util.Enumeration;

import javax.swing.JTree;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class JTreeUtil {
	public static void expandAll(JTree tree, boolean expand) {
		if (treeIsNotNull(tree)) {
			TreeNode root = (TreeNode) tree.getModel().getRoot();
			expandAll(tree, new TreePath(root), expand);
		}
	}

	private static boolean treeIsNotNull(JTree tree) {
		return tree != null;
	}

	private static void expandAll(JTree tree, TreePath parent, boolean expand) {
		TreeNode node = (TreeNode) parent.getLastPathComponent();
		if (node.getChildCount() >= 0) {
			for (Enumeration e = node.children(); e.hasMoreElements();) {
				TreeNode n = (TreeNode) e.nextElement();
				TreePath path = parent.pathByAddingChild(n);
				expandAll(tree, path, expand);
			}
		}
		if (expand) {
			tree.expandPath(parent);
		} else {
			tree.collapsePath(parent);
		}
	}
}
