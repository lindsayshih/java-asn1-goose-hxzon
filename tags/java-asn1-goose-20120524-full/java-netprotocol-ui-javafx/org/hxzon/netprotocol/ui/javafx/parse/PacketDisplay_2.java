package org.hxzon.netprotocol.ui.javafx.parse;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.web.WebView;

import org.hxzon.javafx.layout.simple.SimplePane;
import org.hxzon.netprotocol.packet.Packet;
import org.hxzon.util.BytesUtil;

public class PacketDisplay_2 extends SplitPane {

//    private static final Font font = Font.font("Courier New", 12);
    private static final int byteSplitLen = BytesUtil.HtmlWordSplit.length();
    private static final int lineSplitLen = BytesUtil.HtmlLineSplit.length();

    private final PacketTreeView packetTreeView;
    private final WebView indexPane;
    private final WebView dataPane;
    private byte[] dataByte;
    private String dataString;

    public PacketDisplay_2() {
        packetTreeView = new PacketTreeView();
        //
        indexPane = new WebView();
        indexPane.setPrefWidth(80);
        indexPane.setPrefHeight(1000);
        //
        dataPane = new WebView();
        dataPane.setPrefWidth(500);
        dataPane.setPrefHeight(1000);
        //
        SimplePane messagePane = new SimplePane(true);
        messagePane.setStyle("-fx-background-color:red");
        messagePane.getChildren().add(indexPane);
        messagePane.getChildren().add(dataPane);
        //
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(messagePane);
        getItems().addAll(scrollPane, packetTreeView);
        //
        packetTreeView.getSelectionModel().selectedItemProperty().addListener(new InvalidationListener() {

            @Override
            public void invalidated(Observable arg0) {
                PacketTreeItem node = (PacketTreeItem) packetTreeView.getSelectionModel().getSelectedItem();
                if (node == null) {
                    return;
                }
                //
                int charLenForByte = byteSplitLen + 2;
                int offset = node.getOffset();
                int len = node.getLen();
                int end = offset + len;
                offset = offset * charLenForByte;
                end = end * charLenForByte;
                offset += offset / (16 * charLenForByte) * lineSplitLen;
                end += end / (16 * charLenForByte) * lineSplitLen;
                //fix bug when len=0 make end=offset
                if (end > offset) {
                    end -= byteSplitLen;
                }
                if (dataByte != node.getBytes()) {
                    dataByte = node.getBytes();
                    dataString = BytesUtil.toDisplayHexString(dataByte, true);
                    setText(indexPane, BytesUtil.toIndex(dataByte, true));
                }
                StringBuffer detailText = new StringBuffer(dataString);
                detailText.insert(end, "</span>");
                detailText.insert(offset, "<span style='background:#bce2ec'>");
                setText(dataPane, detailText.toString());
            }

        });
//        .addListener(new ChangeListener<TreeItem<Object>>() {
//
//            @Override
//            public void changed(ObservableValue<? extends TreeItem<Object>> ov, TreeItem<Object> old_val, TreeItem<Object> new_val) {
//                PacketTreeItem node = (PacketTreeItem) new_val;
//                Packet packet = (Packet) ((PacketTreeItem) packetTreeView.getRoot()).getData();
//                //
//                int charLenForByte = byteSplitLen + 2;
//                int offset = node.getOffset();
//                int len = node.getLen();
//                int end = offset + len;
//                offset = offset * charLenForByte;
//                end = end * charLenForByte;
//                offset += offset / (16 * charLenForByte) * lineSplitLen;
//                end += end / (16 * charLenForByte) * lineSplitLen;
//                //fix bug when len=0 make end=offset
//                if (end > offset) {
//                    end -= byteSplitLen;
//                }
//                StringBuffer detailText = new StringBuffer(BytesUtil.toDisplayHexString(packet.getData(), true));
//                detailText.insert(end, "</span>");
//                detailText.insert(offset, "<span style='background:#bce2ec'>");
//                hexPane.getEngine().loadContent(detailText.toString());
//            }
//
//        });
    }

    public void updateData(Packet packet) {
        if (packet == null) {
            indexPane.getEngine().loadContent("");
            dataPane.getEngine().loadContent("");
            packetTreeView.updateData(null);
        } else {
            packetTreeView.updateData(packet);
            packetTreeView.getSelectionModel().select(0);
        }
    }

    private void setText(WebView webView, String content) {
        webView.getEngine().loadContent("<div style=\"font-family:'Courier New';\">" + content + "</div>");
    }

}
