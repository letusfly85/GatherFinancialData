package tool.dbagent.dao

import tool.dbagent.MySQLAccessor

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.SQLException

class TranTradeValueDao {

    /**
     * 貿易額登録
     *
     *
     * @param list
     */
    void insertTranTradeValue(list) {

        MySQLAccessor db = new MySQLAccessor()
        Connection conn = db.getConnect()
        PreparedStatement stmt = conn.prepareStatement("SELECT SYSDATE FROM DUAL")

        try {
            stmt = conn.prepareStatement("INSERT INTO TRAN_TRADE_VALUE (IMP_EXP_KBN) VALUES (?)")

            list.each {entity ->
                stmt.setString(1, entity.impExpKbn)
                stmt.setString(2, entity.year)
                /*
                stmt.setString(3, entity.hs)
                stmt.setString(4, entity.country)
                stmt.setString(5, entity.unit1)
                stmt.setString(6, entity.unit2)
                stmt.setString(7, entity.quantity1Year)
                stmt.setString(8, entity.quantity2Year)
                stmt.setString(9, entity.valueYear)
                stmt.setString(10, entity.quantity1Jan)
                stmt.setString(11, entity.quantity2Jan)
                stmt.setString(12, entity.valueJan)
                stmt.setString(13, entity.quantity1Feb)
                stmt.setString(14, entity.quantity2Feb)
                stmt.setString(15, entity.valueFeb)
                stmt.setString(16, entity.quantity1Mar)
                stmt.setString(17, entity.quantity2Mar)
                stmt.setString(18, entity.valueMar)
                stmt.setString(19, entity.quantity1Apl)
                stmt.setString(20, entity.quantity2Apl)
                stmt.setString(21, entity.valueApl)
                stmt.setString(22, entity.quantity1May)
                stmt.setString(23, entity.quantity2May)
                stmt.setString(24, entity.valueMay)
                stmt.setString(25, entity.quantity1Jun)
                stmt.setString(26, entity.quantity2Jun)
                stmt.setString(27, entity.valueJun)
                stmt.setString(28, entity.quantity1Jul)
                stmt.setString(29, entity.quantity2Jul)
                stmt.setString(30, entity.valueJul)
                stmt.setString(31, entity.quantity1Aug)
                stmt.setString(32, entity.quantity2Aug)
                stmt.setString(33, entity.valueAug)
                stmt.setString(34, entity.quantity1Sep)
                stmt.setString(35, entity.quantity2Sep)
                stmt.setString(36, entity.valueSep)
                stmt.setString(37, entity.quantity1Oct)
                stmt.setString(38, entity.quantity2Oct)
                stmt.setString(39, entity.valueOct)
                stmt.setString(40, entity.quantity1Nov)
                stmt.setString(41, entity.quantity2Nov)
                stmt.setString(42, entity.valueNov)
                stmt.setString(43, entity.quantity1Dec)
                stmt.setString(44, entity.quantity2Dec)
                stmt.setString(45, entity.valueDec)
                */

                stmt.addBatch()
            }

            stmt.executeBatch()
            conn.commit()

        } catch (SQLException e) {
            e.printStackTrace()
            conn.rollback()

        } finally {
            stmt.close()
            conn.close()
        }
    }
}
