package com.example.SuperMarket.Api;

import java.io.IOException;
import java.util.List;


import com.example.SuperMarket.Dto.ProductListDto;
import com.example.SuperMarket.Dto.ProductListDto2;
import com.example.SuperMarket.Dto.ProductWithCategoryName;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(path = "/proList")
public interface ProductListApi {
    @RequestMapping(path = "/post",method = RequestMethod.POST)
    public void post(@ModelAttribute ProductListDto2 productListDto2)throws IOException;

    @RequestMapping(path = "/get",method = RequestMethod.GET)
    public List<ProductListDto> getData();

    @RequestMapping(path = "/get2",method = RequestMethod.GET)
    public List<ProductWithCategoryName> getData2();

    @RequestMapping(method = RequestMethod.GET)
    public ProductListDto getproducode(@RequestParam(value="producode") String producode);

    @RequestMapping(path = "/put",method = RequestMethod.PUT)
    public void edit(@ModelAttribute ProductListDto2 productListDto2)throws IOException;

    @RequestMapping(path = "/delete/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") String id);

    @RequestMapping(path = "pronum",method = RequestMethod.GET)
    public long getProNum();

    @RequestMapping(path ="report/{catId}",method = RequestMethod.GET)
    public List<ProductListDto> getByCat_Id(@PathVariable int catId);
}
