package com.patrol.common.config;

import com.patrol.common.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;


/***
 * 属性文件加载类
 *
 * @author WangSheng/2019-10-18
 *
 */
@Configuration
public class PropConfig {

    private static final Logger logger = LoggerFactory.getLogger(PropConfig.class);

    @Value("${spring.profiles.active}")
    private String system;

    @Value("${jlwh.img.url}")
    private String imgUrl;

    @Value("${jlwh.web.url}")
    private String webUrl;

    @Value("${jlwh.static.url}")
    private String staticUrl;

    @PostConstruct
    public void init(){
        Constants.system = this.system;
        Constants.imgUrl = this.imgUrl;
        Constants.webUrl = this.webUrl;
        Constants.staticUrl = this.staticUrl;

        logger.info("==================Prop Customizer==================");
        logger.info("system:"+this.system);
        logger.info("imgUrl:"+this.imgUrl);
        logger.info("webUrl:"+this.webUrl);
        logger.info("staticUrl:"+this.staticUrl);
        logger.info("===================================================");
    }
}
