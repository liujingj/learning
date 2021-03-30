package com.ljj.malllearning.jvm;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementScanner8;

/**
 * 注解处理器--编译器插件
 *
 * @author ljj
 * @date 2021/3/18
 */
@SupportedAnnotationTypes("*")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class NameCheckProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (!roundEnv.processingOver()) {
            NameCheckScanner scanner = new NameCheckScanner();
            for (Element element : roundEnv.getRootElements()) {
                scanner.scan(element);
            }
        }
        return false;
    }

    public static class NameCheckScanner extends ElementScanner8 {

        /**
         * 检查java类
         *
         * @param e
         * @param o
         * @return
         */
        @Override
        public Object visitType(TypeElement e, Object o) {
            return super.visitType(e, o);
        }

        /**
         * 检查变量命名
         *
         * @param e
         * @param o
         * @return
         */
        @Override
        public Object visitVariable(VariableElement e, Object o) {
            return super.visitVariable(e, o);
        }

        /**
         * 检查方法命名
         *
         * @param e
         * @param o
         * @return
         */
        @Override
        public Object visitExecutable(ExecutableElement e, Object o) {
            return super.visitExecutable(e, o);
        }
    }
}
