import java.time.LocalDate;

public class EmployeePayroll {

    private int id;
    private String name;
    private double salary;

    public EmployeePayroll(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }


    public String toString(){
        return "Employee ID: " + id + ", Name: " + name + ", Salary: Rs." + salary + "/-";
    }

    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }if (o == null || getClass() != o.getClass()){
            return false;
        }
        EmployeePayroll that = (EmployeePayroll) o;
        return id == that.id && Double.compare(that.salary, salary) == 0 && name.equals(that.name);
    }
}
