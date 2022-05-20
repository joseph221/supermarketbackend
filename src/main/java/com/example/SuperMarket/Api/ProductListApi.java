package com.example.SuperMarket.Api;

import java.io.IOException;
import java.util.List;


import com.example.SuperMarket.Dto.ProductListDto;
import com.example.SuperMarket.Dto.ProductListDto2;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(path = "/proList")
public interface ProductListApi {
    @RequestMapping(path = "/post",method = RequestMethod.POST)
    public void post(@ModelAttribute ProductListDto2 productListDto2)throws IOException;

    @RequestMapping(path = "/get",method = RequestMethod.GET)
    public List<ProductListDto> getData();

    @RequestMapping(method = RequestMethod.GET)
    public ProductListDto getproducode(@RequestParam(value="producode") String producode);

    @RequestMapping(path = "/put",method = RequestMethod.PUT)
    public void edit(@RequestBody ProductListDto productListDto);

    @RequestMapping(path = "/delete/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") String id);

    @RequestMapping(path = "pronum",method = RequestMethod.GET)
    public long getProNum();
}
