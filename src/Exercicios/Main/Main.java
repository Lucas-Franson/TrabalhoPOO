package Exercicios.Main;
import Exercicios.contas.AllTributos;
import Exercicios.contas.Banco;
import java.util.Scanner;
import Exercicios.contas.data;
import Exercicios.contas.ContaCorrente;
import Exercicios.contas.ContaPoupanca;
import Exercicios.contas.ITributavel;
import java.util.ArrayList;
import java.util.List;


public class Main {
    
    public static void main(String[] args){
        int select = 0;
        
        Banco banco = new Banco();
        
        
        do{
            System.out.println("--SAIR(0)\n");
            System.out.println("--ABERTURA DE CONTA(1)\n");
            System.out.println("--SELECIONAR UMA CONTA(2)\n");

            Scanner scan = new Scanner(System.in);
            select = Integer.parseInt(scan.nextLine());
            
            // ABERTURA DE CONTA
            if(select == 1){
                System.out.println("=============== ABERTURA DE CONTA ===============");
                System.out.println("-- Conta Corrente(1)");
                System.out.println("-- Conta Poupança(2)");
            
                int n = Integer.parseInt(scan.nextLine());
                
                if(n == 1) {
                    banco.addContaCorrente();               
                }
                if(n == 2 ){
                    banco.addContaPoupanca();
                }
            
            }
            // OPERACOES BANCARIAS
            if(select == 2){
                System.out.println("=============== ACESSO A CONTA  ===============");
                
                System.out.println("Informe seu número da conta: ");
                int conta = Integer.parseInt(scan.nextLine());
                
                banco.AcessarConta(conta);
            }
            
        }while(select != 0);
            

    }

}
