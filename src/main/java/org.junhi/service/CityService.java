package org.junhi.service;

import org.junhi.domain.City;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author junhi
 * @Date 2019/6/6 11:26
 */
public interface CityService {

    /**
     * 获取所有的city列表，返回一个list数组
     * @return
     * @throws SQLException
     */
    List<City> getCityList() throws SQLException;
}
