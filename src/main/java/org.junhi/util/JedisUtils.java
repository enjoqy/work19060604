package org.junhi.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * redis的工具类，加载配置文件，返回一个jedis连接
 * @Author junhi
 * @Date 2019/6/6 14:32
 */
public final class JedisUtils {

    private static JedisPool jedisPool;

    static {
        //通过配置文件加载redis对应的参数
        InputStream is = JedisUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //读取数据，设置到jedisPoolConfig中
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));
        jedisPoolConfig.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));

        //初始化JedisPool
        jedisPool = new JedisPool(jedisPoolConfig, properties.getProperty("host"), Integer.parseInt(properties.getProperty("port")));
    }

    /**
     * 获取连接的方法
     * @return
     */
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }

    /**
     * 关闭连接的方法
     * @param jedis
     */
    public static void close(Jedis jedis){
        if(jedis != null){
            jedis.close();
        }
    }
}
