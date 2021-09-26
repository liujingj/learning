package com.ljj.malllearning;

import com.ljj.malllearning.springboot.NameRepository;
import com.ljj.malllearning.springboot.TransactionalServiceBean;
import com.ljj.malllearning.springboot.annotation.StringRepository;
import com.ljj.malllearning.util.SpringLifeCycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.SimpleTransactionStatus;
import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedElement;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//排除数据库的配置
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan
//@PropertySource("")
//@PropertySource("")
//@PropertySources({@PropertySource(""),@PropertySource("")})
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class},scanBasePackages ="com.ljj.malllearning" )
//@StringRepository
//@Configuration
//@ComponentScan(basePackageClasses = TransactionalServiceBean.class)
//@EnableTransactionManagement
public class MallLearningApplication {
    //    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
//    @Autowired
//    private List<Test> list;
    public void main(String[] args) throws Exception {

        AnnotatedElement annotatedElement=TransactionalServiceBean.class;
        //获取@Service注解的属性
        AnnotationAttributes serviceAttributes= AnnotatedElementUtils.getMergedAnnotationAttributes(annotatedElement, Service.class);
        //获取@Transactional注解的属性
        AnnotationAttributes transactionalAttributes= AnnotatedElementUtils.getMergedAnnotationAttributes(annotatedElement, Transactional.class);
        print(serviceAttributes);
        print(transactionalAttributes);
//        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(MallLearningApplication.class);
//        Map<String,TransactionalServiceBean> map= context.getBeansOfType(TransactionalServiceBean.class);
//        map.forEach((name,bean)->{
//            System.out.printf("beanName=%s",name);
//            bean.save();
//        });
//        context.close();
//        ConfigurableApplicationContext context=SpringApplication.run(MallLearningApplication.class, args);
//        NameRepository nameRepository=(NameRepository)context.getBean("nameRepository");
//        MallLearningApplication bootstrapBean=(MallLearningApplication)context.getBean(MallLearningApplication.class);
//        System.out.println("bootstrapBean="+bootstrapBean);
//        System.out.println("nameRepository="+nameRepository);
//        System.out.println(nameRepository.findAll());

//        ConfigurableApplicationContext context=new AnnotationConfigApplicationContext(MallLearningApplication.class);
//        Map<String,MallLearningApplication> beansMap=context.getBeansOfType(MallLearningApplication.class);
//        beansMap.forEach((name,bean)->{
//            System.out.printf("bean名称：%s,对象：%s",name,bean);
//        });

//        AnnotatedElement annotatedElement=StringRepository.class;
//        AnnotationAttributes repositoryAttributes= AnnotatedElementUtils.getMergedAnnotationAttributes(annotatedElement, Repository.class);
//        print(repositoryAttributes);
//        AnnotationMetadata annotationMetadata=new StandardAnnotationMetadata(MallLearningApplication.class);
//        Set<String> annotationTypes=annotationMetadata.getAnnotationTypes().stream().map(annotationMetadata::getMetaAnnotationTypes)
//                .collect(LinkedHashSet::new,Set::addAll,Set::addAll);
//        annotationTypes.forEach(metaAnnotation->{
//            Map map=annotationMetadata.getAllAnnotationAttributes(metaAnnotation);
//            if(!CollectionUtils.isEmpty(map)){
//                map.forEach((name,value)->{
//                    System.out.printf("注解@%s 属性 %s=%s\n", ClassUtils.getShortName(metaAnnotation),name,value);
//                });
//            }
//        });

//        AnnotatedElement annotatedElement = MallLearningApplication.class;
//        StringRepository stringRepository = annotatedElement.getAnnotation(StringRepository.class);
//        Set<Annotation> set=getAllMetaAnnotations(stringRepository);
//        set.stream().forEach(annotation -> {
//            Class<?> annotationType=annotation.annotationType();
//            ReflectionUtils.doWithMethods(annotationType,
//                    method -> System.out.printf("@%s.%s=%s\n", annotationType.getSimpleName(),method.getName(), ReflectionUtils.invokeMethod(method, annotation)),
//                    method -> !method.getDeclaringClass().equals(Annotation.class)
//            );
//        });
//        String value=stringRepository.value();
//        System.out.println("stringRepository.value()="+value);


//        String className=MallLearningApplication.class.getName();
//        CachingMetadataReaderFactory cachingMetadataReaderFactory=new CachingMetadataReaderFactory();
//        MetadataReader metadataReader=cachingMetadataReaderFactory.getMetadataReader(className);
//        AnnotationMetadata annotationMetadata=metadataReader.getAnnotationMetadata();
//        annotationMetadata.getAnnotationTypes().forEach(annotationType->{
//           Set<String> metaAnnotationTypes= annotationMetadata.getMetaAnnotationTypes(annotationType);
//            metaAnnotationTypes.forEach(metaAnnotationType->{
//                System.out.printf("注解@%s 元标注@%s\n",annotationType,metaAnnotationType);
//            });
//        });
    }
    private static void print(AnnotationAttributes annotationAttributes){
        System.out.printf("注解 @%s 属性集合：\n",annotationAttributes.annotationType().getName());
        annotationAttributes.forEach((name,value)->{
            System.out.printf("\t属性 %s:%s\n",name,value);
        });
    }
//    private static Set<Annotation> getAllMetaAnnotations(Annotation annotation) {
//        //获取所有元注解
//        Annotation[] annotations = annotation.annotationType().getAnnotations();
//        if (ObjectUtils.isEmpty(annotations)) {
//            return Collections.emptySet();
//        }
//        //排除java标准注解，如@Target @Document等 他们因相互依赖将导致递归不断
//        Set<Annotation> set = Stream.of(annotations).filter(metaAnnotation -> !metaAnnotation.annotationType().getPackage().equals(Target.class.getPackage()))
//                .collect(Collectors.toSet());
//        //递归查找元注解的注解集合
//        Set<Annotation> metaSet = set.stream().map(MallLearningApplication::getAllMetaAnnotations).collect(HashSet::new, Set::addAll, Set::addAll);
//        //添加递归结果
//        set.addAll(metaSet);
//        return set;
//    }
//    @Bean
//    @Role(BeanDefinition.ROLE_APPLICATION)//应用角色
//    public ApplicationRunner runner(WebServerApplicationContext context){
//        return args -> {
//            System.out.println("当前server实现类为："+context.getWebServer().getClass().getName());
//        };
//    }
//
//    @EventListener(WebServerInitializedEvent.class)
//    public void onWebServerReady(WebServerInitializedEvent event){
//        System.out.println("当前server实现类为："+event.getWebServer().getClass().getName());
//    }
    @Bean("txManager")
    public PlatformTransactionManager txManager(){
        return new PlatformTransactionManager() {
            @Override
            public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
                return new SimpleTransactionStatus();
            }
            @Override
            public void commit(TransactionStatus status) throws TransactionException {
                System.out.println("txManager:事务提交");
            }
            @Override
            public void rollback(TransactionStatus status) throws TransactionException {}
        };
    }

    @Bean("txManager2")
    public PlatformTransactionManager txManager2(){
        return new PlatformTransactionManager() {
            @Override
            public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
                return new SimpleTransactionStatus();
            }
            @Override
            public void commit(TransactionStatus status) throws TransactionException {
                System.out.println("txManager2:事务提交");
            }
            @Override
            public void rollback(TransactionStatus status) throws TransactionException {}
        };
    }
}
