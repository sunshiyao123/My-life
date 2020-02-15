package com.cases;


import com.Case;
import com.annotations.BenchMark;
import com.annotations.Measurement;

/**
 * 测试用例类
 */@Measurement(iterations = 1000,group = 5)
public class StringConcatCase implements Case {
    @BenchMark
    public String testStringAdd() {
        String s = "";
        for (int i = 0;i < 10;i++) {
            s += i;
        }
        return s;
    }
    @BenchMark
    public String testStringBuilderAdd() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < 10;i++) {
            sb.append(i);
        }
        return sb.toString();
    }
}
