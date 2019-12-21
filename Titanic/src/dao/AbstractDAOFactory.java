package dao;

public abstract class AbstractDAOFactory {
    public abstract TxTDAO getClassTxtDAO();
    public final static int TXT = 1;

    public static AbstractDAOFactory getAbstractDAOFactory(int type){
        AbstractDAOFactory ret = null;
        if (type == TXT)
            ret = new TxTFactory();
        return ret;
    }

}
