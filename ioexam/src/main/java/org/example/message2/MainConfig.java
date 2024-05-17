package org.example.message2;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ServiceConfig.class)
public class MainConfig { // 하나에 몽땅 가지고 있지 않고 컴포넌트를 분리하여 재사용한다던지 할 수 있음.

    // 추가적인 설정이 있다면 여기에!!!
    MainConfig() {
        System.out.println("MainConfig 파일이 생성!!");
    }


}
