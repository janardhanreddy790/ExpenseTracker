package com.personal.expensetracker.controller;

import com.personal.expensetracker.dto.MonthSummary;
import com.personal.expensetracker.dto.MonthlyReportResponse;
import com.personal.expensetracker.service.MonthlyReportService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(controllers = MonthlyReportController.class)
class MonthlyReportControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MonthlyReportService monthlyReportService;

    @Test
    void monthlyReportViewDisplaysSummariesAndTotal() throws Exception {
        MonthlyReportResponse response = new MonthlyReportResponse(
                List.of(
                        new MonthSummary("2024-01", 150.0),
                        new MonthSummary("2024-02", 200.5)
                ),
                350.5
        );
        BDDMockito.given(monthlyReportService.getMonthlyReport())
                .willReturn(response);

        mockMvc.perform(get("/reports/monthly"))
                .andExpect(status().isOk())
                .andExpect(view().name("reports/monthly"))
                .andExpect(model().attribute("summaries", contains(
                        allOf(
                                hasProperty("month", is("2024-01")),
                                hasProperty("total", is(150.0))
                        ),
                        allOf(
                                hasProperty("month", is("2024-02")),
                                hasProperty("total", is(200.5))
                        )
                )))
                .andExpect(model().attribute("total", closeTo(350.5, 0.001)));
    }
}
