package org.example.aopexam;


import org.springframework.stereotype.Service;

@Service
public class SimpleService {
    public String doSomething() {
        // 핵심관심. target
        System.out.println("SimpleService doSomething run");
        return "Doing something service...";
    }

    public void hello(){
        System.out.println("hello method run@@@");

        if(true) {
            throw new RuntimeException();
        }

    }

    public void setName(String name){
        System.out.println("setName() method run");
    }
}
