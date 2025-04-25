package edu.sharif.selab;
import java.util.ArrayList;
import java.util.List;

public class AccountBalanceCalculator {

    private static List<Transaction> transactionHistory = new ArrayList<>();

    // Method to calculate balance based on a given list of transactions AND update history
    public static int calculateBalance(List<Transaction> transactions) {
        int balance = 0;
        transactionHistory.clear(); // Clear the history before processing new transactions
        for (Transaction t : transactions) {
            if (t.getType() == TransactionType.DEPOSIT) {
                balance += t.getAmount();
            } else if (t.getType() == TransactionType.WITHDRAWAL) {
                if (t.getAmount() > balance) {
                    throw new IllegalArgumentException("Insufficient funds for withdrawal of " + t.getAmount());
                }
                balance -= t.getAmount();
            }
            transactionHistory.add(t);
        }
        return balance;
    }

    // Method to get the current transaction history (static)
    public static List<Transaction> getTransactionHistory() {
        return new ArrayList<>(transactionHistory);
    }

    // Method to add a transaction to the history (static)
    public static void addTransaction(Transaction transaction) {
        transactionHistory.add(transaction);
    }

    // Method to clear the transaction history (static)
    public static void clearTransactionHistory() {
        transactionHistory.clear();
    }

    // (Removed calculateBalanceAndUpdateHistory to align with the test's calls)
}