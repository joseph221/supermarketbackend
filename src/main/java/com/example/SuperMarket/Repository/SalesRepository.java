package com.example.SuperMarket.Repository;


import java.time.LocalDate;
import java.util.List;

import com.example.SuperMarket.model.Sales;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SalesRepository extends JpaRepository<Sales,Integer>{
    
    @Query(value = "select * from Sales where s.receiptNo =?1",nativeQuery = true)
    public Sales findByReceiptNo(long receiptNo);

    @Query(value = "SELECT sum(s.amount) from sales s", nativeQuery = true)
    Double sumAmount();

    @Query(value = "Select * from sales where created_date between ?1 and ?2",nativeQuery = true)
    public List<Sales> getByDate(LocalDate createdDate1,LocalDate createdDate2);
}
