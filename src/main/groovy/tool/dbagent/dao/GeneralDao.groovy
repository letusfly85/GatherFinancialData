package tool.dbagent.dao

import tool.dbagent.QueryGenerator
import tool.dbagent.bean.GeneralBean

abstract class GeneralDao extends QueryGenerator, GeneralBean  {

    abstract void insert(list)

}
