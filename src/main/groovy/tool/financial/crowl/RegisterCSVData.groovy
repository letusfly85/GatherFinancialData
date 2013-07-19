package tool.financial.crowl

import tool.dbagent.dao.TranTradeValueDao
import tool.dbagent.bean.TranTradeValueBean

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
        while ( null != ( str = bufferReader.readLine() ) ) {
            def ary = str.split(/,/)

            //TODO add data check procedure
            println(ary)

            /**
             * ary example is below.
             *  [Exp or Imp, Year, HS, Country, Unit1, Unit2, Quantity1-Year, Quantity2-Year, Value-Year, Quantity1-Jan, Quantity2-Jan, Value-Jan, Quantity1-Feb, Quantity2-Feb, Value-Feb, Quantity1-Mar, Quantity2-Mar, Value-Mar, Quantity1-Apl, Quantity2-Apl, Value-Apl, Quantity1-May, Quantity2-May, Value-May, Quantity1-Jun, Quantity2-Jun, Value-Jun, Quantity1-Jul, Quantity2-Jul, Value-Jul, Quantity1-Aug, Quantity2-Aug, Value-Aug, Quantity1-Sep, Quantity2-Sep, Value-Sep, Quantity1-Oct, Quantity2-Oct, Value-Oct, Quantity1-Nov, Quantity2-Nov, Value-Nov, Quantity1-Dec, Quantity2-Dec, Value-Dec]
             *  [1, 2008, '051199000', 312, , KG, 0, 62, 5063, 0, 0, 432, 0, 0, 0, 0, 0, 0, 0, 40, 3842, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 22, 789]
             */
            //avoid header
            if (ary[0].startsWith("Exp") == false) {
                TranTradeValueBean bean = new TranTradeValueBean()
                bean.impExpKbn  =   ary[0]
                bean.year       =   ary[1]
                bean.hs         =   ary[2].replaceAll("'","")

                list.add(bean)
            }
        }
        bufferReader.close();
        connection.disconnect();

        TranTradeValueDao dao = new TranTradeValueDao()
        dao.insert(list)

    }
}