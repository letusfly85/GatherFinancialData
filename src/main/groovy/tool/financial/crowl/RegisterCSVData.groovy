package tool.financial.crowl

import tool.dbagent.dao.TranTradeValueDao
import tool.dbagent.entity.TranTradeValueBean

import java.lang.*;
import java.io.*;
import java.net.*;

class RegisterCSVData {
    static def url

    public static void main(String[] args)  {

        url = new URL("http://www.customs.go.jp/toukei/download/2008/csv/d01/d01h08e001.csv")
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("GET");
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "JISAutoDetect"));
        String str;

        def list = []
        String impExpKbn
        while ( null != ( str = bufferReader.readLine() ) ) {
            impExpKbn = str.split(/,/)[0]

            //TODO 長さ１以上のデータが入ってきたときの対応
            if (impExpKbn != null) {
                TranTradeValueBean entity = new TranTradeValueBean()
                entity.impExpKbn = impExpKbn
                list.add(entity)
            }

            println(str.split(/,/))
        }
        bufferReader.close();
        connection.disconnect();

        TranTradeValueDao register = new TranTradeValueDao()
        register.insertTranTradeValue(list)

    }
}