package com.example.Dynalink.readjavacomment;

import javax.tools.*;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.List;

public class JavaCompilerExample {
    
    public static void main(String[] args) {
        String filePath = "C:\\Users\\MR.WHO\\Desktop\\ReadJavaCommentApplication.java"; // 替换为你的Java文件路径
        
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<>();
        
        try (StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null)) {
            Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(List.of(new File(filePath)));
            String classOutputPath = "E:\\DevelopPackage\\ReadJavaComment\\target\\classes";
            List<String> options = Arrays.asList("-d", classOutputPath);
            
            JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnostics, options, null, compilationUnits);
            
            boolean success = task.call();
            
            if (success) {
                System.out.println("Java文件可以被编译成类。");
            } else {
                System.out.println("Java文件无法被编译成类。");
                for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
                    System.out.format("Error on line %d in %s%n", diagnostic.getLineNumber(), diagnostic.getSource().toUri());
                }
            }
    
            File f = new File("./ReadJavaCommentApplication.class");
//            try (URLClassLoader classLoader = new URLClassLoader(new URL[]{new File(".").toURI().toURL()})) {
            try (URLClassLoader classLoader = new URLClassLoader(new URL[]{f.toURI().toURL()})) {
                Class<?> clazz;
                // 加载编译好的类
                clazz = classLoader.loadClass("com.example.readjavacomment.ReadJavaCommentApplication");
                Method mainMethod = clazz.getMethod("main", String[].class);
                mainMethod.invoke(null, (Object) new String[]{});
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
