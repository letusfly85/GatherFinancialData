package tool.financial.crowl

/**
 * 正規表現を利用して取得したCSV格納先の相対パスを絶対パスに変換する
 *
 */
class ConvertRelativeCSVURL2Absolute {

    /**
     *
     *
     * @param list
     */
    def convertRelativeCSVURL2Absolute(list) {

        def headURL = "http://www.customs.go.jp/toukei/download/2008/"

        //TODO 「年」を動的に変更出来るように相対パス取得プログラムを修正

        def absCUList = []
        list.each {String reCU ->
            def url = headURL + reCU.replace("../", "")
            absCUList.add(url)
        }

        absCUList
    }

}
