package Exercicios.contas;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Banco {
    List<Conta> Contas = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    
   public void addContaCorrente(){
        System.out.print("Nome do Titular: \n");
        String nomeTitular = scan.nextLine();
        
        System.out.print("Numero da conta: \n");
        int numConta = Integer.parseInt(scan.nextLine());
        
        // Verifica se o numero da conta é unico
        while( !this.getConta(numConta).equals(Optional.empty()) ){
            System.out.print("Numero da conta: \n");
            numConta = Integer.parseInt(scan.nextLine());
        }
        
        System.out.print("Agencia: \n");
        String agencia = scan.nextLine();
        
        System.out.print("Limite Cheque Especial: \n");
        int limiteChequeEspecial = Integer.parseInt(scan.nextLine());
        
        ContaCorrente _conta = new ContaCorrente(nomeTitular, numConta, agencia, limiteChequeEspecial);
        
        this.Contas.add(_conta);
   }
   
   public void addContaPoupanca(){
        System.out.print("Nome do Titular: \n");
        String nomeTitular = scan.nextLine();
        
        System.out.print("Numero da conta: \n");
        int numConta = Integer.parseInt(scan.nextLine());
        
        while( this.getConta(numConta) != null ){
            System.out.print("Numero da conta: \n");
            numConta = Integer.parseInt(scan.nextLine());
        }
        
        System.out.print("Agencia: \n");
        String agencia = scan.nextLine();
        
        ContaPoupanca _conta = new ContaPoupanca(nomeTitular, numConta, agencia);
       
        this.Contas.add(_conta);
   }
   
   public Optional<Conta> getConta( int _numero){
       
        return this.Contas.stream().filter( c -> c.Numero == _numero ).findFirst();
       
   }
   
   public void removeConta( int _numero){
       
      this.Contas.removeIf( obj -> obj.Numero == _numero );
      
   }
   
}
