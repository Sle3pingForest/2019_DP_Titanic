package dao;

public abstract class AbstractDAOFactory {
    public final static int TXT = 1;

    public final static int CSV = 2;

    public abstract InterfaceDAO getDAO();

    public static AbstractDAOFactory getAbstractDAOFactory(int type) {

        AbstractDAOFactory abstractDAOFactory = null;
        switch (type) {
            case TXT:
                abstractDAOFactory = new TxTFactory();
                break;
            case CSV:
                abstractDAOFactory = new CsvFactory();
                break;
        }
        return abstractDAOFactory;
    }
}
