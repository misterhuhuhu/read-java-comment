package com.example.GroovySpring;

import groovy.lang.GroovyClassLoader;
import org.codehaus.groovy.control.BytecodeProcessor;
import org.codehaus.groovy.control.CompilerConfiguration;

import java.io.File;
import java.nio.file.Files;

public class LoadGroovyFile {
    public static void main(String[] args) throws Exception {
        // 设置Groovy编译器类加载器和编译配置
        CompilerConfiguration config = new CompilerConfiguration();
        GroovyClassLoader classLoader = new GroovyClassLoader(Thread.currentThread().getContextClassLoader(), config);
        
        // 加载Groovy源文件
        File file = new File("HelloWorld.groovy");
        Class<?> groovyClass = classLoader.parseClass(file);
        
        // 打印Groovy类名
        System.out.println("Groovy class name: " + groovyClass.getName());
        
        // 编译Groovy类并生成class文件
        Class<?> compiledClass = classLoader.loadClass(groovyClass.getName());
        BytecodeProcessor bytecodeProcessor = config.getBytecodePostprocessor();
//        byte[] bytes = bytecodeProcessor.processBytecode(compiledClass.getName(), compiledClass);
        // 将字节码写入class文件
        // 注意：此处需要根据实际情况修改class文件的路径和名称
//        Files.write(new File("HelloWorld.class").toPath(), bytes);
    }
}
