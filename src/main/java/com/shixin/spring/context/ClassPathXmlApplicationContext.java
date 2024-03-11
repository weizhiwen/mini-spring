package com.shixin.spring.context;

import com.shixin.spring.beans.BeanDefinition;
import com.shixin.spring.beans.BeanFactory;
import com.shixin.spring.beans.BeansException;
import com.shixin.spring.beans.SimpleBeanFactory;
import com.shixin.spring.beans.support.XmlBeanDefinitionReader;
import com.shixin.spring.core.ClassPathXmlResource;
import com.shixin.spring.core.Resource;

public class ClassPathXmlApplicationContext implements BeanFactory {
    BeanFactory beanFactory;

    public ClassPathXmlApplicationContext(String fileName) {
        Resource resource = new ClassPathXmlResource(fileName);
        SimpleBeanFactory beanFactory = new SimpleBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(resource);
        this.beanFactory = beanFactory;
    }

    public Object getBean(String beanName) throws BeansException {
        return beanFactory.getBean(beanName);
    }

    @Override
    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        beanFactory.registerBeanDefinition(beanDefinition);
    }
}
