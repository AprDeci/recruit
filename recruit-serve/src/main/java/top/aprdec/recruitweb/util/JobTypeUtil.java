package top.aprdec.recruitweb.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import top.aprdec.recruitweb.pojo.JobPosting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JobTypeUtil {
    @Data
    @AllArgsConstructor
    public static class JobType{
        String id;
        String name;
        int count;
    }


    public static String getJobTypeByJobId(String id){
        switch (id){
            case "1001":
                return "互联网AI";
            case "1002":
                return "电子/电气/通信";
            case "1003":
                return "产品";
            case "1004":
                return "客服/运营";
            case "1005":
                return "销售";
            case "1006":
                return "人力/行政";
            case "1007":
                return "财物/审计";
            case "1008":
                return "生产制造";
            case "1009":
                return "零售/生活服务";
            case "1010":
                return "酒店/旅游";
            case "1011":
                return "教育培训";
            case "1012":
                return "医疗健康";
            case "1013":
                return "物流/存储/司机";
        }
        return null;
    }


    public static String getJobIdByJobType(String type){
        switch (type){
            case "互联网AI":
                return "1001";
            case "电子/电气/通信":
                return "1002";
            case "产品":
                return "1003";
            case "客服/运营":
                return "1004";
            case "销售":
                return "1005";
            case "人力/行政":
                return "1006";
            case "财物/审计":
                return "1007";
            case "生产制造":
                return "1008";
            case "零售/生活服务":
                return "1009";
            case "酒店/旅游":
                return "1010";
            case "教育培训":
                return "1011";
            case "医疗健康":
                return "1012";
            case "物流/存储/司机":
                return "1013";
        }
        return null;
    }

    public static List<JobType> getJobTypeList(List<String> typeList, List<JobPosting> list) {
        Map<String, Integer> typeCountMap = new HashMap<>();

        list.stream()
                .map(JobPosting::getType)
                .forEach(type -> typeCountMap.merge(type, 1, Integer::sum));

        List<JobType> result = new ArrayList<>();
        for (String type : typeList) {
            JobType jobType = new JobType(getJobIdByJobType(type), type, typeCountMap.getOrDefault(type, 0));
            result.add(jobType);
        }
        return result;
    }

    public static void main(String[] args) {
        // 假设这里有你的 typeList 和 list 的初始化
        List<String> typeList = List.of("Type1", "Type2", "Type3");
        List<JobPosting> list = new ArrayList<>();
        // 填充 list 中的 JobPosting 对象

        List<JobType> jobTypeList = getJobTypeList(typeList, list);
        jobTypeList.forEach(System.out::println);
    }

}
