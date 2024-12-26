package br.com.studies.array.stock.max;

import br.com.studies.array.stock.FinancialOperation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxOneTransactionUseCaseTest {

    FinancialOperation financialOperationUseCase;
    FinancialOperation financialOperationBestSolutionUseCase;

    @BeforeEach
    void init() {
        financialOperationBestSolutionUseCase = new MaxOneTransactionBestUseCase();
        financialOperationUseCase = new MaxOneTransactionUseCase();
    }

    @ParameterizedTest
    @MethodSource("br.com.studies.array.stock.MockData#data")
    @DisplayName("Should return the max profit in one operation")
    void maximumProfit(int[] prices) {

        assertEquals(
            financialOperationBestSolutionUseCase.maximumProfit(prices),
            financialOperationUseCase.maximumProfit(prices)
        );

    }

}