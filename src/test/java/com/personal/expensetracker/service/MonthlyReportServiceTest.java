package com.personal.expensetracker.service;

import com.personal.expensetracker.dto.MonthSummary;
import com.personal.expensetracker.dto.MonthlyReportResponse;
import com.personal.expensetracker.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class MonthlyReportServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private MonthlyReportService monthlyReportService;

    @Test
    void getMonthlyReportReturnsSummariesWithCalculatedTotal() {
        BDDMockito.given(transactionRepository.getSummaryByMonth())
                .willReturn(List.of(
                        new MonthSummary("2024-01", 150.0),
                        new MonthSummary("2024-02", null),
                        new MonthSummary("2024-03", 200.5)
                ));

        MonthlyReportResponse response = monthlyReportService.getMonthlyReport();

        assertThat(response.getSummaries())
                .extracting(MonthSummary::getMonth)
                .containsExactly("2024-01", "2024-02", "2024-03");
        assertThat(response.getTotal()).isEqualTo(350.5);
    }

    @Test
    void getMonthlySummariesDelegatesToRepository() {
        List<MonthSummary> summaries = List.of(new MonthSummary("2024-01", 150.0));
        BDDMockito.given(transactionRepository.getSummaryByMonth()).willReturn(summaries);

        assertThat(monthlyReportService.getMonthlySummaries()).isEqualTo(summaries);
    }

    @Test
    void getMonthlySummariesReturnsEmptyListWhenRepositoryReturnsNull() {
        BDDMockito.given(transactionRepository.getSummaryByMonth()).willReturn(null);

        assertThat(monthlyReportService.getMonthlySummaries()).isEmpty();
    }
}
