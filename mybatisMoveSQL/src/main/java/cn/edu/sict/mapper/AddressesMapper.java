package cn.edu.sict.mapper;

import cn.edu.sict.pojo.Addresses;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressesMapper {
    Addresses queryByid(Integer id);

    Addresses queryState(String state);

    List<Addresses> queryCityCountry(@Param("city") String city, @Param("country") String country);

    int update(Addresses addresses);

    List<Addresses> query(Addresses addresses);

    List<Addresses> queryTrim(Addresses addresses);

    List<Addresses> queryByids(List<Integer> ids);

    List<Addresses> queryLike(@Param("city") String city);
}
