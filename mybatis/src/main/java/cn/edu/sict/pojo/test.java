package cn.edu.sict.pojo;


import cn.edu.sict.mapper.GirlMapper;
import cn.edu.sict.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class test {
    SqlSession sqlSession = MyBatisUtil.getSession();
    GirlMapper mapper = sqlSession.getMapper(GirlMapper.class);

    @Test
    public void t1() {
        Girl g = new Girl();
        g.setName("林心如");
        g.setFlower("霍建华");
        g.setBirthday(new Date());
        mapper.insert(g);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void t2() {

        Girl g = mapper.queryById(1L);
        System.out.println(g);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void t3() {

        Girl g = mapper.queryById2(1L);
        System.out.println(g);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void t4() {

        Girl g = mapper.queryByName("林心如");
        System.out.println(g);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void t5() {

        Girl g = mapper.queryByNameFlower("林心如", "霍建华");
        System.out.println(g);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void t6() {

        Girl girl = new Girl();
        girl.setName("林心如");
        girl.setFlower("霍建华");
        Girl g = mapper.queryByNameFlower2(girl);
        System.out.println(g);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void t7() {
        Girl girl = new Girl();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "如花");
        map.put("flower", "霍建华");
        Girl g = mapper.queryByNameFlower3(map);
        System.out.println(g);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void t8() {
        A a = new A();
        a.setName("如花");
        B b = new B();
        b.setFlower("霍建华");
        Girl girl = mapper.queryByAB(a, b);
        System.out.println(girl);
        sqlSession.commit();
        sqlSession.close();

    }
}
