import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Bank {

    private HashMap<String, Account> accounts = new HashMap<>();  // Хранятся счета клиентов.
    private static final Random random = new Random(); // Генерируется в нашем случае true или false.
    private int countIsFraud;  // Использую примитив, т.к. инкремент будет проходить в Synchronized блоке.
    private int countTransfer; // Использую примитив, т.к. инкремент будет проходить в Synchronized блоке.
    private AtomicInteger countRequestsBalance = new AtomicInteger();

    // Метод проверки Службой Безопасности на факт мошеничества.
    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, int amount)
            throws InterruptedException {
        Thread.sleep(1000);
        countIsFraud++;
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами.
     * Если сумма транзакций > 50000, то после совершения транзакции,
     * она отпарвляется на проверку Службе Безопасности - вызывается
     * метод isFraud. Если возвращается true, то делается блокировка
     * счетов (как - на ваше усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, int amount)
            throws InterruptedException {

        // Проверяем счет отправителя, активный он или заблоктрован.
        if (accounts.get(fromAccountNum).getStatus() == Status.BLOCK) {
            System.out.println("Счет отправителя заблокирован! Перевод не проведен!");
            // если счет заблокирован, перевода не будет.
            return;
        }
        // Првоеряем счет получителя, активный он или заблокирован.
        if (accounts.get(toAccountNum).getStatus() == Status.BLOCK) {
            System.out.println("Счет получателя заблокирован! Перевод не проведен!");
            // если счет заблокирован, перевода не будет.
            return;
        }
        synchronized (Account.class) { // Ограничиваем доступ других потоков пока проходит перевод денежных
            // средств и проверяем наличие средств для перевода.
            if (accounts.get(fromAccountNum).getMoney() < amount) {
                System.out.println("На счете №" + fromAccountNum + " недостаточно средств!");
                // если запрашиваемых денежных средств не хватает, перевлда не будет.
                return;
            }
            // Производим перевод денежных средств:
            accounts.get(toAccountNum).setMoney(accounts.get(toAccountNum).getMoney() + amount);
            accounts.get(fromAccountNum).setMoney(accounts.get(fromAccountNum).getMoney() - amount);
//            System.out.println("Перевод со счета №" + fromAccountNum + " на счет №" + toAccountNum +
//                    " проведен успешно!");
            // Считаем количество совершаемых переводов
            countTransfer++;
        }
        if (amount > 50000) {
            if (isFraud(fromAccountNum, toAccountNum, amount)) {
                accounts.get(fromAccountNum).setStatus(Status.BLOCK);
                accounts.get(toAccountNum).setStatus(Status.BLOCK);
//                System.out.println("Счет заблокирован!");
            }
        }
    }
    // Генерируем номера счетов и баланс на счетах.
    public void setUpData() {
        for (int i = 0; i < 100000; i++) {
            int balanceAccount = (int) (Math.random() * 1000000);
            accounts.put(String.valueOf(i), new Account(String.valueOf(i), balanceAccount));
        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счете.
     */
    public void getBalance(String accountNum) {
        countRequestsBalance.getAndIncrement();
        accounts.get(accountNum);
    }

    // Получение всех денежных средств банка
    public String getBankBalance() {
        return accounts.values().stream().mapToLong(Account::getMoney).sum() + " руб.";
    }

    // Получение количества денежных переводов
    public int getCountTransfer() {
        return countTransfer;
    }

    private void setCountTransfer(int countTransfer) {
        this.countTransfer = countTransfer;
    }

    // Получение количества проверок Службой Безопасности на факт мошеничества
    public int getCountIsFraud() {
        return countIsFraud;
    }

    public HashMap<String, Account> getAccounts() {
        return accounts;
    }

    private void setAccounts(HashMap<String, Account> accounts) {
        this.accounts = accounts;
    }

    public AtomicInteger getCountRequestsBalance() {
        return countRequestsBalance;
    }

    public void setCountRequestsBalance(AtomicInteger countRequestsBalance) {
        this.countRequestsBalance = countRequestsBalance;
    }
}
