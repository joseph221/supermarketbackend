package com.example.SuperMarket.Api;

import java.util.List;

import com.example.SuperMarket.Dto.storedto.StoreAddDto;
import com.example.SuperMarket.Dto.storedto.StoreGetDto;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(path = "/store")
public interface StoreApi {
    @RequestMapping(path = "/post",method = RequestMethod.POST)
    public void post(@RequestBody StoreAddDto storeAddDto);

    @RequestMapping(path = "/get",method = RequestMethod.GET)
    public List<StoreGetDto> getData();

    @RequestMapping(path = "/put",method = RequestMethod.PUT)
    public void edit(@RequestBody StoreGetDto storeGetDto);

    @RequestMapping(path = "/delete/{id}",method = { RequestMethod.GET, RequestMethod.DELETE })
    public void delete(@PathVariable("id") long id);

    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public StoreGetDto fetchId(@PathVariable("id") long Id);

    @RequestMapping(path = "amount",method = RequestMethod.GET)
    public double getStoreAmount();

    @RequestMapping(method = RequestMethod.GET)
    public StoreGetDto getproducode(@RequestParam(value="producode") String producode);
}
