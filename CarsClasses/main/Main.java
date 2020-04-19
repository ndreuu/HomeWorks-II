import Cars.LadaPriora;
import Cars.Volga;

public class Main {
    public static void main(String[] args) {
	LadaPriora myPriora = new LadaPriora(200, 4, 2000000, "Russia","Lada Priora", 2010);
	Volga myVolga = new Volga(100,4,1000000,"USSR","Volga","Black");
        System.out.println(myPriora.getInfo());
        System.out.println(myVolga.getInfo());
    }
}
