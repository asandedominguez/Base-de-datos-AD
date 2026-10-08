import connector.ConexionBD;
import model.Anime;
import services.AnimeService;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class main {
    public static Date stringToDate(String dataStr) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date dataUtil = formato.parse(dataStr);
            return new Date(dataUtil.getTime());
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        ConexionBD.conexion();

        Anime novoAnime = new Anime("Naruto", "Shonen", stringToDate("2002-10-03"), 10);
        AnimeService.Añadir(novoAnime);
        AnimeService.leer();
        AnimeService.filtro("Naruto");

        Anime animeModificado = new Anime("Naruto Shippuden", "Nova descrición", stringToDate("2007-02-15"), 10);
        AnimeService.actualizar("Naruto", animeModificado);

        AnimeService.eliminar("Naruto Shippuden");

    }
}

