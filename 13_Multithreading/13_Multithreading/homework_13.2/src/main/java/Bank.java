import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Bank {

    private HashMap<String, Account> accounts = new HashMap<>();  // �������� ����� ��������.
    private static final Random random = new Random(); // ������������ � ����� ������ true ��� false.
    private int countIsFraud;  // ��������� ��������, �.�. ��������� ����� ��������� � Synchronized �����.
    private int countTransfer; // ��������� ��������, �.�. ��������� ����� ��������� � Synchronized �����.
    private AtomicInteger countRequestsBalance = new AtomicInteger();

    // ����� �������� ������� ������������ �� ���� ������������.
    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, int amount)
            throws InterruptedException {
        Thread.sleep(1000);
        countIsFraud++;
        return random.nextBoolean();
    }

    /**
     * TODO: ����������� �����. ����� ��������� ������ ����� �������.
     * ���� ����� ���������� > 50000, �� ����� ���������� ����������,
     * ��� ������������ �� �������� ������ ������������ - ����������
     * ����� isFraud. ���� ������������ true, �� �������� ����������
     * ������ (��� - �� ���� ����������)
     */
    public void transfer(String fromAccountNum, String toAccountNum, int amount)
            throws InterruptedException {

        // ��������� ���� �����������, �������� �� ��� ������������.
        if (accounts.get(fromAccountNum).getStatus() == Status.BLOCK) {
            System.out.println("���� ����������� ������������! ������� �� ��������!");
            // ���� ���� ������������, �������� �� �����.
            return;
        }
        // ��������� ���� ����������, �������� �� ��� ������������.
        if (accounts.get(toAccountNum).getStatus() == Status.BLOCK) {
            System.out.println("���� ���������� ������������! ������� �� ��������!");
            // ���� ���� ������������, �������� �� �����.
            return;
        }
        synchronized (Account.class) { // ������������ ������ ������ ������� ���� �������� ������� ��������
            // ������� � ��������� ������� ������� ��� ��������.
            if (accounts.get(fromAccountNum).getMoney() < amount) {
                System.out.println("�� ����� �" + fromAccountNum + " ������������ �������!");
                // ���� ������������� �������� ������� �� �������, �������� �� �����.
                return;
            }
            // ���������� ������� �������� �������:
            accounts.get(toAccountNum).setMoney(accounts.get(toAccountNum).getMoney() + amount);
            accounts.get(fromAccountNum).setMoney(accounts.get(fromAccountNum).getMoney() - amount);
//            System.out.println("������� �� ����� �" + fromAccountNum + " �� ���� �" + toAccountNum +
//                    " �������� �������!");
            // ������� ���������� ����������� ���������
            countTransfer++;
        }
        if (amount > 50000) {
            if (isFraud(fromAccountNum, toAccountNum, amount)) {
                accounts.get(fromAccountNum).setStatus(Status.BLOCK);
                accounts.get(toAccountNum).setStatus(Status.BLOCK);
//                System.out.println("���� ������������!");
            }
        }
    }
    // ���������� ������ ������ � ������ �� ������.
    public void setUpData() {
        for (int i = 0; i < 100000; i++) {
            int balanceAccount = (int) (Math.random() * 1000000);
            accounts.put(String.valueOf(i), new Account(String.valueOf(i), balanceAccount));
        }
    }

    /**
     * TODO: ����������� �����. ���������� ������� �� �����.
     */
    public void getBalance(String accountNum) {
        countRequestsBalance.getAndIncrement();
        accounts.get(accountNum);
    }

    // ��������� ���� �������� ������� �����
    public String getBankBalance() {
        return accounts.values().stream().mapToLong(Account::getMoney).sum() + " ���.";
    }

    // ��������� ���������� �������� ���������
    public int getCountTransfer() {
        return countTransfer;
    }

    private void setCountTransfer(int countTransfer) {
        this.countTransfer = countTransfer;
    }

    // ��������� ���������� �������� ������� ������������ �� ���� ������������
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
