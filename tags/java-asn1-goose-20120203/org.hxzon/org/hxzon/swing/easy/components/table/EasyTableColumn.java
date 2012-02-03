package org.hxzon.swing.easy.components.table;

import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

public class EasyTableColumn<V> extends TableColumn implements CellEditorListener {
    private static final long serialVersionUID = 1L;
    //   protected int       modelIndex;
//
//   protected Object    identifier;
//
//   protected int       width;
//
//   protected int       minWidth;
//
//   private int         preferredWidth;
//
//   protected int       maxWidth;
//
//   protected TableCellRenderer headerRenderer;
//
//   protected Object            headerValue;
//
//   protected TableCellRenderer cellRenderer;
//
//   protected TableCellEditor   cellEditor;
//
//   protected boolean   isResizable;
    //
    private boolean isEditable;

    private String columnName;
    
    private Class valueClass;

    public EasyTableColumn() {
        super();
    }

    public Object getValue(EasyTable<V> table, V rowValue) {
        return null;
    }

    public void setValue(EasyTable<V> table, V rowValue, Object value) {
        
    }

    public void setCellEditor(TableCellEditor cellEditor) {
        TableCellEditor old = super.getCellEditor();
        if (old != null) {
            old.removeCellEditorListener(this);
        }
        super.setCellEditor(cellEditor);
        cellEditor.addCellEditorListener(this);
    }

    @Override
    public void editingStopped(ChangeEvent e) {

    }

    @Override
    public void editingCanceled(ChangeEvent e) {

    }

    public boolean isEditable() {
        return isEditable;
    }

    public void setEditable(boolean isEditable) {
        this.isEditable = isEditable;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Class getValueClass() {
        return valueClass;
    }

    public void setValueClass(Class valueClass) {
        this.valueClass = valueClass;
    }

}
