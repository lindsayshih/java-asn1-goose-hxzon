package org.hxzon.netprotocol.ui.javafx.parse;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebView;

import org.hxzon.netprotocol.packet.Packet;
import org.hxzon.util.BytesUtil;

public class PacketDisplay extends SplitPane {

    private final PacketTreeView packetTreeView;
    private final WebView indexPane;
    private final WebView hexPane;
//    private static final Font font = Font.font("Courier New", 12);
    private static final int byteSplitLen = BytesUtil.HtmlWordSplit.length();
    private static final int lineSplitLen = BytesUtil.HtmlLineSplit.length();

    public PacketDisplay() {
        packetTreeView = new PacketTreeView();
        //
        indexPane = new WebView();
        indexPane.setPrefWidth(50);
        //
        hexPane = new WebView();
        HBox hbox = new HBox();
        hbox.getChildren().addAll(indexPane, hexPane);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(hbox);
        getItems().addAll(scrollPane, packetTreeView);
        //
        packetTreeView.getSelectionModel().selectedItemProperty().addListener(new InvalidationListener() {

            @Override
            public void invalidated(Observable arg0) {
                PacketTreeItem node = (PacketTreeItem) packetTreeView.getSelectionModel().getSelectedItem();
                PacketTreeItem root = (PacketTreeItem) packetTreeView.getRoot();
                if (node == null || root == null) {
                    return;
                }
                Packet packet = (Packet) root.getData();
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
                StringBuffer detailText = new StringBuffer(BytesUtil.toDisplayHexString(packet.getData(), true));
                detailText.insert(end, "</span>");
                detailText.insert(offset, "<span style='background:#bce2ec'>");
                setText(hexPane, detailText.toString());
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
            hexPane.getEngine().loadContent("");
            packetTreeView.updateData(null);
        } else {
            byte[] data = packet.getData();
            setText(indexPane, BytesUtil.toIndex(data, true));
            setText(hexPane, BytesUtil.toDisplayHexString(data, true));
            packetTreeView.updateData(packet);
        }
    }

    private void setText(WebView webView, String content) {
        webView.getEngine().loadContent("<div style=\"font-family:'Courier New';\">" + content + "</div>");
    }
}
