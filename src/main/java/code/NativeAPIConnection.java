package code;

// Copyright (c) 2024, NoCodeNoLife-cloud. All rights reserved.
// Author: NoCodeNoLife-cloud
// stay hungry，stay foolish
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class NativeAPIConnection {
	/**
	 * Entry point of the application.
	 * @param args The command line arguments.
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		final CountDownLatch countDownLatch = new CountDownLatch(1);
		ZooKeeper zooKeeper =
				new ZooKeeper("127.0.0.1:2181,",
						4000, new Watcher() {
					@Override
					public void process(WatchedEvent event) {
						if (Event.KeeperState.SyncConnected == event.getState()) {
							// 如果收到了服务端的响应事件，连接成功
							countDownLatch.countDown();
						}
					}
				});
		countDownLatch.await();
		// CONNECTED
		System.out.println(zooKeeper.getState());
	}
}
