package com.example.SuperMarket.Repository;

import java.util.List;
import java.util.Optional;

import com.example.SuperMarket.model.Receipt;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecieptRepository extends JpaRepository<Receipt,Integer>{
    
    @Query("select * from Reciept where r.receiptNo =?1")
    public List<Receipt> receiptNo(long receiptNo);

    @Query("select r from Reciept where r.producode =?1 and r.receiptNo =?1")
    Receipt findReceiptByproducode(String producode);

    @Query("select r from Reciept where r.producode =?1")
    Optional<Receipt> findByproducode(String producode);

    @Query("select r from Reciept where r.receiptNo =?1")
    Receipt findReceiptByreceiptNo(long receiptNo);

    @Query("select r from Reciept where r.receiptNo =?1")
    Optional<Receipt> findByreceiptNo(long receiptNo);
}
