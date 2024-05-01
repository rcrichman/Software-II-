package srcCode;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

public class Users {

    private ObservableList<User> allUsers;
    private Integer UserID;

    public Users()
    {
        UserID = 0;
        allUsers = FXCollections.observableArrayList();
    }

    public void AddUser(User newUser)
    {
        UserID++;
        newUser.setUser_id(UserID);
        allUsers.add(newUser);
    }
    public void UpdateUser(User originalUser, User updatedUser)
    {
        allUsers.remove(originalUser);
        allUsers.add(updatedUser);
    }
    public void RemoveUser(User removedUser)
    {
        allUsers.remove(removedUser);
    }
    public ObservableList<User> getAllUsers()
    {
        return allUsers;
    }
    public Integer getNumUsers()
    {
        return allUsers.size();
    }
}
