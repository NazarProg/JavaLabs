package lab4;

import Model.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class lab4Main {
    public static void main(String[] args) {
        System.out.println("======================================Validation======================================");
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        System.out.println("Model.Person:");
        Person person = new Person();
        if (validator.validate(person).size() > 0)
            for (ConstraintViolation<Person> string : validator.validate(person))
                System.out.println(string);
        else
            System.out.println(person);
        System.out.println("Model.Person:");
        Person person1 = generatePerson();
        if (validator.validate(person1).size() > 0)
            for (ConstraintViolation<Person> string : validator.validate(person1))
                System.out.println(string);
        else
            System.out.println(person1);

        System.out.println("======================================================================================");

        System.out.println("Model.Address:");
        Address address = generateAddress();
        if (validator.validate(address).size() > 0)
            for (ConstraintViolation<Address> string : validator.validate(address))
                System.out.println(string);
        else
            System.out.println(address);

        System.out.println("Model.Address:");
        Address address1 = new Address();
        if (validator.validate(address1).size() > 0)
            for (ConstraintViolation<Address> string : validator.validate(address1))
                System.out.println(string);
        else
            System.out.println(address1);

        System.out.println("======================================================================================");

        System.out.println("Model.Contact:");
        Contact contact = generateContact();
        if (validator.validate(contact).size() > 0)
            for (ConstraintViolation<Contact> string : validator.validate(contact))
                System.out.println(string);
        else
            System.out.println(contact);

        System.out.println("Model.Contact:");
        Contact contact1 = new Contact();
        if (validator.validate(contact1).size() > 0)
            for (ConstraintViolation<Contact> string : validator.validate(contact1))
                System.out.println(string);
        else
            System.out.println(contact1);

        System.out.println("======================================================================================");

        System.out.println("Model.Organisation:");
        Organisation organisation = generateOrganisation();
        if (validator.validate(organisation).size() > 0)
            for (ConstraintViolation<Organisation> string : validator.validate(organisation))
                System.out.println(string);
        else
            System.out.println(organisation);

        System.out.println("Model.Organisation:");
        Organisation organisation1 = new Organisation();
        if (validator.validate(organisation1).size() > 0)
            for (ConstraintViolation<Organisation> string : validator.validate(organisation1))
                System.out.println(string);
        else
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
