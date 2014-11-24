package com.zf.cometd.subscribe;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.cometd.annotation.Service;
import org.cometd.annotation.Session;
import org.cometd.bayeux.Message;
import org.cometd.bayeux.server.BayeuxServer;
import org.cometd.bayeux.server.ServerSession;

/**
 * 不能订阅到服务频道的消息/service/hello
 */
@Named
@Singleton
@Service("helloSubscribe")
public class HelloServiceSubscribe {

	@Inject
	private BayeuxServer bayeux;
	@Session
	private ServerSession serverSession;

	@org.cometd.annotation.Subscription("/service/hello")
	public void echo(Message message)
	{
		System.out.println("HelloServiceSubscribe: " + message);
	}

	
}
