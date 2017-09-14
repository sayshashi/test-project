import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class connectiont {

	public static void main(String[] args) throws IOException {


		/*String reqURL = request.getRequestURL().toString();
		int last = reqURL.lastIndexOf("/");
		last = reqURL.lastIndexOf("/",last-1);
		last = reqURL.lastIndexOf("/",last-1);*/
		 
		URL	url = new URL("https://supportqa.polycom.com/PolycomService/menu/getMenuAsJson.htm");
		 
		
		HttpsURLConnection httpConn = (HttpsURLConnection) url.openConnection();
		
		 
		
		httpConn.connect();
		StringBuffer jsonString = new StringBuffer();
		
		InputStreamReader in = new InputStreamReader((InputStream) httpConn.getContent());
		BufferedReader buff = new BufferedReader(in);

		String line = "";
		do {
			line = buff.readLine();
			jsonString.append(line);
		} while (line != null);

		 System.out.println(jsonString);
	
		

	}

}
