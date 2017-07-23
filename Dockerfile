FROM ubuntu
RUN useradd dev
RUN apt-get update
RUN apt-get install -y eclipse-pde
RUN mkdir /home/dev && \
	chmod 777 /home/dev && \
	su dev
WORKDIR /root
RUN apt-get update &&\ 
        apt-get install -y default-jdk openssh-client openssh-server vim net-tools

COPY ./files/* /root/
RUN chmod a+x /root/init.sh
RUN wget http://www-eu.apache.org/dist/hadoop/core/hadoop-2.7.3/hadoop-2.7.3.tar.gz
RUN mv hadoop-2.7.3.tar.gz /root/ && \
    tar xvzf /root/hadoop-2.7.3.tar.gz
RUN rm -rf /root/*.tar.gz  
RUN mkdir /usr/local/hadoop && \
	mv /root/hadoop-2.7.3 /usr/local/hadoop/ && \
	mkdir -p /usr/local/hadoop_store/hdfs/namenode    && \
	mkdir -p /usr/local/hadoop_store/hdfs/datanode   

RUN     mv /root/hadoop-env.sh /usr/local/hadoop/hadoop-2.7.3/etc/hadoop/     && \
        mv /root/core-site.xml /usr/local/hadoop/hadoop-2.7.3/etc/hadoop/     && \
        mv /root/yarn-site.xml /usr/local/hadoop/hadoop-2.7.3/etc/hadoop/     && \
        mv /root/mapred-site.xml /usr/local/hadoop/hadoop-2.7.3/etc/hadoop/   && \
        mv /root/hdfs-site.xml /usr/local/hadoop/hadoop-2.7.3/etc/hadoop/
RUN ssh-keygen -t rsa -P '' -f /root/.ssh/id_rsa


CMD [ "/root/init.sh" ]

