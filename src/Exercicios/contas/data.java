package Exercicios.contas;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class data {
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    
    public String getDate(){
        return dateFormat.format(date);
    }
}
