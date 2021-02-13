
public class Operator implements Employee {

    private String position = Operator;

    @Override
    public int getMonthSalary() {
        return SALARY;
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
