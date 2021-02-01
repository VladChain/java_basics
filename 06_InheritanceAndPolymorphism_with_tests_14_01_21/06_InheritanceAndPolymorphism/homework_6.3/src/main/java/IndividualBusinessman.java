public class IndividualBusinessman extends Client {

    public void put(double amountToPut) {
        if (amountToPut <= 0) {
            System.out.println("Invalid request!");
        }
        else if (amountToPut < 1000) {
            setAmount(getAmount() + amountToPut - (amountToPut * 0.01));
        }
        else if (amountToPut >= 1000) {
            setAmount(getAmount() + amountToPut - (amountToPut * 0.005));
        }
    }
}
