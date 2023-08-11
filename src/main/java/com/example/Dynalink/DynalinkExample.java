package com.example.Dynalink;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class DynalinkExample {
    public static void main(String[] args) throws ScriptException, NoSuchMethodException, IllegalAccessException {
        // 创建一个 GraalVM JavaScript 引擎实例
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("graal.js");
        
        // 创建一个 Java Person 对象
        Person person = new Person("John Doe");
        
        // 创建一个 JavaScript 对象
        engine.eval("var jsPerson = { name: 'Jane Doe', getName: function() { " +
                " var i = 1;" +
                "return this.name; } };");
        
        // 获取 Java Person 对象的名称
        Object javaPersonName = person.getName();
        System.out.println("Java Person name: " + javaPersonName);
        
        // 获取 JavaScript 对象的名称
        Object jsPerson = engine.get("jsPerson");
        Context context = Context.create();
        context.enter();
        
        Value jsPersonValue = context.asValue(jsPerson);
        Object jsPersonName = jsPersonValue.getMember("getName").execute();
        System.out.println("JavaScript Person name: " + jsPersonName);
        System.out.println(jsPersonValue.getMemberKeys());
        System.out.println(jsPersonValue.getMember("name").hasMembers());
        System.out.println(jsPersonValue.getMember("getName").isMetaObject());
        
        context.leave();
        context.close();
    }
}
