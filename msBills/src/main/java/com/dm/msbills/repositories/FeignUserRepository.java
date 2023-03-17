package com.dm.msbills.repositories;

import com.dm.msbills.models.User;
import com.dm.msbills.security.Feign.FeignInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name= "users-service",url = "http://localhost:8089", configuration = FeignInterceptor.class)
public interface FeignUserRepository {

    @RequestMapping(method = RequestMethod.GET,value = "/users/find/{username}")
    User findByUsername(@PathVariable("username") String username);
}
