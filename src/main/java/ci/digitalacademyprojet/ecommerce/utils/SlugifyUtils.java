package ci.digitalacademyprojet.ecommerce.utils;

import com.github.slugify.Slugify;

import java.util.UUID;

public class SlugifyUtils {

    private SlugifyUtils() {}

    public static String generate(String input) {
        // Générer un slug à partir de l'entrée en ajoutant un UUID pour l'unicité
        String value = String.format("%s,%s", input, UUID.randomUUID());
        final Slugify slg = Slugify.builder().underscoreSeparator(true).build(); // Configurer Slugify

        return slg.slugify(value); // Retourner le slug généré

    }

}
