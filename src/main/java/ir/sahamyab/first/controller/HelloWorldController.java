package ir.sahamyab.first.controller;

import ir.sahamyab.first.entity.HelloWorldRepository;
import ir.sahamyab.first.entity.Helloworld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    private HelloWorldRepository helloWorldRepository;

    @GetMapping("/hello")
    public Helloworld index() {
        Helloworld helloworld = new Helloworld(1L, "ali");
        return helloworld;
    }

    @PostMapping("/create-hello")
    public ResponseEntity<Helloworld> createHelloworld(@RequestBody Helloworld helloworld){
        helloWorldRepository.save(helloworld);
        ResponseEntity<Helloworld> responseEntity = new ResponseEntity<>(helloworld, HttpStatus.OK);
        return responseEntity;
    }

}
