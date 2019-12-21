package dao;

public class TxTFactory extends AbstractDAOFactory {
    @Override
    public TxTDAO getClassTxtDAO() {
        return TxTDAO.getInstance();
    }
}
