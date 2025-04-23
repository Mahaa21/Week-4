package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    public void testDeposit() {
        BankAccount account = new BankAccount();
        account.deposit(200);
        assertEquals(200, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        BankAccount account = new BankAccount();
        account.deposit(300);
        account.withdraw(100);
        assertEquals(200, account.getBalance());
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        BankAccount account = new BankAccount();
        account.deposit(100);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(200));
    }
}
