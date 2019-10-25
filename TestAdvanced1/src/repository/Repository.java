package repository;

import java.util.LinkedHashMap;
import java.util.Map;

public class Repository {
    private int id;
    private Map<Integer,Person> data;

    public Repository() {
        this.data = new LinkedHashMap<>();
        int id = 0;
    }

    public void add(Person person){
        this.data.put(id,person);
        id++;
    }

    public Person get(int id){
        //TODO: Check if the id exists
        return this.data.get(id);
    }

    public boolean update(int id, Person newPerson){
        if(this.data.containsKey(id)){
            this.data.put(id,newPerson);
            return true;
        }
        return false;
    }

    public boolean delete (int id){
        if(this.data.containsKey(id)){
            this.data.remove(id);
            return true;
        }
        return false;
    }

    public int getCount(){
        return this.data.size();
    }
}
