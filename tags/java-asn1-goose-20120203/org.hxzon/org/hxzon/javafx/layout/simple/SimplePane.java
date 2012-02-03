package org.hxzon.javafx.layout.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import org.hxzon.swing.layout.simple.SimpleLayoutData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimplePane extends Pane {
    private static final Logger logger = LoggerFactory.getLogger(SimplePane.class);
    protected Map<Node, SimpleLayoutData> componentMap;
    protected boolean horizontal;

    public SimplePane() {
        this(false);
    }

    public SimplePane(boolean horizontal) {
        this.horizontal = horizontal;
        componentMap = new HashMap<Node, SimpleLayoutData>();
        this.getChildren().addListener(new ListChangeListener<Node>() {

            @Override
            public void onChanged(javafx.collections.ListChangeListener.Change<? extends Node> change) {
                while (change.next()) {
                    if (change.wasPermutated()) {
                        for (int i = change.getFrom(); i < change.getTo(); ++i) {
                        }
                    } else {
                        for (Node node : change.getRemoved()) {
                            componentMap.remove(node);
                        }
                        for (Node node : change.getAddedSubList()) {
                            if (!componentMap.containsKey(node)) {
                                componentMap.put(node, null);
                            }
                        }
                    }
                }

            }

        });
    }

    public void add(Node child, SimpleLayoutData layoutData) {
        componentMap.put(child, layoutData);
        this.getChildren().add(child);
    }

    //if fixedSize use fixedSize,else use preferredSize
//    public double prefSize() {
//        double resultWidth = 0;
//        double resultHeight = 0;
//        Insets insets = new Insets(0, 0, 0, 0);
//        if (horizontal) {//h
//            for (Entry<Node, SimpleLayoutData> e : componentMap.entrySet()) {
//                SimpleLayoutData layoutData = e.getValue();
//                double compPreferredSize = e.getKey().prefWidth(USE_PREF_SIZE);
//                if (layoutData == null) {
//                    resultWidth += compPreferredSize;
//                } else if (layoutData.isFixedSize()) {
//                    resultWidth += layoutData.fixedSize;
//                } else {
//                    resultWidth += compPreferredSize;
//                }
//                resultHeight = Math.max(resultHeight, e.getKey().prefHeight(USE_PREF_SIZE));
//            }
//        } else {//v
//            for (Entry<Node, SimpleLayoutData> e : componentMap.entrySet()) {
//                SimpleLayoutData layoutData = e.getValue();
//                double compPreferredSize = e.getKey().prefHeight(USE_PREF_SIZE);
//                if (layoutData == null) {
//                    resultHeight += compPreferredSize;
//                } else if (layoutData.isFixedSize()) {
//                    resultHeight += layoutData.fixedSize;
//                } else {
//                    resultHeight += compPreferredSize;
//                }
//                resultWidth = Math.max(resultWidth, e.getKey().prefWidth(USE_PREF_SIZE));
//            }
//        }
//        resultWidth += (insets.left + insets.right);
//        resultHeight += (insets.top + insets.bottom);
//    }

    public double computePrefHeight(double width) {
        double resultHeight = 0;
        Insets insets = new Insets(0, 0, 0, 0);
        if (horizontal) {//h
            for (Entry<Node, SimpleLayoutData> e : componentMap.entrySet()) {
                logger.debug(e.getKey() + " pref height:" + e.getKey().prefHeight(width));
                resultHeight = Math.max(resultHeight, e.getKey().prefHeight(width));
            }
        } else {//v
            for (Entry<Node, SimpleLayoutData> e : componentMap.entrySet()) {
                SimpleLayoutData layoutData = e.getValue();
                double compPreferredSize = e.getKey().prefHeight(width);
                logger.debug(e.getKey() + " pref height:" + compPreferredSize);
                if (layoutData == null) {
                    resultHeight += compPreferredSize;
                } else if (layoutData.isFixedSize()) {
                    resultHeight += layoutData.fixedSize;
                } else {
                    resultHeight += compPreferredSize;
                }
            }
        }
        resultHeight += (insets.getTop() + insets.getBottom());
        return resultHeight;
    }

    public double computePrefWidth(double height) {
        double resultWidth = 0;
        Insets insets = new Insets(0, 0, 0, 0);
        if (horizontal) {//h
            for (Entry<Node, SimpleLayoutData> e : componentMap.entrySet()) {
                SimpleLayoutData layoutData = e.getValue();
                double compPreferredSize = e.getKey().prefWidth(height);
//                logger.debug(e.getKey()+" pref width:"+compPreferredSize);
                if (layoutData == null) {
                    resultWidth += compPreferredSize;
                } else if (layoutData.isFixedSize()) {
                    resultWidth += layoutData.fixedSize;
                } else {
                    resultWidth += compPreferredSize;
                }
            }
        } else {//v
            for (Entry<Node, SimpleLayoutData> e : componentMap.entrySet()) {
                resultWidth = Math.max(resultWidth, e.getKey().prefWidth(height));
            }
        }
        resultWidth += (insets.getLeft() + insets.getRight());
        return resultWidth;
    }

    public double computeMinHeight(double width) {
        return computePrefHeight(width);
    }

    public double computeMinWidth(double height) {
        return computePrefWidth(height);
    }

    @Override
    public void layoutChildren() {
        synchronized (getParent()) {
            ObservableList<Node> components = this.getChildren();
            Insets insets = new Insets(0, 0, 0, 0);
            double x = insets.getLeft();
            double y = insets.getTop();
            double parentWidth = this.getWidth() - insets.getLeft() - insets.getRight();
            double parentHeight = this.getHeight() - insets.getTop() - insets.getBottom();
//          Dimension preferredParentSize = this.preferredLayoutSize(parent);
            double fillSize = 0;
            double fixedSize = getTotalFixedSize();
            if (horizontal) {//h
                fillSize = parentWidth - fixedSize;
                logger.debug("parent size:" + parentWidth);
            } else {//v
                fillSize = parentHeight - fixedSize;
                logger.debug("parent size:" + parentHeight);
            }
            layoutWhenFull(components, this, fillSize, parentWidth, parentHeight, x, y);
        }

    }

    private int getTotalFixedSize() {
        int result = 0;
        for (SimpleLayoutData layoutData : componentMap.values()) {
            if (layoutData != null && layoutData.isFixedSize()) {
                result += layoutData.fixedSize;
            }
        }
        logger.debug("total fixed size:" + result);
        return result;
    }

    private void layoutWhenFull(ObservableList<Node> components, SimplePane parent, double fillSize, double parentWidth, double parentHeight, double x, double y) {
        double curSize = 0;
        logger.debug("total fill size:" + fillSize);
        logger.debug("parent height:" + parentHeight);
        logger.debug("parent width:" + parentWidth);
        if (horizontal) {//h
            for (Node comp : components) {
                SimpleLayoutData layoutData = componentMap.get(comp);
                if (layoutData == null) {
                    curSize = comp.prefWidth(USE_PREF_SIZE);
                    logger.debug("preferred size:" + curSize);
                } else if (layoutData.isFixedSize()) {
                    curSize = layoutData.fixedSize;
                    logger.debug("fixed size:" + curSize);
                } else {
                    curSize = fillSize * layoutData.fixedPercent / 100;
                    logger.debug("fill size:" + curSize + ", percent:" + layoutData.fixedPercent);
                }
                comp.relocate(x, y);
                comp.resize(curSize, parentHeight);
                x += curSize;
            }
        } else {//v
            for (Node comp : components) {
                SimpleLayoutData layoutData = componentMap.get(comp);
                if (layoutData == null) {
                    curSize = comp.prefHeight(USE_PREF_SIZE);
                    logger.debug("preferred size:" + curSize);
                } else if (layoutData.isFixedSize()) {
                    curSize = layoutData.fixedSize;
                    logger.debug("fixed size:" + curSize);
                } else {
                    curSize = fillSize * layoutData.fixedPercent / 100;
                    logger.debug("fill size:" + curSize + ", percent:" + layoutData.fixedPercent);
                }
                comp.relocate(x, y);
                comp.resize(parentWidth, curSize);
                y += curSize;
            }
        }
        logger.debug("-----------------------------");
    }

    @SuppressWarnings("unused")
    private void layoutWhenPoor() {

    }

}
