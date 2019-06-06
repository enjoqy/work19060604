package org.junhi.service;

import org.junhi.domain.City;
import org.junhi.domain.University;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author junhi
 * @Date 2019/6/6 13:37
 */
public interface UniversityService {

    /**
     * 传入城市名，查询城市中所有的大学
     * @param cName
     * @return
     * @throws SQLException
     */
    List<University> getUniversityByCityName(String cName) throws SQLException;
}
