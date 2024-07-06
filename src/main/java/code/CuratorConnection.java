package code;

// Copyright (c) 2024, NoCodeNoLife-cloud. All rights reserved.
// Author: NoCodeNoLife-cloud
// stay hungry，stay foolish
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;

public class CuratorConnection {
	/**
	 * Entry point of the application.
	 * @param args The command line arguments.
	 */
	public static void main(String[] args) throws Exception {
		CuratorFramework curatorFramework = CuratorFrameworkFactory.builder().connectString("127.0.0.1:2181").sessionTimeoutMs(4000).retryPolicy(new ExponentialBackoffRetry(1000, 3)).namespace("").build();
		curatorFramework.start();
		// create node
		curatorFramework.delete().forPath("/runoob");
		curatorFramework.create().forPath("/runoob", "0".getBytes());
		Stat stat = new Stat();
		// 查询节点数据
		byte[] bytes = curatorFramework.getData().storingStatIn(stat).forPath("/runoob");
		System.out.println(new String(bytes));
		curatorFramework.delete().forPath("/runoob");
		curatorFramework.close();
	}
}
