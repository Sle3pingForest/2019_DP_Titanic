package dao;

public class TxTFactory extends AbstractDAOFactory {

    public TxTDAO getClassTxtDAO() {
        return TxTDAO.getInstance();
    }

    public CsvDAO getClassCsvDAO() {
        return null;
    }

    @Override
    public InterfaceDAO getInterfaceDAO() {
        return null;
    }
}
