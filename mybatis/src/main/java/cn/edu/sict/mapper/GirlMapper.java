package cn.edu.sict.mapper;

import cn.edu.sict.pojo.A;
import cn.edu.sict.pojo.B;
import cn.edu.sict.pojo.Girl;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface GirlMapper {
    int insert(Girl girl);

    Girl queryById(Long id);

    Girl queryById2(long id);

    Girl queryByName(String name);

    Girl queryByNameFlower(@Param("name") String name, @Param("flower") String flower);

    Girl queryByNameFlower2(Girl girl);

    Girl queryByNameFlower3(Map<String, Object> map);

    Girl queryByAB(@Param("a") A a, @Param("b") B b);
}
