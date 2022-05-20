package com.example.SuperMarket.Api;

import java.time.LocalDate;
import java.util.List;

import com.example.SuperMarket.Dto.SalesDto;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(path = "/sales")
public interface SalesApi {
    @RequestMapping(path = "/post",method = RequestMethod.POST)
    public void post(@RequestBody SalesDto salesDto);

   @RequestMapping(path = "/get",method = RequestMethod.GET)
    public List<SalesDto> getData();

    @RequestMapping(path = "/{saleNum}",method = RequestMethod.GET)
    public SalesDto getBySaleNum(@PathVariable("saleNum") int saleNum);

    @RequestMapping(path = "/put",method = RequestMethod.PUT)
    public void edit(@RequestBody SalesDto salesDto);

    @RequestMapping(path = "totalsales",method = RequestMethod.GET)
    public double getTotal();

    @RequestMapping(path = "salereport/start/{start}/end/{end}",method = RequestMethod.GET)
    public List<SalesDto> getSalesCreatedData(@PathVariable("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startLocalDate,@PathVariable("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endLocalDate);
}
