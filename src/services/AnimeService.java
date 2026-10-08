package services;

import connector.ConexionBD;
import model.Anime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnimeService {

    public static void Añadir(Anime anime) {
        String sql = "INSERT INTO public.anime (nome, descripcion, data, puntuacion) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionBD.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, anime.getNome());
            ps.setString(2, anime.getDescripcion());
            ps.setDate(3, anime.getData());
            ps.setInt(4, anime.getPuntuacion());
            ps.executeUpdate();
            System.out.println("Anime añadido con éxito.");

        } catch (SQLException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());
        }
    }

    public static void leer() {
        String sql = "SELECT * FROM public.anime";

        try (Connection conn = ConexionBD.conexion();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet resultado = ps.executeQuery()) {

            while (resultado.next()) {
                System.out.println("Nome: " + resultado.getString("nome"));
                System.out.println("Descripcion: " + resultado.getString("descripcion"));
                System.out.println("Data: " + resultado.getDate("data"));
                System.out.println("Puntuacion: " + resultado.getInt("puntuacion"));
                System.out.println("-----------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());
        }
    }

    public static void filtro(String nome) {
        String sql = "SELECT * FROM public.anime WHERE nome = ?";

        try (Connection conn = ConexionBD.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nome);
            try (ResultSet resultado = ps.executeQuery()) {
                while (resultado.next()) {
                    System.out.println("Nome: " + resultado.getString("nome"));
                    System.out.println("Descripcion: " + resultado.getString("descripcion"));
                    System.out.println("Data: " + resultado.getDate("data"));
                    System.out.println("Puntuacion: " + resultado.getInt("puntuacion"));
                    System.out.println("-----------------------------------");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());
        }
    }

    public static void actualizar(String nomeOrixinal, Anime animeNovo) {
        String sql = "UPDATE public.anime SET nome = ?, descripcion = ?, data = ?, puntuacion = ? WHERE nome = ?";

        try (Connection conn = ConexionBD.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, animeNovo.getNome());
            ps.setString(2, animeNovo.getDescripcion());
            ps.setDate(3, animeNovo.getData());
            ps.setInt(4, animeNovo.getPuntuacion());
            ps.setString(5, nomeOrixinal);

            ps.executeUpdate();
            System.out.println("Anime actualizado con éxito.");

        } catch (SQLException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());
        }
    }

    public static void eliminar(String nome) {
        String sql = "DELETE FROM public.anime WHERE nome = ?";
        try (Connection conn = ConexionBD.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nome);

            ps.executeUpdate();
            System.out.println("Anime eliminado con éxito.");

        } catch (SQLException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());
        }
    }
}