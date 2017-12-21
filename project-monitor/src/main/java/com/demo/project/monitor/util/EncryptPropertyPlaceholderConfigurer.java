package com.demo.project.monitor.util;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Properties;

/**
 * 解密配置文件敏感内容
 */
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
    @Override
    protected String resolvePlaceholder(String placeholder, Properties props) {
        String result = props.getProperty(placeholder);
        if(placeholder.endsWith("jdbc.password")){
            AESEncryption aes = new AESEncryption();
            String decrypt = aes.decrypt(result);
            result = decrypt == null ? result : decrypt;
        }
        return result;
    }
}
