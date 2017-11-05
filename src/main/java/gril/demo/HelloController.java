package gril.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;
    //@RequestMapping(value={"/say","/hi"},method= RequestMethod.GET)
    @GetMapping(value={"/say"})
    public  String say(@RequestParam( value = "id",required = false,defaultValue = "0") Integer myid){
        return "id"+myid;
        //return  girlProperties.getCupSize();
        //return  "index";
    }
}

