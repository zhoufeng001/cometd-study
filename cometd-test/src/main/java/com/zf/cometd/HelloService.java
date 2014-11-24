
package com.zf.cometd;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.cometd.annotation.Listener;
import org.cometd.annotation.Service;
import org.cometd.annotation.Session;
import org.cometd.bayeux.server.BayeuxServer;
import org.cometd.bayeux.server.LocalSession;
import org.cometd.bayeux.server.ServerMessage;
import org.cometd.bayeux.server.ServerSession;

@Named
@Singleton
@Service("helloService")
public class HelloService
{
    @Inject
    private BayeuxServer bayeux;
    @Session
    private ServerSession serverSession;

    @PostConstruct
    public void init()
    {
    }

    @Listener("/service/hello")
    public void processHello(ServerSession remote, ServerMessage message)
    {
        Map<String, Object> input = message.getDataAsMap();
        String name = (String)input.get("name");
        Map<String, Object> output = new HashMap<>();
        output.put("greeting", "Hello, " + name);
        // 这种方式只有remte一个客户端能收到订阅的消息
        remote.deliver(serverSession, "/hello", output);  
        
        //这种方式能让所有订阅了/hello频道的客户端收到消息
        serverSession.getLocalSession().getChannel("/hello").publish(output);  
        
    }
}
