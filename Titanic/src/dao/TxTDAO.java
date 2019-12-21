package dao;

import modele.Modele;

import javax.swing.*;
import java.io.File;

public class TxTDAO implements InterfaceDAO{
    private static TxTDAO instance = null;
    private String type;

    private TxTDAO(){
        type = "txt";
    }

    @Override
    public void save(Modele mod) {
        System.out.println("sauvegarde à implémenter");
    }

    @Override
    public Modele load() {
        System.out.println("Chargement à implémenter");
        return null;
    }

    public static TxTDAO getInstance(){
        if (instance == null)
            instance = new TxTDAO();
        return instance;
    }

    public String getType(){
        return type;
    }
}
