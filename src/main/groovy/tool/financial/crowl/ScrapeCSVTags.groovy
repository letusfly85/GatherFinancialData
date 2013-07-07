package main.groovy.tool.financial.crowl


import java.io.*;

url = new URL("http://www.customs.go.jp/toukei/download/2008/12/d01h0812e_j.htm")
HttpURLConnection connection = (HttpURLConnection)url.openConnection();
connection.setDoOutput(true);
connection.setRequestMethod("GET");
bufferReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "JISAutoDetect"));
String httpSource = new String();
String str;
while ( null != ( str = bufferReader.readLine() ) ) {
    httpSource = httpSource + str + "\n";
}
bufferReader.close();
connection.disconnect();

// 相対パスで指定されたリンク先をすべて取得する
list = new ArrayList<String>()
httpSource.eachLine {
    if (it =~ /CSV\</) {
        matchResult = (it =~ /..([\/]{1})csv([\/]{1})([0-9a-z]+)([\/]{1})d01([0-9a-z]+).csv/)
        if (matchResult) {
            println(matchResult[0][0])
            list.add(matchResult[0][0])
        }
    }
}