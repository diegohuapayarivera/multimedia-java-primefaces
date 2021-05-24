/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ModeloImpl;
import dao.PersonaImpl; 
import dao.ProductoImpl;
import java.io.Serializable;
import java.util.ArrayList;  
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelo.Modelo;
import modelo.Persona;
import modelo.Producto;

/**
 *
 * @author diego
 */
@Named(value = "imgC")
@SessionScoped
public class ImgC implements Serializable {

    private String video ;
    private int numero;
    private ModeloImpl modeloImpl;
    private List<Modelo> listaM;
    private Persona persona;
    private PersonaImpl personaDao;
    private List<Persona> listaP;
    private List<Producto> listaPd;
    private ProductoImpl productoD;

    public ImgC() {
        listaPd = new ArrayList<>();
        productoD = new ProductoImpl();
        listaP = new ArrayList<>();
        personaDao = new PersonaImpl();
        persona = new Persona();
        modeloImpl = new ModeloImpl();
        listaM = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        listar();
    }

    public void listar() {
        try {
            listaM = modeloImpl.listarModelo();
            listaP = personaDao.listar();
            listaPd = productoD.listar();
        } catch (Exception e) {
            System.out.println("Error al listarC: " + e.getMessage());
        }
    }

    public void registrarPersona() {
        try {
//            persona.setVideo(numero);
            personaDao.registrar(persona);
//            System.out.println("Persona: " + persona.toString());
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Se guardo con exito"));
//            limpiar();
        } catch (Exception e) {
            System.out.println("Persona: "+ persona.toString());
            System.out.println("Error al registrarPersonaC: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "Ocurrio un error, vuelva a intentar"));
        }
    }

    public void limpiar() {
        try {
            persona = new Persona();
        } catch (Exception e) {
        }
    }

    public void cambiarVideo() {
        try {
            video = "video/video" + numero + ".mp4";
            System.out.println("video: " + video);
        } catch (Exception e) {
            System.out.println("Error cambiar video: " + e.getMessage());
        }
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public ModeloImpl getModeloImpl() {
        return modeloImpl;
    }

    public void setModeloImpl(ModeloImpl modeloImpl) {
        this.modeloImpl = modeloImpl;
    }

    public List<Modelo> getListaM() {
        return listaM;
    }

    public void setListaM(List<Modelo> listaM) {
        this.listaM = listaM;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public PersonaImpl getPersonaDao() {
        return personaDao;
    }

    public void setPersonaDao(PersonaImpl personaDao) {
        this.personaDao = personaDao;
    }

    public List<Persona> getListaP() {
        return listaP;
    }

    public void setListaP(List<Persona> listaP) {
        this.listaP = listaP;
    }

    public List<Producto> getListaPd() {
        return listaPd;
    }

    public void setListaPd(List<Producto> listaPd) {
        this.listaPd = listaPd;
    }

    public ProductoImpl getProductoD() {
        return productoD;
    }

    public void setProductoD(ProductoImpl productoD) {
        this.productoD = productoD;
    }

}
