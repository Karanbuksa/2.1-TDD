import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class PhoneBookTest {
    @ParameterizedTest
    @MethodSource
    void add_Test(String name, String phoneNumber, int expected) {
        PhoneBook.add(name, phoneNumber);
        assertThat(PhoneBook.add(name, phoneNumber), equalTo(expected));
    }

    private static Stream<Arguments> add_Test() {
        return Stream.of(
                Arguments.of("Alex", "+3754764180", 1),
                Arguments.of("Jane", "+854213054", 2),
                Arguments.of("Ricardo", "88005553535", 3)
                );
    }
}

