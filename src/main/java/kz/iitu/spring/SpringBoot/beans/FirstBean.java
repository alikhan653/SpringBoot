package kz.iitu.spring.SpringBoot.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@Scope("singleton")
public class FirstBean {

    private String name;

    public FirstBean(){

    }

    public FirstBean(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

}
