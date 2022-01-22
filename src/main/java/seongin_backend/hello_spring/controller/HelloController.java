package seongin_backend.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //템블릿엔진 안 거치고 http응답메시지 body부분에 직접 넣어주겠다
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; //"hello spring"
    }

    @GetMapping("hello-api")
    @ResponseBody //viewresolver가 아닌 HttpMessageConverter가 동작함
                  //문자면 StringConverter동작 json이면 jsonConverter 동작
                  //객체 json으로 바꿔주는건 크게 두가지가 쓰임
                  //jackson2, gson
                  //spring은 기본적으로 jackson2 씀
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
