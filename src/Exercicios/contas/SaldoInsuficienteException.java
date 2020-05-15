package Exercicios.contas;

public class SaldoInsuficienteException extends RuntimeException{
    
    public SaldoInsuficienteException(String errorMessage){
        super(errorMessage);
    }
    
}
