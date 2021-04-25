/*
 * package SnacksShop.Service.User;
 * 
 * import java.util.HashMap; import java.util.Map;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import SnacksShop.DAO.BillDAO; import SnacksShop.DTO.CartDTO; import
 * SnacksShop.Entity.Bill; import SnacksShop.Entity.BillDetails;
 * 
 * @Service public class BillServiceImple implements IBillService {
 * 
 * @Autowired public BillDAO billDAO = new BillDAO();
 * 
 * @Override public int addBill(Bill bill) { return billDAO.addBill(bill); }
 * 
 * 
 * @Override public void addBillDetails(HashMap<String, CartDTO> carts) {
 * 
 * int idBill = billDAO.getLastBill();
 * 
 * for(Map.Entry<String, CartDTO> itemCart : carts.entrySet()) { BillDetails
 * billDetails = new BillDetails(); billDetails.setIdBill(idBill);
 * billDetails.setIdProduct(itemCart.getValue().getProduct().getMaSP());
 * billDetails.setQuantity(itemCart.getValue().getQuantity());
 * billDetails.setTotal(itemCart.getValue().getTotalPrice());
 * billDAO.addBillDetails(billDetails); }
 * 
 * }
 * 
 * 
 * }
 */