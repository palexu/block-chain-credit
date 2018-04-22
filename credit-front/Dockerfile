FROM hub.c.163.com/library/nginx
MAINTAINER palexu <1098672878@qq.com>
#把当前打包工程的html复制到虚拟地址
ADD dist /usr/share/nginx/html
#使用自定义nginx.conf配置端口和监听
COPY nginx.conf /etc/nginx/nginx.conf
