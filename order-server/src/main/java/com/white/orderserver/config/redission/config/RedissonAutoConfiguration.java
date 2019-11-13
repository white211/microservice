package com.white.orderserver.config.redission.config;

import com.white.orderserver.config.redission.Impl.RedissonLocker;
import com.white.orderserver.config.redission.util.RedissonLockUtil;
import org.apache.commons.lang.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * redission配置文件
 */
@Configuration
public class RedissonAutoConfiguration {
//    @Autowired
//    private RedissonProperties redssionProperties;

    private int timeout = 3000;

    @Value("${redission.prop.address}")
    private String address;

    @Value("${redission.prop.password}")
    private String password;

    private int connectionPoolSize = 64;

    private int connectionMinimumIdleSize = 10;

    private int slaveConnectionPoolSize = 250;

    private int masterConnectionPoolSize = 250;

    private String[] sentinelAddresses;

    private String masterName;

    @Bean
    RedissonClient redissonSingle() {
        Config config = new Config();
        SingleServerConfig serverConfig = config.useSingleServer()
                .setAddress(address)
                .setTimeout(timeout)
                .setConnectionPoolSize(connectionPoolSize)
                .setConnectionMinimumIdleSize(connectionMinimumIdleSize);

        if (StringUtils.isNotBlank(password)) {
            serverConfig.setPassword(password);
        }

        return Redisson.create(config);
    }


    /**
     * 装配locker类，并将实例注入到RedissLockUtil中
     *
     * @return
     */
    @Bean
    RedissonLocker redissonLocker(RedissonClient redissonClient) {
        RedissonLocker locker = new RedissonLocker();
        locker.setRedissonClient(redissonClient);
        RedissonLockUtil.setLocker(locker);
        return locker;
    }
}
