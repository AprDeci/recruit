import request from "@/utils/request.js";

export const getJobrecordList = ()=>{
    return request({
        url:'/record/list',
        method:'get'
    })
}
export const addjobSerice = (data)=>{
    const params = new URLSearchParams();
    for(let key in data){
        params.append(key,data[key])
    }
    return request.post('/jobPosting/add',params)
}
export const getjobListPageService= (size,page,eid)=>{
    return request.get('/jobPosting/listpage',{params:{size,page,eid}})
}
export const deletejobByidService = (id)=>{
    return request.post('/jobPosting/delete/'+id)
}
export const getjobListByRandomService = (limit)=>{
    return request.get('/jobPosting/getrand/'+limit)
}