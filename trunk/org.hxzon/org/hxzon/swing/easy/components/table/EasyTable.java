package org.hxzon.swing.easy.components.table;

import java.util.List;

import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.TableColumn;

public class EasyTable<V> extends JTable {

    private static final long serialVersionUID = 1L;

    private List<V> origDatas;

    private List<V> viewDatas;

    public Object getValueAt(int row, int col) {
        EasyTableColumn<V> column = (EasyTableColumn<V>) this.getColumnModel().getColumn(col);
        V rowValue = getViewDatas().get(row);
        return column.getValue(this, rowValue);
    }
    
    public void setValueAt(Object aValue, int row, int col){
        EasyTableColumn<V> column = (EasyTableColumn<V>) this.getColumnModel().getColumn(col);
        V rowValue = getViewDatas().get(row);
        column.setValue(this, rowValue, aValue);
    }

    public String getColumnName(int column) {
        return ((EasyTableColumn<V>) getColumnModel().getColumn(column)).getColumnName();
    }

    public Class<?> getColumnClass(int column) {
        return ((EasyTableColumn<V>) getColumnModel().getColumn(column)).getValueClass();
    }

    public int getRowCount() {
        RowSorter sorter = getRowSorter();
        if (sorter != null) {
            return sorter.getViewRowCount();
        }
        return getViewDatas().size();
    }

    public void addColumn(TableColumn aColumn) {
        if (!(aColumn instanceof EasyTableColumn)) {
            throw new RuntimeException("");
        }
        EasyTableColumn<V> column = (EasyTableColumn<V>) aColumn;
        if (column.getHeaderValue() == null) {
            column.setHeaderValue(column.getColumnName());
        }
        getColumnModel().addColumn(aColumn);
    }

    public List<V> getOrigDatas() {
        return origDatas;
    }

    public void setOrigDatas(List<V> origDatas) {
        this.origDatas = origDatas;
    }

    public List<V> getViewDatas() {
        if (viewDatas == null) {
            viewDatas = origDatas;
        }
        return viewDatas;
    }

    public void setViewDatas(List<V> viewDatas) {
        this.viewDatas = viewDatas;
    }

}
