/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 00098519
 */
package Exercicios;

public class Exercicios {
    public static void main(String[] args){
        conta c1 = new conta();
        data c3 = new data();
        
        c1.NomeTitular = "Guilherme";
        c1.Numero = 123;
        c1.Agencia = "45678-9";
        c1.Saldo = 100.0;
        c1.DataAbertura = c3;
        
        c1.Deposita(500.0);
        c1.recuperaDadosParaImpressao();
        System.out.println(c1.recuperaDadosParaImpressao());
        
        System.out.println(c1.getIdentificador());
        
        conta c2 = new conta();
        c2.NomeTitular = "Daniel";
        c2.Numero = 321;
        c2.Agencia = "98765-4";
        c2.Saldo = 1000.0;
        c2.DataAbertura = c3;
        
        System.out.println(c2.getIdentificador());
        
        if(c1 == c2){
            System.out.println("Iguais");
        } else{
            System.out.println("Diferentes");
        }
        /*conta c1 = new conta();
        c1.NomeTitular = "Guilherme";
        c1.Numero = 123;
        c1.Agencia = "45678-9";
        c1.Saldo = 100.0;
        c1.DataAbertura = "01/02/2020";
        
        c2 = c1;*/
        
        
    }
}

