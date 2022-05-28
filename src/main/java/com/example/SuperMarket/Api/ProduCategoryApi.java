package com.example.SuperMarket.Api;

import java.util.List;

import com.example.SuperMarket.Dto.ProduCtegoryDto;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(path = "/category")
public interface ProduCategoryApi {
    @RequestMapping(path = "/post",method = RequestMethod.POST)
    public void post(@RequestBody ProduCtegoryDto produCtegoryDto);

    @RequestMapping(path = "/get",method = RequestMethod.GET)
    public List<ProduCtegoryDto> getData();

    @RequestMapping(path = "/{cid}",method = RequestMethod.GET)
    public ProduCtegoryDto getByCatId(@PathVariable("cid") int cid);

    @RequestMapping(path = "/put",method = RequestMethod.PUT)
    public void edit(@RequestBody ProduCtegoryDto produCtegoryDto);

    @RequestMapping(path = "/delete/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id);

    @RequestMapping(path = "categonum",method = RequestMethod.GET)
    public long getCatNum();

}
