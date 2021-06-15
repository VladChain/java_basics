
public class Account {

    private int money;           // Количество денег на этом счете.
    private String accNumber;    // Номер счета.
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
