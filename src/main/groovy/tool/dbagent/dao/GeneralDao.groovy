package tool.dbagent.dao

import tool.dbagent.QueryGenerator
import tool.dbagent.bean.GeneralBean

public abstract class GeneralDao<T extends GeneralBean> extends QueryGenerator {

    abstract void insert(List<? extends T>[] list)

}
