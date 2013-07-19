package tool.dbagent

/**
 *
 *
 */
class QueryGenerator {

    /**
     * resources以下のSQLファイルを参照してクエリを返却する
     *
     * @author wada.shunsuke
     *
     * @param path
     * @return query
     *
     */
    def getQuery(String path)  {
        InputStream inputStream = getClass().getResourceAsStream(path)
        BufferedReader reader =
            new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

        StringBuffer buf = new StringBuffer()

        def contents
        while ((contents = reader.readLine()) != null) {
            buf.append(contents)
            buf.append("\n")
        }

        return buf.toString()
    }

}
