package cn.edu.sict;


import cn.edu.sict.mapper.AddressesMapper;
import cn.edu.sict.pojo.Addresses;
import cn.edu.sict.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class AppTest {
    SqlSession sqlSession = MyBatisUtil.getSession();
    AddressesMapper addressesMapper = sqlSession.getMapper(AddressesMapper.class);

    @Test
    public void update() {

        Addresses addresses1 = new Addresses();
        addresses1.setZip("哈哈哈");
        addresses1.setAddrid(5);
        addressesMapper.update(addresses1);
        sqlSession.commit();
    }

    @Test
    public void t1() {
        Addresses addresses = addressesMapper.queryByid(5);
        System.out.println(addresses);
        sqlSession.close();

    }

    @Test
    public void t2() {
        Addresses addresses = addressesMapper.queryState("山东");
        System.out.println(addresses);
        sqlSession.close();
    }

    @Test
    public void t3() {

        //  List<Addresses> addresses = addressesMapper.queryCityCountry("Perry", "");
        //    List<Addresses> addresses = addressesMapper.queryCityCountry("", "Comanche");
        List<Addresses> addresses = addressesMapper.queryCityCountry("Perry", "Comanche");
        //     List<Addresses> addresses = addressesMapper.queryCityCountry(null, null);
        //   List<Addresses> addresses = addressesMapper.queryCityCountry("", "");
        System.out.println(addresses);
        sqlSession.close();
    }

    @Test
    public void t4() {

        List<Addresses> addresses = addressesMapper.queryCityCountry("Perry", "Comanche");

        for (Addresses addresses1 : addresses) {

            System.out.println(addresses1.getCountry());
            System.out.println(addresses);
        }
        sqlSession.close();
    }

    @Test
    public void t5() {
        // Addresses addresses = new Addresses("沂源", "淄博", "山东", "FDS", "中国", 5);
        Addresses addresses = new Addresses();
        addresses.setStreet("沂源县");
        addresses.setCity("淄博");
        addresses.setState("山东");
        addresses.setZip("FDS");
        //    addresses.setCountry("中国");
        addresses.setAddrid(5);
        addressesMapper.update(addresses);
        sqlSession.commit();
        Addresses addresses1 = addressesMapper.queryByid(5);
        System.out.println(addresses1);

    }

    @Test
    public void t6() {
        Addresses addresses = new Addresses();
        //   addresses.setCountry("中国");
        //     addresses.setState("山东");
        addresses.setCity("淄博");
        List<Addresses> addresses1 = addressesMapper.query(addresses);
        System.out.println(addresses1);
        sqlSession.close();
    }

    @Test
    public void t7() {
        Addresses addresses = new Addresses();
        addresses.setCity("淄博");
        List<Addresses> addresses1 = addressesMapper.queryTrim(addresses);
        System.out.println(addresses1);
        sqlSession.close();
    }

    @Test
    public void t8() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        List<Addresses> addresses1 = addressesMapper.queryByids(list);
        System.out.println(addresses1);
        sqlSession.close();
    }

    @Test
    public void t9() {
        /*模糊查询解决方案一   "%Perry%"  */
        // List<Addresses> addresses=addressesMapper.queryLike("%Perry%");
        /*方案二      city like concat("%",#{city},"%")  */
        List<Addresses> addresses = addressesMapper.queryLike("Per");
        System.out.println(addresses);
        sqlSession.close();
    }

    @Test
    //一级缓存
    public void t10() {

        List<Addresses> addresses = addressesMapper.queryLike("Per");
        System.out.println(addresses);
        Addresses addresses1 = new Addresses();
        addresses1.setZip("哈哈哈");
        addresses1.setAddrid(5);

        addressesMapper.update(addresses1);
        sqlSession.commit();
        List<Addresses> addresses2 = addressesMapper.queryLike("Per");
        System.out.println(addresses2);
        sqlSession.close();
    }


    //强制清空缓存
    @Test
    public void t11() {
        Addresses addresses = addressesMapper.queryByid(5);
        System.out.println(addresses);

//        sqlSession.clearCache();
        sqlSession.flushStatements();
        Addresses addresses2 = addressesMapper.queryByid(5);
        System.out.println(addresses2);
    }

    @Test
    //二级缓存
    public void t12() {
        SqlSession sqlSession1 = MyBatisUtil.getSession();
        AddressesMapper addressesMapper1 = sqlSession1.getMapper(AddressesMapper.class);
        SqlSession sqlSession2 = MyBatisUtil.getSession();
        AddressesMapper addressesMapper2 = sqlSession2.getMapper(AddressesMapper.class);

        Addresses addresses1 = addressesMapper1.queryByid(5);
        System.out.println(addresses1);
        sqlSession1.close();
        Addresses addresses2 = addressesMapper2.queryByid(5);
        System.out.println(addresses2);
        sqlSession2.close();
    }

}
