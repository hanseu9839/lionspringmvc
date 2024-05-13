package org.sample.run;

import org.sample.bean.MyBean;
import org.sample.config.MyBeanConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class SpringExam01 {
    public static void main(String[] args) {
//        MyBean bean = new MyBean();
//        bean.setName("Kang");
//
//        System.out.println(bean);
        //스프링 ioc container 이용해서 사용하는 경우
        // 스프링 컨테이너에게 알려줘야하지 않을까??
        // 1. 애노테이션으로 알려줌  -- 컴포넌트 스캔 해보도록!!
        // 2. 자바파일을 통해서 알려줌
        // 3. xml을 통해서 알려줌. => xml 통해서 빈을 생성해줘  -> 현재는 많이 사용하지 않는다.

        // BeanFactory -- 빈을 생성하는데 간단한 기능만 포함하고 있다. aop 기술은 사용할 수 없다.
        // 굳이 BeanFactory를 많이 사용하지 않는다.
        System.out.println("ApplicationContext 생성전!!!");
        ApplicationContext context = new AnnotationConfigApplicationContext(MyBeanConfig.class); // 공장이 생성될 때 어떤 빈을 생성해야할지 알 수 있음.
        System.out.println("ApplicationContext 생성후!!!");

        MyBean bean1 = (MyBean) context.getBean("myBean"); // lookup 방식 .. id를 알려줌.

        bean1.setName("carami");

        System.out.println(bean1);

//        MyBean bean2 = context.getBean(MyBean.class); // 타입만 알려줌

        MyBean bean2 = context.getBean("myBean2", MyBean.class);
        bean2.setName("kim");
        System.out.println(bean2);
        System.out.println(bean1);

        if(bean2 == bean1)
            System.out.println("같아요.");


        MyBean bean3  = context.getBean("myBean", MyBean.class);
        if(bean3 == bean1 ) System.out.println("bean3과 bean1은 같은 인스턴스입니다.");

        MyBean bean4 = context.getBean("myBean3", MyBean.class);
        bean4.setName("hong");

        MyBean bean5 = context.getBean("myBean3", MyBean.class);
        bean5.setName("lee");

        System.out.println(bean4);
        System.out.println(bean5);
        System.out.println(bean4);

        MyBean bean6 = context.getBean("myBean4", MyBean.class);
        System.out.println(bean6);
    }
}
