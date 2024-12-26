package br.com.studies.array.moveallzerostoend;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class MockData {

    public static Stream<Arguments> provideArraysForTesting() {
        return Stream.of(
            Arguments.of(new int[]{}, new int[]{}),
            Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 3}),
            Arguments.of(new int[]{0, 0, 0}, new int[]{0, 0, 0}),
            Arguments.of(new int[]{0, 1, 0, 2, 3}, new int[]{1, 2, 3, 0, 0}),
            Arguments.of(new int[]{1, 2, 3, 0, 0}, new int[]{1, 2, 3, 0, 0}),
            Arguments.of(new int[]{0, 1, 0, 2, 0, 3, 0}, new int[]{1, 2, 3, 0, 0, 0, 0}),
            Arguments.of(new int[]{1, 0, 0, 2, 0, 3, 4}, new int[]{1, 2, 3, 4, 0, 0, 0})
        );
    }

    public static Stream<Arguments> provideLargeArraysForPerformanceTest() {
        int[] largeArray = new int[1000000];
        for (int i = 0; i < 500000; i++) {
            largeArray[i] = i % 2 == 0 ? 1 : 0; // Intercalando zeros e uns
        }
        int[] expected = new int[1000000];
        for (int i = 0; i < 250000; i++) {
            expected[i] = 1; // Todos os 1s no início
        }

        return Stream.of(Arguments.of(largeArray, expected));
    }

}
