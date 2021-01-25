import java.time.LocalDate;

public class DepositAccount extends BankAccount {
    private LocalDate lastIncome;

    public void put(double amountToPut) {
        if (amountToPut < 0) {
            System.out.println("Invalid request!");
        } else {
            amount += amountToPut;
            lastIncome = LocalDate.now();
        }
    }

    public void take(double amountToTake) {
        if (LocalDate.now().compareTo(lastIncome) > 0 && amount > amountToTake) {
            amount -= amountToTake;
        }
    }
}
