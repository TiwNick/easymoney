import Models.Person;
import Services.PersonService;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        PersonService personService = new PersonService();
        Person person = new Person();

        int selection;
        Scanner input = new Scanner(System.in);

        /***************************************************/
        System.out.println("Login");
        System.out.println("-------------------------\n");
        System.out.println("email: ");
        person.setEmail(input.nextLine());

        System.out.println("password: ");
        person.setPassword(input.nextLine());

        boolean authorizedUser = personService.validUser(person.getEmail(), person.getPassword());

        if (authorizedUser) {
            System.out.println("Welcome " + person.getEmail());
        } else
            System.out.println("Vá embora " + person.getEmail());




//        System.out.println(person.getEmail());
//        System.out.println(person.getPassword());
//
//        System.out.println("2 - Profiles");
//        System.out.println("3 - Expenses");
//        System.out.println("4 - Quit");
//
//        /***************************************************/
//        System.out.println("Choose from these choices");
//        System.out.println("-------------------------\n");
//        System.out.println("1 - Investments");
//        System.out.println("2 - Profiles");
//        System.out.println("3 - Expenses");
//        System.out.println("4 - Quit");
//
//        selection = input.nextInt();
////        return selection;
//
//
//        //John
//        person.setName("John");
//        person.setCpf("0123456789");
//        person.setEmail("john@gmail.com");
//        person.setDateBirthday(new java.sql.Date(2020,12,12));
//        person.setTelephone("11 91234-5678");
//        person.setPassword("123456");
//        personService.createPerson(person);
//
//        //Peter
//        person.setName("Peter");
//        person.setCpf("0123456789");
//        person.setEmail("peter@gmail.com");
//        person.setDateBirthday(new java.sql.Date(2003,10,01));
//        person.setTelephone("11 91234-5678");
//        person.setPassword("555555");
//        personService.createPerson(person);
//
//        //Charlie
//        person.setName("Charlie");
//        person.setCpf("0123456789");
//        person.setEmail("charlie@gmail.com");
//        person.setDateBirthday(new java.sql.Date(1985,02,27));
//        person.setTelephone("11 91234-5678");
//        person.setPassword("333333");
//        personService.createPerson(person);
//
//        //Mary
//        person.setName("Mary");
//        person.setCpf("0123456789");
//        person.setEmail("mary@gmail.com");
//        person.setDateBirthday(new java.sql.Date(1985,02,27));
//        person.setTelephone("11 91234-5678");
//        person.setPassword("444444");
//        personService.createPerson(person);
//
//        //Joseph
//        person.setName("Joseph");
//        person.setCpf("0123456789");
//        person.setEmail("joseph@gmail.com");
//        person.setDateBirthday(new java.sql.Date(1985,02,27));
//        person.setTelephone("11 91234-5678");
//        person.setPassword("888888");
//        personService.createPerson(person);
//
//        var listPerson = personService.getAllPersons();
//
//        for (var item : listPerson) {
//            System.out.println(item.getName());
//            System.out.println(item.getCpf());
//            System.out.println(item.getEmail());
//            System.out.println(item.getTelephone());
//            System.out.println(item.getDateBirthday().toString());
//            System.out.println(item.getBalance());
//            System.out.println("\n");
//        }
    }
}