package dao;

public class CsvFactory extends AbstractDAOFactory {

    @Override
    public InterfaceDAO getDAO() {
        return CsvDAO.getInstance();
    }
}
