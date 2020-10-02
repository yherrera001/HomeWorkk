package contact;

import java.util.*;

public class PhoneBook {
    //holds names and phoneNumbers

    private Map<String, List<String>> phoneBook;

    public PhoneBook(Map<String, List<String>> phoneBook) {
        this.phoneBook = phoneBook;
    }

    public void add(String name, String phoneNumber){
        //we should check if the name exist else we put it there with a name
    if(phoneBook.containsKey(name)){ //if whatever the name is in the book then return true
        phoneBook.get(name).add(phoneNumber);
        } else{
        phoneBook.put(name, new ArrayList<String>());
        add(name, phoneNumber);
        }
    }
    //ADD ALL
    public void addAll(String name, String ... phoneNumbers){
        phoneBook.put(name, Arrays.asList(phoneNumbers));
    }

    //REMOVE
    public void remove(String name){
        phoneBook.remove(name);
    }

    //HASENTRY
    public boolean hasEntry(String name) {
        return phoneBook.containsKey(name);
    }

    //LOOKUP
    public List<String> lookup(String name){
    return phoneBook.get(name);
    }

    //GET ALL CONTACT NAMES
    public Set<String> getAllContactNames(){
        return phoneBook.keySet();
    }

}
