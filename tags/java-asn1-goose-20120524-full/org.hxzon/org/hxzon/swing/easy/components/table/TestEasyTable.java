package org.hxzon.swing.easy.components.table;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class TestEasyTable {

    public static void test() {
        JFrame frame = new JFrame("");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        EasyTable<Person> table = new EasyTable<Person>();
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("hello", 1, true));
        persons.add(new Person("mimi", 2, false));
        persons.add(new Person("hxzon", 1, true));
        //column name
        EasyTableColumn<Person> nameColumn = new EasyTableColumn<Person>() {
            public Object getValue(EasyTable<Person> table, Person person) {
                return person.getName();
            }

            public void setValue(EasyTable<Person> table, Person person, Object value) {
                person.setName((String) value);
            }
        };
        nameColumn.setColumnName("name");
        nameColumn.setEditable(true);
        nameColumn.setValueClass(String.class);
        table.addColumn(nameColumn);
        //column age
        EasyTableColumn<Person> ageColumn = new EasyTableColumn<Person>() {
            public Object getValue(EasyTable<Person> table, Person person) {
                return person.getAge();
            }

            public void setValue(EasyTable<Person> table, Person person, Object value) {
                person.setAge((Integer) value);
            }
        };
        ageColumn.setColumnName("age");
        ageColumn.setEditable(true);
        ageColumn.setValueClass(Integer.class);
        table.addColumn(ageColumn);
        //column male
        EasyTableColumn<Person> maleColumn = new EasyTableColumn<Person>() {
            public Object getValue(EasyTable<Person> table, Person person) {
                return person.isMale();
            }

            public void setValue(EasyTable<Person> table, Person person, Object value) {
                person.setMale((Boolean) value);
            }
        };
        maleColumn.setColumnName("male");
        maleColumn.setEditable(true);
        maleColumn.setValueClass(Boolean.class);
        table.addColumn(maleColumn);
        //
        table.setOrigDatas(persons);
        frame.add(new JScrollPane(table));
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                test();
            }
        });

    }

}
