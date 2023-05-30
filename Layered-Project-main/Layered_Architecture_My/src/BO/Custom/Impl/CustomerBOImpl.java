package BO.Custom.Impl;

import BO.Custom.CustomerBO;
import DAO.Custom.CustomerDAO;
import DAO.Custom.Impl.CustomerDAOImpl;
import DAO.DAOFactory;
import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {

    //CustomerDAO CustomerDAO = new CustomerDAOImpl();
    CustomerDAO CustomerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.CUSTOMER);

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        return CustomerDAO.getAll();
    }

    @Override
    public boolean deleteCustomers(String id) throws SQLException, ClassNotFoundException {
        return CustomerDAO.delete(id);
    }

    @Override
    public boolean saveCustomers(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return CustomerDAO.save(dto);
    }

    @Override
    public boolean updateCustomers(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return CustomerDAO.update(dto);
    }

    @Override
    public boolean existCustomers(String id) throws SQLException, ClassNotFoundException {
        return CustomerDAO.exist(id);
    }

    @Override
    public String generateId() throws SQLException, ClassNotFoundException {
        return CustomerDAO.generateId();
    }

//
//
//    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
//        return customerDAO.getAll();
//    }
//
//    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
//        return customerDAO.save(dto);
//    }
//
//    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
//        return customerDAO.update(dto);
//    }
//
//    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
//        return customerDAO.exist(id);
//    }
//
//    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
//        return customerDAO.delete(id);
//    }
//
//    public String generateId() throws SQLException, ClassNotFoundException {
//        return customerDAO.generateId();
//    }


}
