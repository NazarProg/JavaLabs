import DB.DBConnection;
import Model.*;
import Serialize.JsonSerialize;
import Serialize.TxtSerialize;
import Serialize.XmlSerialize;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

public class Main {
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
