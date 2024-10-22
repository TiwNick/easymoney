package Services;

import DAO.TransactionDAO;
import Models.Transaction;

import java.util.List;

public class TransactionService {
    TransactionDAO transactionDAO;

    public TransactionService() {
        transactionDAO = new TransactionDAO();
    }

    public void createTransaction(Transaction transaction) throws Exception {
        transactionDAO.insert(transaction);
    }

    public void updateTransaction(Transaction transaction) throws Exception {
        transactionDAO.update(transaction);
    }

    public List<Transaction> getTransactionPerson(int idPerson) throws Exception {
        return transactionDAO.getByIdPerson(idPerson);
    }

    public Transaction getTransaction(int idTransaction) throws Exception {
        return transactionDAO.getById(idTransaction);
    }
}
