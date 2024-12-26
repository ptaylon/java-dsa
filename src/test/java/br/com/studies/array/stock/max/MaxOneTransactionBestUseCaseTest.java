package br.com.studies.array.stock.max;

import br.com.studies.array.stock.FinancialOperation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class MaxOneTransactionBestUseCaseTest {

    FinancialOperation financialOperationUseCase;
    FinancialOperation financialOperationBestUseCase;

    @BeforeEach
    void init() {
        financialOperationBestUseCase = new MaxOneTransactionBestUseCase();
        financialOperationUseCase = new MaxOneTransactionUseCase();
    }

    @ParameterizedTest
    @MethodSource("br.com.studies.array.stock.MockData#data")
    @DisplayName("Should return the max profit in one operation")
    void maximumProfit(int[] prices) {

        assertEquals(
            financialOperationBestUseCase.maximumProfit(prices),
            financialOperationUseCase.maximumProfit(prices)
        );

    }

}