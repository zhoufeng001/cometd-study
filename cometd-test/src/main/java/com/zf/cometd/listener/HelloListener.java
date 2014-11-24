package com.zf.cometd.listener;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.cometd.annotation.Listener;
import org.cometd.annotation.Service;
import org.cometd.annotation.Session;
import org.cometd.bayeux.server.BayeuxServer;
import org.cometd.bayeux.server.ServerMessage;
import org.cometd.bayeux.server.ServerSession;

@Named
@Singleton
@Service("helloListener")
public class HelloListener {

	@Inject
	private BayeuxServer bayeux;
	@Session
	private ServerSession serverSession;
	
	@Listener("/service/hello")
	public void processHello(ServerSession remote, ServerMessage message)
	{
		System.out.println("HelloListener...");
	}

}
