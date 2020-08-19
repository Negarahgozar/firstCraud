package ir.sahamyab.first.controller;

import ir.sahamyab.first.entity.HelloWorldRepository;
import ir.sahamyab.first.entity.Helloworld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloWorldController {

    @Autowired
    private HelloWorldRepository helloWorldRepository;

    @GetMapping("/hello")
    public Helloworld index() {
        Helloworld helloworld = new Helloworld(1L, "ali");
        return helloworld;
    }

    @GetMapping("get-hello")
    public Page<Helloworld> getAllHelloWorld(Pageable pageable) {

        Page<Helloworld> all = helloWorldRepository.findAll(pageable);

        return all;
    }

    @PostMapping("/create-hello")
    public ResponseEntity<Helloworld> createHelloworld(@RequestBody Helloworld helloworld) {
        helloWorldRepository.save(helloworld);
        ResponseEntity<Helloworld> responseEntity = new ResponseEntity<>(helloworld, HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/delete-hello/{id}")
    public Map<String, Boolean> deleteAllHello(@PathVariable(value = "id") Long helloId) {
        Helloworld helloWorld = helloWorldRepository.findById(helloId).orElseThrow();
        helloWorldRepository.delete(helloWorld);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    //    @RequestMapping(value = "update-hello", method = RequestMethod.PUT)
    @PutMapping("/update-hello/{id}")
    public ResponseEntity<Helloworld> updateHello(@PathVariable(value = "id") Long helloId,
                                                  @RequestBody Helloworld hello) {
        Helloworld helloWorld = helloWorldRepository.findById(helloId).orElseThrow();
        //.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        helloWorld.setName(hello.getName());
        final Helloworld updatedHelloWorld = helloWorldRepository.save(helloWorld);
        return ResponseEntity.ok(updatedHelloWorld);
    }
}
