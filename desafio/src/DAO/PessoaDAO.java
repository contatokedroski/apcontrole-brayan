package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.table.DefaultTableModel;

import java.util.Map.Entry;

import dto.PessoaDTO;
import jdbc.ConexaoUtil;

public class PessoaDAO {
	private static final Connection Connection = null;
	int numeroDaUnidade;
	String nomeDaUnidade;
	String propietario;
	String condominio;

	@SuppressWarnings("unused")
	private static java.sql.Connection connect = Connection;
	public boolean isAvailable() {
	 this.connect = openDB();
     return this.connect == null ? false : true;
	}
     private java.sql.Connection openDB() {
		// TODO Auto-generated method stub
		return null;
	}
	private static Statement statement ;
	
	
	
	
	public void inserir(PessoaDTO PessoaDTO) {
		Scanner scan3 = new Scanner(System.in); scan3.useLocale(Locale.US);
		Connection connection;
		try {
			connection = ConexaoUtil.getIstance().getConnection();

			String sql = "INSERT INTO pessoas  (`nome`, `idade`, `genero`, `telefone`, `email`) values(?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
	
			statement.setString(1, PessoaDTO.getNome());
			statement.setInt(2, PessoaDTO.getIdade());
			statement.setString(3, PessoaDTO.getGenero());
			statement.setString(4, PessoaDTO.getTelefone());
			statement.setString(5, PessoaDTO.getEmail());
			statement.execute();
			connection.close();
			System.out.println("foi cadastrado");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
		System.out.println("erro nao foi possivel cadastrar");
		}

	}
	public void inserirDespesa(PessoaDTO PessoaDTO) {

		Connection connection;
		try {
			connection = ConexaoUtil.getIstance().getConnection();

			String sql = "INSERT INTO despesas  (`descricao`, `tipo_despesa`, `vencimento_fatura`, `valor`, `status_pagamento`) values(?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
	
			
		//	+-------------------+
		//	| COLUMN_NAME       |
		//	+-------------------+
		//	| id                |
		//	| descricao         |
		//	| tipo_despesa      |
		//	| status_pagamento  |
		//	|  |
		//	| valor             |
		//	+-------------------+
			statement.setString(1, PessoaDTO.getDescricao());
			statement.setString(2, PessoaDTO.getTipo_despesa());
			statement.setInt(3, PessoaDTO.getVencimento_fatura());
			statement.setDouble(4, PessoaDTO.getValor());
			statement.setString(5, PessoaDTO.getStatus_pagamento());
			
			statement.execute();
			connection.close();
			System.out.println("foi cadastrado");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
		System.out.println("erro nao foi possivel cadastrar");
		}

	}
	public void inserirUnidade(PessoaDTO PessoaDTO) {
		
		Connection connection;
		try {
			connection = ConexaoUtil.getIstance().getConnection();

			String sql = "INSERT INTO unidades  (`numeroDaUnidade`, `nomeDaUnidade`, `proprietario`, `condominio`, `endereco`) values(?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
	
			
			statement.setInt(1, PessoaDTO.getNumeroDaUnidade());
			statement.setString(2, PessoaDTO.getNomeDaUnidade());
			statement.setString(3, PessoaDTO.getPropietario());
			statement.setString(4, PessoaDTO.getCondominio());
			statement.setString(5, PessoaDTO.getEndereco());
		
			statement.execute();
			connection.close();
			System.out.println("foi cadastrado");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		System.out.println("erro nao foi possivel cadastrar");
		}

	}
	private static void writeResultSet(ResultSet resultSet) throws SQLException {

		while (resultSet.next()) {

			String meuID = resultSet.getString("id_pessoa");
			String meuNome = resultSet.getString("nome");
			int idade = resultSet.getInt("idade");
			String genero = resultSet.getString("genero");
			String telefone = resultSet.getString("telefone");
			String email = resultSet.getString("email");
			
			
		    System.out.println("id:"+meuID);
			System.out.println("nome: "+meuNome);
		    System.out.println("idade: "+idade);
			System.out.println("genero: "+genero);		          
            System.out.println("telefone: "+telefone);
            System.out.println("email: "+email);
            System.out.println("+--------+-------+--------+----------------+-----------------------------+-----------+");
		
		}
		
	}
	private static void writeResultSeunidades(ResultSet resultSet2) throws SQLException {

		while (resultSet2.next()) {

			int numeroDaUnidade = resultSet2.getInt("numeroDaUnidade");
			String nomeDaUnidade = resultSet2.getString("nomeDaUnidade");
			String propietario = resultSet2.getString("proprietario");
			String condominio = resultSet2.getString("condominio");
			String endereco = resultSet2.getString("endereco");
			
			
			
		    System.out.println("numero da Unidade:"+numeroDaUnidade);
			System.out.println(" nome da unidade : "+nomeDaUnidade);
		    System.out.println("propietario: "+propietario);
			System.out.println("condominio: "+condominio);		          
            System.out.println("endereço: "+endereco);
      
            System.out.println("+--------+-------+--------+----------------+-----------------------------+-----------+");
		
		}
		
	}
	private static void writeResultdespesas(ResultSet resultSet2) throws SQLException {

		while (resultSet2.next()) {
			
		

			int id = resultSet2.getInt("id");
			String descricao = resultSet2.getString("descricao");
			String Tipo_despesa = resultSet2.getString("Tipo_despesa");
	
			String Vencimento_fatura = resultSet2.getString("Vencimento_fatura");
			String Status_pagamento = resultSet2.getString("Status_pagamento");
			
			
			
			System.out.println("id:"+id);
			System.out.println(" descrição : "+descricao);
		    System.out.println("Tipo_despesa: "+Tipo_despesa);
				          
			 System.out.println("Vencimento_fatura: "+Vencimento_fatura);
			 System.out.println("Status_pagamento: "+Status_pagamento);
            System.out.println("+--------+-------+--------+----------------+-----------------------------+-----------+");
		
		}
		
	}
	private static void writeResultFiltR(ResultSet resultSet2) throws SQLException {

		while (resultSet2.next()) {
			
		

			int id = resultSet2.getInt("id");
			String descricao = resultSet2.getString("descricao");
			String Tipo_despesa = resultSet2.getString("Tipo_despesa");
	
			String Vencimento_fatura = resultSet2.getString("Vencimento_fatura");
			String Status_pagamento = resultSet2.getString("Status_pagamento");
			
			
			
			System.out.println("id:"+id);
			System.out.println(" descrição : "+descricao);
		    System.out.println("Tipo_despesa: "+Tipo_despesa);
				          
			 System.out.println("Vencimento_fatura: "+Vencimento_fatura);
			 System.out.println("Status_pagamento: "+Status_pagamento);
            System.out.println("+--------+-------+--------+----------------+-----------------------------+-----------+");
		
		}
		
	}
	// You need to close the resultSet
	private static void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	

	
	}

	
	
	private static  ResultSet resultSet ;

	final private static String host = "localhost";
	final private static String user = "root";
	final private static String passwd = "";
	public void remover(int id_pessoa) {

		Connection connection;
		try {
			connection =  ConexaoUtil.getIstance().getConnection();

			  String sql = "DELETE FROM pessoas WHERE id_pessoa = ?";
		
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id_pessoa);

			statement.execute();
			connection.close();
			System.out.println("removido com suceso");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void removerUnidades(int numeroDaUnidade) {

		Connection connection;
		try {
			connection = ConexaoUtil.getIstance().getConnection();

			String sql = "DELETE FROM unidades WHERE numeroDaUnidade = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, numeroDaUnidade);

			statement.execute();
			connection.close();
			System.out.println("removido com suceso");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	

	 public static ResultSet carregaTabela () throws SQLException, ClassNotFoundException{
			Scanner scan2 = new Scanner(System.in); scan2.useLocale(Locale.US);
		 String argumento;

			
			 Connection conexao = ConexaoUtil.getIstance().getConnection();

			 System.out.println("digite a descrição do produto dejesjado");
	           argumento = scan2.next();
		 

		 
			PreparedStatement statement = conexao.prepareStatement("SELECT * FROM despesas WHERE descricao like '"+argumento+"%' ");
					 
		 ResultSet rs = statement.executeQuery(); 
		 writeResultFiltR(rs);
		return null; 
		 
		 
		 
		 
	 }
	

	 public static ResultSet carregaTabelaVencido () throws SQLException, ClassNotFoundException{
			Scanner scan2 = new Scanner(System.in); scan2.useLocale(Locale.US);
		 String argumento;

			
			 Connection conexao = ConexaoUtil.getIstance().getConnection();

			 System.out.println("digite o dia");
	           argumento = scan2.next();
		 

		 
			PreparedStatement statement = conexao.prepareStatement("SELECT * FROM despesas WHERE vencimento_fatura < "+argumento+" ");
					 
		 ResultSet rs = statement.executeQuery(); 
		 writeResultFiltR(rs);
		return null; 
		 
		 
		 
		 
	 }
	
	 
	
	      
	private void filto() {
		String tipo ="";
		
		
		String escolha="";
		
		tipo = ""+"descricao";
	 
		try {
			String arg = "";
			ResultSet rs = PessoaDAO.carregaTabela();
			
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}


	
	public void listarTodos () throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");

			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://" + host + "/apcontrole?" + "user=" + user + "&password=" + passwd);

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL 
			 System.out.println("+--------+-------+--------+----------------+-----------------------------+-----------+");
			resultSet = statement.executeQuery("select * from pessoas");
			writeResultSet(resultSet);
			
			System.out.println("Banco de Dados Conectado com sucesso!");
			 System.out.println("+--------+-------+--------+----------------+-----------------------------+-----------+");
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
			
	}
	public void listarTodasUnidades () throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");

			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://" + host + "/apcontrole?" + "user=" + user + "&password=" + passwd);

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL 
			 System.out.println("+--------+-------+--------+----------------+-----------------------------+-----------+");
			resultSet = statement.executeQuery("select * from unidades");
			writeResultSeunidades(resultSet);
			
			System.out.println("Banco de Dados Conectado com sucesso!");
			 System.out.println("+--------+-------+--------+----------------+-----------------------------+-----------+");
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
			
	}
	public void listarTodasdispesas () throws Exception {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");

			// Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://" + host + "/apcontrole?" + "user=" + user + "&password=" + passwd);

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL v
			 System.out.println("+--------+-------+--------+----------------+-----------------------------+-----------+");
			resultSet = statement.executeQuery("select * from despesas");
			writeResultdespesas(resultSet);
			
			System.out.println("Banco de Dados Conectado com sucesso!");
			 System.out.println("+--------+-------+--------+----------------+-----------------------------+-----------+");
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
			
	}
	
	public void atualizarnome(PessoaDTO pessoaDTO) {
		try {
			Connection connection;
			
			
			connection = ConexaoUtil.getIstance().getConnection(); 

			String sql = "UPDATE pessoas SET NOME = ? WHERE id_pessoa = ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,pessoaDTO.getNome());
			statement.setInt(2,pessoaDTO.getId_pessoa());
			
			
			statement.execute();
			connection.close();
			
		} catch (Exception e) {
		}
	}
	
	public void atualizaridade(PessoaDTO pessoaDTO2) {
		try {
			Connection connection;
			
			connection = ConexaoUtil.getIstance().getConnection();

			String sql = "UPDATE pessoas SET idade = ? WHERE id_pessoa = ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1,pessoaDTO2.getIdade());
			statement.setInt(2,pessoaDTO2.getId_pessoa());
			
			
			statement.execute();
			connection.close();
			
		} catch (Exception e) {
			
		}
	}
	public void atualizargenero(PessoaDTO pessoaDTO2) {
		try {
			Connection connection;
			
			connection = ConexaoUtil.getIstance().getConnection();

			String sql = "UPDATE pessoas SET genero = ? WHERE id_pessoa = ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,pessoaDTO2.getGenero());
			statement.setInt(2,pessoaDTO2.getId_pessoa());
			
			
			statement.execute();
			connection.close();
			
		} catch (Exception e) {
			
		}
	}
	public void atualizarTelefone(PessoaDTO pessoaDTO2) {
		try {
			Connection connection;
			
			connection = ConexaoUtil.getIstance().getConnection();

			String sql = "UPDATE pessoas SET telefone = ? WHERE id_pessoa = ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,pessoaDTO2.getTelefone());
			statement.setInt(2,pessoaDTO2.getId_pessoa());
			
			
			statement.execute();
			connection.close();
			
		} catch (Exception e) {
			
		}
	}
	public void atualizaremail(PessoaDTO pessoaDTO2) {
		try {
			Connection connection;
			
			connection = ConexaoUtil.getIstance().getConnection();

			String sql = "UPDATE pessoas SET email = ? WHERE id_pessoa = ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,pessoaDTO2.getEmail());
			statement.setInt(2,pessoaDTO2.getId_pessoa());
			
			
			statement.execute();
			connection.close();
			
		} catch (Exception e) {
			
		}
	}
	public void atualizarNumeroDaUnidade(PessoaDTO pessoaDTO) {
		try {
			Connection connection;
			
			connection = ConexaoUtil.getIstance().getConnection();

			String sql = "UPDATE unidade SET numeroDaUnidade = ? WHERE numeroDaUnidade = ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1,pessoaDTO.getNumeroDaUnidade());
			statement.setInt(2,pessoaDTO.getNumeroDaUnidade());
			
			
			statement.execute();
			connection.close();
			
		} catch (Exception e) {
		}
	}
	public void atualizarNomeDaUnidade(PessoaDTO pessoaDTO) {
		try {
			Connection connection;
			
			connection = ConexaoUtil.getIstance().getConnection();

			String sql = "UPDATE unidade SET nomeDaUnidade = ? WHERE numeroDaUnidade = ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,pessoaDTO.getNomeDaUnidade());
			statement.setInt(2,pessoaDTO.getNumeroDaUnidade());
			
			
			statement.execute();
			connection.close();
			
		} catch (Exception e) {
		}
	}
	
	public void atualizarPropietario (PessoaDTO pessoaDTO) {
		try {
			Connection connection;
			
			connection = ConexaoUtil.getIstance().getConnection();

			String sql = "UPDATE unidade SET numeroDaUnidade = ? WHERE numeroDaUnidade = ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,pessoaDTO.getPropietario());
			statement.setInt(2,pessoaDTO.getNumeroDaUnidade());
			
			
			statement.execute();
			connection.close();
			
		} catch (Exception e) {
			
		}
	}
	public void atualizarEndereco(PessoaDTO pessoaDTO2) {
		try {
			Connection connection;
			
			connection = ConexaoUtil.getIstance().getConnection();

			String sql = "UPDATE unidades SET endereco = ? WHERE numeroDaUnidade = ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,pessoaDTO2.getEndereco());
			statement.setInt(2,pessoaDTO2.getNumeroDaUnidade());
			
			
			statement.execute();
			connection.close();
			
		} catch (Exception e) {
			
		}
	}
	public void atualizaCondomino(PessoaDTO pessoaDTO2) {
		try {
			Connection connection;
			
			connection = ConexaoUtil.getIstance().getConnection();

			String sql = "UPDATE unidades SET condomino = ? WHERE numeroDaUnidade = ? ";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,pessoaDTO2.getCondominio());
			statement.setInt(2,pessoaDTO2.getNumeroDaUnidade());
			
			
			statement.execute();
			connection.close();
			
		} catch (Exception e) {
			
		}
	}
	
	
	
	
	public static void main(String[] args) {

			  
		  }
		
		
       
	
		
		
		
	}
	
	

