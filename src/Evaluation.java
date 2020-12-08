public class Evaluation{
    public final String amPm;
    public final String color;
    public final String[] personality;
    public final String pace;
    public final String style;

    public Evaluation(String amPm,  String color,  String[] personality,  String pace,  String style) {
        this.amPm = amPm;
        this.color = color;
        this.personality = personality;
        this.pace = pace;
        this.style = style;
    }

    public static Evaluation fromCsv(String... args) {
        return new Evaluation(args[0].trim(), args[1].trim(), args[2].trim().split("\\,"), args[3].trim(), args[4].trim());
    }


    public String toString() {
        return this.amPm + "\n" + this.color + "\n" + this.personality + "\n" + this.pace + "\n" + this.style;
    }
}




