import request from "@/utils/request.js";
//登陆
export const userLoginService = (loginData)=>{
    const params = new URLSearchParams();
    for(let key in loginData){
        params.append(key,loginData[key])
    }
    return request.post('/user/login',params)
}

export const userregisterService = async (registerData)=>{
    const params = new URLSearchParams();
    for(let key in registerData){
        params.append(key,registerData[key])
    }
    return request.post('/user/register',params)
}

export const userInfoService = ()=>{
    return request.get('/user/info')
}

export const EmplyeeDtoInfoService = ()=>{
    return request.get('/user/info2')
}

export const EmployeeinfoUpdateService = (employeeinfo)=>{
    return request.put('/user/update/employee',employeeinfo)
    }

export const EmployerinfoUpdateService = (employerinfo)=>{
    return request.put('/user/update/employer',employerinfo)
}