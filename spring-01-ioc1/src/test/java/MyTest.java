import com.ling.dao.UserDaoImpl;
import com.ling.dao.UserDaoMysqlImpl;
import com.ling.service.UserServiceImpl;
import org.junit.Test;

public class MyTest {
    @Test
    public static void main(String[] args) {
        //用户实际调用的市业业务层
        UserServiceImpl userService = new UserServiceImpl();
        //利用set进行动态实现值
        userService.setUserDao(new UserDaoMysqlImpl());
        userService.getUser();
    }
}
