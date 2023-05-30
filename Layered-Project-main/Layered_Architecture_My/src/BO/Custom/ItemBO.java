package BO.Custom;

import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO {
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;

    public boolean deleteItems(String code) throws SQLException, ClassNotFoundException;

    public boolean saveItems(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

    public boolean updateItems(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;

    public boolean existItem(String code) throws SQLException, ClassNotFoundException;

    public String generateId() throws SQLException, ClassNotFoundException;
}
