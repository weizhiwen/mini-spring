package com.shixin.spring.beans;

import java.util.HashMap;
import java.util.Map;

public class SimpleBeanFactory implements BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();
    private Map<String, Object> singletonMap = new HashMap<>();

    @Override
    public Object getBean(String beanName) throws BeansException {
        Object singleton = singletonMap.get(beanName);
        if (singleton != null) {
            return singleton;
        }
        boolean contains = beanDefinitionMap.containsKey(beanName);
        if (!contains) {
            throw new BeansException();
        }
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        try {
            singleton = Class.forName(beanDefinition.getClassName()).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        singletonMap.put(beanName, beanDefinition);
        return singleton;
    }

    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanDefinition.getId(), beanDefinition);
    }
}
