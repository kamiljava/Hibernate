package controller;

import configuration.HibernateConfiguration;
import model.Role1;
import model.RoleEnum;
import model.User;
import model.User1;
import org.hibernate.Query;
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
        public Role1 getRoleById(int Id){
            Session session = HibernateConfiguration.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            //Pytanie select
            Query query = session.createQuery("SELECT r FROM Role1 r WHERE r.id_r=:id ");
            query.setInteger("id",Id);
            query.setMaxResults(1);
            Role1 role =(Role1) query.uniqueResult();
            transaction.commit();
            session.close();
        return role;
    }

    public void  addUser1(String email,String password){
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        //utworzenie uzytkownia user1
        User1 user1 = new User1(email,password);
        //przypisanie aktywnosci
        user1.setEnable(true);
        //przypisanie daty
        user1.setDate_add(LocalDate.now());
        //przypisanie roli
        user1.addRolesToSet(getRoleById(1));
        session.save(user1);
        transaction.commit();
        session.close();
    }


}
