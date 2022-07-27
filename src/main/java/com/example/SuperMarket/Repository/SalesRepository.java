package com.example.SuperMarket.Repository;


import java.time.LocalDate;
import java.util.List;

import com.example.SuperMarket.Dto.Chartdata;
import com.example.SuperMarket.Dto.OderByMonth;
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

    @Query(value = "select year(created_date) as year,month(created_date) as month,sum(amount) as amount from sales  group by year(created_date),month(created_date) order by year(created_date),month(created_date)",nativeQuery = true)
    List<OderByMonth> orderByMonth();

    @Query(value = " SELECT  SUM(IF(month = 'Jan', total, 0)) AS 'Jan',     SUM(IF(month = 'Feb', total, 0)) AS 'Feb',     SUM(IF(month = 'Mar', total, 0)) AS 'Mar',     SUM(IF(month = 'Apr', total, 0)) AS 'Apr',     SUM(IF(month = 'May', total, 0)) AS 'May',     SUM(IF(month = 'Jun', total, 0)) AS 'Jun'"+
    "FROM (SELECT MIN(DATE_FORMAT(created_date, '%b')) AS month,SUM(amount) AS total FROM sales GROUP BY  MONTH(created_date) ORDER BY MONTH(created_date)) as sales",nativeQuery = true)
    Chartdata getChartdata();
}
