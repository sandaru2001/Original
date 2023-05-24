package DAO;

import com.jfoenix.controls.JFXComboBox;
import db.DBConnection;
import model.ItemDTO;

import java.sql.*;

public interface PlaceOrderDAO {
    public boolean exitItem(String code) throws SQLException, ClassNotFoundException;

    public boolean exitCustomer(String id) throws SQLException, ClassNotFoundException;

    public String generateNextOrderId() throws SQLException, ClassNotFoundException;

    public void loadAllCustomerId(JFXComboBox<String> cmbCustomerId) throws SQLException, ClassNotFoundException;

    public void loadAllItemCodes(JFXComboBox<String> cmbItemCode) throws SQLException, ClassNotFoundException;


    public ItemDTO findItems(String code) throws SQLException, ClassNotFoundException;

}
