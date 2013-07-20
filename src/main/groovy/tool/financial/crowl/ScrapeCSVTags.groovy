package tool.financial.crowl

import java.io.*;

class ScrapeCSVTags {

    def getCSVPathList(URL url) {
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("GET");
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "JISAutoDetect"));
        String httpSource = new String();
        String str;
        while ( null != ( str = bufferReader.readLine() ) ) {
            httpSource = httpSource + str + "\n";
        }
        bufferReader.close();
        connection.disconnect();

        // 相対パスで指定されたリンク先をすべて取得する
        ArrayList<String> list = new ArrayList<String>()
        httpSource.eachLine {
            if (it =~ /CSV\</) {
                def matchResult = (it =~ /..([\/]{1})csv([\/]{1})([0-9a-z]+)([\/]{1})d01([0-9a-z]+).csv/)
                if (matchResult) {
                    list.add(matchResult[0][0])
                }
            }
        }

        ConvertRelativeCSVURL2Absolute converter = new ConvertRelativeCSVURL2Absolute()
        List<String> absCUList = converter.convertRelativeCSVURL2Absolute(list)

        return absCUList
    }
}