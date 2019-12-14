
public class Cbr {
    public static void main(String[] args) {
        Farbe rot = new Farbe("rot");
        Farbe blau = new Farbe("blau");
        unsinn(rot, blau);
        System.out.println("----------------unsinn------------");
        System.out.println("rot=" + rot.get());
        System.out.println("blau=" + blau.get());
        rot = blau;
        System.out.println("----------------rot=blau------------");
        System.out.println("rot=" + rot.get());
        System.out.println("blau=" + blau.get());
        bleichen(blau);
        System.out.println("----------------bleichen------------");
        System.out.println("rot=" + rot.get());
        System.out.println("blau=" + blau.get());
    }

    static void bleichen(Farbe f) {
        f.set("gelb");
        f = new Farbe("schwarz");
        f.set("weiss");
    }

    static void unsinn(Farbe f1, Farbe f2) {
        Farbe tmp = f1;
        f1 = f2;
        f2 = tmp;
    }

    
}