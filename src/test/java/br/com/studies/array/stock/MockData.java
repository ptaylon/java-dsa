package br.com.studies.array.stock;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class MockData {

    public static Stream<Arguments> provideAdditionalTestCases() {
        return Stream.of(
            Arguments.of(new int[]{10, 20, 30, 40, 50, 60}),
            Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}),
            Arguments.of(new int[]{1, 2, 3, 4, 5, 6}),
            Arguments.of(new int[]{6, 7, 8, 9, 10}),
            Arguments.of(new int[] {100, 180, 260, 310, 40, 535, 695}),
            Arguments.of(new int[] {4, 2, 2, 2, 4}),
            Arguments.of(new int[] {57, 94, 87, 60, 89, 82, 35, 90, 86, 24, 77, 38, 24, 23, 72, 59})
        );
    }

}