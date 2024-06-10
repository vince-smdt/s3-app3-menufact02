package main.Chef.exceptions;

public class ChefException extends Exception{

    public ChefException(String message){
        super("ChefException: " + message);
    }
}


