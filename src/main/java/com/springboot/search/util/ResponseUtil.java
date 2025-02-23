package com.springboot.search.util;

import com.springboot.search.domain.ErrorResponseDomain;
import com.springboot.search.domain.ResponseDomain;
import com.springboot.search.domain.SuccessResponseDomain;
import org.springframework.http.HttpStatus;

import java.util.List;

public class ResponseUtil<T> {


    /**
     * populate success response with message only
     * @param data
     * @return
     */
    public static <T> ResponseDomain populateSuccessResponseDomain(String message){
        ResponseDomain responseDomain = new ResponseDomain();
        SuccessResponseDomain<T> successResponseDomain = new SuccessResponseDomain<T>();
        successResponseDomain.setResponseMessage(message);
        responseDomain.setSuccess(successResponseDomain);
        return responseDomain;
    }

    /**
     * populate success response with data
     * @param data
     * @return
     */
    public static <T> ResponseDomain populateSuccessResponseDomain(T data){
        ResponseDomain responseDomain = new ResponseDomain();
        SuccessResponseDomain<T> successResponseDomain = new SuccessResponseDomain<T>();
        successResponseDomain.setData(data);
        responseDomain.setSuccess(successResponseDomain);
        return responseDomain;
    }

    /**
     * populate success response with data and message
     * @param data
     * @param message
     * @return
     */
    public static <T> ResponseDomain populateSuccessResponseDomain(T data, String message){
        ResponseDomain responseDomain = new ResponseDomain();
        SuccessResponseDomain<T> successResponseDomain = new SuccessResponseDomain<T>();
        successResponseDomain.setData(data);
        successResponseDomain.setResponseMessage(message);
        responseDomain.setSuccess(successResponseDomain);
        return responseDomain;
    }

    /**
     * populate success response with List of data and message
     * @param dataList
     * @param message
     * @return
     */
    public static <T> ResponseDomain populateSuccessResponseDomain(List<T> dataList, String message){
        ResponseDomain responseDomain = new ResponseDomain();
        SuccessResponseDomain<T> successResponseDomain = new SuccessResponseDomain<T>();
        successResponseDomain.setDataList(dataList);
        successResponseDomain.setResponseMessage(message);
        responseDomain.setSuccess(successResponseDomain);
        return responseDomain;
    }

    /**
     * populate error response with data and errorMessage
     * @param httpStatus
     * @param errorMessage
     * @return
     */
    public static <T> ResponseDomain populateErrorResponseDomain(HttpStatus httpStatus, String errorMessage){
        ResponseDomain responseDomain = new ResponseDomain();
        ErrorResponseDomain errorResponseDomain = new ErrorResponseDomain();
        errorResponseDomain.setErrorMessage(errorMessage);
        errorResponseDomain.setStatusCodeMessage(httpStatus);
        errorResponseDomain.setStatusCode(httpStatus.value());
        responseDomain.setError(errorResponseDomain);
        return responseDomain;
    }
}
