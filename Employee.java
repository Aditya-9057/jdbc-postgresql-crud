public class Employee {
    private int id;
    private String name;
    private float salary;

    public Employee(int id, String name, float salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setSalary(float salary){
        this.salary = salary;
    }

    public float getSalary(){
        return salary;
    }

    @Override 
    public String toString(){
        return id + " | " + name + " | " + salary;
    }
}
