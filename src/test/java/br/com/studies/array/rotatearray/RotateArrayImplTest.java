package br.com.studies.array.rotatearray;

import br.com.studies.array.moveallzerostoend.approach.FirstApproach;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RotateArrayImplTest {

    private RotateArray rotateArray;

    @BeforeEach
    public void init() {
        rotateArray = new RotateArrayImpl();
    }

    @ParameterizedTest
    @MethodSource("br.com.studies.array.rotatearray.MockData#provideAdditionalTestCases")
    @DisplayName("Should rotate arrays")
    void shouldRotateArrays(int[] arr, int d, int[] expectedResult) {

        rotateArray.rotateArr(arr, d);

        assertArrayEquals(
            expectedResult,
            arr,
            () -> "Process result: \n" + Arrays.toString(arr) + " \n" + Arrays.toString(expectedResult)
        );

    }

}