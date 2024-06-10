package Client.exceptions;

public class ClientException extends Exception{

    public ClientException(String message){
        super("ClientException: " + message);
    }
}
