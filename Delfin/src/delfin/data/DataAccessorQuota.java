package delfin.data;

import delfin.logic.DomainObject;
import delfin.logic.Quota;
import delfin.logic.Member;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
<<<<<<< HEAD:Delfin/src/delfin/data/DataAccessorQuotans.java
 * @author Nina Lisakowski
=======
 * @author Nina Lisakovski
>>>>>>> e97dad17a95c27824d268ce7207a39fe9fa1036d:Delfin/src/delfin/data/DataAccessorQuota.java
 */
public class DataAccessorQuota implements DataAccessor {
    private DBConnector connector = null;
    
    public DataAccessorQuota (DBConnector connector) {
        this.connector = connector;
    }

    @Override
    public List<DomainObject> getAll() {
        try{
            String query = "SELECT * FROM quota;";
            
            Connection connection = connector.getConnection(); 
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            ArrayList <DomainObject> quotas = new ArrayList();
            DataAccessor da = new DataAccessorMember(new DBConnector());
            
            while (rs.next()) {
                Member member = (Member)da.getSingleById(rs.getString("ssn"));
                quotas.add(new Quota (rs.getString("ssn"), rs.getDouble("subscription"), rs.getDouble("paid"), member));
            }
            return quotas;
        }catch(Exception ex){
            ex.printStackTrace();
            throw new IllegalAccessError();
        }
    }

    @Override
    public List<DomainObject> getAllById(String id) {
        try{
            String query = "SELECT * FROM quota WHERE ssn = '" + id + "';";
            
            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            ArrayList<DomainObject> quotas = new ArrayList();
            DataAccessor da = new DataAccessorMember(new DBConnector());
            
            while (rs.next()) {
                Member member = (Member)da.getSingleById(rs.getString("ssn"));
                quotas.add(new Quota (rs.getString("ssn"), rs.getDouble("subscription"), rs.getDouble("paid"), member));
            }
            return quotas;
        }catch (Exception ex) {
            ex.printStackTrace();
            throw new IllegalAccessError();
        }
    }

    @Override
    public DomainObject getSingleById(String id) {
        try{
            String query = "SELECT * FROM quota WHERE ssn = '" + id + "';";

            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            DataAccessor da = new DataAccessorMember(new DBConnector());

            while (rs.next()) {
                Member member = (Member)da.getSingleById(rs.getString("ssn"));
                return (new Quota (rs.getString("ssn"), rs.getDouble("subscription"), rs.getDouble("paid"), member));
            }
            throw new NullPointerException();
        }catch (Exception ex) {
            ex.printStackTrace();
            throw new IllegalAccessError();
        }
    }

    @Override
    public void create(DomainObject obj) {
        try{
            Quota quota = (Quota)obj;
            
            String query = "INSERT INTO quota (ssn, subscription, paid, createdate) VALUES ('" + quota.getSsn() + "','" + quota.getSubscription() + "','" + quota.getPaid() + "', '" + LocalDate.now() + "');";

            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            stmt.execute(query);

        }catch (Exception ex){
            ex.printStackTrace();
            throw new IllegalAccessError();
        }
    }
    
    public void createPayment(Object obj) {
        try{
            Quota quota = (Quota)obj;
            
            String query = "UPDATE quota as a INNER JOIN (SELECT ssn, min(createdate) AS createdate from quota WHERE ssn = '" + quota.getSsn() + "' AND paid <> subscription) AS b ON (a.ssn=b.ssn) set paid = paid + " + quota.getPaid() + " where a.createdate=b.createdate;";
                    
            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            stmt.execute(query);

        } catch (Exception ex){
            ex.printStackTrace();
            throw new IllegalAccessError();
        }
    }
}