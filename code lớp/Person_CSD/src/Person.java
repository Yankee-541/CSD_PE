public class Person {

     String ID;
     String name;
     int age;
    Person next, pre;

    public Person(String ID, String name, int age) {
        this.ID = ID;
        this.name = name;
        this.age = age;
    }

    Person() {

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getNext() {
        return next;
    }

    public void setNext(Person next) {
        this.next = next;
    }

    public Person getPre() {
        return pre;
    }

    public void setPre(Person pre) {
        this.pre = pre;
    }

    
    
    @Override
    public String toString() {
        return "("+ID + ", " +  name+ ", " + age + ")" ;
    }

    

}
