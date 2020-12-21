package lab4.Classes;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Organisation implements Comparable<Organisation>{
    /**
     * Класс організація
     */
    @NotNull(message = "Name cannot be null")
    private String organisationName;
    @NotNull(message = "People cannot be null")
    private ArrayList<Person> people;
    @NotNull(message = "Creation Date cannot be null")
    private Date creationDate;
    @NotNull(message = "SportType cannot be null")
    private SportType sportType;
    @NotNull(message = "Active cannot be null")
    private Boolean active;
    @NotNull(message = "Address cannot be null")
    private Address address;
    @NotNull(message = "Contact cannot be null")
    private Contact contact;

    @Override
    public int compareTo(Organisation o) {
        if (this.organisationName.compareTo(o.getOrganisationName()) != 0)
            return this.organisationName.compareTo(o.getOrganisationName());
        if (this.active.compareTo(o.getActive()) != 0)
            return this.active.compareTo(o.getActive());
        if (this.creationDate.compareTo(o.getCreationDate()) != 0)
            return this.creationDate.compareTo(o.getCreationDate());
        if (this.address.compareTo(o.getAddress()) != 0)
            return this.address.compareTo(o.getAddress());
        if (this.contact.compareTo(o.getContact()) != 0)
            return this.contact.compareTo(o.getContact());
        return 0;
    }

    public static class Builder {
        private Organisation newOrganisation;

        public Builder() {
            newOrganisation = new Organisation();
        }

        public Builder withOrganisationName(String organisationName){
            newOrganisation.setOrganisationName(organisationName);
            return this;
        }

        public Builder withPeople(ArrayList<Person> people){
            newOrganisation.setPeople(people);
            return this;
        }

        public Builder withCreationDate(Date creationDate){
            newOrganisation.setCreationDate(creationDate);
            return this;
        }

        public Builder withSportType(SportType sportType){
            newOrganisation.setSportType(sportType);
            return this;
        }

        public Builder withActive(Boolean active){
            newOrganisation.setActive(active);
            return this;
        }

        public Builder withAddress(Address address){
            newOrganisation.setAddress(address);
            return this;
        }

        public Builder withContact(Contact contact){
            newOrganisation.setContact(contact);
            return this;
        }

        public Organisation build(){
            return newOrganisation;
        }
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public SportType getSportType() {
        return sportType;
    }

    public void setSportType(SportType sportType) {
        this.sportType = sportType;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Model.Organisation{" +
                "organisationName='" + organisationName + '\'' +
                ", people=" + people +
                ", creationDate=" + creationDate +
                ", sportType=" + sportType +
                ", active=" + active +
                ", address=" + address +
                ", contact=" + contact +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organisation that = (Organisation) o;
        return Objects.equals(organisationName, that.organisationName) &&
                Objects.equals(people, that.people) &&
                Objects.equals(creationDate, that.creationDate) &&
                sportType == that.sportType &&
                Objects.equals(active, that.active) &&
                Objects.equals(address, that.address) &&
                Objects.equals(contact, that.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organisationName, people, creationDate, sportType, active, address, contact);
    }
}
