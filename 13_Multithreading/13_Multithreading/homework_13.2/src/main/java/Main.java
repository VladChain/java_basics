
public class Main {

    public static final int AMOUNT_ACCOUNTS = 100000;
    public static Bank bank = new Bank();

    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();

        bank.setUpData();

        for (int i = 0; i < 1000; i++) {
            new Thread(Main::testTransfer).start();
            for (int j = 0; j < (int) (Math.random() * 5 + 5); j++) {
                new Thread(Main::testBalance).start();
            }
        }

        System.out.println("Время выполнения: " + (System.currentTimeMillis() - startTime) / 1000 + " сек.");
        System.out.println("Сумма денежных средств в банка: " + bank.getBankBalance());
        String finishBankBalance = bank.getBankBalance();
        System.out.println("Сумма денежных средств в банке по окончанию операций: " + finishBankBalance);
        System.out.println("Количество счетов в банке: " + bank.getAccounts().keySet().size());
        System.out.println("Количество переводов денежных средств: " + bank.getCountTransfer());
        System.out.println("Количество запросов баланса: " + bank.getCountRequestsBalance());
        System.out.println("Количество переводов проверенных на мошенничество: " + bank.getCountIsFraud());
        Thread.sleep(10000); // Выдержим паузу в 10 секунд, т.к. несколько проверок находятся в очереди
        System.out.println("Оставшиеся количество переводов проверенных на мошенничество: "
                + bank.getCountIsFraud());
    }

    public static void testTransfer() {
        try {
            //Генерируем номера счетов и сумму перевода денежных средств
            String fromAccountNum = String.valueOf((int) (Math.random() * AMOUNT_ACCOUNTS));
            String toAccountNum = String.valueOf((int) (Math.random() * AMOUNT_ACCOUNTS));
            int transferSum = (int) (Math.random() * 55000); // 5% от генерируемых сумм подходят под проверку
            bank.transfer(fromAccountNum, toAccountNum, transferSum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testBalance() {
        String account = String.valueOf((int) (Math.random() * AMOUNT_ACCOUNTS));
        bank.getBalance(account);
    }
}
