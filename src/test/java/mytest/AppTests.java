package mytest;

import gril.demo.controller.GirlController;
import gril.demo.dycs;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration()
public class AppTests {
    private MockMvc mockMvc;
    //测试接口
    @Before
    public void setup() {
        //MockitoAnnotations.initMocks(this);
        //this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();
        this.mockMvc = MockMvcBuilders.standaloneSetup(new dycs()).build();//获取mockMvc实例
    }
    @Test
    public void simple() throws Exception {
////测试VIEW
//        mockMvc.perform(get("/SetData"))//执行一个RequestBuilder请求
//                .andExpect(view().name("test"))//验证返回视图是否是"index2"
//                .andExpect(status().isOk())
//                .andDo(print()); //打印结果到控制台
        //测试接口
        mockMvc.perform(post("/SetData1").param("name","zs"))//执行一个RequestBuilder请求

                .andExpect(status().isOk())
                .andDo(print()); //打印结果到控制台
    }

}
