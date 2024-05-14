package come.example;


import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int age;
    private List<Person> children;
    private boolean isMarried;
    private String spouseName;
    private int spouseAge;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.children = new ArrayList<>();
        this.isMarried = false;
        this.spouseName = "";
        this.spouseAge = 0;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public List<Person> getChildren() {
        return children;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean married, String spouseName, int spouseAge) {
        this.isMarried = married;
        this.spouseName = spouseName;
        this.spouseAge = spouseAge;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public int getSpouseAge() {
        return spouseAge;
    }
}