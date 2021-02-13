
public class Manager implements Employee {

    private String position = Manager;
    private int salary;

    public Manager() {
        this.salary = (int) (FIX_SALARY + (Math.random() * (MAХ_INCOME_FOR_COMPANY -
                MIN_INCOME_FOR_COMPANY + 1) + MIN_INCOME_FOR_COMPANY) * 0.05);
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
