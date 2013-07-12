package tool.financial.crowl

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.SQLException

class RegisterTranTradeValue {

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
