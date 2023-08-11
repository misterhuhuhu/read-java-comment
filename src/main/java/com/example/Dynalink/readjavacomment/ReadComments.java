package com.example.Dynalink.readjavacomment;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.comments.Comment;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 读取Java源文件中的注释,并分类
 */
public class ReadComments {
    public static void main(String[] args) throws IOException {
        // 读取Java源文件
        FileInputStream fis = new FileInputStream("E:\\DevelopPackage\\ReadJavaComment\\src\\main\\java\\com\\example\\readjavacomment\\ReadJavaCommentApplication.java");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        
        // 使用JavaParser解析为CompilationUnit(编译单元)
        var parse = new JavaParser().parse(new String(data));
        
        // 获取源文件中的所有注释
        var comments = parse.getCommentsCollection().get();
        var comments1 = comments.getComments();
        // 创建列表保存不同类别的注释
        List<Comment> classComments = new ArrayList<>();
        List<Comment> methodComments = new ArrayList<>();
        List<Comment> fieldComments = new ArrayList<>();
        
        // 遍历注释,根据注释内容判断分类并添加到相应列表
        for (var c : comments1) {
            if (c.isLineComment()) { // 过滤行注释
                
                String content = c.getContent(); // 获取注释内容
                System.out.println(content);
//                // 如果注释内容包含“class”且在类体外,则判定为类注释
//                if (isClassComment(content) && !cu.getClassByName(content).isPresent()) {
//                    classComments.add(c);
//                }
//
//                // 如果注释内容包含“method”且紧跟着方法,则判定为方法注释
//                else if (isMethodComment(content) && cu.getMethodBySignature(content) != null) {
//                    methodComments.add(c);
//                }
//
//                // 如果注释内容包含“field”且紧跟着字段,则判定为字段注释
//                else if (isFieldComment(content) && cu.getFieldByName(content).isPresent()) {
//                    fieldComments.add(c);
//                }
            }
        }
        
        // 使用分类后注释...
//        System.out.println(classComments);
//        System.out.println(methodComments);
//        System.out.println(fieldComments);
    }
    
    // 判断是否为类注释
    private static boolean isClassComment(String content) {
        return content.contains("class");
    }
    
    // 判断是否为方法注释
    private static boolean isMethodComment(String content) {
        return content.contains("method");
    }
    
    // 判断是否为字段注释
    private static boolean isFieldComment(String content) {
        return content.contains("field");
    }
}