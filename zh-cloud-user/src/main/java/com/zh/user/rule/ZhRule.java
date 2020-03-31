package com.zh.user.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;

/**
 * 自定义负载均衡规则
 *
 * @author he.zhang
 * @date 2020/3/15 22:14
 */
public class ZhRule extends AbstractLoadBalancerRule {

    Random rand;

    /**
     * 当前下标，因为list下标是从0开始的，所以初始值选择-1，表示不存在
     */
    private int nowIndex = -1;

    /**
     * 对比的上一次下标
     */
    private int lastIndex = -1;

    /**
     * 跳过的下标
     */
    private int skipIndex = -1;

    public ZhRule(){
        rand = new Random();
    }

    /**
     * 伪随机，当一个下标（微服务） 连续被调用两次， 第三次如果还是它， 那么咱们就再随机一次。
     * Randomly choose from all living servers
     */
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            // 如果当前线程被中断，返回null
            if (Thread.interrupted()) {
                return null;
            }
            // 获取要访问的服务器
            List<Server> upList = lb.getReachableServers();
            // 获取所有服务器列表
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }

            int index = rand.nextInt(serverCount);
            System.out.println("当前下标:"+index);
            if (index==skipIndex){
                System.out.println("跳过");
                index =rand.nextInt(serverCount);
                lastIndex = -1;
                System.out.println("跳过之后的下标:"+index);
            }
            //1 1   0
            skipIndex = -1;
            nowIndex = index;
            if(nowIndex==lastIndex){
                System.out.println("需要跳过的下标："+nowIndex);
                skipIndex = nowIndex;
            }

            // 根据下标获取服务器
            server = upList.get(index);

            // 每次随机之后，上一次下标就变成当前下标
            lastIndex = nowIndex;

            // 如果服务为空，中断
            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub

    }

}
