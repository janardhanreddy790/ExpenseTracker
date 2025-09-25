package com.personal.expensetracker.repository;

import com.personal.expensetracker.dto.CategorySummary;
import com.personal.expensetracker.dto.ItemSummary;
import com.personal.expensetracker.dto.MonthSummary;
import com.personal.expensetracker.dto.VendorSummary;
import com.personal.expensetracker.model.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    Page<Transaction> findAll(Pageable pageable);

    Page<Transaction> findByCategory(String category, Pageable pageable);
    Page<Transaction> findByVendor(String vendor, Pageable pageable);

    @Query("SELECT t FROM Transaction t WHERE " +
            "LOWER(t.item) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(t.vendor) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(t.category) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    Page<Transaction> findByKeyword(@Param("keyword") String keyword, Pageable pageable);


    @Query("SELECT new com.personal.expensetracker.dto.CategorySummary(t.category, SUM(t.amount)) " +
            "FROM Transaction t GROUP BY t.category")
    List<CategorySummary> getSummaryByCategory();

//    @Query("SELECT new com.personal.expensetracker.dto.MonthSummary(" +
//            "FUNCTION('TO_CHAR', t.date, 'YYYY-MM'), CAST(SUM(t.amount) AS big_decimal)) " +
//            "FROM Transaction t " +
//            "GROUP BY FUNCTION('TO_CHAR', t.date, 'YYYY-MM') " +
//            "ORDER BY FUNCTION('TO_CHAR', t.date, 'YYYY-MM')")
//    List<MonthSummary> getSummaryByMonth();




    @Query("SELECT new com.personal.expensetracker.dto.VendorSummary(t.vendor, SUM(t.amount)) " +
            "FROM Transaction t GROUP BY t.vendor ORDER BY SUM(t.amount) DESC")
    List<VendorSummary> getTopVendors();

    @Query("SELECT new com.personal.expensetracker.dto.ItemSummary(t.item, SUM(t.amount)) " +
            "FROM Transaction t " +
            "GROUP BY t.item " +
            "ORDER BY SUM(t.amount) DESC")
    List<ItemSummary> getTopItems();


}
