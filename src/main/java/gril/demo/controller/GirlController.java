package gril.demo.controller;

import gril.demo.domain.Result;
import gril.demo.service.GirlService;
import gril.demo.domain.Girl;
import gril.demo.repository.GirlRepository;
import gril.demo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
public class GirlController {
    private  final static Logger logger= LoggerFactory.getLogger(GirlController.class);
    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;
    /**
     * 获取所有女生
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlsList(){
        logger.info("girlsList");
        return girlRepository.findAll();
    }

    /**
     * 新增女生
     * @return
     */
    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return  ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * 查找
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return   girlRepository.findOne(id);
    }
    //更新
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdata(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age  ){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age );
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);

    }

    //删除
    @DeleteMapping(value = "/girls/{id}")
    public  void deleGirl(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return  girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public  void    girlTwo(){
      girlService.insertTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public  void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }
}
