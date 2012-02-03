package org.hxzon.netprotocol.ui.javafx.parse;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.SplitPane;
import javafx.scene.web.WebView;

import org.hxzon.netprotocol.packet.Packet;
import org.hxzon.util.BytesUtil;

public class PacketDisplay extends SplitPane {

    private final PacketTreeView packetTreeView;
    private final WebView hexPane;
//    private static final Font font = Font.font("Courier New", 12);
    private static final int byteSplitLen = BytesUtil.HtmlWordSplit.length();
    private static final int lineSplitLen = BytesUtil.HtmlLineSplit.length();

    public PacketDisplay() {
        packetTreeView = new PacketTreeView();
        //
        hexPane = new WebView();
        hexPane.setPrefWidth(500);
        hexPane.setMinHeight(200);
        //
        getItems().addAll(hexPane, packetTreeView);
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
                String hex = BytesUtil.toDisplayHexString(packet.getData(), true);
                String index = BytesUtil.toIndex(packet.getData(), true);
                StringBuffer detailText = new StringBuffer(hex);
                detailText.insert(end, "</span>");
                detailText.insert(offset, "<span style='background:#bce2ec'>");
                setText(hexPane, index, detailText.toString());
            }

        });
    }

    public void updateData(Packet packet) {
        if (packet == null) {
            hexPane.getEngine().loadContent("");
            packetTreeView.updateData(null);
        } else {
            byte[] data = packet.getData();
            String index = BytesUtil.toIndex(data, true);
            String hex = BytesUtil.toDisplayHexString(data, true);
            setText(hexPane, index, hex);
            packetTreeView.updateData(packet);
        }
    }

    private void setText(WebView webView, String index, String hex) {
        StringBuffer sb = new StringBuffer("<table>");
        sb.append("<tr style=\"font-family:'Courier New';\" >");
        sb.append("<td >").append(index).append("</td>");
        sb.append("<td >").append(BytesUtil.HtmlWordSplit).append("</td>");
        sb.append("<td >").append(hex).append("</td>");
        sb.append("</tr>");
        sb.append("</table>");
        webView.getEngine().loadContent(sb.toString());
    }

}
