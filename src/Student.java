public class Student extends Persoon{
    int studentNummer;
    String studieRichting;
    Student(int studentNummer, String studieRichting,int bsn, String voornaam, String achternaam, Datum geboortedatum, char geslacht){
        super(bsn,voornaam,achternaam,geboortedatum,geslacht);
        this.studentNummer = studentNummer;
        this.studieRichting = studieRichting;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNummer=" + studentNummer +
                ", studieRichting='" + studieRichting + '\'' +
                '}';
    }
}
