import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private static final Map<String, String> phoneBook = new HashMap<>();

    public  int add(String name, String phoneNumber) {
        phoneBook.put(name, phoneNumber);
        return phoneBook.size();
    }

    public  String findByNumber(String number){
        return null;
    }
}
