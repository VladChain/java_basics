public class CardAccount extends BankAccount {

    public void take(double amountToTake) {
        if (amount < amountToTake) {
            System.out.println("Insufficient funds!");
        } else {
            amount = amount - (amountToTake + (amountToTake * 0.01));
        }
    }
}
