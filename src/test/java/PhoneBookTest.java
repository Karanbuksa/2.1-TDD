import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class PhoneBookTest {
    static PhoneBook phoneBook = new PhoneBook();

    //  Немного изменил первый тест. Думаю, ничего критичного. Он проходил до изменения, проходит и после
    @ParameterizedTest
    @MethodSource
    void add_Test(String name, String phoneNumber, int expected) {
        assertThat(phoneBook.add(name, phoneNumber), equalTo(expected));
    }

    private static Stream<Arguments> add_Test() {
        return Stream.of(
                Arguments.of("Alex", "+3754764180", 1),
                Arguments.of("Jane", "+854213054", 2),
                Arguments.of("Ricardo", "88005553535", 3)
        );
    }

    @ParameterizedTest
    @MethodSource
    void findByNumber_Test(String number, String expected) {
        assertThat(phoneBook.findByNumber(number), equalTo(expected));
    }

    private static Stream<Arguments> findByNumber_Test() {
        return Stream.of(
                Arguments.of("+3754764180", "Alex"),
                Arguments.of("+854213054", "Jane"),
                Arguments.of("88005553535", "Ricardo")
        );
    }
}

