package projectsauss;

/**
 * <p>A program to translate from one language to another using dictionaries.
 * </p>
 * @author antoniomalvagomes
 */
public class ProjectSauss {

    public static void main(String[] args) {
        if(args.length<2)
        {
            System.err.println("Usage:\n\tjava ProjectSauss [lang] [phrase]");
            System.exit(1);
        }
        Dictionary dict = new Dictionary(args[0]);
        System.out.println(dict.wordTranslate(args[1]));
    }
}
