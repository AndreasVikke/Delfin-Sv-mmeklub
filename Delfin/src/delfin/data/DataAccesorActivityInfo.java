/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delfin.data;

import delfin.logic.ActivityEnum;
import delfin.logic.ActivityInfo;
import delfin.logic.StatusEnum;
import delfin.logic.TeamEnum;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vikke
 */
public class DataAccesorActivityInfo implements DataAccessor {

    private DBConnector connector = null;

    public DataAccesorActivityInfo(DBConnector connector) {
        this.connector = connector;
    }
    
    @Override
    public List<Object> getAll() {
        try{
            String query = "SELECT * FROM activityinfo;";

            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            List<Object> activityInfos = new ArrayList<>();

            while (rs.next()) {  
                activityInfos.add(new ActivityInfo(rs.getString("ssn"), StatusEnum.values()[rs.getInt("status")], TeamEnum.values()[rs.getInt("team")], ActivityEnum.values()[rs.getInt("activity")]));
            }
            return activityInfos;       
        }catch (Exception ex) {     
            ex.printStackTrace();
            throw new IllegalArgumentException();
        } 
    }

    @Override
    public List<Object> getAllById(String id) {
        try{
            String query = "SELECT * FROM activityinfo WHERE ssn = '" + id + "';";

            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            List<Object> activityInfos = new ArrayList<>();
            
            while (rs.next()) {
                activityInfos.add(new ActivityInfo(rs.getString("ssn"), StatusEnum.values()[rs.getInt("status")], TeamEnum.values()[rs.getInt("team")], ActivityEnum.values()[rs.getInt("activity")]));
            }
            return activityInfos;       
        }catch (Exception ex) {     
            ex.printStackTrace();
            throw new IllegalArgumentException();
        } 
    }

    @Override
    public Object getSingleById(String id) {
        try{
            String query = "SELECT * FROM activityinfo WHERE ssn = '" + id + "';";

            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                return new ActivityInfo(rs.getString("ssn"), StatusEnum.values()[rs.getInt("status")], TeamEnum.values()[rs.getInt("team")], ActivityEnum.values()[rs.getInt("activity")]);
            }
            throw new NullPointerException();       
        }catch (Exception ex) {     
            ex.printStackTrace();
            throw new IllegalArgumentException();
        } 
    }

    @Override
    public void create(Object obj) {
        try{
            ActivityInfo activityInfo = (ActivityInfo)obj;
            
            String query = "INSERT INTO activityinfo (ssn, status, team, activity) VALUES ('" + activityInfo.getSsn() + "', " + activityInfo.getStatus().ordinal() + ", " + activityInfo.getTeam().ordinal() + ", " + activityInfo.getActivity().ordinal() + ")";

            Connection connection = connector.getConnection();  
            Statement stmt = connection.createStatement();
            stmt.execute(query);

        }catch (Exception ex){
            ex.printStackTrace();
            throw new IllegalArgumentException();
        }
    }
}
