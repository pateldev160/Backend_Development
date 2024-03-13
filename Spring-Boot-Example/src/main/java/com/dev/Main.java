package com.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        System.out.println("Hello World");
    }
    @GetMapping("/greet")
    public GreetResponce greet(@RequestParam(value = "name", required = false) String name){
        String greetMessage = name==null || name.isBlank()? "Hello" : "Hello " +name;
        GreetResponce responce= new GreetResponce(greetMessage,
        List.of("Java", "Golang", "JavaScript"),
                new Person("Dev", 23, 30_000));
        return responce;
    }
    record Person (String name, int age, double savings){}
    record GreetResponce(
            String greet,
            List<String> favProgramingLanguages,
            Person person){}
   /* class GreetResponce{
        private final String greet;

      GreetResponce(String greet) {
          this.greet = greet;
      }

      public String getGreet() {
          return greet;
      }

      @Override
      public String toString() {
          return "GreetResponce{" +
                  "greet='" + greet + '\'' +
                  '}';
      }

      @Override
      public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          GreetResponce that = (GreetResponce) o;
          return Objects.equals(greet, that.greet);
      }

      @Override
      public int hashCode() {
          return Objects.hash(greet);
      }

  }

    */
}
