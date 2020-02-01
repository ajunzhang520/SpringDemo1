package example4;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class Loader implements InitializingBean {
    private Log log = LogFactory.getLog(Loader.class);

    public void afterPropertiesSet() throws Exception {
        log.info("afterPropertiesSet: " + new Date());
        System.out.println("afterPropertiesSet: " + new Date());
    }

}

