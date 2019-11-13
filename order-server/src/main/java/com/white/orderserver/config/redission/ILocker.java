package com.white.orderserver.config.redission;

import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

/**
 * 锁接口
 *
 * @author lianxinxiong
 */
public interface ILocker {

    /**
     * 加锁
     * @param lockKey
     * @return
     */
    RLock lock(String lockKey);

    /**
     * 加锁并有超时时间，单位：秒
     * @param lockKey
     * @param timeout
     * @return
     */
    RLock lock(String lockKey, int timeout);

    /**
     * 加锁并有超时时间，并且可以设置时间单位
     * @param lockKey
     * @param unit
     * @param timeout
     * @return
     */
    RLock lock(String lockKey, TimeUnit unit, int timeout);

    /**
     *  尝试获取锁
     * @param lockKey
     * @param unit
     * @param waitTime 最多等待时间
     * @param leaseTime 上锁后自动释放锁时间
     * @return
     */
    boolean tryLock(String lockKey, TimeUnit unit, int waitTime, int leaseTime);

    /**
     * 释放锁
     * @param lockKey
     */
    void unlock(String lockKey);

    /**
     * 释放锁
     * @param lock
     */
    void unlock(RLock lock);
}
