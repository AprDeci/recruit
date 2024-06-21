package top.aprdec.recruitweb.util;

import top.aprdec.recruitweb.DTO.JobCompanyDTO;

import java.util.List;

public  class DTOUtil {
    public static void JobCompanyDTOinitst(JobCompanyDTO jobCompanyDTO) {
        jobCompanyDTO.initst();
    }
    public static void JobCompanyDTOinitst(List<JobCompanyDTO> list) {
        for (JobCompanyDTO jobCompanyDTO:list) {
            jobCompanyDTO.initst();
        }
    }

}
