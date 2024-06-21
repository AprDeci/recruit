import axios from "axios"
import { useTokenStore } from "../store/tokenStore";

const instance = axios.create({
    baseURL:'/api',
    timeout: 5000,
})

// 请求拦截器
instance.interceptors.request.use(config => {
    const tokenStore = useTokenStore();
    if (tokenStore.token) {
        config.headers['Authorization'] = tokenStore.token
    }
    if (config.url.indexOf("ak") > -1) {
        config.baseURL = "";
      }
    return config
}, error => {
     Promise.reject(error)
})


import router from '@/router'
//添加响应拦截器
instance.interceptors.response.use(
    result => {
        //判断业务状态码
        if(result.data.code===200){
            return result.data;
        }
        //操作失败
        //alert(result.data.msg?result.data.msg:'服务异常')
        ElMessage.error(result.data.msg?result.data.msg:'服务异常')
        //异步操作的状态转换为失败
        return Promise.reject(result.data)
        
    },
    err => {
        //token失效
        //判断响应状态码,如果为401,则证明未登录,提示请登录,并跳转到登录页面
        if(err.response.status===401){
            ElMessage.error('请先登录')
            router.push('/login')
        }else{
            ElMessage.error('服务异常')
        }
        ElMessage.error('服务异常')
        return Promise.reject(err);//异步的状态转化成失败的状态
    }
)

export default instance