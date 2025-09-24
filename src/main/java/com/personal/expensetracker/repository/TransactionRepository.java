package com.personal.expensetracker.repository;

import com.personal.expensetracker.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("SELECT t.category, SUM(t.amount) FROM Transaction t GROUP BY t.category ORDER BY SUM(t.amount) DESC")
    List<Object[]> findSumByCategory();

    @Query("SELECT FUNCTION('to_char', t.date, 'YYYY-MM'), SUM(t.amount) FROM Transaction t GROUP BY FUNCTION('to_char', t.date, 'YYYY-MM') ORDER BY 1 ASC")
    List<Object[]> findSumByMonth();

    @Query("SELECT t.item, SUM(t.amount) FROM Transaction t WHERE t.item IS NOT NULL GROUP BY t.item ORDER BY SUM(t.amount) DESC")
    List<Object[]> findTopItems();

    @Query("SELECT t.vendor, SUM(t.amount) FROM Transaction t WHERE t.vendor IS NOT NULL GROUP BY t.vendor ORDER BY SUM(t.amount) DESC")
    List<Object[]> findTopVendors();

    List<Transaction> findByDateBetween(LocalDate start, LocalDate end);

    List<Transaction> findByDateBetweenAndOwner(LocalDate start, LocalDate end, String owner);

    List<Transaction> findByDateBetweenAndCategory(LocalDate start, LocalDate end, String category);

    List<Transaction> findByDateBetweenAndOwnerAndCategory(LocalDate start, LocalDate end, String owner, String category);


}
