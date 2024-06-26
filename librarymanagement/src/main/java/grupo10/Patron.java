package grupo10;
/**
 * Represents a patron of the library.
 * A patron has a name and an contact.
 */
public class Patron {
    private String name;
    private String contactInfo;
    /**
     * Constructs a new Patron with the specified name and ID.
     */
    public Patron(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }

    /**
     * Gets the name of the patron.
     */
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    /**
     * Gets the contact of the patron.
     */
    public String getContactInfo() { return contactInfo; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }
}
