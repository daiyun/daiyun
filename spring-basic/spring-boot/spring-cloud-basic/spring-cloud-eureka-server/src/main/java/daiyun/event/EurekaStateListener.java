package daiyun.event;

import com.netflix.appinfo.InstanceInfo;
import daiyun.service.DcsInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author godaiyun
 * @date 2019-03-11 17:28.
 */
@Component
@ComponentScan
public class EurekaStateListener {
    private final static Logger LOGGER = LoggerFactory.getLogger(EurekaStateListener.class);

    @Autowired
    private DcsInfoService dcsInfoService;


    @EventListener(condition = "#event.replication==false")
    public void listen(EurekaInstanceCanceledEvent event) {
        String msg = "服务" + event.getAppName() + "\n" + event.getServerId() + "已下线";
        LOGGER.info(msg);
    }

    @EventListener(condition = "#event.replication==false")
    public void listen(EurekaInstanceRegisteredEvent event) {
        InstanceInfo instanceInfo = event.getInstanceInfo();


        String msg = "服务" + instanceInfo.getAppName() + "\n" + instanceInfo.getHostName() + ":" + instanceInfo.getPort() + " \nip: " + instanceInfo.getIPAddr() + "进行注册";
        LOGGER.info(msg);
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {

        InstanceInfo instanceInfo = event.getInstanceInfo();
        String msg = "服务" + instanceInfo.getAppName() + "\n" + instanceInfo.getHostName() + ":" + instanceInfo.getPort() + " \nip: " + instanceInfo.getIPAddr() + "进行续约";
        LOGGER.info(msg);
    }

    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        LOGGER.info("注册中心启动,{}", System.currentTimeMillis());
    }

    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        LOGGER.info("注册中心服务端启动,{}", System.currentTimeMillis());
    }

}
