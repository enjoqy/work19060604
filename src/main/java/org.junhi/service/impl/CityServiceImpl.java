package org.junhi.service.impl;

import org.junhi.dao.impl.CityDaoImpl;
import org.junhi.domain.City;
import org.junhi.service.CityService;
import org.junhi.util.JedisUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Author junhi
 * @Date 2019/6/6 11:26
 */
public class CityServiceImpl implements CityService {

    /**
     * 获取所有城市列表
     * @return
     * @throws SQLException
     */
    @Override
    public List<City> getCityList() throws SQLException {

        //获取jedis
        Jedis jedis = JedisUtils.getJedis();
        //查询city对象的值
        Set<Tuple> cityJedis = jedis.zrangeWithScores("city", 0, -1);

        List<City> cityList = null;
        //如果redis中没有city对应的值，则从数据库中查询，否则从redis中读取
        if(cityJedis == null || cityJedis.size() == 0){
            System.out.println("从数据库中查询");

            String sql = "select * from city";
            cityList = new CityDaoImpl().getCityList(sql, new Object[]{});

            //将数据库中查出来的值，写入到redis中
            for (int i = 0; i < cityList.size(); i++) {
                jedis.zadd("city", cityList.get(i).getCid(), cityList.get(i).getCityName());
            }
        }else{
            System.out.println("从缓存中查询");

            //从缓存中读取对应的值
            cityList = new ArrayList<City>();
            for(Tuple tuple : cityJedis){
                City city = new City();
                city.setCid((int) tuple.getScore());
                city.setCityName(tuple.getElement());
                cityList.add(city);
            }
        }

        return cityList;
    }
}
