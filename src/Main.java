public class Main {
    public static void main(String[] args) {
        // Создание простого счета
        SimpleAccount simpleAccount = new SimpleAccount(1000);
        System.out.println("SimpleAccount Balance: " + simpleAccount.getBalance()); // 1000

        // Пополнение
        simpleAccount.add(500);
        System.out.println("SimpleAccount Balance after add: " + simpleAccount.getBalance()); // 1500

        // Списание
        simpleAccount.pay(800);
        System.out.println("SimpleAccount Balance after pay: " + simpleAccount.getBalance()); // 700

        // Создание кредитного счета
        CreditAccount creditAccount = new CreditAccount(-500, 1000); // Изначальный баланс -500, кредитный лимит 1000
        System.out.println("CreditAccount Balance: " + creditAccount.getBalance()); // -500

        // Пополнение
        creditAccount.add(300);
        System.out.println("CreditAccount Balance after add: " + creditAccount.getBalance()); // -200

        // Списание
        creditAccount.pay(400);
        System.out.println("CreditAccount Balance after pay: " + creditAccount.getBalance()); // -600

        // Перевод между счетами
        simpleAccount.transfer(creditAccount, 200);
        System.out.println("SimpleAccount Balance after transfer: " + simpleAccount.getBalance()); // 500
        System.out.println("CreditAccount Balance after transfer: " + creditAccount.getBalance()); // -400
    }
}