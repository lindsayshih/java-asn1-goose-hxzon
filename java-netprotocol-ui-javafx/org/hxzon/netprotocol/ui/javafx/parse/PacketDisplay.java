package org.hxzon.netprotocol.ui.javafx.parse;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.SplitPane;
import javafx.scene.web.WebView;

import org.hxzon.netprotocol.packet.Packet;
import org.hxzon.util.BytesUtil;

public class PacketDisplay extends SplitPane {

//    private static final Font font = Font.font("Courier New", 12);
    private static final int byteSplitLen = BytesUtil.HtmlWordSplit.length();
    private static final int lineSplitLen = BytesUtil.HtmlLineSplit.length();

    private final PacketTreeView packetTreeView;
    private final WebView hexPane;
    private byte[] dataByte;
    private String dataIndex;
    private String dataString;

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
                    dataIndex = BytesUtil.toIndex(dataByte, true);
                    dataString = BytesUtil.toDisplayHexString(dataByte, true);
                }
                StringBuffer detailText = new StringBuffer(dataString);
                detailText.insert(end, "</span>");
                detailText.insert(offset, "<span style='background:#bce2ec'>");
                setText(hexPane, dataIndex, detailText.toString());
            }

        });
    }

    public void updateData(Packet packet) {
        if (packet == null) {
            hexPane.getEngine().loadContent("");
            packetTreeView.updateData(null);
        } else {
            packetTreeView.updateData(packet);
            packetTreeView.getSelectionModel().select(0);
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
