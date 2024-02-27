#!bin/bash

gradle clean && gradle build && mv build/libs/eshoppers-1.0-SNAPSHOT.war build/libs/cart.war && cp build/libs/cart.war /opt/tomcat/updated/webapps/ && /opt/tomcat/updated/bin/catalina.sh stop && /opt/tomcat/updated/bin/catalina.sh start