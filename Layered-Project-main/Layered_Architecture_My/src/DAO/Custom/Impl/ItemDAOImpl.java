package DAO.Custom.Impl;

import DAO.Custom.ItemDAO;
import DAO.SQLUtil;
import model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl  implements ItemDAO {
    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {

        ArrayList<ItemDTO> allItems = new ArrayList<>();

//        Connection connection = DBConnection.getDbConnection().getConnection();
//        Statement stm = connection.createStatement();
        ResultSet rst = SQLUtil.excute("SELECT * FROM Item");

        while (rst.next()){
            ItemDTO itemDTO = new ItemDTO(
                    rst.getString("code"),
                    rst.getString("description"),
                    rst.getBigDecimal("unitPrice"),
                    rst.getInt("qtyOnHand")
            );
            allItems.add(itemDTO);
        }

        return allItems;
    }

    @Override
    public boolean save(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.excute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand());
    }

    @Override
    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.excute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand(),dto.getCode());
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return SQLUtil.excute("SELECT code FROM Item WHERE code=?",s);
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return SQLUtil.excute("DELETE FROM Item WHERE code=?",s);
    }

    @Override
    public String generateId() throws SQLException, ClassNotFoundException {
        return SQLUtil.excute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
    }

    @Override
    public ItemDTO search(String code) throws SQLException, ClassNotFoundException {
        ResultSet rst  = SQLUtil.excute("SELECT * FROM Item WHERE code=?",code+"");
        rst.next();
        return new ItemDTO(code + "", rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
    }

//    @Override
//    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
//
//        ArrayList<ItemDTO> allItems = new ArrayList<>();
//
////        Connection connection = DBConnection.getDbConnection().getConnection();
////        Statement stm = connection.createStatement();
//        ResultSet rst = SQLUtil.excute("SELECT * FROM Item");
//
//        while (rst.next()){
//            ItemDTO itemDTO = new ItemDTO(
//                    rst.getString("code"),
//                    rst.getString("description"),
//                    rst.getBigDecimal("unitPrice"),
//                    rst.getInt("qtyOnHand")
//            );
//            allItems.add(itemDTO);
//        }
//        return allItems;
//    }
//
//    @Override
//    public boolean deleteItems(String code) throws SQLException, ClassNotFoundException {
////        Connection connection = DBConnection.getDbConnection().getConnection();
////        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Item WHERE code=?");
////        pstm.setString(1, code);
////        return pstm.executeUpdate()>0;
//
//        return SQLUtil.excute("DELETE FROM Item WHERE code=?",code);
//    }
//
//    @Override
//    public boolean saveItems(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
////        Connection connection = DBConnection.getDbConnection().getConnection();
////        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)");
////        pstm.setString(1, itemDTO.getCode());
////        pstm.setString(2, itemDTO.getDescription());
////        pstm.setBigDecimal(3, itemDTO.getUnitPrice());
////        pstm.setInt(4, itemDTO.getQtyOnHand());
////        return pstm.executeUpdate()>0;
//
//        return SQLUtil.excute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",itemDTO.getCode(),itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQtyOnHand());
//
//    }
//
//    @Override
//    public boolean updateItems(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
////        Connection connection = DBConnection.getDbConnection().getConnection();
////        PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
////        pstm.setString(1, itemDTO.getDescription());
////        pstm.setBigDecimal(2, itemDTO.getUnitPrice());
////        pstm.setInt(3, itemDTO.getQtyOnHand());
////        pstm.setString(4, itemDTO.getCode());
////        return pstm.executeUpdate()>0;
//
//        return SQLUtil.excute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",itemDTO.getDescription(),itemDTO.getUnitPrice(),itemDTO.getQtyOnHand(),itemDTO.getCode());
//    }
//
//    @Override
//    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
////        Connection connection = DBConnection.getDbConnection().getConnection();
////        PreparedStatement pstm = connection.prepareStatement("SELECT code FROM Item WHERE code=?");
////        pstm.setString(1,code);
////        return pstm.executeQuery().next();
//
//        return SQLUtil.excute("SELECT code FROM Item WHERE code=?",code);
//    }
//
//    @Override
//    public String generateId() throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        ResultSet rst = connection.createStatement().executeQuery("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
//
//        //return SQLUtil.excute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;",)
//        if (rst.next()) {
//            String id = rst.getString("code");
//            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
//            return String.format("I00-%03d", newItemId);
//        } else {
//            return "I00-001";
//        }
//    }


}
