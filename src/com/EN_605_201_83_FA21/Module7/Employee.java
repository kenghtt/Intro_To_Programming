
class Employee {
    private int id;
    private Name name;
    private Address address;
    private Date date;

    Employee(Name name, Address address, Date date, int id) {

        this.name = name;
        this.address = address;
        this.date = date;
        this.id = id;
    }

    String getName() {
        return this.name.getName();
    }

    String getAddress() {
        return this.address.getAddress();
    }

    String getDate() {
        return this.date.getDate();
    }

    int getId(){
        return this.id;
    }


}

class Name {
    private String firstName;
    private String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getName() {
        return firstName + " " + lastName;
    }
}

class Address {
    private String street;
    private String city;
    private String state;
    private int zipCode;

    public Address(String street, String city, String state, int zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return street + " " + city + " " + state + ", " + zipCode;
    }
}

class Date {
    private int month;
    private int day;
    private int year;

    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public String getDate() {
        return month + "/" + day + "/" + year;
    }
}
