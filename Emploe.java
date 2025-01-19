abstract class Employee {
    String name;
    int id;
    double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }


    public String getDetails() {
        return super.getClass() + ", Specialty: ";
    }
}









