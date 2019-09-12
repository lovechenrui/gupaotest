package com.chenrui.restonspringwebmvc;


import org.springframework.util.StringUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpDownLoadTest {
	public static void main(String[] args) {
		String urls = args[0];
		System.out.println(urls);
		HttpURLConnection connection = null;
		if(!StringUtils.isEmpty(urls)){
			try {
				URL url = new URL(urls);
				connection = (HttpURLConnection)url.openConnection();
				connection.setReadTimeout(3000);
				connection.setUseCaches(false);
				//connection.setRequestProperty("Content-Type",  "application/x-www-form-urlencoded");
				connection.setRequestMethod("GET");
				if(connection.getResponseCode() == 200){
					InputStream inputStream = connection.getInputStream();
					BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
					String line = null;
					StringBuilder msg = new StringBuilder();
					while ((line = bufferedReader.readLine()) != null){
						msg.append(line + "\n");
					}
					System.out.println(msg.toString());
					File file = new File("a.html");
					FileWriter writer = new FileWriter(file);
					BufferedWriter bufferedWriter = new BufferedWriter(writer);
					bufferedWriter.write(msg.toString());
					bufferedWriter.flush();
					writer.close();
					bufferedWriter.close();
					bufferedReader.close();
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				if(connection != null){
					connection.disconnect();
				}
			}

		}
	}
}
