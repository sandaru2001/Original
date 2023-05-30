package DAO.Custom;

import DAO.SuperDAO;
import model.CustomerDTO;

import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
    ArrayList<CustomerDTO> searchOrder();
}
