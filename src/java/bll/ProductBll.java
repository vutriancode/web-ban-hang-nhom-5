
package bll;

import entity.Product;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ProductBll {
    public List<Product> getNewProducts(int number) throws NamingException {
        try {
            Context initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/NMCNPM");
            Connection conn = ds.getConnection();
            Statement sttm = conn.createStatement();
            String sql = "select * from Product where brandID= 'B02'";
            ResultSet rs = sttm.executeQuery(sql);
            ArrayList<Product> prods = new ArrayList<>();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getString("productID"));
                p.setName(rs.getString("nameP"));
                p.setPrice(rs.getFloat("price"));
                p.setDescription(rs.getString("descriptionP"));
                p.setLastUpdate(rs.getDate("lastUpdate"));
                p.setCategoryID(rs.getString("categoryID"));
                p.setImage(rs.getString("imageP"));
                p.setThumbImage(rs.getString("thumbImage"));
                p.setDescriptionDetail(rs.getString("descriptionDetail"));
                p.setBrandID(rs.getString("brandID"));
                prods.add(p);
            }
            return prods;
        } catch (SQLException ex) {
            System.err.println(ex);
        }catch (NamingException ex) {
            Logger.getLogger(ProductBll.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
