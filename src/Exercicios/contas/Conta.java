package Exercicios.contas;

public abstract class Conta {
   public String NomeTitular;
   public int Numero;
   public String Agencia;
   public double Saldo;
   public data DataAbertura;
   private static int totalContas;
   private int identificador;
   
   public Conta(){
        this.DataAbertura = new data();
        
        totalContas++;
        this.identificador = totalContas;
   }

    public Conta( String _nomeTitular,int _numeroConta, String _agencia){
        this.DataAbertura = new data();
        this.NomeTitular = _nomeTitular;
        this.Numero = _numeroConta;
        this.Agencia = _agencia;
        this.Saldo = 0;
        
        totalContas++;
        this.identificador = totalContas;
    }
   
   //identificador unico
    public int getIdentificador() {
        return identificador;
    }
   
   public double Saca(double _valor){
       if( this.Saldo - _valor >= 0 ){
            this.Saldo -= _valor;
            return this.Saldo;
       }
       else{
           throw new SaldoInsuficienteException("Saldo Insuficiente");
       }
   }
   public double Deposita(double _valor){
       
       if( _valor <= 0.0 ){
           throw new IllegalArgumentException("Valor Negativo!");
       }
       this.Saldo +=  _valor;
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
       dados += "\nData de abertura: " + this.DataAbertura.getDate();
       //Quando é executado sem valores o dia, mes e ano, é atribuído zero.
       dados += "\nCálculo do Rendimento Mensal: " + this.CalculaRendimento();
       return dados;
   }
   
   public String getTipo(){
       return this.getClass().getSimpleName();
   }
   
   public void transferir(Conta conta, double _valor) {
       if (this.Saldo >= _valor) {
           this.Saldo -= _valor;
           conta.Deposita(_valor);
           System.out.println("Transferência efetuada com sucesso!");
       } else {
           throw new SaldoInsuficienteException("Saldo Insuficiente");
       }
   }
   
}
 