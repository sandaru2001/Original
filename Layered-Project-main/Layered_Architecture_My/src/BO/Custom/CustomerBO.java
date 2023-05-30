package BO.Custom;

import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO {
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException;

    public boolean deleteCustomers(String code) throws SQLException, ClassNotFoundException;

    public boolean saveCustomers(CustomerDTO itemDTO) throws SQLException, ClassNotFoundException;

    public boolean updateCustomers(CustomerDTO itemDTO) throws SQLException, ClassNotFoundException;

    public boolean existCustomers(String code) throws SQLException, ClassNotFoundException;

    public String generateId() throws SQLException, ClassNotFoundException;
}
