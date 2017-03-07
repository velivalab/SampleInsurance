#!/bin/sh

TOMCAT_SERVER_URL=$1
echo "Tomcat Serrver Url is : $TOMCAT_SERVER_URL"

VERSION_NO=$2
echo "Version to be downloaded is : $VERSION_NO"

cd /tmp

echo "Downloading InsuranceManagement war version $VERSION_NO"
wget "http://ec2-52-24-142-120.us-west-2.compute.amazonaws.com:8081/nexus/content/repositories/releases/content/repositories/releases/org/cdsdemo/InsuranceManagement/$VERSION_NO/InsuranceManagement-$VERSION_NO.war"

if [ -f InsuranceManagement-$VERSION_NO.war ]; then
        echo "Downloaded Insuurance management war version $VERSION_NO"

        cp InsuranceManagement-$VERSION_NO.war InsuranceManagement.war
        echo "Copied InsuranceManagement-$VERSION_NO.war to InsuranceManagement.war"

        echo "Deploying InsuranceManagement.war to Tomcat Server $TOMCAT_SERVER_URL"
        curl -v --basic --user admin:devops --upload-file InsuranceManagement.war "http://manager-script:changeit@$TOMCAT_SERVER_URL/manager/text/deploy?path=/InsuranceManagement&update=true"
        echo "Deployment Successful"
        rm -f InsuranceManagement*.war
else
        echo "Deployment Failed"
fi
