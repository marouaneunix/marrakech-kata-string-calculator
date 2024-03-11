package fr.norsys.stringcalculator;

public class NegativeNumberException extends  Exception{
    String comment;
    public NegativeNumberException(String comment){
        this.comment=comment;
    }
}
