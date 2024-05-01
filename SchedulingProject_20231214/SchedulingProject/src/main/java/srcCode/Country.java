package srcCode;

/**
 * Supplied class Country.java
 */

/**
 *
 * @author Russell Richman
 */
public class Country
{
    private int country_id;
    private String country;

    private String create_date;
    private String created_by;
    private String last_update;
    private String last_updated_by;
    public Country()
    {
        this.country_id = -1;
        this.country = "";
        this.create_date = "";
        this.created_by = "";
        this.last_update = "";
        this.last_updated_by = "";
    }
    public Country(int country_id, String country, String create_date, String created_by,
                   String last_update, String last_updated_by)
    {
        this.country_id = country_id;
        this.country = country;
        this.create_date = create_date;
        this.created_by = created_by;
        this.last_update = last_update;
        this.last_updated_by = last_updated_by;
    }

    /**
     * @return the id
     */
    public int getCountry_id() {
        return country_id;
    }
    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
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

}