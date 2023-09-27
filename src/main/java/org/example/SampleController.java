package org.example;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

// вешаем аннотации, говорящие, что это REST-контроллер,
// который сконфигурируется сам
@Controller
@EnableAutoConfiguration
public class SampleController {

    // сообщаем сервису, что он должен работать по URL-адресу /hello
    // например, http://localhost:8080/hello
    // и говорим, что у него должно быть тело ответа (т.е. ответ не пустой)
    @RequestMapping("/hello")
    @ResponseBody
    String helloCourse() {
        return "Hello SkillFactory!";
    }

    public static void main(String[] args) throws Exception {
        // метод, который запускает наше Spring-приложение,
        // от main больше ничего не надо
        SpringApplication.run(SampleController.class, args);
    }
}