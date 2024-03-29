
import database.HibernateUtil;
import model.Alumno;
import model.Aula;
import model.Direccion;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Entrada {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        // Directa
        // List<Alumno> lista = session.createNativeQuery("SELECT * FROM alumno", Alumno.class).list();
        // Indirecta-> parametros nombre o parametros posicion
        System.out.println("Introduce el nombre que quieres buscar");
        String nombreBucar = new Scanner(System.in).next();
        System.out.println("Introduce el la poblacion que quieres buscar");
        String polacionBuscar = new Scanner(System.in).next();
        /*List<Alumno> lista = session.createNativeQuery("SELECT nombre, edad FROM alumno " +
                        "WHERE nombre = :pnombre AND poblacion = :ppoblacion", Alumno.class)
                .setParameter("pnombre",nombreBucar)
                .setParameter("ppoblacion",polacionBuscar)
                .list();*/

        List<Alumno> listaResultados = session.createQuery("SELECT a FROM Alumno a", Alumno.class).list();

        for ( Alumno item : listaResultados ) {
            item.mostrarDatos();
        }

        // List = null --> ArrayList = null
        List<Alumno> alumnos = session.createNamedQuery("insercion",Alumno.class).list();



        //session.persist(new Aula("Barcelona",20));
        //Alumno alumno = session.get(Alumno.class,6)
        //System.out.println(alumno.getNombre());
        //session.persist(new Alumno("Ejemplo6","Ejemplo6","correo@correo.com")); // db);
        //session.persist(new Alumno("Ejemplo6","Ejemplo6","correo@correo.com","Calle","MAdrid","Madrid",123)); // db);
        //session.persist(new Alumno("Ejemplo6","Ejemplo6","correo@correo.com",new Direccion("Calle","MAdrid","Madrid",123))); // db);
        /*session.persist(new Alumno("Ejemplo8","Ejemplo8","correo@correo.com"
                ,new Direccion("Calle1","MAdrid1","Madrid1",123)
                ,new Direccion("Calle2","MAdrid2","Madrid2",123))); // db);*/

        // SELECT --> SELECT * FROM alumno WHERE id=13 (pk)
        /*Alumno alumno =  session.get(Alumno.class,14);
        session.createNamedQuery("nombreQuero",Alumno.class);
        Query query = session.createQuery("SELECT * FROM usuario WHERE telefono=123123 AND provincia='Madrid'", Alumno.class);
        // ps = INSERT INTO ALUMNOS VALUES(?,?,?)
        // ps.setInt(1,123123)
        // ps.setString(2,"123123")
        // ps.setBool(3,true)
        // ps.execute()
        ArrayList<Alumno> lista = (ArrayList<Alumno>) query.list();
        for (Alumno item: lista ) {
            System.out.println(item);
        }
        try {
            System.out.println(alumno.getNombre());
            System.out.println(alumno.getDireccion_tutor().getCalle());
        }catch (NullPointerException e){
            System.out.println("Alguno de los datos de la bd son nulos");
        }*/


        session.getTransaction().commit();
        session.close();

    }

}
