package com.sadp.hibernate.tph;  
  
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
  
public class StoreData {  
public static void main(String[] args) {  
	Configuration configuration = new Configuration().configure();
	// AnnotationConfiguration cfg=new AnnotationConfiguration();  
    Session session=configuration.configure("hibernate.cfg.tph.xml").buildSessionFactory().openSession();  
      
    Transaction t=session.beginTransaction();  
      
    Employee e1=new Employee();  
    e1.setName("sonoo");  
      
    Regular_Employee e2=new Regular_Employee();  
    e2.setName("Vivek Kumar");  
    e2.setSalary(50000);  
    e2.setBonus(5);  
      
    Contract_Employee e3=new Contract_Employee();  
    e3.setName("Arjun Kumar");  
    e3.setPay_per_hour(1000);  
    e3.setContract_duration("15 hours");  
      
    session.persist(e1);  
    session.persist(e2);  
    session.persist(e3);  
      
    t.commit();  
    session.close();  
    System.out.println("success");  
}  
}  