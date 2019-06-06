package org.junhi.dao;

import org.junhi.domain.City;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author junhi
 * @Date 2019/6/6 11:25
 */
public interface CityDao {

    /**
     * 获取城市列表的list数组
     * @param sql
     * @param obj
     * @return
     */
    List<City> getCityList(String sql, Object[] obj) throws SQLException;
}
