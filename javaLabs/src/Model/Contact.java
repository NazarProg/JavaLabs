package Model;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Contact implements Comparable<Contact> {
    /**
     * Класс контакт
     */
    @NotNull(message = "Contact value cannot be null")
    private String value;
    @NotNull(message = "Person cannot be null")
    private Person person;

    @Override
    public int compareTo(Contact o) {
        if (this.value.compareTo(o.getValue()) != 0)
            return this.value.compareTo(o.getValue());
        if (this.person.compareTo(o.getPerson()) != 0)
            return this.person.compareTo(o.getPerson());
        return 0;
    }

    public static class Builder {
        private Contact newContact;

        public Builder() {
            newContact = new Contact();
        }

        public Builder withValue(String value) {
            newContact.setValue(value);
            return this;
        }

        public Builder withPerson(Person person) {
            newContact.setPerson(person);
            return this;
        }

        public Contact build() {
            return newContact;
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Model.Contact{" +
                "value='" + value + '\'' +
                ", person=" + person +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(value, contact.value) &&
                Objects.equals(person, contact.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, person);
    }
}
