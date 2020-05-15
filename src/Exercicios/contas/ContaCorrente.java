package Exercicios.contas;


public class ContaCorrente extends Conta implements ITributavel{
    private int limiteChequeEspecial;
    
    public ContaCorrente(){
        this.DataAbertura = new data();
    }
    
    public ContaCorrente(String _nomeTitular,int _numeroConta, String _agencia, int _limiteChequeEspecial){
        super(_nomeTitular,_numeroConta,_agencia);
        this.limiteChequeEspecial = _limiteChequeEspecial;
    }
    
    // saque Conta corrente
   @Override
   public double Saca(double Valor){
       if( (this.Saldo + this.limiteChequeEspecial) >= (Valor + 0.10)){
           this.Saldo -= (Valor + 0.10);
           return this.Saldo; 
       }
       return this.Saldo; 
   }
    public int getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(int limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public double getValorImposto() {
        return this.Saldo * 0.01;
    }
}
