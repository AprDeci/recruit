//package top.aprdec.recruitweb.mbp;
//
//import com.baomidou.mybatisplus.core.injector.AbstractMethod;
//import com.baomidou.mybatisplus.core.metadata.TableInfo;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.ibatis.executor.keygen.NoKeyGenerator;
//import org.apache.ibatis.mapping.MappedStatement;
//import org.apache.ibatis.mapping.SqlSource;
//
//public class MysqlInsertAllBatch extends AbstractMethod {
//    protected MysqlInsertAllBatch(String methodName) {
//        super(methodName);
//    }
//
//    @Override
//    public MappedStatement SELECTBYRAND(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
//
////SELECT * FROM jobposting ORDER BY RAND() LIMIT 9;
//        String sql = "SELECT * FROM"+tableInfo.getTableName()+"ORDER BY RAND() LIMIT"+1;
//
//        SqlSource sqlSource= languageDriver.createSqlSource();
//        // 第三个参数必须和baseMapper的自定义方法名一致
//        return this.addInsertMappedStatement(mapperClass, modelClass, "mysqlInsertAllBatch", sqlSource, new NoKeyGenerator(), null, null);
//    }
//
//
//}