package com.aaa.hjd.config;

import com.aaa.hjd.properties.RedisConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author 胡江迪
 * Date: 2020/5/13 0013
 * Time: 18:47
 * Description:
 */
@Configuration
public class RedisConfig {
    @Autowired
    private RedisConfigProperties redisConfigProperties;

    @Bean
    public JedisCluster getJedisCluster(){
        String nodes = redisConfigProperties.getNodes();
        String[] ipPort = nodes.split(",");
        Set<HostAndPort> hostAndPortSet = new HashSet<HostAndPort>();
        for (String ipAndPort:ipPort) {
            String[] ipOrPort = ipAndPort.split(":");
            HostAndPort hostAndPort = new HostAndPort(ipOrPort[0],Integer.parseInt(ipOrPort[1]));
            hostAndPortSet.add(hostAndPort);
        }
        return new JedisCluster(hostAndPortSet,redisConfigProperties.getCommandTimeout(),redisConfigProperties.getMaxAttempts());
    }
}
