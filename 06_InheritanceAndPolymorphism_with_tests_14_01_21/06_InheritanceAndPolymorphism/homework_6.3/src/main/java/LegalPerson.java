public class LegalPerson extends Client {

    public void take(double amountToTake) {
        if (getAmount() < amountToTake) {
            System.out.println("Insufficient funds!");
        } else {
            setAmount(getAmount() - amountToTake - (amountToTake * 0.01));
        }
    }
}
