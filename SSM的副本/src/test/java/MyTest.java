import com.zhou.pojo.Agency;
import com.zhou.service.impl.AgencyServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MyTest {

    @Test
    public void test01() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AgencyServiceImpl agencyService = (AgencyServiceImpl) context.getBean("AgencyServiceImpl");
        for (Agency agency : agencyService.queryAgencyList(new HashMap<>())) {
            System.out.println(agency);
        }
    }

    @Test
    public void test02() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AgencyServiceImpl agencyService = (AgencyServiceImpl) context.getBean("AgencyServiceImpl");
        Map<String, Object> map = new HashMap<>();
        map.put("distributoridName", "胡氏家族");
        map.put("distributoridAddress", "南充");
        map.put("contactPerson", "胡俊杰");
        map.put("contactMethod", "999999999");
        map.put("updateTime", new Date());
        map.put("status", 1);
        System.out.println(agencyService.insertAgency(map));
    }

    @Test
    public void test03() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AgencyServiceImpl agencyService = (AgencyServiceImpl) context.getBean("AgencyServiceImpl");
        Map<String, Object> map = new HashMap<>();
        map.put("distributorId", "65751000-deab-11ed-bed6-1f0fee7ca1b5");
        System.out.println(agencyService.deleteAgency(map));
    }

    @Test
    public void test04() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AgencyServiceImpl agencyService = (AgencyServiceImpl) context.getBean("AgencyServiceImpl");
        Map<String, Object> map = new HashMap<>();
        map.put("distributorId", "1");
        map.put("distributoridName", "万键集团");
        map.put("contactPerson", "周渠岸");
        map.put("contactMethod", "88888888");
        System.out.println(agencyService.updateAgency(map));

    }

}

