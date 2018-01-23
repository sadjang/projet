/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Classe.Informations;
import Util.NewHibernateUtil;
import static com.oracle.jrockit.jfr.ContentType.Timestamp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author sadjang
 */
public class Dinformations implements IDinformations {
     int index=1;
    @Override
    public Informations save(Informations entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Informations update(Informations entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Informations entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteInBatch(List<Informations> entities) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Informations find(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void lecture(String nomfichier){
       
            BufferedReader reader;
            String ligne="";
            FileReader in;
            
        try {
            in=new FileReader(new File(nomfichier));
            reader=new  BufferedReader(in);
            String chiffre="";
           while ((ligne = reader.readLine()) != null) {
               if(ligne!=null){
                   chiffre=chiffre+ligne;
                   index=Integer.valueOf(chiffre);   
                } 
              }
       
            reader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dinformations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Dinformations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void ecrirDansFichier(String nonfichier,String numer){
        
        
       
        final File fichier =new File(nonfichier); 
        try {
            // Creation du fichier
          //  fichier .createNewFile();
            // creation d'un writer (un écrivain)
            final FileWriter writer = new FileWriter(fichier);
            try {
                writer.write(numer);
            } finally {
                // quoiqu'il arrive, on ferme le fichier
                writer.close();
            }
        } catch (Exception e) {
            System.out.println("Impossible de creer le fichier");
        }
    }
        
        
        
        
        
        
    

    @Override
    public List<Informations> findAll(){
        Informations inf=null;
        //  Lecture du fichier
        
       
       Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        // lecture du fichier
        lecture("indexFille.txt");
        Criteria c=session.createCriteria(Informations.class);
        c.addOrder(Order.desc("id"));
        c.add(Restrictions.gt("id",index));
       // c.add(Restrictions.between("numeroexpediteur",date,date));
       // Modification du fichier
       //  obtension du dernier enregistrement dans une liste
       if(c.list().size()>0){
           System.out.println(String.valueOf(c.list().size()));
        Informations e = (Informations) c.list().get(1);
       // System.out.println("je suis iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
       System.out.print("Id du Dernier element :");
        System.out.println(String.valueOf(e.getId()+1));
         ecrirDansFichier("indexFille.txt",String.valueOf(e.getId()+1));
       }
      
       
        session.getTransaction().commit();    
    return c.list();    
    }

    @Override
    public List<Informations> findAllbyTable(String[] tabRequette) {
       Session session = NewHibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria c=session.createCriteria(Informations.class);
        c.addOrder(Order.desc("id"));
        if(!tabRequette[4].equals("")){
         /*   System.out.println(tabRequette[4]);
            String[]tabDa=new String[3];
            tabDa=tabRequette[4].split("/");
            String strDateFrom =tabDa[2]+"-"+tabDa[1]+"-"+tabDa[0];
            strDateFrom=strDateFrom+" "+"00:00:00.0000";
            //System.out.println(strDateFrom);
            
        try {
              SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
             // Date parsedDate = dateFormat.parse("2017-11-22 22:10:36.118981");
              Date parsedDate = dateFormat.parse(strDateFrom);
              Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
              System.out.println("Je suis ici en ce moment ci");
              c.add(Restrictions.eq("dateexpedition",timestamp ));
             
              
        } catch (ParseException ex) {
            Logger.getLogger(Dinformations.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        }
        
        if(!tabRequette[0].equals("")&&tabRequette[1].equals("")&&tabRequette[2].equals("")&&tabRequette[3].equals("")&&tabRequette[4].equals(""))
           c.add(Restrictions.like("nomexpediteur",tabRequette[0]));
        if(tabRequette[0].equals("")&&!tabRequette[1].equals("")&&tabRequette[2].equals("")&&tabRequette[3].equals("")&&tabRequette[4].equals(""))
            c.add(Restrictions.eq("numeroexpediteur",tabRequette[1]));
         if(tabRequette[0].equals("")&&tabRequette[1].equals("")&&!tabRequette[2].equals("")&&tabRequette[3].equals("")&&tabRequette[4].equals(""))
            c.add(Restrictions.eq("nomrecepteur",tabRequette[2]));
        if(tabRequette[0].equals("")&&tabRequette[1].equals("")&&tabRequette[2].equals("")&&!tabRequette[3].equals("")&&tabRequette[4].equals(""))
            c.add(Restrictions.eq("numerorecepteur",tabRequette[3]));
        /*if(tabRequette[0].equals("")&&tabRequette[1].equals("")&&tabRequette[2].equals("")&&tabRequette[3].equals("")&&!tabRequette[4].equals(""))
            c.add(Restrictions.eq("dateexpedition",tabRequette[4]));*/
       if(!tabRequette[0].equals("")&&!tabRequette[1].equals("")&&tabRequette[2].equals("")&&tabRequette[3].equals("")&&tabRequette[4].equals("")){
            c.add(Restrictions.eq("nomexpediteur",tabRequette[0]));
            c.add(Restrictions.eq("numeroexpediteur",tabRequette[1]));
       }
        if(!tabRequette[0].equals("")&&!tabRequette[1].equals("")&&!tabRequette[2].equals("")&&tabRequette[3].equals("")&&tabRequette[4].equals("")){
            c.add(Restrictions.eq("nomexpediteur",tabRequette[0]));
            c.add(Restrictions.eq("numeroexpediteur",tabRequette[1]));
            c.add(Restrictions.eq("nomrecepteur",tabRequette[2]));
             }
        if(!tabRequette[0].equals("")&&!tabRequette[1].equals("")&&!tabRequette[2].equals("")&&!tabRequette[3].equals("")&&tabRequette[4].equals("")){
            c.add(Restrictions.eq("nomexpediteur",tabRequette[0]));
            c.add(Restrictions.eq("numeroexpediteur",tabRequette[1]));
            c.add(Restrictions.eq("nomrecepteur",tabRequette[2]));
            c.add(Restrictions.eq("numerorecepteur",tabRequette[3]));
             }
        if(!tabRequette[0].equals("")&&!tabRequette[1].equals("")&&!tabRequette[2].equals("")&&!tabRequette[3].equals("")&&!tabRequette[4].equals("")){
            c.add(Restrictions.eq("nomexpediteur",tabRequette[0]));
            c.add(Restrictions.eq("numeroexpediteur",tabRequette[1]));
            c.add(Restrictions.eq("nomrecepteur",tabRequette[2]));
            c.add(Restrictions.eq("numerorecepteur",tabRequette[3]));
           // c.add(Restrictions.eq("dateexpedition",tabRequette[4]));
            }
        if(!tabRequette[0].equals("")&&tabRequette[1].equals("")&&!tabRequette[2].equals("")&&tabRequette[3].equals("")&&tabRequette[4].equals("")){
            c.add(Restrictions.eq("nomexpediteur",tabRequette[0]));
            c.add(Restrictions.eq("nomrecepteur",tabRequette[2]));
             }
      if(!tabRequette[0].equals("")&&tabRequette[1].equals("")&&tabRequette[2].equals("")&&!tabRequette[3].equals("")&&tabRequette[4].equals("")){
            c.add(Restrictions.eq("nomexpediteur",tabRequette[0]));
            c.add(Restrictions.eq("numerorecepteur",tabRequette[3]));
      }
       if(!tabRequette[0].equals("")&&tabRequette[1].equals("")&&tabRequette[2].equals("")&&tabRequette[3].equals("")&&!tabRequette[4].equals("")){
            c.add(Restrictions.eq("nomexpediteur",tabRequette[0]));
          //  c.add(Restrictions.eq("dateexpedition",tabRequette[4]));
           }
      if(tabRequette[0].equals("")&&!tabRequette[1].equals("")&&!tabRequette[2].equals("")&&tabRequette[3].equals("")&&tabRequette[4].equals("")){
            c.add(Restrictions.eq("numeroexpediteur",tabRequette[1]));
            c.add(Restrictions.eq("nomrecepteur",tabRequette[2]));
             }
      if(tabRequette[0].equals("")&&!tabRequette[1].equals("")&&tabRequette[2].equals("")&&!tabRequette[3].equals("")&&tabRequette[4].equals("")){
            c.add(Restrictions.eq("numeroexpediteur",tabRequette[1]));
            c.add(Restrictions.eq("numerorecepteur",tabRequette[3]));
             }
       if(tabRequette[0].equals("")&&!tabRequette[1].equals("")&&tabRequette[2].equals("")&&tabRequette[3].equals("")&&!tabRequette[4].equals("")){
            c.add(Restrictions.eq("numeroexpediteur",tabRequette[1]));
            c.add(Restrictions.eq("dateexpedition",tabRequette[4]));
             }
      if(tabRequette[0].equals("")&&tabRequette[1].equals("")&&!tabRequette[2].equals("")&&!tabRequette[3].equals("")&&tabRequette[4].equals("")){
            c.add(Restrictions.eq("nomrecepteur",tabRequette[2]));
            c.add(Restrictions.eq("numerorecepteur",tabRequette[3]));
             }
      if(tabRequette[0].equals("")&&tabRequette[1].equals("")&&!tabRequette[2].equals("")&&tabRequette[3].equals("")&&!tabRequette[4].equals("")){
            c.add(Restrictions.eq("nomrecepteur",tabRequette[2]));
         //   c.add(Restrictions.eq("dateexpedition",tabRequette[4]));
          }
       if(tabRequette[0].equals("")&&!tabRequette[1].equals("")&&!tabRequette[2].equals("")&&!tabRequette[3].equals("")&&tabRequette[4].equals("")){
            c.add(Restrictions.eq("numeroexpediteur",tabRequette[1]));
            c.add(Restrictions.eq("nomrecepteur",tabRequette[2]));
            c.add(Restrictions.eq("numerorecepteur",tabRequette[3]));
      }
      if(tabRequette[0].equals("")&&!tabRequette[1].equals("")&&!tabRequette[2].equals("")&&tabRequette[3].equals("")&&!tabRequette[4].equals("")){
            c.add(Restrictions.eq("numeroexpediteur",tabRequette[1]));
            c.add(Restrictions.eq("nomrecepteur",tabRequette[2]));
          //  c.add(Restrictions.eq("dateexpedition",tabRequette[4]));
           }
      if(tabRequette[0].equals("")&&!tabRequette[1].equals("")&&!tabRequette[2].equals("")&&!tabRequette[3].equals("")&&!tabRequette[4].equals("")){
            c.add(Restrictions.eq("numeroexpediteur",tabRequette[1]));
            c.add(Restrictions.eq("nomrecepteur",tabRequette[2]));
            c.add(Restrictions.eq("numerorecepteur",tabRequette[3]));
           // c.add(Restrictions.eq("dateexpedition",tabRequette[4]));
            }
     if(tabRequette[0].equals("")&&tabRequette[1].equals("")&&tabRequette[2].equals("")&&!tabRequette[3].equals("")&&!tabRequette[4].equals("")){
            c.add(Restrictions.eq("nomrecepteur",tabRequette[2]));
            c.add(Restrictions.eq("numerorecepteur",tabRequette[3]));
         //   c.add(Restrictions.eq("dateexpedition",tabRequette[4]));
          }
           // c.add(Restrictions.eq("dateexpedition",tabRequette[4]));
            //c.setMaxResults(10);
       /* c.add(Restrictions.eq("nomexpediteur",inf.getNumeroexpediteur()));
        c.add(Restrictions.eq("nomexpediteur",inf.getNumerorecepteur()));
        c.add(Restrictions.eq("nomexpediteur",inf.getMarquetelephone()));
        c.add(Restrictions.eq("nomexpediteur",inf.getDateexpedition()));
        c.add(Restrictions.eq("nomexpediteur",inf.getOperateur()));
        c.setMaxResults(10);*/
     
    
        session.getTransaction().commit();    
    return c.list();   
    }
    
}
