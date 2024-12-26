package br.com.studies.array.stock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class MultipleTransactionBestSolutionUseCaseTest {

    FinancialOperation financialOperation;
    FinancialOperation financialOperationBestSolution;

    @BeforeEach
    void init() {

        financialOperation = new MultipleTransactionAllowedUseCase();
        financialOperationBestSolution = new MultipleTransactionBestSolutionUseCase();

    }

    @ParameterizedTest
    @MethodSource("br.com.studies.array.stock.MockData#provideAdditionalTestCases")
    @DisplayName("should calculate the maximum profit in multiple operations")
    void maximumProfit(int[] prices) {

        assertEquals(
            financialOperationBestSolution.maximumProfit(prices),
            financialOperation.maximumProfit(prices)
        );

    }

}