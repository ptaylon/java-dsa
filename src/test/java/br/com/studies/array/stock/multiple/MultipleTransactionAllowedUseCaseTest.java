package br.com.studies.array.stock.multiple;

import br.com.studies.array.stock.FinancialOperation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class MultipleTransactionAllowedUseCaseTest {

    FinancialOperation financialOperation;
    FinancialOperation financialOperationBestSolution;

    @BeforeEach
    void init() {

        financialOperation = new MultipleTransactionBestSolutionUseCase();
        financialOperationBestSolution = new MultipleTransactionBestSolutionUseCase();

    }

    @ParameterizedTest
    @MethodSource("br.com.studies.array.stock.MockData#data")
    @DisplayName("should calculate the maximum profit in multiple operations")
    void maximumProfit(int[] prices) {

        assertEquals(
            financialOperation.maximumProfit(prices),
            financialOperationBestSolution.maximumProfit(prices)
        );

    }

}