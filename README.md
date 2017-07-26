# Docker-HADOOP

The thing which developers don't like is to setup environment, it might be because of lot many things.
It could be because of lot of time is wasted in installing tools.
Or it could or the errors which comes while setting up the environment.
Basically I have a view that if someone want to learn something then he should be directly be able to start using it without any complications.

So i choose HADOOP only because frankly speaking I joined a class to learn HADOOP, but all the motivation to learn was lost when it took us more then 20 hrs to setup the HADOOP environment only.
Due to this issue we got hardly few hours to learn the actual analytics and codding of MapReduce programs.

My basic target people are the students who don't have any knowledge of Docker, HADOOP and they want to start learning HADOOP from scratch.

Also my other target people are the Developers who want to switch to HADOOP and start working directly. I'll be proving more updates to the code to simplify the application more.

There are still lot of scope remaining to improve therefore I request you all to please give it a try, just the basic requirement is have at least 64 bit cpu and any amount of other configurations.
Even if you don't have 64 bit CPU, you can still start with the link given below, it is a digital ocean link with 10$ in your account.
https://m.do.co/c/de71aab856b0


HOW TO USE :=

If you already Docker installed on your system then continue with Step 2

Step 1) curl -fsSL https://get.docker.com/ | sh
        This command will install Docker on your system.
        
Step 2) sudo docker pull devendrabhat/docker_hadoop
        It will take a while to download as the image is upto 1 GB of size.
        
Step 3) sudo docker tag devendrabhat/docker_hadoop [your name]       /////////// Here use your own name

Step 4) sudo docker run --privileged -v /tmp/.X11-unix/:/tmp/.X11-unix/ -e DISPLAY=$DISPLAY -e MY_UID=$(id -u) -e MY_GID=$(id -g) -it [your name] bash

Step 5) Now start the services of HADOOP components.
        ./start_all.sh             // Just run this command to start
        
        
