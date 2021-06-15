
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

        System.out.println("����� ����������: " + (System.currentTimeMillis() - startTime) / 1000 + " ���.");
        System.out.println("����� �������� ������� � �����: " + bank.getBankBalance());
        String finishBankBalance = bank.getBankBalance();
        System.out.println("����� �������� ������� � ����� �� ��������� ��������: " + finishBankBalance);
        System.out.println("���������� ������ � �����: " + bank.getAccounts().keySet().size());
        System.out.println("���������� ��������� �������� �������: " + bank.getCountTransfer());
        System.out.println("���������� �������� �������: " + bank.getCountRequestsBalance());
        System.out.println("���������� ��������� ����������� �� �������������: " + bank.getCountIsFraud());
        Thread.sleep(10000); // �������� ����� � 10 ������, �.�. ��������� �������� ��������� � �������
        System.out.println("���������� ���������� ��������� ����������� �� �������������: "
                + bank.getCountIsFraud());
    }

    public static void testTransfer() {
        try {
            //���������� ������ ������ � ����� �������� �������� �������
            String fromAccountNum = String.valueOf((int) (Math.random() * AMOUNT_ACCOUNTS));
            String toAccountNum = String.valueOf((int) (Math.random() * AMOUNT_ACCOUNTS));
            int transferSum = (int) (Math.random() * 55000); // 5% �� ������������ ���� �������� ��� ��������
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
