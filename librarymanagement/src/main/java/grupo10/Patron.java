public class Patron {
    private String name;
    private String contactInfo;

    public Patron(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }

    // Getters e setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getContactInfo() { return contactInfo; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }
}
