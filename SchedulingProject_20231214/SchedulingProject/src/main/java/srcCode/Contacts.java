package srcCode;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Contacts {
    private ObservableList<Contact> allContacts;
    private ObservableList<String> allContactNames;
    private Integer contactID;

    public Contacts()
    {
        contactID = 0;
        allContacts = FXCollections.observableArrayList();
        allContactNames = FXCollections.observableArrayList();
    }

    public void AddContact(Contact newContact)
    {
        contactID++;
        newContact.setContact_id(contactID);
        allContacts.add(newContact);
        allContactNames.add(newContact.getContact_name());
    }
    public void UpdateContact(Contact originalContact, Contact updatedContact)
    {
        allContacts.remove(originalContact);
        allContacts.add(updatedContact);
    }
    public void RemoveContact(Contact removedContact)
    {
        allContacts.remove(removedContact);
    }
    public ObservableList<Contact> getAllContacts()
    {
        return allContacts;
    }
    public ObservableList<String> getAllContactNames()
    {
        return allContactNames;
    }
    public Integer getNumContacts()
    {
        return allContacts.size();
    }

    public String getContactNameById(int id)
    {
        AtomicReference<String> contactName = new AtomicReference<>("");
        allContacts.forEach((contact) -> {
            if (contact.getContact_id() == id)
            {
                contactName.set(contact.getContact_name());
            }
        });

        return contactName.get();
    }

    public int GetContactID(String sContactName)
    {
        AtomicInteger iContactID = new AtomicInteger(-1);
        allContacts.forEach((contact) -> {
            if (contact.getContact_name() == sContactName)
            {
                iContactID.set(contact.getContact_id());
            }
        });

        return iContactID.get();

    }
}
