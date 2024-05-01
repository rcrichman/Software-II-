package srcCode;

public class Contact {

    private int contact_id;

    private String contact_name;
    private String email;

    public Contact()
    {
        this.contact_name = "";
        this.contact_id = -1;
        this.email = "";

    }

    public Contact(String contact_name, String email)
    {
        this.contact_name = contact_name;
        this.email = email;
    }

    public int getContact_id() {
        return contact_id;
    }
    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }

    public String getContact_name() {
        return contact_name;
    }
    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
