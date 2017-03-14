FROM tomcat:latest
MAINTAINER "Anand<Anand.KumarDas@cognizant.com>"

ADD target/autoclaim.war /usr/local/tomcat/webapp
