package org.hxzon.netprotocol.ui.javafx.parse;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import org.hxzon.netprotocol.packet.Packet;

public class PacketTableView extends TableView<Packet> {

    private final ObservableList<Packet> data = FXCollections.observableArrayList();

    public PacketTableView() {
        Callback<TableColumn<Packet, String>, TableCell<Packet, String>> cellFactory = new Callback<TableColumn<Packet, String>, TableCell<Packet, String>>() {
            public TableCell<Packet, String> call(TableColumn<Packet, String> p) {
                return new TableCell<Packet, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        setText(String.valueOf(getIndex() + 1));
                    }
                };
            }
        };
        TableColumn<Packet, String> indexColumn = new TableColumn<Packet, String>("序号");
        indexColumn.setCellFactory(cellFactory);
        TableColumn<Packet, String> lastPayloadTypeColumn = new TableColumn<Packet, String>("报文类型");
//        lastPayloadTypeColumn.setCellValueFactory(new PropertyValueFactory<Packet, String>("lastPayloadType"));
        lastPayloadTypeColumn.setCellValueFactory(new Callback<CellDataFeatures<Packet, String>, ObservableValue<String>>() {
            public ObservableValue<String> call(CellDataFeatures<Packet, String> p) {
                return new SimpleStringProperty(p.getValue().getLastPayloadType());
            }
        });
        lastPayloadTypeColumn.setMinWidth(300);
        this.getColumns().addAll(indexColumn, lastPayloadTypeColumn);
        this.setItems(data);
    }

    public ObservableList<Packet> getData() {
        return data;
    }
}
