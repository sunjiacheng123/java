package domain;

import lombok.Data;

@Data
public class Person {
    String name;
    int age;
    double money;

    public Person(String hepengju, int i, double v) {
        this.age=i;
        this.name=hepengju;
        this.money=v;
    }
}
