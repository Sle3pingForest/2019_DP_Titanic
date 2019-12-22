package dao;

public class CsvFactory extends AbstractDAOFactory {

    public TxTDAO getClassTxtDAO() {
        return null;
    }

    public CsvDAO getClassCsvDAO() {
        return CsvDAO.getInstance();
    }

    @Override
    public InterfaceDAO getInterfaceDAO() {
        return null;
    }
}
