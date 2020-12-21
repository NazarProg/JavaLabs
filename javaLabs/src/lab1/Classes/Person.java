package lab1.Classes;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Person implements Comparable<Person> {
    /**
     * Класс людина
     */
    @NotNull(message = "Name cannot be null")
    private String name;
    @NotNull(message = "Surname cannot be null")
    private String surname;
    @NotNull(message = "FatherName cannot be null")
    private String fatherName;
    @Min(value = 0, message = "Age should not be less than 0")
    @Max(value = 150, message = "Age should not be greater than 150")
    private Integer age;
    @Min(value = 10, message = "Height should not be less than 10")
    @Max(value = 350, message = "Height should not be greater than 350")
    private Integer height;
    @Min(value = 1, message = "Weight should not be less than 1")
    @Max(value = 1000, message = "Weight should not be greater than 1000")
    private Integer weight;
    @NotNull(message = "Qualification cannot be null")
    private Qualification qualification;

    @Override
    public int compareTo(Person o) {
        if (this.surname.compareTo(o.getSurname()) != 0)
            return this.surname.compareTo(o.getSurname());
        if (this.name.compareTo(o.getName()) != 0)
            return this.name.compareTo(o.getName());
        if (this.fatherName.compareTo(o.getFatherName()) != 0)
            return this.fatherName.compareTo(o.getFatherName());
        if (this.age.compareTo(o.getAge()) != 0)
            return this.surname.compareTo(o.getSurname());
        return 0;
    }

    public static class Builder {
        private Person newPerson;

        public Builder() {
            newPerson = new Person();
        }

        public Builder withName(String name) {
            newPerson.setName(name);
            return this;
        }

        public Builder withSurname(String surname) {
            newPerson.setSurname(surname);
            return this;
        }

        public Builder withFatherName(String fatherName) {
            newPerson.setFatherName(fatherName);
            return this;
        }

        public Builder withAge(Integer age) {
            newPerson.setAge(age);
            return this;
        }

        public Builder withHeight(Integer height) {
            newPerson.setHeight(height);
            return this;
        }

        public Builder withWeight(Integer weight) {
            newPerson.setWeight(weight);
            return this;
        }

        public Builder withQualification(Qualification qualification) {
            newPerson.setQualification(qualification);
            return this;
        }

        public Person build() {
            return newPerson;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    public void setQualification(String qualification) {
        for (Qualification qualification1 : Qualification.values())
            if (qualification1.toString().equals(qualification)) {
                this.qualification = qualification1;
                break;
            }
    }

    @Override
    public String toString() {
        return "Model.Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", qualification=" + qualification +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age.equals(person.age) &&
                height.equals(person.height) &&
                weight.equals(person.weight) &&
                Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(fatherName, person.fatherName) &&
                qualification == person.qualification;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, fatherName, age, height, weight, qualification);
    }
}
