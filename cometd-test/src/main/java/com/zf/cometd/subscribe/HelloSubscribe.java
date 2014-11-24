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
 * 能够正常订阅到/hello广播频道的消息
 * @author zf
 *
 */
@Named
@Singleton
@Service("helloSubscribe")
public class HelloSubscribe {

	@Inject
	private BayeuxServer bayeux;
	@Session
	private ServerSession serverSession;

	@org.cometd.annotation.Subscription("/hello")
	public void echo(Message message)
	{
		System.out.println("HelloSubscribe: " + message);
	}


}
