package com.personal.expensetracker.repository;

import com.personal.expensetracker.dto.MonthSummary;
import com.personal.expensetracker.model.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

@DataJpaTest
class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void getSummaryByMonthReturnsTotalsSortedByMonth() {
        persistTransaction(LocalDate.of(2024, 3, 5), "Utilities", 80.0);
        persistTransaction(LocalDate.of(2024, 1, 15), "Groceries", 40.0);
        persistTransaction(LocalDate.of(2024, 1, 25), "Groceries", 10.0);
        persistTransaction(LocalDate.of(2024, 2, 10), "Transport", 25.5);

        entityManager.flush();
        entityManager.clear();

        List<MonthSummary> summaries = transactionRepository.getSummaryByMonth();

        assertThat(summaries)
                .extracting(MonthSummary::getMonth, MonthSummary::getTotal)
                .containsExactly(
                        tuple("2024-01", 50.0),
                        tuple("2024-02", 25.5),
                        tuple("2024-03", 80.0)
                );
    }

    private void persistTransaction(LocalDate date, String category, double amount) {
        Transaction transaction = new Transaction();
        transaction.setDate(date);
        transaction.setCategory(category);
        transaction.setAmount(amount);
        entityManager.persist(transaction);
    }
}
