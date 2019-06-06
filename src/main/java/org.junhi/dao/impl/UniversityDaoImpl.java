package org.junhi.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junhi.dao.UniversityDao;
import org.junhi.domain.City;
import org.junhi.domain.University;
import org.junhi.util.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author junhi
 * @Date 2019/6/6 13:39
 */
public class UniversityDaoImpl implements UniversityDao {
    @Override
    public List<University> getUniversityByCityName(String sql, Object[] obj) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        List<University> universityList = queryRunner.query(sql, new BeanListHandler<University>(University.class), obj);

        return universityList;
    }
}
