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
export const getJobCompanyByRandomService = (limit)=>{
    return request.get('/jobPosting/getjcDto',{params:{limit}})
}
export const getJobCompanyByIdService = (id)=>{
    return request.get('/jobPosting/getjcDto/'+id)
}
export const getJobtypesByCompanyIdService = (id)=> {
    return request.get('/jobPosting/gettypes/' + id)
}
export const getinfoBypageByjobcompanyid = (id,size,page,type)=>{
    if(type===''){
        return request.get('/jobPosting/getinfoBypageBycompanyid/'+id,{params:{size,page}})
    }else{

    return request.get('/jobPosting/getinfoBypageBycompanyidBytype/'+id,{params:{size,page,type}})
    }
    
}
export const getjobinfobyidService = (id)=>{
    return request.get('/jobPosting/getjobinfo/'+id)
}