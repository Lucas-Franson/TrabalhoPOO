package Exercicios.contas;
import java.util.List;

public class AllTributos {
    public double aTributos;

    public double calcularTributos( List<ITributavel> _objsTributaveis ){
        _objsTributaveis.forEach( item -> this.aTributos += item.getValorImposto());
        return aTributos;
    }
    
}
