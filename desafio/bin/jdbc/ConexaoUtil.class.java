package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class ConexaoUtil {

	private static ConexaoUtil conexaoUtil;
	public static Object getConnectionUnidades;

	public static ConexaoUtil getIstance() {

		if (conexaoUtil == null) {

			conexaoUtil = new ConexaoUtil();

		}
		
		return conexaoUtil;
	}


	public class Conexao {
	  
	 
	



	    public static Connection conexao;
	    public Conexao()
	    { try
	        {
	    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    String url = "jdbc:sqlserver://localhost:1433;databaseName=apcontrole;user=root;password=";        
	    
	  /// Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	 ///  String url = "jdbc:odbc:myodbc;database="+base+";user=sa;password=";          
	            
	     
	          conexao = DriverManager.getConnection(url);
	          System.out.println("conexao ok");        
	          
	        }
	        catch(Exception erro){
	            JOptionPane.showMessageDialog(null,
	          "Ocorreu um erro de conexão. Verifique a Base de Dados indicada !"+"\n" +  erro.getMessage(),"Conexão",3);
	            erro.printStackTrace();
	        }
	    }

	    // Mtodos pblicos:
	    public Connection getConexao()
	    {
	        return conexao;
	        
	    }
	    
	   public void getConexaoFechar()
	    {
	    try {
	        conexao.close();
	    } catch (SQLException ex) {
	        Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
	    }
	        
	    }     
	    
	    
	   


	}
	
	
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		
	
		   
		   return (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");
		   
		   
		   
		   
	}
	
	  public static Connection getConnectionUnidades(String string) throws SQLException, ClassNotFoundException {
			
		   Class.forName("com.mysql.jdbc.Driver");
		   
		   return (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/apcontrole","root","");
		
	
}
	
	public static void main(String[]args) {
		
		try {
			System.out.println(getIstance().getConnection());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
