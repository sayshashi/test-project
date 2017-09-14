import java.util.ArrayList;
import java.util.HashMap;

public class ArrayListStr {

	public static void main(String[] args) {

		 System.out.println("ŁŞçžáâöÑŏẔŎđĔëéïūŪēîăÓņŢėċõḍřĭğīèšäәḤġḨķÚ"+"|       testing13242");
		 HashMap<String, String> mp = new HashMap<>();
      ArrayList<String> ar = new ArrayList<String>(){
    	  @Override public String toString()
    	  {
    		  return super.toString().replace(",", " -");
    	  }
      };
      for(long i=0;;i++){
    	  mp.put("key"+i, "value");
      }
//      ar.add("yes");
//      ar.add("yenki");
//       System.out.println(String.join(";", ar));
//       System.out.println(ar);
//       String email ="raju@gmail.com";
//       System.out.println(email.substring(email.indexOf("@")));
	}

}
