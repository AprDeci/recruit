//package top.aprdec.recruitweb.mbp;
//
//import com.baomidou.mybatisplus.core.injector.AbstractMethod;
//import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
//
//import java.util.List;
//
//public class MyLogicSqlInjector extends DefaultSqlInjector {
//
//    @Override
//    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
//        List<AbstractMethod> methodList = super.getMethodList(mapperClass);
//        methodList.add(new MysqlInsertAllBatch());
//        return methodList;
//    }
//}