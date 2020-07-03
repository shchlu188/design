package com.scl.design.factory;

/**
 * @author scl
 * @Date 2020/6/27
 * @Description
 */
public interface Product {
    void product();

}


class FoodProduct implements  Product{
    @Override
    public void product(){
        System.out.println("FoodProduct---------product");
    }

}


class Creator{
    public Product createProduct(){
        return new FoodProduct();
    }
}