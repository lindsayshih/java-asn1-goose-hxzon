package org.hxzon.swing.easy.components.table;

public class Person {

    private String _name;
    private int _age;
    private boolean _male;

    public Person() {
        super();
    }

    public Person(String name, int age, boolean male) {
        super();
        this._name = name;
        this._age = age;
        this._male = male;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public int getAge() {
        return _age;
    }

    public void setAge(int age) {
        this._age = age;
    }

    public boolean isMale() {
        return _male;
    }

    public void setMale(boolean male) {
        this._male = male;
    }

}
