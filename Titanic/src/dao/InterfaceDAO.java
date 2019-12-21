package dao;

import modele.Modele;

public interface InterfaceDAO {
    public void save(Modele mod);
    public Modele load();
}
