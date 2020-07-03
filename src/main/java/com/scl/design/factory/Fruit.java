package com.scl.design.factory;

/**
 * @author scl
 * @Date 2020/6/27
 * @Description
 */
public interface Fruit {
    void grow();
    void plant();
    void harvest();
}

class Apple implements  Fruit{

    @Override
    public void grow() {
        System.out.println("Apple--------grow");
    }

    @Override
    public void plant() {
        System.out.println("Apple--------plant");

    }

    @Override
    public void harvest() {
        System.out.println("Apple--------harvest");

    }
}
class Strawberry implements Fruit{

    @Override
    public void grow() {
        System.out.println("Strawberry--------grow");
    }

    @Override
    public void plant() {
        System.out.println("Strawberry--------plant");

    }

    @Override
    public void harvest() {
        System.out.println("Strawberry--------harvest");

    }
}
class Grape implements Fruit{

    @Override
    public void grow() {
        System.out.println("Grape--------grow");
    }

    @Override
    public void plant() {
        System.out.println("Grape--------plant");

    }

    @Override
    public void harvest() {
        System.out.println("Grape--------harvest");

    }
}


class FruitGardener{
    public static Fruit factory(String fruitName){
        Fruit fruit =null;
        if (fruitName.equalsIgnoreCase("apple")){
            fruit = new Apple();
        }else if (fruitName.equalsIgnoreCase("Strawberry")){
            fruit = new Strawberry();
        } else if (fruitName.equalsIgnoreCase("Grape")){
            fruit = new Grape();
        }else {
            throw new BadFruitException("没有这类水果");
        }
        return fruit;
    }
}

class BadFruitException extends RuntimeException{
    private  String message;
    BadFruitException(){
        super();
    }
    BadFruitException(String message){
        super(message);
    }
}