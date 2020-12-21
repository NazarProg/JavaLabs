package lab5.DB;

import Model.Address;
import Model.Person;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConnection {

    private Connection connection;
    private final AddressService addressService;
    private final PersonService personService;

    public DBConnection() throws SQLException {
        connection = DBConnect.getConnect();
        Statement statement = connection.createStatement();
        statement.executeUpdate("CREATE DATABASE IF NOT EXISTS organisation;");

        addressService = new AddressService(connection);
        personService = new PersonService(connection);
    }

    public ArrayList<Address> getAddresses() throws SQLException {
        return addressService.getAddresses();
    }

    public void insertAddress(Address address) throws SQLException {
        addressService.insertAddress(address);
    }

    public void clearAddress() throws SQLException {
        addressService.clearAddress();
    }

    public ArrayList<Person> getPeople() throws SQLException {
        return personService.getPeople();
    }

    public void insertPerson(Person person) throws SQLException {
        personService.insertPerson(person);
    }

    public void clearPerson() throws SQLException {
        personService.clearPerson();
    }

}
