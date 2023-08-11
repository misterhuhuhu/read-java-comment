package com.example.Groovy;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;
import java.nio.file.Files;

public class GroovyDemo {
    
    public static void main(String[] args) throws Exception {
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("groovy");
        File scriptFile = new File("E:\\DevelopPackage\\ReadJavaComment\\src\\main\\java\\com\\example\\Groovy\\personScript.groovy");
        Reader reader = new FileReader(scriptFile);
        engine.eval(reader);
    
        // 创建GroovyParams对象并设置参数
        GroovyParams params = new GroovyParams();
        params.setName("John");
        params.setAge(30);
    
        // 在Groovy脚本中执行函数，并传递参数
        Invocable inv = (Invocable) engine;
        inv.invokeFunction("sayHello", params);
    
        // 获取GroovyParams对象的结果
        String result = params.getResult();
        System.out.println("结果"+result);
    }
    
   
    
}
