package App.controller;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class ConnectDB {
	
	private static Connection connect = null;
		
		/* Connexion à la base de données */
		private String url = "jdbc:mysql://localhost:3306/siobank";
		private String utilisateur = "root";
		private String motDePasse = "";


		public ConnectDB() {
			
			/* Chargement du driver JDBC pour MySQL */
			try {
			    Class.forName( "com.mysql.jdbc.Driver" );
			    System.out.println("Driver OK");
			    connect = (Connection) DriverManager.getConnection( url, utilisateur, motDePasse );
			    System.out.println("Connexion à la base OK");
			} catch ( Exception e ) {
				e.printStackTrace();
			}
			
			
			
		} //Fin public ConnectDB()
		
		
		
		
		
		public static Connection initConnection() {
			
			if (connect == null) {
				new ConnectDB();
			}
			return connect;
			
		}
		
		
		
} //Fin public class ConnectDB





