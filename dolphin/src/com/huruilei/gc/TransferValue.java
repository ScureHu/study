package com.huruilei.gc;

class Person{
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Person(){

    }
}
public class TransferValue {
    public void setValue(String v1){
        v1 = "xxxx";
    }
    public void setValue2(Person person){
        person.setValue("xxxx");
    }
    public void setValue3(int value3){
        value3 = 3;
    }

    public static void main(String[] args) {
        TransferValue transferValue = new TransferValue();
        String value1 = "123213";
        transferValue.setValue(value1);
        System.out.println(value1);

        Person person = new Person();
        person.setValue("kkkk");
        transferValue.setValue2(person);
        System.out.println(person.getValue());

        int value3 = 1;
        transferValue.setValue3(value3);
        System.out.println(value3);
    }
}
