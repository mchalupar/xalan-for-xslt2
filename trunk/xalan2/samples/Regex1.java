import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Regex1 {
	public static void main(String args[]) {
		try {
			 System.out.println(URLEncoder.encode("编码格式","UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String str = "abracadabra";
		String regEx = "^bra"; // 表示a或f
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		boolean result = m.find();
		System.out.println(result);
		
		
		
		
		System.out.println("abracadabra".replaceAll("a.*?a", "*"));
		
		StringTokenizer st = new StringTokenizer("The cat sat on the mat", "s+");
		 while(st.hasMoreElements()){
		 System.out.println("Token:" + st.nextToken());
		 }
	
		 method1("The cat sat on the mat");
	}
	
	public static void method1(String str) {
     String ret = Arrays.asList(Pattern.compile("\\s+").split(str)).toString();
     
       System.out.println(ret);
	}
}
