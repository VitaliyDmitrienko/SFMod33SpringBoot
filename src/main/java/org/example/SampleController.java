package org.example;

import org.example.dto.UserData;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;


// вешаем аннотации, говорящие, что это REST-контроллер,
// который сконфигурируется сам
@Controller
@RestController
@RequestMapping("/users")
@EnableAutoConfiguration
public class SampleController {
    static String postString = null;
    UserData userData;
//    userData = null;

    // сообщаем сервису, что он должен работать по URL-адресу /hello
    // например, http://localhost:8080/hello
    // и говорим, что у него должно быть тело ответа (т.е. ответ не пустой)
//    @RequestMapping("/")
    @GetMapping("/hello")
//    @ResponseBody
    String helloCourse() {
        return "Hello SkillFactory!";
    }

    @GetMapping("/oneanswer")
//    @ResponseBody
    String something() {
        return "One answer";
    }

//    @PostMapping
////    @ResponseBody
//    void postSaver (@RequestParam String incomingString){
//        postString = incomingString;
//    }

    @PostMapping
    void createUser (@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName) {
        if (userData == null) {
            userData = new UserData();
        }
        userData.setUserID(id);
        userData.setFirstName(firstName);
        userData.setLastName(lastName);
    }

//    @GetMapping
////    @ResponseBody
//    String responseSomething() {
//        if (postString == null || postString.isEmpty()) return "Record is not present/not yet init.";
//        else return("Record is present. User name is: " + postString);
//    }

    @GetMapping
    String responseUserData () {
        if (userData == null) {
            return "Record is not present/not yet init.";
        } else {return (userData.toString());}
    }


    public static void main(String[] args) throws Exception {
        // метод, который запускает наше Spring-приложение,
        // от main больше ничего не надо
//        ApplicationContext context = new AnnotationConfigApplicationContext("org.example");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("org.example"); //Указываем, где искать наши бины
        context.refresh();  //Обновляем контекст, чтобы наши бины были созданы

//        ApplicationContext context = new ClassPathApplicationContext("config.xml");
//        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        UserData userData = (UserData) context.getBean("userData");
        UserData userData = context.getBean(UserData.class);
        System.out.println("UserData.getUserID= " + userData.getUserID());

        SpringApplication.run(SampleController.class, args);
    }
}