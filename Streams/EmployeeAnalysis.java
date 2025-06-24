/*You are given details of n employees in an organization. Each employee record contains:
	Employee ID: an integer
	Name: a string (single line)
	Department: a string (single line)
	Salary: a floating-point number

Write a Java program that:

	1.Finds the top-salaried employee in each department.
	2.Prints each department name (in ascending lexicographic order) along with all employee names in that department (sorted by name).
	3.Sorts the entire employee list by name and prints each record.

Use the Java Stream API (groupingBy, maxBy, mapping, sorted, etc.) to perform these operations.

Input Format:
-------------
n
id₁
name₁
department₁
salary₁
id₂
name₂
department₂
salary₂
...
idₙ
nameₙ
departmentₙ
salaryₙ
.
where, 
n: number of employees
For each employee i (1 ≤ i ≤ n):
	idᵢ (integer)
	nameᵢ (string)
	departmentᵢ (string)
	salaryᵢ (double)
	
Output Format:
--------------
1) Top-salaried employee in each department:
  <Dept₁> => <Name> (<Salary>)
  <Dept₂> => <Name> (<Salary>)
  ...
  
2) Departments (asc) with their employees:
  <Dept₁>: NameA, NameB, …
  <Dept₂>: NameC, NameD, …
  ...
  
3) All employees sorted by name:
  <id>:<Name>(<Dept>,$<Salary>)
  ...
  
  
  
Sample Input:
-------------
10
101
Alice
HR
75000.00
102
Bob
Engineering
98000.00
103
Carol
HR
82000.00
104
Dave
Engineering
120000.00
105
Eve
Finance
90000.00
106
Frank
Finance
88000.00
107
Grace
Engineering
115000.00
108
Heidi
HR
79000.00
109
Ivan
Engineering
105000.00
110
Judy
Finance
95000.00

Sample Output:
--------------
1) Top-salaried employee in each department:                                                                                                          
  Engineering => Dave (120000.00)                                                                                                                     
  Finance => Judy (95000.00)                                                                                                                          
  HR => Carol (82000.00)                                                                                                                              
                                                                                                                                                      
2) Departments (asc) with their employees:                                                                                                            
  Engineering: Bob, Dave, Grace, Ivan                                                                                                                 
  Finance: Eve, Frank, Judy                                                                                                                           
  HR: Alice, Carol, Heidi                                                                                                                             
                                                                                                                                                      
3) All employees sorted by name:                                                                                                                      
  101:Alice(HR,$75000.00)                                                                                                                             
  102:Bob(Engineering,$98000.00)                                                                                                                      
  103:Carol(HR,$82000.00)                                                                                                                             
  104:Dave(Engineering,$120000.00)                                                                                                                    
  105:Eve(Finance,$90000.00)                                                                                                                          
  106:Frank(Finance,$88000.00)                                                                                                                        
  107:Grace(Engineering,$115000.00)                                                                                                                   
  108:Heidi(HR,$79000.00)                                                                                                                             
  109:Ivan(Engineering,$105000.00)                                                                                                                    
  110:Judy(Finance,$95000.00) */
import java.util.*;
import java.util.stream.*;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class EmployeeAnalysis {
    static class Employee {
        private final int id;
        private final String name;
        private final String department;
        private final double salary;

        Employee(int i, String n, String d, double s) {
            this.id = i;
            this.name = n;
            this.department = d;
            this.salary = s;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return id + ":" + name + "(" + department + ",$" + String.format("%.2f", salary) + ")";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine().trim());

        List<Employee> employees = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int id = Integer.parseInt(scanner.nextLine().trim());
            String name = scanner.nextLine().trim();
            String dept = scanner.nextLine().trim();
            double sal = Double.parseDouble(scanner.nextLine().trim());

            employees.add(new Employee(id, name, dept, sal));
        }

        // 1) Top-salaried employee in each department
        System.out.println("\n1) Top-salaried employee in each department:");

        Map<String, Optional<Employee>> topSalaried = employees.stream()
            .collect(groupingBy(Employee::getDepartment,
                    maxBy(comparing(Employee::getSalary))));

        topSalaried.entrySet().stream()
            .sorted(Map.Entry.comparingByKey()) // Sort departments
            .forEach(entry -> {
                Employee emp = entry.getValue().get();
                System.out.printf("  %s => %s (%.2f)\n", entry.getKey(), emp.getName(), emp.getSalary());
            });

        // 2) Departments (asc) with their employees
        System.out.println("\n2) Departments (asc) with their employees:");

        Map<String, List<String>> deptEmployees = employees.stream()
            .collect(groupingBy(Employee::getDepartment,
                    mapping(Employee::getName, toList())));

        deptEmployees.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(entry -> {
                List<String> names = entry.getValue().stream()
                    .sorted()
                    .collect(toList());
                System.out.printf("  %s: %s\n", entry.getKey(), String.join(", ", names));
            });

        // 3) All employees sorted by name
        System.out.println("\n3) All employees sorted by name:");

        employees.stream()
            .sorted(comparing(Employee::getName))
            .forEach(emp -> System.out.println("  " + emp.toString()));
    }
}
