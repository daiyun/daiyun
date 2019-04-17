#!/usr/bin/python
# -*- coding: UTF-8 -*-

import sys
from kazoo.client import KazooClient
import logging

logging.basicConfig(
    level=logging.DEBUG
    , stream=sys.stdout
    , format='%(asctime)s %(pathname)s %(funcName)s%(lineno)d %(levelname)s: %(message)s')

# 创建一个客户端，可以指定多台zookeeper，
zk = KazooClient(hosts='127.0.0.1:2181', timeout=10.0, logger=logging)
# 开始心跳

zk.start()
print('zookeeper connected!')

# 获取根节点数据和状态
data, stat = zk.get('/iot/dcs/d022a6a7d972433d')

print(data)

print(stat)

# 获取根节点的所有子节点，返回的是一个列表，只有子节点的名称
children = zk.get_children("/")
print(children)

# 下面是根节点的返回值
# [u'rmstore', u'kazoo', u'yarn-leader-election', u'zookeeper']

# 执行stop后所有的临时节点都将失效

zk.stop()
zk.close()
