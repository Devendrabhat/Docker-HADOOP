#! /bin/bash

source ~/.bashrc
hdfs namenode -format
cat ~/.ssh/id_rsa.pub >> ~/.ssh/authorized_keys
service ssh restart
apt-get install -y mysql-server
/etc/init.d/mysql start
service apache2 restart
rm -rf /usr/local/hadoop_store/hdfs/datanode/*

start-dfs.sh
start-yarn.sh
jps

