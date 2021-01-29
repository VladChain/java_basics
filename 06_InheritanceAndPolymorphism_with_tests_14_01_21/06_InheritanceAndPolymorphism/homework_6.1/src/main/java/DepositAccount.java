import java.time.LocalDate;

class DepositAccount extends BankAccount {
    private LocalDate lastIncome;
    private double amount;

    protected double getAmount() {
        return amount;
    }

    protected void put(double amountToPut) {
        if (amountToPut < 0) {
            System.out.println("Invalid request!");
        } else {
            amount += amountToPut;
            lastIncome = LocalDate.now();
        }
    }

    protected void take(double amountToTake) {
        if (LocalDate.now().compareTo(lastIncome) > 0 && getAmount() > amountToTake) {
            amount -= amountToTake;
        }
    }
}
