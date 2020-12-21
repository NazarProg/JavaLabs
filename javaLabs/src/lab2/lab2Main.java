package lab2;

import Model.*;
import Serialize.JsonSerialize;
import Serialize.TxtSerialize;
import Serialize.XmlSerialize;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class lab2Main {
    public static void main(String[] args) {
        Organisation organisation = generateOrganisation();
        System.out.println("=======================================Serialize======================================");
        System.out.println("JSON serialize:");
        JsonSerialize jsonSerialize = new JsonSerialize();
        try {
            jsonSerialize.serialize(organisation, "organisation.json");
            Organisation organisation1 = jsonSerialize.deserialize("organisation.json");
            System.out.println(organisation1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("XML serialize:");
        XmlSerialize xmlSerialize = new XmlSerialize();
        try {
            xmlSerialize.serialize(organisation, "organisation.xml");
            Organisation organisation2 = xmlSerialize.deserialize("organisation.xml");
            System.out.println(organisation2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Txt serialize:");
        TxtSerialize txtSerialize = new TxtSerialize();
        try {
            txtSerialize.serialize(organisation, "organisation.txt");
            Organisation organisation3 = txtSerialize.deserialize("organisation.txt");
            System.out.println(organisation3);
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
