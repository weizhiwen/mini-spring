package com.shixin.spring;

import com.shixin.spring.beans.BeansException;
import com.shixin.spring.context.ClassPathXmlApplicationContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("测试ClassPathXmlApplicationContext")
class TestClassPathXmlApplicationContext {
    private AService aService;

    @BeforeEach
    void beforeEach() throws BeansException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        aService = (AService) context.getBean("aService");
    }

    @Test
    @DisplayName("应该得到非null的bean")
    void shouldGetNoNullBean() {
        assertNotNull(aService);
    }

    @Test
    @DisplayName("应该得到正确的函数返回值")
    void shouldGetCorrectMethodReturnValue() {
        Object a = "test";
        assertEquals(aService.aMethod(a), a);
    }
}