
public class TopManager extends Company implements Employee {

    private String position = TopManager;
    private int salary;

    public TopManager() {
        if (getIncome() > INCOME_COMPANY) {
            this.salary = (int) (FIXED_SALARY * 1.5);
        } else {
            this.salary = FIXED_SALARY;
        }
    }

    @Override
    public int getMonthSalary() {
        return this.salary;
    }

    @Override
    public String getPosition() {
        return this.position;
    }

    @Override
    public String toString() {
        return this.position + " - " + this.getMonthSalary();
    }
}
