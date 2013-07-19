package tool.financial.crowl

import tool.dbagent.dao.TranTradeValueDao
import tool.property.PropertyUtils

PropertyUtils utils = new PropertyUtils()
Properties properties = utils.getProperties()

println(properties.getProperty("DB_HOST"))
