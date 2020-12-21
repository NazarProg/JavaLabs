package lab4.Classes;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Address implements Comparable<Address> {
    /**
     * Класс адрес
     */
    @NotNull(message = "Country cannot be null")
    private String country;
    @NotNull(message = "Region cannot be null")
    private String region;
    @NotNull(message = "City cannot be null")
    private String city;
    @NotNull(message = "Street cannot be null")
    private String street;
    @Min(value = 1, message = "House number should not be less than 1")
    private Integer house;

    @Override
    public int compareTo(Address o) {
        if (this.country.compareTo(o.getCountry()) != 0)
            return this.country.compareTo(o.country);
        if (this.region.compareTo(o.region) != 0)
            return this.region.compareTo(o.region);
        if (this.city.compareTo(o.getCity()) != 0)
            return this.city.compareTo(o.getCity());
        if (this.street.compareTo(o.getStreet()) != 0)
            return this.street.compareTo(o.getStreet());
        if (this.house.compareTo(o.getHouse()) != 0)
            return this.house.compareTo(o.getHouse());
        return 0;
    }

    public static class Builder {
        private Address newAddress;

        public Builder() {
            newAddress = new Address();
        }

        public Builder withCountry(String country){
            newAddress.setCountry(country);
            return this;
        }

        public Builder withRegion(String region){
            newAddress.setRegion(region);
            return this;
        }

        public Builder withCity(String city){
            newAddress.setCity(city);
            return this;
        }

        public Builder withStreet(String street){
            newAddress.setStreet(street);
            return this;
        }

        public Builder withHouse(Integer house){
            newAddress.setHouse(house);
            return this;
        }

        public Address build(){
            return newAddress;
        }
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return "Model.Address{" +
                "country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(country, address.country) &&
                Objects.equals(region, address.region) &&
                Objects.equals(city, address.city) &&
                Objects.equals(street, address.street) &&
                Objects.equals(house, address.house);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, region, city, street, house);
    }
}
