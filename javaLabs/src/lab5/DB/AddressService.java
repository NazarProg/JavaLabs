package lab5.DB;

import Model.Address;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

class AddressService {

    private final Connection connection;

    AddressService(Connection connection) throws SQLException {
        this.connection = connection;
        Statement statement = connection.createStatement();
        statement.executeUpdate("CREATE  TABLE IF NOT EXISTS `organisation`.`address` (" +
                "  `address_id` INT NOT NULL," +
                "  `country` VARCHAR(50)," +
                "  `region` VARCHAR(50)," +
                "  `city` VARCHAR(50)," +
                "  `street` VARCHAR(50)," +
                "  `house` INT," +
                "  PRIMARY KEY (`address_id`) )");
    }

    ArrayList<Address> getAddresses() throws SQLException {
        ArrayList<Address> addresses = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet set = statement.executeQuery("SELECT * FROM `organisation`.`address`");

        while (set.next()) {
            Address address = new Address.Builder()
                    .withCountry(set.getString("country"))
                    .withRegion(set.getString("region"))
                    .withCity(set.getString("city"))
                    .withStreet(set.getString("street"))
                    .withHouse(set.getInt("house"))
                    .build();
            addresses.add(address);
        }

        return addresses;
    }

    void insertAddress(Address address) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet set = statement.executeQuery("SELECT * FROM `organisation`.`address`");
        int idAddress = 0;
        while (set.next()) {
            ++idAddress;
        }
        ++idAddress;
        String sql = "INSERT INTO `organisation`.`address`" +
                " ( `address_id`, `country` , `region`, `city`, `street`, `house` ) " +
                "VALUES " +
                "('" + idAddress + "', '" + address.getCountry() + "', '" + address.getRegion() +
                "', '" + address.getCity() + "', '" + address.getStreet() + "', '" + address.getHouse() + "')";
        statement.executeUpdate(sql);
    }

    void clearAddress() throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("truncate table `organisation`.`address`");
    }
}
