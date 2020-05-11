package Exercicios;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 00098519
 */
public class conta {
   public String NomeTitular;
   public int Numero;
   public String Agencia;
   public double Saldo;
   public data DataAbertura;
   private static int totalContas;
   private int identificador;
   
   public conta(){
        totalContas++;
        this.identificador = totalContas;
   }
   public conta(String _nomeTitular){
       this.NomeTitular = _nomeTitular;
        totalContas++;
        this.identificador = totalContas;
   }
   
   //identificador unico
    public int getIdentificador() {
        return identificador;
    }
   
   public double Saca(double Valor){
       return Saldo - Valor;
   }
   public double Deposita(double Valor){
       this.Saldo = this.Saldo + Valor;
       return this.Saldo;
   }
   public double CalculaRendimento(){
       return Saldo + (Saldo * 0.01);
   }
   
   public String recuperaDadosParaImpressao(){
       String dados = "Titular: " + this.NomeTitular;
       dados += "\nNúmero: " + this.Numero;
       dados += "\nAgência: " + this.Agencia;
       dados += "\nSaldo: " + this.Saldo;
       //dados += "\nDia: " + this.DataAbertura.dia;
       //dados += "\nMês: " + this.DataAbertura.mes;
       //dados += "\nAno: " + this.DataAbertura.ano;
       dados += "\nData de abertura: " + this.DataAbertura.formatada();
       //Quando é executado sem valores o dia, mes e ano, é atribuído zero.
       dados += "\nCálculo do Rendimento Mensal: " + this.CalculaRendimento();
       return dados;
   }
}
 