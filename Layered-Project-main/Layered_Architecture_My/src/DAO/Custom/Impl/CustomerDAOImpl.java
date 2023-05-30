package DAO.Custom.Impl;

import DAO.Custom.CustomerDAO;
import DAO.SQLUtil;
import model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();

        ResultSet rst = SQLUtil.excute("SELECT * FROM Customer");

        while (rst.next()){
            CustomerDTO customerDTO = new CustomerDTO(
                    rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("address")
            );
            allCustomers.add(customerDTO);
        }
        return allCustomers;
    }

    @Override
    public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.excute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",dto.getId(),dto.getName(),dto.getAddress());
    }

    @Override
    public boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.excute("UPDATE Customer SET name=?, address=? WHERE id=?",dto.getName(),dto.getAddress(),dto.getId());
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return SQLUtil.excute("SELECT id FROM Customer WHERE id=?",s);
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return SQLUtil.excute("DELETE FROM Customer WHERE id=?",s);
    }

    @Override
    public String generateId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.excute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }

    @Override
    public CustomerDTO search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.excute("SELECT * FROM Customer WHERE id=?", id + "");
        rst.next();
        return new CustomerDTO(id + "", rst.getString("name"), rst.getString("address"));
    }
}


//    @Override
//    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
//
//        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
//
////        Connection connection = DBConnection.getDbConnection().getConnection();
////        Statement stm = connection.createStatement();
//        ResultSet rst = SQLUtil.excute("SELECT * FROM Customer");
//
//        while (rst.next()){
//            CustomerDTO customerDTO = new CustomerDTO(
//                    rst.getString("id"),
//                    rst.getString("name"),
//                    rst.getString("address")
//            );
//            allCustomers.add(customerDTO);
//        }
//        return allCustomers;
//    }
//
//    @Override
//    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
////        Connection connection = DBConnection.getDbConnection().getConnection();
////        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer (id,name, address) VALUES (?,?,?)");
////        pstm.setString(1, customerDTO.getId());
////        pstm.setString(2, customerDTO.getName());
////        pstm.setString(3, customerDTO.getAddress());
////        return pstm.executeUpdate()>0;
//
//        return SQLUtil.excute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress());
//    }
//
//    @Override
//    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
////        Connection connection = DBConnection.getDbConnection().getConnection();
////        PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET name=?, address=? WHERE id=?");
////        pstm.setString(1, customerDTO.getName());
////        pstm.setString(2, customerDTO.getAddress());
////        pstm.setString(3, customerDTO.getId());
////        return pstm.executeUpdate()>0;
//
//        return SQLUtil.excute("UPDATE Customer SET name=?, address=? WHERE id=?",customerDTO.getName(),customerDTO.getAddress(),customerDTO.getId());
//    }
//
//    @Override
//    public boolean exitCustomer(String id) throws SQLException, ClassNotFoundException {
////        Connection connection = DBConnection.getDbConnection().getConnection();
////        PreparedStatement pstm = connection.prepareStatement("SELECT id FROM Customer WHERE id=?");
////        pstm.setString(1, id);
////        return pstm.executeQuery().next();
//
//        return SQLUtil.excute("SELECT id FROM Customer WHERE id=?",id);
//    }
//
//    @Override
//    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
////        Connection connection = DBConnection.getDbConnection().getConnection();
////        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE id=?");
////        pstm.setString(1, id);
////        return pstm.executeUpdate()>0;
//
//        return SQLUtil.excute("DELETE FROM Customer WHERE id=?",id);
//    }
//
//    @Override
//    public String generateId() throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        ResultSet rst = connection.createStatement().executeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
//        if (rst.next()) {
//            String id = rst.getString("id");
//            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
//            return String.format("C00-%03d", newCustomerId);
//        } else {
//            return "C00-001";
//        }
//    }

