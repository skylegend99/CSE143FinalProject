public class Information{
    public final String name;
    public final String pronoun;
    public final String section;
    public final String email;
    public final String ipl;
    public final String comment;

    public Information(String... args) {
        this.name = args[0];
        this.pronoun = args[1];
        this.section = args[2];
        this.email = args[3];
        this.ipl = args[4];
        this.comment = args[5];
    }

    public static Information fromCsv(String... args) {
        return new Information(args[0].trim(), args[1].trim(), args[2].trim(), args[3].trim(), args[4].trim(), args[5].trim());
    }

    public String toString() {
        return this.name + "\n" + this.pronoun + "\n" + this.section + "\n" + this.email + "\n" + this.ipl + "\n" + this.comment;
    }
}




