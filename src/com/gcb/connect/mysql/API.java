package com.gcb.connect.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class API {
	
	public static void criarTabelas() {
		try {
			String sql = "CREATE TABLE IF NOT EXISTS `jobs` (id int PRIMARY KEY AUTO_INCREMENT, UUID text, mineracao int, assassino int, lenhador int, classe text);";
			Statement st = Conexao.getConnection().createStatement();
			st.executeUpdate(sql);
		} catch (SQLException ev) {
			ev.printStackTrace();
		}
	}
	
	public static void deletarTabelas() {
		try {
			String sql = "DROP TABLE `jobs`";
			Statement st = Conexao.getConnection().createStatement();
			st.executeUpdate(sql);
		} catch (SQLException ev) {
			ev.printStackTrace();
		}
	}
	
	public static void createPlayer(UUID player) {
		if(!playerExists(player)) {
			try {
				String sql = "INSERT INTO jobs (UUID, mineracao, assassino, lenhador, classe) VALUES ('"+player+"', 0, 0, 0, '---');";
				Statement st = Conexao.getConnection().createStatement();
				st.executeUpdate(sql);
			} catch (SQLException ev) {
				ev.printStackTrace();
			}
		}
	}
	
	public static String getClasse(UUID player) {
		if(playerExists(player)) {
			String retorno = null;
			try {
				Statement st = Conexao.getConnection().createStatement();
				String sql = "SELECT * FROM jobs WHERE UUID= '"+player+"';";
				ResultSet rs = st.executeQuery(sql);
				if(!rs.next() || String.valueOf(rs.getString("classe")) == null) {
					return retorno;
				}
				retorno = rs.getString("classe");
				return retorno;
			} catch (SQLException ev) {ev.printStackTrace(); return null;}
		} else {
			return null;
			
		}
	}
	
	public static void setClasse(UUID player, String classe) {
		if(playerExists(player)) {
			try {
				String sql = "UPDATE jobs SET classe = '"+classe+"' WHERE UUID= '"+player+"';";
				Statement st = Conexao.getConnection().createStatement();
				st.executeUpdate(sql);
			} catch (SQLException ev) {
				ev.printStackTrace();
			}
		}
	}
	
	
	public static int getMineracao(UUID player) {
		if(playerExists(player)) {
			int retorno = 0;
			try {
				Statement st = Conexao.getConnection().createStatement();
				String sql = "SELECT * FROM jobs WHERE UUID= '"+player+"';";
				ResultSet rs = st.executeQuery(sql);
				if(!rs.next() || Integer.valueOf(rs.getInt("mineracao")) == null) {
					return retorno;
				}
				retorno = rs.getInt("mineracao");
				return retorno;
			} catch (SQLException ev) {ev.printStackTrace(); return 0;}
		} else {
			return 0;
			
		}
	}
	
	public static void setLenhador(UUID player, int level) {
		if(playerExists(player)) {
			try {
				String sql = "UPDATE jobs SET lenhador = '"+level+"' WHERE UUID= '"+player+"';";
				Statement st = Conexao.getConnection().createStatement();
				st.executeUpdate(sql);
			} catch (SQLException ev) {
				ev.printStackTrace();
			}
		}
	}
	
	public static int getLenhador(UUID player) {
		if(playerExists(player)) {
			int retorno = 0;
			try {
				Statement st = Conexao.getConnection().createStatement();
				String sql = "SELECT * FROM jobs WHERE UUID= '"+player+"';";
				ResultSet rs = st.executeQuery(sql);
				if(!rs.next() || Integer.valueOf(rs.getInt("lenhador")) == null) {
					return retorno;
				}
				retorno = rs.getInt("lenhador");
				return retorno;
			} catch (SQLException ev) {ev.printStackTrace(); return 0;}
		} else {
			return 0;
			
		}
	}
	
	public static void setMineracao(UUID player, int level) {
		if(playerExists(player)) {
			try {
				String sql = "UPDATE jobs SET mineracao = '"+level+"' WHERE UUID= '"+player+"';";
				Statement st = Conexao.getConnection().createStatement();
				st.executeUpdate(sql);
			} catch (SQLException ev) {ev.printStackTrace();}
		}
	}
	
	public static int getAssassino(UUID player) {
		if(playerExists(player)) {
			int retorno = 0;
			try {
				Statement st = Conexao.getConnection().createStatement();
				String sql = "SELECT * FROM jobs WHERE UUID= '"+player+"';";
				ResultSet rs = st.executeQuery(sql);
				if(!rs.next() || Integer.valueOf(rs.getInt("assassino")) == null) {
					return retorno;
				}
				retorno = rs.getInt("assassino");
				return retorno;
			} catch (SQLException ev) {ev.printStackTrace(); return 0;}
		} else {
			return 0;
			
		}
	}
	
	public static void setAssassino(UUID player, int level) {
		if(playerExists(player)) {
			try {
				String sql = "UPDATE jobs SET assassino = '"+level+"' WHERE UUID= '"+player+"';";
				Statement st = Conexao.getConnection().createStatement();
				st.executeUpdate(sql);
			} catch (SQLException ev) {ev.printStackTrace();}
		}
	}
	
	public static boolean playerExists(UUID player) {
		try {
			Statement st = Conexao.getConnection().createStatement();
			String sql = "SELECT * FROM jobs WHERE UUID= '"+player+"';";
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
			if(rs.getString("UUID") == null) {
				return false;
			}
			return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
