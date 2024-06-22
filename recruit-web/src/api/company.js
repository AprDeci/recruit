import request from '@/utils/request'

//查询对应公司
export function CompanyinfoService() {
    return request.get('/company/info')
}
export function CompanywithJobService() {
    return request.get('/company/randomlistwithjobs')
}
// 0为所有
export function CompanyListService(num) {
    return request.get('/company/list/'+num)
}
export function CompanyinfoByidService(id) {
    return request.get('/company/info/'+id)
}
