package br.com.studies.moveallzerostoend.approach;

import br.com.studies.array.moveallzerostoend.approach.FirstApproach;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FirstApproachTest {

    FirstApproach firstApproach;
    MeterRegistry meterRegistry;

    @BeforeEach
    public void init() {

        firstApproach = new FirstApproach();
        meterRegistry = new SimpleMeterRegistry();

    }

    @ParameterizedTest
    @MethodSource("br.com.studies.moveallzerostoend.approach.MockData#provideArraysForTesting")
    @DisplayName("Should move zeros to end")
    void shouldMoveZeroToEnd(int[] arr, int[] expected) {

        firstApproach.pushZerosToEnd(arr);
        assertArrayEquals(expected, arr,
            () -> "O array esperado era " + Arrays.toString(expected) +
                " mas obteve " + Arrays.toString(arr));

    }

    @ParameterizedTest
    @MethodSource("br.com.studies.moveallzerostoend.approach.MockData#provideLargeArraysForPerformanceTest")
    void testLargeArray(int[] input, int[] expected) {

        Timer timer = Timer.builder("pushZerosToEnd")
            .publishPercentileHistogram()
            .register(meterRegistry);

        timer.record(() -> firstApproach.pushZerosToEnd(input));

        double executionTime = timer.totalTime(TimeUnit.MILLISECONDS);
        System.out.println("Execution time (ms): " + executionTime);

        assertArrayEquals(expected, input);

    }

}