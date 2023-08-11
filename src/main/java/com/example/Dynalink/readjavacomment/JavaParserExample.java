package com.example.Dynalink.readjavacomment;

import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.utils.SourceRoot;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JavaParserExample {
    public static void main(String[] args) throws IOException {
        // 1. 定义要解析的 Java 源代码目录
        Path sourcePath = Paths.get("src/main/java");
        
        // 2. 创建 SourceRoot 实例
        SourceRoot sourceRoot = new SourceRoot(sourcePath);
        
        
        
        // 3. 遍历解析结果
        for (ParseResult<CompilationUnit> parseResult : sourceRoot.tryToParse()) {
            if (parseResult.isSuccessful()) {
                // 5. 获取 CompilationUnit（代码的抽象语法树表示）
                CompilationUnit compilationUnit = parseResult.getResult().get();
                
                // 6. 处理解析结果（例如打印结果）
                System.out.println(compilationUnit.toString());
            } else {
                System.err.println("解析失败: " + parseResult.getProblems());
            }
        }
    }
}
