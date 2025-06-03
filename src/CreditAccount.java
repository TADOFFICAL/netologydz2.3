public class CreditAccount extends Account {
    private long creditLimit;

    public CreditAccount(long initialBalance, long creditLimit) {
        super(initialBalance);
        this.creditLimit = creditLimit;
    }

    // Переопределение метода pay для учета кредитного лимита
    @Override
    public boolean pay(long amount) {
        if (amount > 0 && balance - amount >= -creditLimit) {
            balance -= amount;
            return true;
        }
        return false;
    }

    // Переопределение метода add для ограничения положительного баланса
    @Override
    public boolean add(long amount) {
        if (amount > 0 && balance < 0) {
            balance += amount;
            return true;
        }
        return false;
    }
}