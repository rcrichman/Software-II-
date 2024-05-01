package srcCode;

/**
 * Supplied class Customer.java
 */

/**
 *
 * @author Russell Richman
 */
public class Customer
{
    private int customer_id;
    private int division_id;

    private int country_id;

    private String division_name;

    private String country_name;
    private String customer_name;
    private String address;
    private String postal_code;
    private String phone;
    private String create_date;
    private String created_by;
    private String last_update;
    private String last_updated_by;


    public  Customer()
    {
        this.customer_id = -1;
        this.customer_name = "";
        this.address = "";
        this.postal_code = "";
        this.phone = "";
        this.create_date = "";
        this.created_by = "";
        this.last_update = "";
        this.last_updated_by = "";
        this.division_id = -1;
        this.country_id = -1;
        this.country_name = "";
        this.division_name = "";
    }
    public  Customer(String customer_name, String address, String postal_code, String phone,
                    String create_date, String created_by, String last_update, String last_updated_by,
                     int division_id, int country_id, String division_name, String country_name)
    {

        this.customer_name = customer_name;
        this.address = address;
        this.postal_code = postal_code;
        this.phone = phone;
        this.create_date = create_date;
        this.created_by = created_by;
        this.last_update = last_update;
        this.last_updated_by = last_updated_by;
        this.division_id = division_id;
        this.country_id = country_id;
        this.division_name = division_name;
        this.country_name = country_name;
    }

    /**
     * @return the id
     */
    public int getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }
    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostal_code() {
        return postal_code;
    }
    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreate_date() {
        return create_date;
    }
    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getCreated_by() {
        return created_by;
    }
    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getLast_update() {
        return last_update;
    }
    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public String getLast_updated_by() {
        return last_updated_by;
    }
    public void setLast_updated_by(String last_updated_by) {
        this.last_updated_by = last_updated_by;
    }

    public int getDivision_id() {
        return division_id;
    }
    public void setDivision_id(int division_id) {
        this.division_id = division_id;
    }

    public int getCountry_id() {
    return country_id;
}
    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getDivision_name() {
        return division_name;
    }
    public void setDivision_name(String division_name) {
        this.division_name = division_name;
    }

    public String getCountry_name() {
        return country_name;
    }
    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }
}