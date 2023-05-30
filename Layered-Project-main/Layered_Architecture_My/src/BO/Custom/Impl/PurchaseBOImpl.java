package BO.Custom.Impl;

import BO.Custom.PurchaseBO;
import DAO.Custom.CustomerDAO;
import DAO.Custom.Impl.CustomerDAOImpl;
import DAO.Custom.Impl.ItemDAOImpl;
import DAO.Custom.Impl.OrderDAOImpl;
import DAO.Custom.Impl.OrderDetailDAOImpl;
import DAO.Custom.ItemDAO;
import DAO.Custom.OrderDAO;
import DAO.Custom.OrderDetailDAO;
import DAO.DAOFactory;
import db.DBConnection;
import model.CustomerDTO;
import model.ItemDTO;
import model.OrderDTO;
import model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PurchaseBOImpl implements PurchaseBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.CUSTOMER);
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.ITEM);
    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.ORDER);
    OrderDetailDAO orderDetailDAO = (OrderDetailDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.ORDER_DETAILS);

    @Override
    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.search(id);
    }

    @Override
    public ItemDTO searchItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.search(code);
    }

    @Override
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(code);
    }

    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(id);
    }

    @Override
    public String generateOrderID() throws SQLException, ClassNotFoundException {
        return orderDAO.generateId();
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        return customerDAO.getAll();
    }

    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean purchaseOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) {
        return false;
    }

    @Override
    public ItemDTO findItem(String code) {
        return null;
    }

//    OrderDAO orderDAO = new OrderDAOImpl();
//    CustomerDAO customerDAO = new CustomerDAOImpl();
//    ItemDAO itemDAO = new ItemDAOImpl();
//    OrderDetailDAO orderDetailsDAO = new OrderDetailDAOImpl();
//
//    public boolean placeOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) {
//
//        Connection connection = null;
//        try {
//            connection = DBConnection.getDbConnection().getConnection();
//
//            //Check order id already exist or not
//
//            boolean b1 = orderDAO.exist(orderId);
//            /*if order id already exist*/
//            if (b1) {
//                return false;
//            }
//
//            connection.setAutoCommit(false);
//
//            //Save the Order to the order table
//            boolean b2 = orderDAO.save(new OrderDTO(orderId, orderDate, customerId));
//
//            if (!b2) {
//                connection.rollback();
//                connection.setAutoCommit(true);
//                return false;
//            }
//
//
//            // add data to the Order Details table
//
//            for (OrderDetailDTO detail : orderDetails) {
//                boolean b3 = orderDetailsDAO.save(detail);
//                if (!b3) {
//                    connection.rollback();
//                    connection.setAutoCommit(true);
//                    return false;
//                }
//
//                //Search & Update Item
//                ItemDTO item = findItem(detail.getItemCode());
//                item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());
//
//                //update item
//                boolean b = itemDAO.update(new ItemDTO(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand()));
//
//                if (!b) {
//                    connection.rollback();
//                    connection.setAutoCommit(true);
//                    return false;
//                }
//            }
//
//            connection.commit();
//            connection.setAutoCommit(true);
//            return true;
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return false;
//
//}
//
//
//    public ItemDTO findItem(String code) {
//        try {
//            return itemDAO.search(code);
//        } catch (SQLException e) {
//            throw new RuntimeException("Failed to find the Item " + code, e);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
