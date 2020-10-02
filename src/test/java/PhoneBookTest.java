import contact.PhoneBook;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class PhoneBookTest {
    @Test
    public void addTest(){
    //GIVEN
        ArrayList<String> numberList = new ArrayList<String>();
        numberList.add("302-432-2434");

        Map<String, List<String>> phoneBookMap = new HashMap();
        phoneBookMap.put("Sarah", numberList);

        PhoneBook phoneBook = new PhoneBook(phoneBookMap);
        List<String> expected = numberList;
        List<String> actual = phoneBook.lookup("Sarah");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addAllTest(){
        ArrayList<String> phoneNumbers = new ArrayList<String>();
        phoneNumbers.add("302-342-4234");
        phoneNumbers.add("454-432-4324");
        phoneNumbers.add("656-343-4342");

        Map<String, List<String>> phoneBookMap = new HashMap();
        phoneBookMap.put("Cindy", new ArrayList<String>());
        PhoneBook phoneBook = new PhoneBook(phoneBookMap);

        Assert.assertEquals(0, phoneBook.lookup("Cindy").size());

        phoneBook.addAll("Cindy", phoneNumbers.toArray(new String[0]));

        List<String> expected = phoneNumbers;
        List<String> actual = phoneBook.lookup("Cindy");

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void hasEntryTest(){
        ArrayList<String> numberOfPerson = new ArrayList<String>();
        numberOfPerson.add("302-342-4234");

        Map<String, List<String>> phoneBookMap = new HashMap( );
        phoneBookMap.put("joe", numberOfPerson);
        PhoneBook phoneBook = new PhoneBook(phoneBookMap);

        Assert.assertTrue(phoneBook.hasEntry("joe"));
        Assert.assertFalse(phoneBook.hasEntry("Cindy")); //test as much as possible to be wrong
    }

    @Test
    public void lookUpTest(){
        ArrayList<String> listOfPhoneNumbers = new ArrayList<String>();
        listOfPhoneNumbers.add("202-751-5934");
        listOfPhoneNumbers.add("302-563-5466");
        Map<String, List<String>> phoneBookMap = new HashMap( );
        phoneBookMap.put("joe", listOfPhoneNumbers);
        PhoneBook phoneBook = new PhoneBook(phoneBookMap);
        //WHEN
        //EXPECT THE LIST OF NUMBERS TO COME BACK
        //ACTUAL -- INVOKE THE LOOKUP METHOD ON THE OBJECT
    List<String> expected = listOfPhoneNumbers;
    List<String> actual = phoneBook.lookup("joe");
        //THEN ASSERT
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeTest(){
        //GIVEN
        ArrayList<String> listOfPhoneNumbers = new ArrayList<String>();
        listOfPhoneNumbers.add("202-751-5934");
        listOfPhoneNumbers.add("302-563-5466");
        Map<String, List<String>> phoneBookMap = new HashMap( );
        phoneBookMap.put("mike", listOfPhoneNumbers);
        PhoneBook phoneBook = new PhoneBook(phoneBookMap);

        //WHEN
        phoneBook.remove("mike");

        //THEN
        Assert.assertEquals(null, phoneBook.lookup("mike"));
    }
    @Test
    public void getAllContactsTest(){
        //given
        ArrayList<String> expectedContacts = new ArrayList<String>();
        expectedContacts.add("Cindy");
        expectedContacts.add("Sarah");
        expectedContacts.add("Java");

        Map<String, List<String>> phoneBookMap = new HashMap( );
        phoneBookMap.put("Cindy", Collections.singletonList("5643342223"));
        phoneBookMap.put("Java", Collections.singletonList("663454y5783657"));
        PhoneBook phoneBook = new PhoneBook(phoneBookMap);

        //WHEN
        Set<String> actualContacts = phoneBook.getAllContactNames();


        //THEN
        Assert.assertTrue(actualContacts.contains(expectedContacts.get(0)));
        Assert.assertFalse(actualContacts.contains(expectedContacts.get(1)));
        Assert.assertTrue(actualContacts.contains(expectedContacts.get(2)));
    }
 }

