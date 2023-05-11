package school.sptech.metadados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MetaDadosApplication {

	public static void main(String[] args) {
		try (Connection connection = AzureDatabase.getConnection()) {
			String sqlEsporte = "INSERT INTO competencias (esporte) VALUES (?)";
			String sqlTecido = "INSERT INTO competencias (tecido) VALUES (?)";

			try (PreparedStatement statement = connection.prepareStatement(sqlEsporte)) {
				String[] esportes = {"futebol", "basquete", "vôlei"};
				for (int i = 0; i < esportes.length; i++) {
					statement.setString(1, esportes[i]);
					statement.executeUpdate();
				}
			}
			try(PreparedStatement statement = connection.prepareStatement(sqlTecido)){
				String[] tecidos = {"algodão", "poliéster", "nylon"};
				for (int i = 0; i < tecidos.length; i++) {
					statement.setString(1, tecidos[i]);
					statement.executeUpdate();
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

	//		try (Connection connection = AzureDatabase.getConnection()) {
//			String sql = "INSERT INTO competencias (esporte, tecido) VALUES (?, ?)";
//			try (PreparedStatement statement = connection.prepareStatement(sql)) {
//				String[] esportes = {"futebol", "basquete", "vôlei"};
//				String[] tecidos = {"algodão", "poliéster", "nylon"};
//				for (int i = 0; i < esportes.length; i++) {
//					statement.setString(1, esportes[i]);
//					statement.setString(2, tecidos[i]);
//					statement.executeUpdate();
//				}
//			}
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
