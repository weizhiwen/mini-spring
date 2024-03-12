package com.shixin.spring.beans.support;

import com.shixin.spring.beans.BeanDefinition;
import com.shixin.spring.beans.BeanFactory;
import com.shixin.spring.core.Resource;
import org.dom4j.Element;

public class XmlBeanDefinitionReader {
    public static final String ID = "id";
    public static final String CLASS_NAME = "class";

    BeanFactory beanFactory;

    public XmlBeanDefinitionReader(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void loadBeanDefinitions(Resource resource) {
        while (resource.hasNext()) {
            Element element = (Element) resource.next();
            String id = element.attributeValue(ID);
            String className = element.attributeValue(CLASS_NAME);
            BeanDefinition beanDefinition = new BeanDefinition(id, className);
            beanFactory.registerBeanDefinition(beanDefinition);
        }
    }
}
