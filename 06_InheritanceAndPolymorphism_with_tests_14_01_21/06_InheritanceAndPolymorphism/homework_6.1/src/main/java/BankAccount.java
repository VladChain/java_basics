class BankAccount {
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
        if (amount < amountToTake) {
            System.out.println("Insufficient funds!");
        } else {
            amount -= amountToTake;
        }
    }

    protected boolean send(BankAccount receiver, double amount) {
        if (this.amount >= amount) {
            receiver.amount += amount;
            this.amount -= amount;
            return true;
        } else {
            return false;
        }
    }
}
