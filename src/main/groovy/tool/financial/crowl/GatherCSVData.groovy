package main.groovy.tool.financial.crowl

import java.lang.*;
import java.io.*;
import java.net.*;

url = new URL("http://www.customs.go.jp/toukei/download/2008/csv/d01/d01h08e001.csv")
HttpURLConnection connection = (HttpURLConnection)url.openConnection();
connection.setDoOutput(true);
connection.setRequestMethod("GET");
bufferReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "JISAutoDetect"));
String str;

def list = []
String impExpKbn
while ( null != ( str = bufferReader.readLine() ) ) {
    impExpKbn = str.split(/,/)[0]

    //TODO 長さ１以上のデータが入ってきたときの対応
    if (impExpKbn != null) {
        EntityTranTradeValue entity = new EntityTranTradeValue()
        entity.impExpKbn = impExpKbn
        list.add(entity)
    }

    println(str.split(/,/))
}
bufferReader.close();
connection.disconnect();

RegisterTranTradeValue register = new RegisterTranTradeValue()
register.insertTranTradeValue(list)
