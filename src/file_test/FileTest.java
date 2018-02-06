package file_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileTest {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("d:/data.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osw);
		String str1 = "中国移动阅读基地";
		String str2 = "中国移动视频基地";
		bw.write(str1);
		bw.write("\r\n");
		bw.write(str2);
		bw.close();
		FileInputStream fis = new FileInputStream("d:/data.txt");
		   InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
		   BufferedReader br = new BufferedReader(isr);
		   String str;
		   while(null != (str = br.readLine()))
		   {
		      System.out.println(str);
		   }
		br.close();
		File file = new File("");
		System.out.println(file.isFile());
	}

}
