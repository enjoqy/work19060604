package org.junhi.dao;

import org.junhi.domain.City;
import org.junhi.domain.University;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author junhi
 * @Date 2019/6/6 13:38
 */
public interface UniversityDao {

    /**
     * 通过城市的名字，获取对应的大学列表
     * @param sql
     * @param obj
     * @return
     * @throws SQLException
     */
    List<University> getUniversityByCityName(String sql, Object[] obj) throws SQLException;
}
