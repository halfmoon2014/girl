package gril.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;
    @GetMapping(value = "/girls")
    public List<Girl> girlsList(){
        return girlRepository.findAll();
    }
}
