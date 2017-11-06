package gril.demo.service;
import gril.demo.domain.Girl;
import gril.demo.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;
    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(19);
        girlA.setMoney(2.0);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("B");
        girlB.setMoney(1.5);
        girlB.setAge(20);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl=girlRepository.findOne(id);
        Integer age=girl.getAge();
        if(age<10){
            throw  new Exception("小学生");
        }else  if (age>10 && age<16){
            throw  new Exception("初中生");
        }
    }
}