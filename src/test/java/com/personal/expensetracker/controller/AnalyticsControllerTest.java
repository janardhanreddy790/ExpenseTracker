package com.personal.expensetracker.controller;

import com.personal.expensetracker.dto.MonthSummary;
import com.personal.expensetracker.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AnalyticsController.class)
class AnalyticsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionRepository transactionRepository;

    @Test
    void monthlyReportEndpointReturnsSummariesWithTotal() throws Exception {
        BDDMockito.given(transactionRepository.getSummaryByMonth())
                .willReturn(List.of(
                        new MonthSummary("2024-01", 150.0),
                        new MonthSummary("2024-02", 200.5)
                ));

        mockMvc.perform(get("/api/analytics/reports/monthly"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.summaries", hasSize(2)))
                .andExpect(jsonPath("$.summaries[0].month").value("2024-01"))
                .andExpect(jsonPath("$.summaries[1].total").value(200.5))
                .andExpect(jsonPath("$.total").value(350.5));
    }
}
