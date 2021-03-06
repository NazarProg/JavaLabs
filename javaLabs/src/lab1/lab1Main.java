package lab1;

import Model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class lab1Main {
    public static void main(String[] args) {
        System.out.println("========================================Models========================================");
        System.out.println("Model.Person:");
        Person person = generatePerson();
        System.out.println(person);

        System.out.println("Model.Address:");
        Address address = generateAddress();
        System.out.println(address);

        System.out.println("Model.Contact:");
        Contact contact = generateContact();
        System.out.println(contact);

        System.out.println("Model.Organisation:");
        Organisation organisation = generateOrganisation();
        System.out.println(organisation);

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
