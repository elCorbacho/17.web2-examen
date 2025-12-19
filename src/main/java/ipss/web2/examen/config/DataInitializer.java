package ipss.web2.examen.config;

import ipss.web2.examen.models.Album;
import ipss.web2.examen.models.Lamina;
import ipss.web2.examen.repository.AlbumRepository;
import ipss.web2.examen.repository.LaminaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final AlbumRepository albumRepository;
    private final LaminaRepository laminaRepository;

    @Override
    public void run(String... args) throws Exception {
        // Verificar si ya existen datos
        if (albumRepository.count() > 0) {
            System.out.println("⚠️ Base de datos ya contiene datos. Saltando inicialización.");
            return;
        }

        System.out.println("🚀 Iniciando población de base de datos...");

        // ==================== ALBUM 1: THRILLER ====================
        Album album1 = new Album();
        album1.setNombre("Thriller");
        album1.setYear(1982);
        album1.setDescripcion("Álbum icónico de Michael Jackson que revolucionó la música pop");
        album1.setActive(true);
        album1.setLaminas(new ArrayList<>());
        Album savedAlbum1 = albumRepository.save(album1);

        crearLaminas(savedAlbum1, new String[][] {
                {"Billie Jean", "https://example.com/billie-jean.jpg", "Holográfica"},
                {"Beat It", "https://example.com/beat-it.jpg", "Rara"},
                {"Thriller", "https://example.com/thriller.jpg", "Edición limitada"},
                {"Human Nature", "https://example.com/human-nature.jpg", "Común"}
        }, 1982);

        // ==================== ALBUM 2: BAD ====================
        Album album2 = new Album();
        album2.setNombre("Bad");
        album2.setYear(1987);
        album2.setDescripcion("Segundo álbum de estudio que consolidó la carrera de Michael Jackson");
        album2.setActive(true);
        album2.setLaminas(new ArrayList<>());
        Album savedAlbum2 = albumRepository.save(album2);

        crearLaminas(savedAlbum2, new String[][] {
                {"Smooth Criminal", "https://example.com/smooth-criminal.jpg", "Holográfica"},
                {"The Way You Make Me Feel", "https://example.com/the-way.jpg", "Rara"},
                {"Man in the Mirror", "https://example.com/man-in-mirror.jpg", "Común"},
                {"Dirty Diana", "https://example.com/dirty-diana.jpg", "Edición limitada"},
                {"Just Good Friends", "https://example.com/just-good-friends.jpg", "Común"}
        }, 1987);

        // ==================== ALBUM 3: DANGEROUS ====================
        Album album3 = new Album();
        album3.setNombre("Dangerous");
        album3.setYear(1991);
        album3.setDescripcion("Álbum que marca la transición de Michael Jackson hacia sonidos más contemporáneos");
        album3.setActive(true);
        album3.setLaminas(new ArrayList<>());
        Album savedAlbum3 = albumRepository.save(album3);

        crearLaminas(savedAlbum3, new String[][] {
                {"Black or White", "https://example.com/black-or-white.jpg", "Rara"},
                {"Who Is It", "https://example.com/who-is-it.jpg", "Holográfica"},
                {"Remember the Time", "https://example.com/remember-time.jpg", "Edición limitada"},
                {"Jam", "https://example.com/jam.jpg", "Común"},
                {"Give in to Me", "https://example.com/give-in-to-me.jpg", "Rara"}
        }, 1991);

        // ==================== ALBUM 4: HIStory ====================
        Album album4 = new Album();
        album4.setNombre("HIStory: Past, Present and Future, Book I");
        album4.setYear(1995);
        album4.setDescripcion("Álbum recopilatorio que incluye hits y nuevas canciones de Michael Jackson");
        album4.setActive(true);
        album4.setLaminas(new ArrayList<>());
        Album savedAlbum4 = albumRepository.save(album4);

        crearLaminas(savedAlbum4, new String[][] {
                {"Scream", "https://example.com/scream.jpg", "Edición limitada"},
                {"They Don't Care About Us", "https://example.com/they-dont-care.jpg", "Holográfica"},
                {"Earth Song", "https://example.com/earth-song.jpg", "Rara"},
                {"You Are Not Alone", "https://example.com/you-are-not-alone.jpg", "Común"},
                {"Stranger in Moscow", "https://example.com/stranger-moscow.jpg", "Común"},
                {"This Time Around", "https://example.com/this-time-around.jpg", "Rara"}
        }, 1995);

        // ==================== ALBUM 5: INVINCIBLE ====================
        Album album5 = new Album();
        album5.setNombre("Invincible");
        album5.setYear(2001);
        album5.setDescripcion("Último álbum de estudio que combinó elementos de R&B y producción moderna");
        album5.setActive(true);
        album5.setLaminas(new ArrayList<>());
        Album savedAlbum5 = albumRepository.save(album5);

        crearLaminas(savedAlbum5, new String[][] {
                {"You Rock My World", "https://example.com/you-rock-my-world.jpg", "Holográfica"},
                {"Butterflies", "https://example.com/butterflies.jpg", "Rara"},
                {"Heartbreaker", "https://example.com/heartbreaker.jpg", "Edición limitada"},
                {"Don't Walk Away", "https://example.com/dont-walk-away.jpg", "Común"},
                {"Unbreakable", "https://example.com/unbreakable.jpg", "Rara"}
        }, 2001);

        System.out.println("✅ Base de datos poblada correctamente:");
        System.out.println("   - 5 Albumes creados");
        System.out.println("   - 20 Láminas creadas");
        System.out.println("   - Total registros: " + albumRepository.count() + " albumes, " + laminaRepository.count() + " láminas");
    }

    /**
     * Método auxiliar para crear láminas
     */
    private void crearLaminas(Album album, String[][] laminas, int año) {
        int mes = 1;
        int dia = 1;

        for (String[] laminaData : laminas) {
            Lamina lamina = new Lamina();
            lamina.setNombre(laminaData[0]);
            lamina.setImagen(laminaData[1]);
            lamina.setFechaLanzamiento(LocalDateTime.of(año, mes, Math.min(dia, 28), 12, 0, 0));
            lamina.setTipoLamina(laminaData[2]);
            lamina.setAlbum(album);
            lamina.setActive(true);

            laminaRepository.save(lamina);

            // Incrementar fecha para la próxima lámina
            dia += 2;
            if (dia > 28) {
                dia = 1;
                mes++;
                if (mes > 12) mes = 1;
            }
        }
    }
}
