package equalitylogic;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public int hashCode() {
        return this.name.hashCode() + ((Integer) this.age).hashCode();
    }


    @Override
    public int compareTo(Person o) {
        int result = this.name.compareTo(o.name);

        if(result == 0){
            result =  this.age - o.age;
        }
       return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj instanceof Person) {
            return this.name.equals(((Person) obj).name) && this.age == (((Person) obj).age);
        }
        return false;
    }
}
