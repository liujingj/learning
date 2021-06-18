package com.ljj.malllearning.java8;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

/**
 * @author ljj
 * @date 2021/3/25
 */
public class Java8Test {

    private String fileName
        = "/Users/ljj/Desktop/workspace/mall-learning/src/main/java/com/ljj/malllearning/java8/TestJavac.java";
    private String classPath
        = "/Users/ljj/Desktop/workspace/mall-learning/target/classes/com/ljj/malllearning/java8 ";

    public static void main(String[] args) throws Exception {
        Java8Test java8Test = new Java8Test();
        String code = "package com.ljj.malllearning.java8;\n"
            + "\n"
            + "import java.util.Arrays;\n"
            + "import java.util.List;\n"
            + "import java.util.function.Predicate;\n"
            + "\n"
            + "public class TestJavac {\n"
            + "    public static boolean test() {\n"
            + "        Predicate<List> predicate = (v -> v.size() == 5);\n"
            + "        boolean result = predicate.test(Arrays.asList(1, 2, 3, 4, 5));\n"
            + "        System.out.println(result);\n"
            + "        return result;\n"
            + "    }\n"
            + "}";
        java8Test.createAndCompileFile(code);
        java8Test.run();

    }

    //创建java文件 Test类 runCode方法
    public void createAndCompileFile(String code) throws Exception {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(fileName));
        dataOutputStream.writeBytes(code);
        dataOutputStream.close();

        Process process = Runtime.getRuntime().exec("javac -d " + classPath + fileName);
        process.waitFor();
    }

    public void run() throws Exception {
        Class.forName("com.ljj.malllearning.java8.TestJavac").getMethod("test").invoke(null);
    }
}
