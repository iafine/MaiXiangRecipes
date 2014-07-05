package com.hyyy.spider;

import java.util.regex.*;

public class Reg{
    public static void main(String[] args) {

        String sentence = "this is what you want to replace: class='info'";
        System.out.println(sentence);

        // 编译正则类
        Pattern pattern = Pattern.compile("class='info'");
        Matcher matcher = pattern.matcher(sentence);
        // 替换所有匹配
        String output = matcher.replaceAll("\"") ;
        System.out.println("After replace:");
        System.out.println(output);

    }
}
