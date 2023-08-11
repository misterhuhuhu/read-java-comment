package com.example.Dynalink.readjavacomment;

import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.utils.SourceRoot;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class SpringAnnotationFinder {
    public static void main(String[] args) throws IOException {
    
        // 1. 定义要解析的 Java 源代码目录
        Path sourcePath = Paths.get("src/main/java");
    
        // 2. 创建 SourceRoot 实例
        SourceRoot sourceRoot = new SourceRoot(sourcePath);
        sourceRoot.tryToParse();
        for (ParseResult<CompilationUnit> parseResult : sourceRoot.tryToParse()){
            if (parseResult.isSuccessful()){
                var compilationUnit = parseResult.getResult().get();
                
                compilationUnit.findAll(ClassOrInterfaceDeclaration.class).stream().filter(cd->cd.getAnnotationByName("SpringBootApplication").isPresent()).
                        forEach(cd-> System.out.println("Found @Component class: " + StringUtils.trimWhitespace(compilationUnit.getPackageDeclaration().get().toString()) ));

                compilationUnit.findAll(MethodDeclaration.class).stream().filter(cd->cd.getAnnotationByName("RequestMapping").isPresent()).
                        forEach(cd-> System.out.println("Found @RequestMapping Method: "  + StringUtils.trimWhitespace(compilationUnit.getPackageDeclaration().get().toString()) + cd.getNameAsString()));
                compilationUnit.findAll(MethodDeclaration.class).stream().filter(cd->cd.getAnnotationByName("RequestMapping").isPresent()).
                        forEach(cd-> System.out.println("Found @RequestMapping Method: "  + StringUtils.trimWhitespace(compilationUnit.getPackageDeclaration().get().toString()) + compilationUnit.getPrimaryTypeName().get()));
    
    
            }
        }
       
    }
}