import com.ling.service.UserService;
import com.ling.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.util.*;

public class MyTest {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        //动态代理 代理的是接口，不是类
//        UserService userService = (UserService) context.getBean("userService");
//        userService.add();
        HashMap<Object, Object> map = new HashMap<>();
        Set<Map.Entry<Object, Object>> entries = map.entrySet();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int indexEnd = m + n - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[indexEnd--] = nums1[i--];
            } else {
                nums1[indexEnd--] = nums2[j--];
            }
        }
        System.out.println(Arrays.toString(nums1));

    }
}
