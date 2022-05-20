package com.example.SuperMarket.Api;

import java.util.List;

import com.example.SuperMarket.model.Roles;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(path = "role")
public interface RoleApi {

    @RequestMapping(path = "get" , method = RequestMethod.GET)
    public List<Roles> getRoles();

    @RequestMapping(path = "post",method = RequestMethod.POST)
    public void add(@RequestBody Roles roles);

    @RequestMapping(path = "/{rid}",method = RequestMethod.GET)
    public Roles getByRoleId(@PathVariable("rid") long rid);

    @RequestMapping(path = "edit",method = RequestMethod.PUT)
    public void editRole(@RequestBody Roles roles);

    @RequestMapping(path = "delete/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") long id);
    
}
