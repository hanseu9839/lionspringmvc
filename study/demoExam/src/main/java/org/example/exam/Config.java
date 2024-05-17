package org.example.exam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 설정을 올려주는데 어떤애를 쓸건지
// 컨테이너위에 어떤 객체를 쓸건지 올려둔다.
@Configuration
public class Config {

    @Bean
    public A a(){
        return new A();
    }

    @Bean
    public B b() {
        return new B();
    }

    @Bean
    public C c() {
        return new C();
    }

}
