// MinLimit.java
public class MinLimit extends ValidateTransaction{
    @Override
    public void check(MoneyTransaction moneyTransaction) {
        if (moneyTransaction.getAmount() > 1000) {
            System.out.println("Необходимо ввести пин-код");
        }
        checkNext(moneyTransaction);
    }
}
