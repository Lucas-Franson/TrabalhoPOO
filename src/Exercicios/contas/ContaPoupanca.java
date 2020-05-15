package Exercicios.contas;


public class ContaPoupanca extends Conta{
    
    public ContaPoupanca(){
        this.DataAbertura = new data();
    }
    
    public ContaPoupanca(String _nomeTitular,int _numeroConta, String _agencia){
        super(_nomeTitular,_numeroConta,_agencia);
    }
    
    public double Rendimento(){
        return this.Saldo += this.Saldo * 0.005;
    }
    
}
