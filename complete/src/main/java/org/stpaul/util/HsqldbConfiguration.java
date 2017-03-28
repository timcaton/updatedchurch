package org.stpaul.util;

import org.hsqldb.server.ServerAcl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.SmartLifecycle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.hsqldb.Server;
import org.hsqldb.persist.HsqlProperties;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by tjc4h on 3/28/2017.
 */
@Configuration
public class HsqldbConfiguration {
    @Bean(initMethod = "start")
    public HsqldbServer hsqldbServer(){
        Properties props = new Properties();
        props.setProperty("server.database.0", "mem:testdb");
        props.setProperty("server.dbname.0", "testdb");
        props.setProperty("server.remote.open", "true");
        props.setProperty("hsqldb.reconfig_logging", "false");
        return new HsqldbServer(props);
    }

    public static class HsqldbServer implements SmartLifecycle {
        private final Logger logger = LoggerFactory.getLogger(HsqldbServer.class);
        private HsqlProperties properties;
        private Server server;
        private boolean running = false;

        public HsqldbServer(Properties props) {
            properties = new HsqlProperties(props);
        }

        @Override
        public boolean isRunning(){
            if(server != null)
                server.checkRunning(running);
            return running;
        }

        @Override
        public void start() {
            if(server == null) {
                logger.info("Starting HSQLDB Server");
                server = new Server();
                try {
                    server.setProperties(properties);
                    server.start();
                    running = true;
                }catch (ServerAcl.AclFormatException afe){
                    logger.error("Error starting HSQLDB", afe);
                }catch (IOException e){
                    logger.error("Error starting HSQLDB", e);
                }
            }
        }

        @Override
        public void stop(){
            logger.info("Stopping HSQLDB");
            if (server != null){
                server.stop();
                running = false;
            }
        }

        @Override
        public int getPhase(){
            return 0;
        }

        @Override
        public boolean isAutoStartup() {
            return true;
        }

        @Override
        public void stop(Runnable runnable) {
            stop();
            runnable.run();
        }
    }
}
