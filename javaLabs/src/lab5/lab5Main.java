package lab5;

import DB.DBConnection;
import Model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class lab5Main {
    public static void main(String[] args) {
        System.out.println("====================================DBConnection======================================");
        try {
            DBConnection db = new DBConnection();

            db.clearAddress();

            System.out.println("------Address------");
            for (int i = 0; i < 50; ++i)
                db.insertAddress(generateAddress());

            for (Address address1 : db.getAddresses())
                System.out.println(address1);

            db.clearPerson();
            System.out.println("------Person------");
            for (int i = 0; i < 50; ++i)
                db.insertPerson(generatePerson());

            for (Person person1 : db.getPeople())
                System.out.println(person1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("======================================================================================");
    }

    public static Organisation generateOrganisation() {
        return new Organisation.Builder()
                .withOrganisationName("-Name-")
                .withPeople(generatePeople())
                .withCreationDate(new Date())
                .withSportType(SportType.football)
                .withActive(Boolean.TRUE)
                .withAddress(generateAddress())
                .withContact(generateContact())
                .build();
    }

    public static ArrayList<Person> generatePeople() {
        ArrayList<Person> people = new ArrayList<Person>();
        for (int i = 0; i < 10; ++i)
            people.add(generatePerson());
        return people;
    }

    public static Person generatePerson() {
        return new Person.Builder()
                .withName("-Name-")
                .withSurname("Surname")
                .withFatherName("fatherName")
                .withAge(randInt(15, 30))
                .withHeight(randInt(150, 200))
                .withWeight(randInt(60, 90))
                .withQualification(Qualification.masters_of_sport)
                .build();
    }

    public static Address generateAddress() {
        return new Address.Builder()
                .withCountry("country")
                .withRegion("region")
                .withCity("city")
                .withStreet("street")
                .withHouse(randInt(1, 500))
                .build();
    }

    public static int randInt(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public static Contact generateContact() {
        return new Contact.Builder()
                .withValue("contact@gmail.com")
                .withPerson(generatePerson())
                .build();
    }
}
