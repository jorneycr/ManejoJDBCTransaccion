package test;

import dao.PersonaDAO;
import db.Conexion;
import domain.Persona;

import java.sql.*;
import java.util.List;

public class TestManejoPersonas {
    public static void main(String[] args) {

        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }

            PersonaDAO personaDAO = new PersonaDAO(conexion);
            Persona cambiopersona = new Persona(1,"Jorney11","Lopez","jorney@hotmail.com","83148845");
            personaDAO.actualizar(cambiopersona);
            Persona nuevaPersona = new Persona("Daniel11","Martinez","danie@htomailc.om","8544411");
            int afectados =  personaDAO.insertar(nuevaPersona);
            System.out.println("Afectados "+afectados);

            conexion.commit();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }


//        PersonaDAO personaDAO = new PersonaDAO();
//        List<Persona> personas = personaDAO.seleccionar();
//        for(Persona persona: personas){
//            System.out.println(persona);
//        }
//        personas.forEach( persona -> {
//            System.out.println(persona);
//        });

        //insertar persona
//        Persona personaNuevo = new Persona("Mario", "Alfaro", "car@ghg.com", "8554411");
//        int afectados = personaDAO.insertar(personaNuevo);
//        System.out.println("Campos afectados "+ afectados);
//        List<Persona> personasNuevas = personaDAO.seleccionar();
//        personasNuevas.forEach( p -> {
//            System.out.println(p);
//        });

        //update persona
//        Persona personaNuevo = new Persona(4,"Mario", "podero", "Mario@ghg.com", "8554411");
//        personaDAO.actualizar(personaNuevo);
//        List<Persona> personasNuevas = personaDAO.seleccionar();
//        personasNuevas.forEach( p -> {
//            System.out.println(p);
//        });

        //eliminar persona
//            Persona persona = new Persona(4);
//            int personasEli = personaDAO.eliminar(persona);
//            System.out.println("Cantidad afectados "+personasEli);
//            List<Persona> personasNuevas = personaDAO.seleccionar();
//            personasNuevas.forEach( p -> {
//                System.out.println(p);
//            });
    }
}
