// This class reads the string from a file and collects the content within the string.
public class Evaluation{
    public final String amPm;
    public final String color;
    public final String[] personality;
    public final String pace;
    public final String style;

    // Initializes the fields.
    public Evaluation(String amPm,  String color,  String[] personality,  String pace,  String style) {
        this.amPm = amPm;
        this.color = color;
        this.personality = personality;
        this.pace = pace;
        this.style = style;
    }

    // Constructs and returns a new Evaluation with the given argument.
    public static Evaluation fromCsv(String... args) {
        return new Evaluation(args[0].trim(), args[1].trim(), args[2].trim().split("\\,"), args[3].trim(), args[4].trim());
    }

    // Returns the content in the file as a string.
    public String toString() {
        return this.amPm + "\n" + this.color + "\n" + this.personality + "\n" + this.pace + "\n" + this.style;
    }
}