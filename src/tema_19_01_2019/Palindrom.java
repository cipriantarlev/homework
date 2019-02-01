package tema_19_01_2019;

public class Palindrom {

	boolean ok = true;
	private String n;

	public String isThisNumberPalindrom(String n) {
		String x;

		for (int i = 0, j = n.length() - 1; i < n.length() / 2 + 1 && ok; i++, j--) {

			if (n.charAt(i) != n.charAt(j)) {
				ok = false;
			}
		}
		if (ok) {
			x = "Acest String este palindrom";
		} else {
			x = "Acest String nu este palindrom";
		}
		return x;
	}

	// metoda asta ar fi fost mai usor de testat daca ar intoarce un boolean
	//in plus am imbunatatit putin si parcurgerea sirului
	public boolean isThisNumberPalindromBoolean(String str) {
		int length = str.length(); //extragem lungimea stringului intr-o variabila, pt ca o folosesc de mai multe ori, ca sa evit apelul duplicat al lui String.length()
		for (int i = 0; i < length / 2; i++) {
			if (str.charAt(i) != str.charAt(length - i - 1)) {//compar fiecare caracter cu omologul sau de cealalta parte a mijlocului stringului
				return false;//daca gasesc o pereche de caractere omoloage (egal departate de capetele stringului) diferite termin metoda, e clar ca stringul nu e palindrom
			}
		}
		return true;//daca a ajuns aici inseamna ca nu a gasit nicio pereche de caractere diferite
	}

//	public static void main(String[] args) {
//		Palindrom s = new Palindrom();
//
//		s.isThisNumberPalindrom("tata");
//	}
}