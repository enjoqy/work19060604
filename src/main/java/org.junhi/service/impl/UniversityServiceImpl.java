package org.junhi.service.impl;

import org.junhi.dao.UniversityDao;
import org.junhi.dao.impl.UniversityDaoImpl;
import org.junhi.domain.City;
import org.junhi.domain.University;
import org.junhi.service.UniversityService;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author junhi
 * @Date 2019/6/6 13:38
 */
public class UniversityServiceImpl implements UniversityService {
    @Override
    public List<University> getUniversityByCityName(String cName) throws SQLException {
        String sql = "select * from city, university where city.cid = university.cid and city.cityname = ?";
        Object[] obj = {cName};
        UniversityDao universityDao = new UniversityDaoImpl();
        List<University> universityList = universityDao.getUniversityByCityName(sql, obj);
        return universityList;
    }
}
