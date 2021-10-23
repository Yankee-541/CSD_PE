
package person;

public class Person {
    String id;
    String name;
    int age;
    Person next, pre;

    public Person() {
    }

    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "(" + id + ", " + name + ", " + age + ')';
    }
    
}
