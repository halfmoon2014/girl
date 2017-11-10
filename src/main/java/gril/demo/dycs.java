package gril.demo;


import javax.servlet.http.HttpServletRequest;

import gril.demo.domain.Girl;
import gril.demo.repository.GirlRepository;
import gril.demo.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class dycs {
    @Autowired
    private GirlService girlService;
    @Autowired
    private GirlRepository girlRepository;
    @RequestMapping("/SetData")
    public String SetData() {
        return "test";
    }

    @RequestMapping("/SetData1")
    @ResponseBody
    public String SetData1(HttpServletRequest request) {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(19);
        girlA.setMoney(2.0);
        //girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("B");
        girlB.setMoney(1.5);
        girlB.setAge(20);
       // girlRepository.save(girlB);
        return "888888888888"+request.getParameter("name");
    }

}