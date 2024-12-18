package br.com.studies.array.rotatearray;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class MockData {

    public static Stream<Arguments> provideAdditionalTestCases() {
        return Stream.of(
            Arguments.of(new int[]{10, 20, 30, 40, 50, 60}, 2, new int[]{30, 40, 50, 60, 10, 20}),
            Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 8, new int[]{9, 10, 1, 2, 3, 4, 5, 6, 7, 8}),
            Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, 6, new int[]{1, 2, 3, 4, 5, 6}),
            Arguments.of(new int[]{6, 7, 8, 9, 10}, 3, new int[]{9, 10, 6, 7, 8})
        );
    }

}
