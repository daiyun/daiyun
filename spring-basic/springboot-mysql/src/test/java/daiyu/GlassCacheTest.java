package daiyu;

import daiyu.user.dao.UserRepository;
import daiyu.user.vo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class GlassCacheTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void save() {

        User user = new User();

        for (int i = 0; i < 10000; i++) {

            user.setUserId("98" + i);
            user.setName(i+"");
            user.setPassword("11111");
            user.setStatus(1);
            user.setType(1);
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());


            userRepository.save(user);
        }
    }


}