package com.example.Spel;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class MyClass {
    private String myField = "Hello World";
    
    public String getMyField() {
        return myField;
    }
    
    public void setMyField(String myField) {
        this.myField = myField;
    }
    
    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        MyClass myClass = new MyClass();
        parser.parseExpression("setMyField('Hello SpEL')").getValue(myClass);
        String myFieldValue = parser.parseExpression("getMyField()").getValue(myClass, String.class);
        System.out.println(myFieldValue);
    }
}
