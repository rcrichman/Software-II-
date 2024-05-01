package srcCode;

/**
 * Supplied class Division.java
 */

/**
 *
 * @author Russell Richman
 */
public class Division
{
    private int division_id;
    private int country_id;
    private String division;
    private String create_date;
    private String created_by;
    private String last_update;
    private String last_updated_by;
    public Division()
    {
        this.division_id = -1;
        this.country_id = -1;
        this.division = "";
        this.create_date = "";
        this.created_by = "";
        this.last_update = "";
        this.last_updated_by = "";
    }
    public Division(int division_id, int country_id, String division,
                    String create_date, String created_by, String last_update, String last_updated_by)
    {

        this.division_id = division_id;
        this.country_id = country_id;
        this.division = division;
        this.create_date = create_date;
        this.created_by = created_by;
        this.last_update = last_update;
        this.last_updated_by = last_updated_by;
    }

    /**
     * @return the id
     */
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

    public String getDivision() {
        return division;
    }
    public void setDivision(String division) {
        this.division = division;
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