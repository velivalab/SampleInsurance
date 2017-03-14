FROM tomcat:8.0.41-jre8
MAINTAINER "Anand<Anand.KumarDas@cognizant.com>"

ADD target/autoclaim.war /usr/local/tomcat/webapps/
