abstract class Employee {
    protected String name;
    protected int id;
    protected double salary;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    abstract void calculateSalary();

    void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

class FullTimeEmployee extends Employee {
    private double basic;
    private double hra;
    private double da;

    FullTimeEmployee(String name, int id, double basic) {
        super(name, id);
        this.basic = basic;
    }

    @Override
    void calculateSalary() {
        hra = basic * 0.20;
        da = basic * 0.10;
        salary = basic + hra + da;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double ratePerHour;

    PartTimeEmployee(String name, int id, int hoursWorked, double ratePerHour) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.ratePerHour = ratePerHour;
    }

    @Override
    void calculateSalary() {
        salary = hoursWorked * ratePerHour;
    }
}

public class EmployeePayrollSystem {
    public static void main(String[] args) {

        Employee emp1 = new FullTimeEmployee("Rahul", 101, 30000);
        emp1.calculateSalary();
        emp1.displayDetails();

        System.out.println();

        Employee emp2 = new PartTimeEmployee("Amit", 102, 80, 500);
        emp2.calculateSalary();
        emp2.displayDetails();
    }
}
