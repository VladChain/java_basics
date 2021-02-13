import java.util.*;

public class Company {

    private final int MAX_INCOME = 15000000;
    private final int MIN_INCOME = 5000000;

    private int income;

    private final List<Employee> employeesList = new ArrayList<>();

    public Company() {
        this.income = (int) (Math.random() * (MAX_INCOME - MIN_INCOME + 1) + MIN_INCOME);
    }

    protected int getIncome() {
        return this.income;
    }

    // Доход компании:
    public void printIncomeOfCompany() {
        System.out.println("Income of Company: " + this.income);
    }

    // Количество сотрудников в компание;
    public void printCountEmployees() {
        if (employeesList.size() <= 1) {
            System.out.println(employeesList.size() + " employee works in Company");
        } else {
            System.out.println(employeesList.size() + " employees work in Company");
        }
    }

    // Список всех сотрудников, в формате:
    // e.g. Operator - 30000;
    public void employeesList() {
        employeesList.forEach(list -> System.out.println(list));
    }

    // Найм сотрудников с указанием должности и количества:
    public void hireAll(Employee employees, int count) {
        for (int i = 0; i < count; i++) {
            employeesList.add(employees);
        }
    }

    // Рандомное увольнение половины сотрудников:
    public void fireHalf() {
        System.out.println("Half of the employees were fired!");
        int halfEmployees = employeesList.size() / 2;
        for (int i = 0; i < halfEmployees; i++) {
            int index = (int) (Math.random() * halfEmployees);
            this.employeesList.remove(index);
        }
    }

    // Найм одного сотрудника:
    public void hire(Employee employee) {
        employeesList.add(employee);
    }

    // Увольнение одного сотрудника:
    public void fire() {
        int index = (int) (Math.random() * employeesList.size());
        employeesList.remove(index);
    }

    // Отсортированный список зп сотрудников по возрастанию:
    public List<Employee> getTopSalaryStaff(int count) {
        employeesList.sort(new Salary().reversed());
        System.out.println("List of the highest employees' salaries: ");
        if (count <= employeesList.size()) {
            for (int i = 0; i < count; i++) {
                System.out.println((i + 1) + ". " + employeesList.get(i));
            }
        }
        return employeesList;
    }

    // Отсортированный список зп сотрудников по убыванию:
    public List<Employee> getLowestSalaryStaff(int count) {
        employeesList.sort(new Salary());
        System.out.println("List of the lowest employees' salaries: ");
        if (count <= employeesList.size()) {
            for (int i = 0; i < count; i++) {
                System.out.println((i + 1) + ". " + employeesList.get(i));
            }
        }
        return employeesList;
    }

//     =====================================================================================================
    // ДОПОЛНИТЕЛЬНО:

    // Список зп:
    public void printListOfAllSalaries() {
        List<String> list = new ArrayList<>();
        for (Employee lists : employeesList) {
            list.add(String.valueOf(lists));
        }
        Collections.sort(list);
        for (String lists : list)
            System.out.println(lists);
    }

    // Список всех Менеджеров:
    public void printListAllManager() {
        ArrayList<Employee> listOfManagers = new ArrayList<>();
        for (Employee employee : employeesList) {
            if (employee instanceof Manager)
                listOfManagers.add(employee);
        }
        listOfManagers.forEach(list -> System.out.println(list));
        if (listOfManagers.size() <= 1) {
            System.out.println(listOfManagers.size() + " manager works in Company");
        } else {
            System.out.println(listOfManagers.size() + " managers work in Company");
        }
    }

    // Список всех Операторов:
    public void printListAllOperator() {
        ArrayList<Employee> listOfOperator = new ArrayList<>();
        for (Employee employee : employeesList) {
            if (employee instanceof Operator)
                listOfOperator.add(employee);
        }
        listOfOperator.forEach(list -> System.out.println(list));
        if (listOfOperator.size() <= 1) {
            System.out.println(listOfOperator.size() + " operator works in Company");
        } else {
            System.out.println(listOfOperator.size() + " operators work in Company");
        }
    }

    // Список всех Топ-Менеджеров:
    public void printListAllTopManager() {
        ArrayList<Employee> listOfTopManager = new ArrayList<>();
        for (Employee employee : employeesList) {
            if (employee instanceof TopManager)
                listOfTopManager.add(employee);
        }
        listOfTopManager.forEach(list -> System.out.println(list));
        if (listOfTopManager.size() <= 1) {
            System.out.println(listOfTopManager.size() + " Top manager works in Company");
        } else {
            System.out.println(listOfTopManager.size() + " Top managers work in Company");
        }
    }
}
