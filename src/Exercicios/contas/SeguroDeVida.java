package Exercicios.contas;

public class SeguroDeVida implements ITributavel{
    public double Valor;
    public String Titular;
    public int numeroApolice;
    
    public SeguroDeVida( String _titular, int _numeroApolice, double _valor ){
        this.Titular = _titular;
        this.numeroApolice = _numeroApolice;
        this.Valor = _valor;
    }

    @Override
    public double getValorImposto() {
        return 42.00 + (this.Valor * 0.02);
    }
    
}
