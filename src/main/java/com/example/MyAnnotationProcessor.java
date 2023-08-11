package com.example;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.util.Set;

@SupportedAnnotationTypes("com.example.MyAnnotation")
@SupportedSourceVersion(SourceVersion.RELEASE_11)
public class MyAnnotationProcessor extends AbstractProcessor  {
    
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        // 处理注解逻辑
        return true;
    }
    
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Set.of("com.example.MyAnnotation");
    }
    
    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}