public class BankAccount {
    public double amount;

    public double getAmount() {
        return amount;
    }

    public void put(double amountToPut) {
        if (amountToPut < 0) {
            System.out.println("Invalid request!");
        } else {
            amount += amountToPut;
        }
    }

    public void take(double amountToTake) {
        if (amount < amountToTake) {
            System.out.println("Insufficient funds!");
        } else {
            amount -= amountToTake;
        }
    }
}
