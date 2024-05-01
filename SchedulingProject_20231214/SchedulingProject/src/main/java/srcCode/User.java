package srcCode;

public class User {
    private int user_id;

    private String user_name;

    private String password;
    private String create_date;
    private String created_by;
    private String last_update;
    private String last_updated_by;


    public  User()
    {
        this.user_id = -1;
        this.user_name = "";
        this.password = "";
        this.create_date = "";
        this.created_by = "";
        this.last_update = "";
        this.last_updated_by = "";
    }
    public  User(String user_name, String password, String create_date, String created_by, String last_update, String last_updated_by)
    {

        this.user_name = user_name;
        this.password = password;
        this.create_date = create_date;
        this.created_by = created_by;
        this.last_update = last_update;
        this.last_updated_by = last_updated_by;
    }

    /**
     * @return the id
     */
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_name_code() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
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
