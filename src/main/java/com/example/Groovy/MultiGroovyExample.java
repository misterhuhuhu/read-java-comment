package com.example.Groovy;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class MultiGroovyExample {
    public static void main(String[] args) throws Exception {
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("groovy");
        
        // 加载并执行第一个Groovy脚本
        File scriptFile1 = new File("./script1.groovy");
        Reader reader1 = new FileReader(scriptFile1);
        engine.eval(reader1);
        
        // 加载并执行第二个Groovy脚本
        File scriptFile2 = new File("./script2.groovy");
        Reader reader2 = new FileReader(scriptFile2);
        engine.eval(reader2);
        
        // 调用第一个Groovy脚本中的函数
        Invocable inv = (Invocable) engine;
        int sum = (int) inv.invokeFunction("add", 2, 3);
        System.out.println("sum = " + sum);
        
        // 调用第二个Groovy脚本中的函数
        int product = (int) inv.invokeFunction("multiply", 2, 3);
        System.out.println("product = " + product);
    }
}
