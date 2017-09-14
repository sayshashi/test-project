import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;

public class FRMTString {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(
				                 new FileReader("c:\\users\\sduchetty\\downloads\\ISOCODEs.csv"));
		StringBuffer buff = new StringBuffer();
		String ch;
		while((ch=reader.readLine())!=null)
		{
			boolean flag = false;
			if(ch.contains("\""))
			{
				int st = ch.indexOf("\"");
				int en = ch.indexOf("\"",st+1);
				String temp = ch.substring(st, en);
				ch = ch.replaceAll(temp, temp.replace(",", "+")); 
// 				System.out.println(ch);
				flag =true;
			}
			String[] ors = ch.split(",");
	 			
		    if("To Be added new in Portal".equalsIgnoreCase(ors[6].trim()) && flag ){
		    	if(flag)
		    		ors[3]=ors[3].replace("+", ",").replace("\"", "");
 		    	 
//		    	System.out.println(ch);
		    	
				MessageFormat fmt = new MessageFormat("insert into list_states name(state_id,state_code,state_name,country_id,is_active,timezone_id)"
						+ " values((select max(state_id)+1 from list_states),\"{5}\",\"{2}\", "
						+ " (select country_id from list_countries where upper(COUNTRY_NAME) like upper(\"{3}\")) ,1,"
						+ " (select distinct timezone_id from List_countries where"
						+ " upper(COUNTRY_NAME) like upper(\"{3}\"))); ");
				if(ors[5].length()>10)
					buff.append("--");
				buff.append(fmt.format(ors));
				buff.append("\r\n");
			 
			}
		    if("Transformation needed in Support Portal".equalsIgnoreCase(ors[4].trim())){
		    	MessageFormat fmt = new MessageFormat("update list_states set state_name=\"{2}\" where state_name like \"{1}\"");
		    	System.out.println(fmt.format(ors));
		    }
			
		}
		ch = buff.toString();
		ch = ch.replaceAll("'", "''");
 		ch = ch.replaceAll("\"", "'");
		System.out.println(ch);
	}

}
