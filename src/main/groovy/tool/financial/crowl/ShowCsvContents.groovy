package tool.financial.crowl


import java.lang.*;
import java.io.*;
import java.net.*;

url = new URL("http://www.customs.go.jp/toukei/download/2008/csv/d01/d01h08e001.csv")
HttpURLConnection connection = (HttpURLConnection)url.openConnection();
connection.setDoOutput(true);
connection.setRequestMethod("GET");
bufferReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "JISAutoDetect"));
String httpSource = new String();
String str;
while ( null != ( str = bufferReader.readLine() ) ) {
    httpSource = httpSource + str;
    println(str)
}
bufferReader.close();
connection.disconnect();