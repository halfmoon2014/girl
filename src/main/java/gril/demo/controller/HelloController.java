package gril.demo.controller;

import gril.demo.domain.Girl;
import gril.demo.properties.GirlProperties;
import gril.demo.service.NotificacionesJpaController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {
	@Autowired
	private NotificacionesJpaController notificacionesJpaController;
    @Autowired
    private GirlProperties girlProperties;
    //@RequestMapping(value={"/say","/hi"},method= RequestMethod.GET)
    @GetMapping(value={"/say"})
    public  String say(@RequestParam( value = "id",required = false,defaultValue = "0") Integer myid){
        return "id"+myid;
        //return  girlProperties.getCupSize();
        //return  "index";
    }
    
	@GetMapping(value = "/users")
	private List<Girl> usersList() {
		//List<Girl> l = new ArrayList<Girl>();
		//return l;
		return notificacionesJpaController.getNotifications(false, 0, 10);

	}
}

