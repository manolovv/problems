package book1.Classes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CompanyRoster {

    /*Define a class Employee that holds the following information: name, salary, position, department, email and age.
    The name, salary, position and department are mandatory while the rest are optional.
    Your task is to write a program which takes N lines of information about employees from the console and calculates
    the department with the highest average salary and prints for each employee in that department his name, salary, emai
    l and age - sorted by salary in descending order. If an employee doesn’t have an email – in place of that field you should
    print "n/a" instead, if he doesn’t have an age – print "-1" instead. The salary should be printed to two decimal places after the seperator.*/

    static class Department {
        private String name;
        private List<Employee> employees;
        private Double avrSalary;

        Department(String name, List<Employee> employees) {
            this.name = name;
            this.employees = employees;
            this.avrSalary = employees.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
        }

        public String getName() {
            return name;
        }

        public List<Employee> getEmployees() {
            return employees;
        }

        public Double getAvrSalary() {
            return avrSalary;
        }
    }


    static class Employee {
        private String name;
        private String position;
        private String department;
        private String email;
        private double salary;
        private int ages;

         Employee() {
             this.email = "n/a";
             this.ages = -1;
        }

        void setName(String name) {
            this.name = name;
        }

        void setPosition(String position) {
            this.position = position;
        }

        void setDepartment(String department) {
            this.department = department;
        }

        void setEmail(String email) {
            this.email = email;
        }

        void setAges(Integer ages) {
            this.ages = ages;
        }

        void setSalary(Double salary) {
            this.salary = salary;
        }
        double getSalary() {
            return salary;
        }

        String getDepartment() {
            return department;
        }

        String getName() {
            return name;
        }

        public String getPosition() {
            return position;
        }

        String getEmail() {
            return email;
        }

        int getAge() {
            return ages;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            Employee employee = new Employee();
            employee.setName(input[0]);
            employee.setSalary(Double.parseDouble(input[1]));
            employee.setPosition(input[2]);
            employee.setDepartment(input[3]);

            switch (input.length) {
                case 5 -> {
                    if (input[4].contains("@")) {
                        employee.setEmail(input[4]);
                    } else {
                        employee.setAges(Integer.parseInt(input[4]));
                    }
                }
                case 6 -> {
                    employee.setEmail(input[4]);
                    employee.setAges(Integer.parseInt(input[5]));
                }
            }
            employees.add(employee);
        }

        List<String> departmentsList = employees.stream().map(Employee::getDepartment).distinct().toList();
        List<Department> departments = new ArrayList<>();

        for (String department : departmentsList) {
            departments.add(new Department(department, employees.stream()
                    .filter(employee -> employee.getDepartment().
                            equals(department)).collect(Collectors.toList())));
        }

        departments.sort(Comparator.comparingDouble(Department::getAvrSalary).reversed());
        Department department = departments.get(0);
        department.getEmployees().sort(Comparator.comparingDouble(Employee::getSalary).reversed());

        System.out.println("Highest Average Salary: " + department);
        for (Employee employee : department.getEmployees()) {
            System.out.printf("%s %.2f %s %d%n",
                    employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge());
        }
    }
}
/*
Examples:

Input:
        4
        Pesho 120.00 Dev Development pesho@abv.bg 28
        Toncho 333.33 Manager Marketing 33
        Ivan 840.20 ProjectLeader Development ivan@ivan.com
        Gosho 0.20 Freeloader Nowhere 18
Output:
        Highest Average Salary: Development
        Ivan 840.20 ivan@ivan.com -1
        Pesho 120.00 pesho@abv.bg 28

Input:
        6
        Stanimir 496.37 Temp Coding stancho@yahoo.com
        Yovcho 610.13 Manager Sales
        Toshko 609.99 Manager Sales toshko@abv.bg 44
        Venci 0.02 Director BeerDrinking beer@beer.br 23
        Andrei 700.00 Director Coding
        Popeye 13.3333 Sailor SpinachGroup popeye@pop.ey
Output:
        Highest Average Salary: Sales
        Yovcho 610.13 n/a -1
        Toshko 609.99 toshko@abv.bg 44

*/
