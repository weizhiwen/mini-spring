package com.shixin.spring;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassPathXmlApplicationContext {
    public static final String ID = "id";
    public static final String CLASS_PATH = "class";
    private List<BeanDefinition> beanDefinitionList = new ArrayList<>();
    private Map<String, Object> singletonMap = new HashMap<>();

    public ClassPathXmlApplicationContext(String fileName) {
        SAXReader saxReader = new SAXReader();
        Document document;
        try {
            URL xmlPath = getClass().getClassLoader().getResource(fileName);
            document = saxReader.read(xmlPath);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
        Element rootElement = document.getRootElement();
        for (Element element : rootElement.elements()) {
            String id = element.attributeValue(ID);
            String className = element.attributeValue(CLASS_PATH);
            BeanDefinition beanDefinition = new BeanDefinition(id, className);
            beanDefinitionList.add(beanDefinition);
        }

        for (BeanDefinition beanDefinition : beanDefinitionList) {
            Object object;
            try {
                object = Class.forName(beanDefinition.getClassPath()).newInstance();
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            singletonMap.put(beanDefinition.getId(), object);
        }
    }

    public Object getBean(String beanName) {
        return singletonMap.get(beanName);
    }
}
