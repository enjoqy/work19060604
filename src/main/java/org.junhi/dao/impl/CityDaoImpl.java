package org.junhi.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junhi.dao.CityDao;
import org.junhi.domain.City;
import org.junhi.util.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author junhi
 * @Date 2019/6/6 11:25
 */
public class CityDaoImpl implements CityDao {


    @Override
    public List<City> getCityList(String sql, Object[] obj) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        List<City> cityList = queryRunner.query(sql, new BeanListHandler<City>(City.class), obj);
        return cityList;
    }
}
