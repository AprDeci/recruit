import request from '@/utils/request'

//查询对应公司
export function CompanyinfoService() {
    return request.get('/company/info')
}