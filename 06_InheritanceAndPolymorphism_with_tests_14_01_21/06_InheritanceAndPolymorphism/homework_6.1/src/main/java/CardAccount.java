class CardAccount extends BankAccount {
    private double amount;

    protected double getAmount() {
        return amount;
    }

    protected void put(double amountToPut) {
        if (amountToPut < 0) {
            System.out.println("Invalid request!");
        } else {
            amount += amountToPut;
        }
    }

    protected void take(double amountToTake) {
        if (getAmount() < amountToTake) {
            System.out.println("Insufficient funds!");
        } else {
            amount = getAmount() - (amountToTake + (amountToTake * 0.01));
        }
    }
}
