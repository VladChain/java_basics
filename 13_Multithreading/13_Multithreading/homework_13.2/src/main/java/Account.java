
public class Account {

    private int money;           // ���������� ����� �� ���� �����.
    private String accNumber;    // ����� �����.
    private Status status;

    public Account(String accNumber, int money) {
        this.accNumber = accNumber;
        this.money = money;
        this.status = Status.ACTIVE;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public String getAccNumber() {
        return accNumber;
    }
}
