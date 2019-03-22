package controller;

import configuration.HibernateConfiguration;
import model.RoleEnum;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;
import java.util.List;

public class UserController {

    public void addUser(String email, String password, RoleEnum role, boolean enable, LocalDate date_added,String secrete_code){
        //Otwieranie sesji-tranzakcji
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        //Rozpoczęcie tranzakcji
        Transaction transaction = session.beginTransaction();
        //wykonanie polecen sql
        User user = new User(email,password,role,enable,date_added,secrete_code);
        //Insert into user
        session.save(user);
        //Zatwierdzenie tranzakcji
        transaction.commit();
        //zamkniecie sesji
        session.close();
    }

}
