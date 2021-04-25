/*
 * package SnacksShop.DAO;
 * 
 * import SnacksShop.Entity.Bill;
 * 
 * public class BillDAO extends BaseDAO {
 * 
 * public int addBill(Bill bill) { StringBuffer sql= new StringBuffer();
 * sql.append("INSERT INTO bill "); sql.append("( "); sql.
 * append("`name`, `email`, `phoneNumber`, `address`, `note`, `quantity`, `total` "
 * ); sql.append(") "); sql.append("VALUES "); sql.append("( ");
 * sql.append("'"+bill.getName()+"', '"+bill.getEmail()+"', '"+bill.
 * getPhoneNumber()+"', '"+bill.getAddress()+"', '"+bill.getNote()+"', '"+bill.
 * getQuantity()+"', '"+bill.getTotal()+"' "); sql.append(") ");
 * 
 * int insert= _jdbcTemplate.update(sql.toString());
 * 
 * return insert; };
 * 
 * 
 * public int getLastBill() { StringBuffer sql = new StringBuffer();
 * sql.append("SELECT MAX(id) FROM bill"); int id=
 * _jdbcTemplate.queryForObject(sql.toString(), new Object[] {}, int.class);
 * return id; };
 * 
 * public int addBillDetails(BillDetails billDetails ) { StringBuffer sql= new
 * StringBuffer(); sql.append("INSERT INTO bill "); sql.append("( ");
 * sql.append("``idProduct`, `idBill`, `quantity`, `total "); sql.append(") ");
 * sql.append("VALUES "); sql.append("( ");
 * sql.append("'"+billDetails.getIdProduct()+"', '"+billDetails.getIdBill()
 * +"', '"+billDetails.getQuantity()+"', '"+billDetails.getTotal()+"' ");
 * sql.append(") ");
 * 
 * int insert= _jdbcTemplate.update(sql.toString());
 * 
 * return insert; }
 * 
 * }
 */