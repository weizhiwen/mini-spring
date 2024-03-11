package com.shixin.spring;

import java.io.Serializable;

public class BeanDefinition implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String classPath;

    public BeanDefinition(String id, String classPath) {
        this.id = id;
        this.classPath = classPath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }
}
