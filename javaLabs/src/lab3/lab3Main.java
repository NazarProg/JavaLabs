package lab3;

import Model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

public class lab3Main {
    public static void main(String[] args) {
        System.out.println("=====================================Collections======================================");
        ArrayList<Organisation> organisations = new ArrayList<>();

        organisations.add(generateOrganisation());
        organisations.add(generateOrganisation());
        organisations.get(1).setActive(false);
        organisations.add(generateOrganisation());
        organisations.get(2).setOrganisationName("some name");
        organisations.add(generateOrganisation());
        organisations.get(3).getAddress().setCity("some city");
        organisations.add(generateOrganisation());
        organisations.get(4).getContact().setValue("number");
        organisations.add(generateOrganisation());

        for (Organisation organisation1 : organisations)
            System.out.println(organisation1);

        Collections.sort(organisations);
        System.out.println();

        for (Organisation organisation1 : organisations)
            System.out.println(organisation1);

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
