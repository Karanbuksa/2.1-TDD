import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class PhoneBookTest {
    static PhoneBook phoneBook = new PhoneBook();

    //Опять переделываю тест, потому что ранее без первого теста не проходили бы последующие
    @BeforeAll
    static void start() {
        phoneBook.add("Dan", "+3756781230");
        phoneBook.add("Cole", "+89049844126");
        phoneBook.add("Bill", "89501946668");
    }

    //  Немного изменил первый тест. Думаю, ничего критичного. Он проходил до изменения, проходит и после
    @ParameterizedTest
    @MethodSource
    void add_Test(String name, String phoneNumber, int expected) {
        assertThat(phoneBook.add(name, phoneNumber), equalTo(expected));
    }

    private static Stream<Arguments> add_Test() {
        return Stream.of(
                Arguments.of("Alex", "+3754764180", 4),
                Arguments.of("Jane", "+854213054", 5),
                Arguments.of("Ricardo", "88005553535", 6)
        );
    }


    @ParameterizedTest
    @MethodSource
    void findByNumber_Test(String expected, String number) {
        assertThat(phoneBook.findByNumber(number), equalTo(expected));
    }

    private static Stream<Arguments> findByNumber_Test() {
        return Stream.of(
                Arguments.of("Dan", "+3756781230"),
                Arguments.of("Cole", "+89049844126"),
                Arguments.of("Bill", "89501946668"),
                Arguments.of(null, "547")
        );
    }
}

