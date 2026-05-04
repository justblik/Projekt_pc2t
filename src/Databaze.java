import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class Databaze {
	
	private Connection conn; 		
	public boolean connect(String dbName) { 
	       conn= null; 
	       try {
	              conn = DriverManager.getConnection("jdbc:sqlite:"+dbName);                       
	       } 
	      catch (SQLException e) { 
	            System.out.println(e.getMessage());
		    return false;
	      }
	      return true;
	}
	
	public boolean ulozeniZamestnance(int id, String jmeno, String prijmeni, int rok_narozeni, String typ) {
		String sql = "INSERT INTO zamestnanci(id,jmeno,prijmeni, rok_narozeni, typ) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql); 		
            pstmt.setInt(1, id);	
            pstmt.setString(2, jmeno);	
            pstmt.setString(3, prijmeni);		
            pstmt.setInt(4, rok_narozeni);
            pstmt.setString(5, typ);
            pstmt.executeUpdate();
        } 
         catch (SQLException e) {
             System.out.println(e.getMessage());
             return false;
        }
        return true;

	}
	
	public boolean nacteniZamestnance(Map<Integer, Zamestnanci> mapa_zamestnanci) {
		String sql = "SELECT * FROM zamestnanci";
        try {
        	Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);	
            
            mapa_zamestnanci.clear();
            
            while (rs.next()) {			
               int id = rs.getInt("id");
               String jmeno = rs.getString("jmeno");
               String prijmeni = rs.getString("prijmeni");
               int rok_narozeni = rs.getInt("rok_narozeni");
               String typ = rs.getString("typ");
               
               Zamestnanci z;

               if (typ.equals("Datový analytik")) {
                   z = new Datovi_analytici(id, jmeno, prijmeni, rok_narozeni);
               } 
               else {
                   z = new Bezpecnostni_specialiste(id, jmeno, prijmeni, rok_narozeni);
               }

               mapa_zamestnanci.put(id, z);
        }
            } 
         catch (SQLException e) {
             System.out.println(e.getMessage());
             return false;
        }
        return true;

	}
	
	
	public void disconnect() { 
		if (conn != null) {
			try { 
				conn.close();  
			} 
			catch (SQLException e) { 
			   System.out.println(e.getMessage()); 
			}
		}
	}

}
