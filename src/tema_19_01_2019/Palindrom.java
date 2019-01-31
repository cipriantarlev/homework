package tema_19_01_2019;

public class Palindrom {

	boolean ok = true;
	private String n;

		public String isThisNumberPalindrom (String n) {
			String x;
			
			for(int i = 0, j = n.length() - 1;i<n.length()/2+1&&ok;i++,j--)
			{
				
				if (n.charAt(i) != n.charAt(j)) {
					ok = false;
				}
			}if(ok)
			{
				x = "Acest String este palindrom";
			}else
			{
				x = "Acest String nu este palindrom";
			}
			return x;
		}
		
		public static void main(String[] args) {
			Palindrom s = new Palindrom();
			
			s.isThisNumberPalindrom("tata");
		}
}