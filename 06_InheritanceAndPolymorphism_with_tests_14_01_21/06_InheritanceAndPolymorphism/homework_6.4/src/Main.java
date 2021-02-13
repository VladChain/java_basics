
public class Main {
    public static void main(String[] args) {

        Company company = new Company();
//  Доход компании:
        company.printIncomeOfCompany();

//  Наняли 3 сотрудника:
        company.hire(new Operator());
        company.hire(new Manager());
        company.hire(new TopManager());
        company.printCountEmployees();

//  Уволили 3 сотрудника:
        company.fire();
        company.fire();
        company.fire();
        company.printCountEmployees();

//  Создайте и наймите в компанию: 180 операторов Operator,
//  80 менеджеров по продажам Manager, 10 топ-менеджеров TopManager:
        company.hireAll(new Manager(), 80);
        company.hireAll(new Operator(), 180);
        company.hireAll(new TopManager(), 10);
        company.printCountEmployees();
        System.out.println();

//  Распечатайте список из 10–15 самых высоких зарплат в компании:
        company.getTopSalaryStaff(15);
        System.out.println();

//  Распечатайте список из 30 самых низких зарплат в компании:
        company.getLowestSalaryStaff(30);
        System.out.println();

//  Увольте 50% сотрудников:
        company.fireHalf();
        company.printCountEmployees();
        System.out.println();

//  Распечатайте список из 10–15 самых высоких зарплат в компании:
        company.getTopSalaryStaff(15);
        System.out.println();

//  Распечатайте список из 30 самых низких зарплат в компании.
        company.getLowestSalaryStaff(30);
        System.out.println();
    }
}
