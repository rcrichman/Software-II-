package srcCode;

/**
 * Supplied class Customer.java
 */

import java.time.LocalDate;

/**
 *
 * @author Russell Richman
 */
public class Appointment
{
    private int appointment_id;
    private int user_id;

    private int contact_id;
    private int customer_id;

    private String title;

    private String description;
    private String location;
    private String contact;
    private String type;
    private String startDate;
    private String endDate;
    private String create_date;
    private String created_by;
    private String last_update;
    private String last_updated_by;


    public Appointment()
    {
        this.appointment_id = -1;
        this.user_id = -1;
        this.contact_id = -1;
        this.customer_id = -1;
        this.title = "";
        this.description = "";
        this.location = "";
        this.contact = "";
        this.type = "";
        this.startDate = null;
        this.endDate = "";
        this.create_date = "";
        this.created_by = "";
        this.last_update = "";
        this.last_updated_by = "";

    }
    public Appointment(String title, String description, String location, String contact,
                       int user_id, int contact_id, int customer_id, String type, String startDate, String endDate,
                        String create_date, String created_by, String last_update, String last_updated_by)

    {

        this.title = title;
        this.description = description;
        this.location = location;
        this.contact = contact;
        this.create_date = create_date;
        this.created_by = created_by;
        this.last_update = last_update;
        this.last_updated_by = last_updated_by;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.user_id = user_id;
        this.contact_id = contact_id;
        this.customer_id = customer_id;
    }

    /**
     * @return the id
     */
    public int getAppointment_id() {
        return appointment_id;
    }
    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
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

    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getContact_id() {
        return contact_id;
    }
    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getStartDateOnly()
    {
        String[] startDateRay = startDate.split(" ");
        return startDateRay[0];
    }
    public String getStartTimeOnly()
    {
        String[] startDateRay = startDate.split(" ");
        return startDateRay[1] + " " + startDateRay[2];
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDateOnly()
    {
        String[] endDateRay = endDate.split(" ");
        return endDateRay[0];
    }
    public String getEndTimeOnly()
    {
        String[] endDateRay = endDate.split(" ");
        return endDateRay[1] + " " + endDateRay[2];
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}