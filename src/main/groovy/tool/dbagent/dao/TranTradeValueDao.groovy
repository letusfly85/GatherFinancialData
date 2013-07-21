package tool.dbagent.dao

import tool.dbagent.MySQLAccessor
import tool.dbagent.bean.GeneralBean
import tool.dbagent.bean.TranTradeValueBean

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.SQLException

class TranTradeValueDao extends GeneralDao<GeneralBean> {

    /**
     *
     *
     * @param T
     */
    @Override
    void delete(T) {
        MySQLAccessor db = new MySQLAccessor()
        Connection conn = db.getConnect()

        def deleteQuery = getQuery("/sql/delete_tran_trade_value_by_year.sql")
        PreparedStatement stmt = conn.prepareStatement(deleteQuery)

        try {
            def bean = (TranTradeValueBean)T
            stmt = conn.prepareStatement(deleteQuery)
            stmt.setString(1, bean.year)
            stmt.execute()

        }  catch (SQLException e) {
            e.printStackTrace()

        } finally {
            stmt.close()
            conn.close()
        }

    }


    /**
     * 貿易額登録
     *
     *
     * @param list
     */
    @Override
    void insert(List<? extends GeneralBean> list) {
        MySQLAccessor db = new MySQLAccessor()
        Connection conn = db.getConnect()

        def insertQuery = getQuery("/sql/insert_tran_trade_value.sql")
        PreparedStatement stmt = conn.prepareStatement(insertQuery)

        try {
            stmt = conn.prepareStatement(insertQuery)
            list.each {TranTradeValueBean bean ->
                stmt.setString(1, bean.impExpKbn)
                stmt.setString(2, bean.year)
                stmt.setString(3, bean.hs)
                stmt.setString(4, bean.country)
                stmt.setString(5, bean.unit1)
                stmt.setString(6, bean.unit2)
                stmt.setString(7, bean.quantity1Year)
                stmt.setString(8, bean.quantity2Year)
                stmt.setString(9, bean.valueYear)
                /*
stmt.setString(10, bean.quantity1Jan)
stmt.setString(11, bean.quantity2Jan)
stmt.setString(12, bean.valueJan)
stmt.setString(13, bean.quantity1Feb)
stmt.setString(14, bean.quantity2Feb)
stmt.setString(15, bean.valueFeb)
stmt.setString(16, bean.quantity1Mar)
stmt.setString(17, bean.quantity2Mar)
stmt.setString(18, bean.valueMar)
stmt.setString(19, bean.quantity1Apl)
stmt.setString(20, bean.quantity2Apl)
stmt.setString(21, bean.valueApl)
stmt.setString(22, bean.quantity1May)
stmt.setString(23, bean.quantity2May)
stmt.setString(24, bean.valueMay)
stmt.setString(25, bean.quantity1Jun)
stmt.setString(26, bean.quantity2Jun)
stmt.setString(27, bean.valueJun)
stmt.setString(28, bean.quantity1Jul)
stmt.setString(29, bean.quantity2Jul)
stmt.setString(30, bean.valueJul)
stmt.setString(31, bean.quantity1Aug)
stmt.setString(32, bean.quantity2Aug)
stmt.setString(33, bean.valueAug)
stmt.setString(34, bean.quantity1Sep)
stmt.setString(35, bean.quantity2Sep)
stmt.setString(36, bean.valueSep)
stmt.setString(37, bean.quantity1Oct)
stmt.setString(38, bean.quantity2Oct)
stmt.setString(39, bean.valueOct)
stmt.setString(40, bean.quantity1Nov)
stmt.setString(41, bean.quantity2Nov)
stmt.setString(42, bean.valueNov)
stmt.setString(43, bean.quantity1Dec)
stmt.setString(44, bean.quantity2Dec)
stmt.setString(45, bean.valueDec)
*/

                stmt.addBatch()
            }

            stmt.executeBatch()
            //conn.commit()

        } catch (SQLException e) {
            e.printStackTrace()

        } finally {
            stmt.close()
            conn.close()
        }
    }
}
