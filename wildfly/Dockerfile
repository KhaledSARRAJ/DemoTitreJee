FROM jboss/wildfly:11.0.0.Final


#despligue del jar de mysql
ENV mysql_module_dir=/opt/jboss/wildfly/modules/system/layers/base/org/mysql/main/
RUN mkdir -p ${mysql_module_dir}
ADD module.xml ${mysql_module_dir}
ADD mysql-connector-java-5.1.49.jar ${mysql_module_dir}

#configuracion del datasource
ENV config_dir=/opt/jboss/wildfly/standalone/configuration
ADD standalone.xml ${config_dir}

#despliegue del archivo war
#ADD /war/MyCrudDemoJEE.war /opt/jboss/wildfly/standalone/deployments/

#creacion del usuario administrador
RUN /opt/jboss/wildfly/bin/add-user.sh admin admin --silent

#inicio del servidor
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]

