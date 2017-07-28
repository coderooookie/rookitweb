/**
 * @copyright: Copyright (c) 2015-2020 jd.com All Rights Reserved
 * @file: VelocityConfig.java project: jcloud-b2c-mall-web
 * @creator: wangxin17
 * @date: 2017/2/15
 */
package pers.shubin.config;

import org.springframework.boot.autoconfigure.velocity.VelocityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.velocity.VelocityLayoutViewResolver;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

/**
 * @description:
 * @author: wangxin17
 * @requireNo:
 * @createdate: 2017-02-15 14:54
 * @lastdate:
 */
@Configuration
public class VelocityConfig {
    @Bean
    public VelocityViewResolver velocityViewResolver(VelocityProperties velocityProperties) {
        VelocityLayoutViewResolver viewResolver = new VelocityLayoutViewResolver();
        viewResolver.setExposeRequestAttributes(true);
        velocityProperties.applyToViewResolver(viewResolver);
        return viewResolver;
    }
}
