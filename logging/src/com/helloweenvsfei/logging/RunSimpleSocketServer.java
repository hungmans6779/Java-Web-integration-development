package com.helloweenvsfei.logging;

import org.apache.log4j.net.SimpleSocketServer;

public class RunSimpleSocketServer {

	public static void main(String[] args) {
		String port = "2009";
		String file = "E:\\socket.log";
		SimpleSocketServer.main(new String[] { port, file });
	}
}
