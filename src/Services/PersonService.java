package Services;

import DAO.PersonDAO;
import Models.Person;

import java.util.List;

public class PersonService {

    PersonDAO personDAO;

    public PersonService() {
        personDAO = new PersonDAO();
    }

    public void createPerson(Person person) {
        personDAO.insert(person);
        //return personDAO.getById(person.getId());
    }

    public void updatePerson(Person person) {
        personDAO.update(person);
    }

    public Person getPerson(int id) {
        return personDAO.getById(id);
    }

    public List<Person> getAllPersons() {
        return personDAO.getAllPerson();
    }

    public boolean validUser(String email, String password)
    {
        return personDAO.validUser(email, password);
    }
}
