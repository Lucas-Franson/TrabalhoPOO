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
        
        while( !this.getConta(numConta).equals(Optional.empty()) ){
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
   
   public void AcessarConta(int conta) {
       
       if (!this.getConta(conta).equals(Optional.empty())) {
        Conta account = this.getConta(conta).get();
        
        System.out.println("=============== OPERAÇÕES NA CONTA  ===============");    
        System.out.println("-- Sacar (1)");
        System.out.println("-- Depositar (2)");
        System.out.println("-- Imprimir extrato (3)");
        System.out.println("-- Tipo da conta (4)");
        System.out.println("-- Transferir dinheiro (5)");

        int operacao = Integer.parseInt(scan.nextLine());

        switch(operacao) {
            case 1:
                System.out.println("Informe o valor para saque:");
                double saque = Double.parseDouble(scan.nextLine());
                account.Saca(saque);
                break;
            case 2:
                System.out.println("Informe o valor para deposito:");
                double deposito = Double.parseDouble(scan.nextLine());
                account.Deposita(deposito);
                break;
            case 3:
                System.out.println(account.recuperaDadosParaImpressao());
                break;
            case 4:
                System.out.println(account.getTipo());
                break;
            case 5:
                this.transferir(account);
                break;
            default:
                System.out.println("Não existe operação com esse número.");
                break;
        }
       
       } else {
           System.out.println("Não existe conta com esse número.");
       }
       
   }
   
   private void transferir(Conta account) {
        System.out.println("Informe o número da conta para transferência:");
        int contaReceptor = Integer.parseInt(scan.nextLine());
        Optional<Conta> receptor = this.getConta(contaReceptor);
        
        while( receptor.equals(Optional.empty()) ){
            System.out.print("Numero da conta para transferência: \n");
            int numConta = Integer.parseInt(scan.nextLine());
            receptor = this.getConta(numConta);
        }
        
        System.out.println("Informe o valor para transferência: ");
        double valor = Double.parseDouble(scan.nextLine());
        
        account.transferir(receptor.get(), valor);
   }
   
}
