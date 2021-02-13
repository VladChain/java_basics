
public interface Employee {

    // Manager:
    final String Manager = "Manager";
    final int MIN_INCOME_FOR_COMPANY = 115000;
    final int MAХ_INCOME_FOR_COMPANY = 140000;
    final int FIX_SALARY = 60000;

    // Top Manager:
    final String TopManager = "TopManager";
    final int FIXED_SALARY = 90000;
    final int INCOME_COMPANY = 10000000;

    // Operator:
    final String Operator = "Operator";
    final int SALARY = 30000;

    public int getMonthSalary();

    public String getPosition();

    public String toString();
}
