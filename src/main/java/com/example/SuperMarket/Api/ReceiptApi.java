package com.example.SuperMarket.Api;

import java.util.List;

import com.example.SuperMarket.Dto.ReceiptDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RequestMapping(path = "receipt")
public interface ReceiptApi {

    @RequestMapping(path = "get", method=RequestMethod.GET)
    public List<ReceiptDto> getReceipt();

    @RequestMapping(path = "post", method = RequestMethod.POST)
    public ResponseEntity post(@RequestBody List<ReceiptDto> receiptDto);

    @RequestMapping(path = "put", method = RequestMethod.PUT)
    public void put(@RequestBody ReceiptDto receiptDto);

    @RequestMapping(path = "/{receiptNo}",method = RequestMethod.GET)
    public List<ReceiptDto> getreceiptNo(@PathVariable("receiptNo") long receiptNo);


}
