import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PhoneBook {
    private static final Map<String, String> phoneBook = new HashMap<>();

    public int add(String name, String phoneNumber) {
        phoneBook.put(name, phoneNumber);
        return phoneBook.size();
    }

    public String findByNumber(String number) {
        List<Map.Entry<String, String>> entryList = phoneBook.entrySet()
                .stream()
                .filter(x -> Objects.equals(x.getValue(), number))
                .toList();
        if (!entryList.isEmpty()) {
            return entryList.get(0).getKey();
        } else return null;

    }
public String findByName(String name){
        return null;
    }
}
