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

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = ReportController.class)
class ReportControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionRepository transactionRepository;

    @Test
    void monthlyReportRendersSummaries() throws Exception {
        BDDMockito.given(transactionRepository.getSummaryByMonth())
                .willReturn(List.of(
                        new MonthSummary("2024-01", 150.0),
                        new MonthSummary("2024-02", 200.5)
                ));

        mockMvc.perform(get("/reports/monthly"))
                .andExpect(status().isOk())
                .andExpect(view().name("reports/monthly"))
                .andExpect(model().attributeExists("summaries"))
                .andExpect(model().attribute("summaries", hasSize(2)))
                .andExpect(content().string(containsString("2024-01")))
                .andExpect(content().string(containsString("2024-02")));
    }
}
