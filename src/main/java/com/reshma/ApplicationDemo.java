package com.reshma;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.reshma.bean.Circle;
import com.reshma.dao.HibernateDaoImpl;

@EnableTransactionManagement
public class ApplicationDemo 
{
    public static void main( String[] args )
    {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        HibernateDaoImpl dao = ctx.getBean("hibernateDaoImpl",HibernateDaoImpl.class);
        
        
        Circle circle1 = new Circle(14, "equilateral");
        System.out.println(dao.saveCircle(circle1));
        
        Circle circle2 = new Circle(15, "bilateral");
        System.out.println(dao.saveCircle(circle2));
        
        Circle circle3 = new Circle(16, "test");
        System.out.println(dao.saveCircle(circle3));
        
       
        
        System.out.println(dao.getCircleCount());
        dao.deleteCirle(1);
        System.out.println(dao.getCircleCount());
        
    }
}
