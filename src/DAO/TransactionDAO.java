package DAO;

import Models.Person;
import Models.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO extends AcessoDAO {

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl, username, password);
    }

    public void insert(Transaction transaction) throws SQLException {
        String sql = "INSERT INTO transaction (id, idPerson, value, type, date, observation) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, transaction.getId());
            stmt.setInt(2, transaction.getIdPerson());
            stmt.setDouble(3, transaction.getValue());
            stmt.setString(4, transaction.getType());
            stmt.setString(5, transaction.getDate());
            stmt.setString(6, transaction.getObservation());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Transaction> getByIdPerson(int idPerson) {
        String sql = "SELECT * FROM transaction WHERE idPerson = ?";
        List<Transaction> listTransaction = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setId(rs.getInt("id"));
                transaction.setIdPerson(rs.getInt("idPerson"));
                transaction.setValue(rs.getDouble("value"));
                transaction.setType(rs.getString("type"));
                transaction.setDate(rs.getString("date"));
                transaction.setObservation(rs.getString("observation"));
                listTransaction.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listTransaction;
    }

    public void update(Transaction transaction) {
        String sql = "UPDATE person SET value = ?, type = ?, date = ?, observation = ? WHERE id = ?";

        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setDouble(1, transaction.getValue());
            stmt.setString(2, transaction.getType());
            stmt.setString(3, transaction.getDate());
            stmt.setString(4, transaction.getObservation());
            stmt.setInt(5, transaction.getId());
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Pessoa atualizada com sucesso!");
            } else {
                System.out.println("Nenhuma pessoa encontrada com o ID especificado.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Transaction getById(int id) {
        String sql = "SELECT * FROM transaction WHERE id = ?";
        Transaction transaction = null;
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                transaction = new Transaction();
                transaction.setId(rs.getInt("id"));
                transaction.setIdPerson(rs.getInt("idPerson"));
                transaction.setValue(rs.getDouble("value"));
                transaction.setType(rs.getString("type"));
                transaction.setDate(rs.getString("date"));
                transaction.setObservation(rs.getString("observation"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transaction;
    }
}
