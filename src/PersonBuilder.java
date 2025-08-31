public class PersonBuilder {
    protected String name = null;
    protected String surname = null;
    protected Integer age = null;
    protected String address = null;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    // Возраст ребенка не может быть отрицательный. Но может и не доходить не единицы(например, 1 месячный ребенок)
    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid age value: " + age + ". Age cannot be negative.");
        }

        this.age = age;
        return this;
    }

    public Person build() throws IllegalArgumentException {
        if (name == null) {
            throw new IllegalArgumentException("Invalid name value: " + name + ". Name must be provided.");
        }
        if (surname == null) {
            throw new IllegalArgumentException("Invalid surname value: " + surname + ". Surname must be provided.");
        }

        return new Person(name, surname, age, address);
    }
}
