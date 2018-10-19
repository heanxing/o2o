package com.o2o.exceptions;

/**
 * Created by heanxing on 2018/10/15.
 */
public class ShopOperationException extends RuntimeException {
    public ShopOperationException(String msg){
        super((msg));
    }
}
