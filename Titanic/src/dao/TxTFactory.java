package dao;

public class TxTFactory extends AbstractDAOFactory {

    @Override
    public InterfaceDAO getDAO() {
        return TxTDAO.getInstance();
    }
}
