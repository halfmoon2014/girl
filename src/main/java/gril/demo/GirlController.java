package gril.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;
    @GetMapping(value = "/girls")
    public List<Girl> girlsList(){
        return girlRepository.findAll();
    }

    @PostMapping(value = "/girls")
    public  Girl girlAdd(@RequestParam("cupSize") String cupSize,
                          @RequestParam("age") Integer age){
        Girl girl= new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return  girlRepository.getOne(id);
    }
    //更新
    //@PutMapping(value = "/girls/{id}")

    //删除
    //@DeleteMapping(value = "/girls/{id}")
}
