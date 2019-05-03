package cn.edu.sict.service;

import cn.edu.sict.dao.girlDao;
import org.junit.Test;

public class girlService {
    public void queryService(){
        girlDao girlDao=new girlDao();
        girlDao.queryDao();
        System.out.println("调用service层代码......");
    }
    @Test
    public void test(){
        queryService();
    }
}
