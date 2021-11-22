/**
 * This is the Object used to contain information for a contact.
 */
public class Contact {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    /**
     * @param firstName   This is the first name of the contact
     * @param lasName     This is the last name of the contact
     * @param phoneNumber This is the phone number of the contact
     * @param email       This is the email of the contact
     */
    public Contact(String firstName, String lasName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lasName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    //    Below are the getters for each Contact Attribute
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

}
