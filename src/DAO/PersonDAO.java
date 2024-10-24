package DAO;
import Models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO extends AcessoDAO {

//    public PersonDAO() {
//        super();
//    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl, username, password);
    }

    public void insert(Person person) {
        String sql = "INSERT INTO person (name, email, password, cpf, telephone, dateBirthday) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, person.getName());
            stmt.setString(2, person.getEmail());
            stmt.setString(3, person.getPassword());
            stmt.setString(4, person.getCpf());
            stmt.setString(5, person.getTelephone());
            stmt.setDate(6, person.getDateBirthday());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Person getById(int id) {
        String sql = "SELECT * FROM pessoa WHERE id = ?";
        Person person = null;
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                person = new Person();
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setEmail(rs.getString("email"));
                person.setCpf(rs.getString("cpf"));
                person.setTelephone(rs.getString("telephone"));
                person.setDateBirthday(rs.getDate("dateBirthday"));
                person.setBalance(rs.getDouble("balance"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    public List<Person> getAllPerson() {
        String sql = "SELECT * FROM person";
        List<Person> listPerson = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Person person = new Person();
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setEmail(rs.getString("email"));
                person.setCpf(rs.getString("cpf"));
                person.setTelephone(rs.getString("telephone"));
                person.setDateBirthday(rs.getDate("dateBirthday"));
                person.setBalance(rs.getDouble("balance"));
                listPerson.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPerson;
    }

    public void update(Person person) {
        String sql = "UPDATE person SET name = ?, email = ?, password = ?, cpf = ?, telephone = ?, dateBirthday = ? WHERE id = ?";

        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, person.getName());
            stmt.setString(2, person.getEmail());
            stmt.setString(3, person.getPassword());
            stmt.setString(4, person.getCpf());
            stmt.setString(5, person.getTelephone());
            stmt.setDate(6, person.getDateBirthday());
            stmt.setInt(7, person.getId());
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

    public boolean validUser(String email, String password) {
        String sql = "SELECT * FROM person WHERE email = ? AND password = ?";

        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
