package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!"); // model에 key가 "data"이고 value가 "hello!!"인 값 add
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name); // key, value
        return "hello-template";
    }

    // 문자열 넘기기
    @GetMapping("hello-string")
    @ResponseBody
    /*ResponseBody : viewResolver 사용하지 않음
    * 대신 http의 body 부분에 내용을 직접 반환*/
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    //객체 넘기기
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
