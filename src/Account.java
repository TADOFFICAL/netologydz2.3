public abstract class Account {
    protected long balance;

    public Account(long initialBalance) {
        this.balance = initialBalance;
    }

    // Метод для пополнения счета
    public boolean add(long amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    // Метод для списания средств
    public boolean pay(long amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    // Метод для перевода средств
    public boolean transfer(Account targetAccount, long amount) {
        if (targetAccount == null || amount <= 0 || balance < amount) {
            return false; // Некорректные данные или недостаточно средств
        }

        if (!targetAccount.add(amount)) {
            return false;
        }


        if (!this.pay(amount)) {
            targetAccount.subtract(amount); // Отменяем зачисление
            return false;
        }

        return true; // Всё прошло успешно
    }

    public long getBalance() {
        return balance;
    }

    public boolean subtract(long amount) {
        if (amount > 0) {
            long newBalance = balance - amount;
            if (newBalance < Long.MIN_VALUE) {
                return false; // Защита от переполнения
            }
            balance = newBalance;
            return true;
        }
        return false;
    }
}