package org.hxzon.netprotocol.ui.javafx.parse;

import java.io.File;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import org.hxzon.netprotocol.packet.CotpPacket;
import org.hxzon.netprotocol.packet.EthernetPacket;
import org.hxzon.netprotocol.packet.GoosePacket;
import org.hxzon.netprotocol.packet.Ip4Packet;
import org.hxzon.netprotocol.packet.OsiPresentationPacket;
import org.hxzon.netprotocol.packet.OsiSessionPacket;
import org.hxzon.netprotocol.packet.Packet;
import org.hxzon.netprotocol.packet.SvPacket;
import org.hxzon.netprotocol.packet.TcpPacket;
import org.hxzon.netprotocol.packet.TpktPacket;
import org.hxzon.netprotocol.packet.UdpPacket;
import org.hxzon.netprotocol.packet.VlanPacket;
import org.hxzon.pcap.PcapHandler;
import org.hxzon.ui.util.UIUtil;

public class DisplayApplication extends Application {
    static {
        new EthernetPacket();
        new VlanPacket();
        new GoosePacket();
        new SvPacket();
        new Ip4Packet();
        new TcpPacket();
        new UdpPacket();
        new TpktPacket();
        new CotpPacket();
        new OsiSessionPacket();
        new OsiPresentationPacket();
    }

    private PacketTableView packetsTableView;
    private PacketDisplay packetDisplay;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new BorderPane());
        stage.setTitle("java-asn1-goose parser");
        stage.setWidth(570);
        stage.setHeight(550);
        init(scene);
        stage.setScene(scene);
        stage.show();
    }

    public void init(final Scene scene) {
        Button openFile = new Button("打开文件");
        Button prePacket = new Button("样例");
        openFile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                FileChooser fileChooser = new FileChooser();
                File file = fileChooser.showOpenDialog(scene.getWindow());
                if (file != null) {
                    PcapHandler handler = new PcapHandler();
                    handler.addListener(new PacketHandlerListener(DisplayApplication.this));
                    handler.addFile(file);
                    handler.run();
                }
            }
        });
        prePacket.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                packetsTableView.getData().clear();
                for (Packet packet : UIUtil.examplePackets) {
                    packetsTableView.getData().add(packet);
                }
            }
        });
        ToolBar toolBar = new ToolBar(openFile, prePacket);
        packetDisplay = new PacketDisplay();
        packetsTableView = new PacketTableView();
        packetsTableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Packet>() {
            public void changed(ObservableValue<? extends Packet> ov, Packet old_val, Packet new_val) {
                packetDisplay.updateData(new_val);
            }

        });
        SplitPane splitPane = new SplitPane();
        splitPane.setOrientation(Orientation.VERTICAL);
        splitPane.getItems().addAll(packetsTableView, packetDisplay);
        BorderPane borderPane = (BorderPane) scene.getRoot();
        borderPane.setCenter(splitPane);
        borderPane.setTop(toolBar);
    }

    public PacketTableView getPacketTableView() {
        return packetsTableView;
    }

    public PacketDisplay getPacketDisplay() {
        return packetDisplay;
    }

}
