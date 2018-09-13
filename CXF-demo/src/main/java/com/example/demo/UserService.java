package com.example.demo;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
@WebService
public interface UserService {

    @WebMethod
    String getName(@WebParam(name = "userId") String userId);
    @WebMethod
    String getUser(String userId);
}