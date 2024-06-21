import {defineStore} from 'pinia'
import {ref} from 'vue'

export const useTokenStore = defineStore('token',()=>{
    const token = ref('')
    
    //2.定义一个函数,修改token的值
    const setToken = (newToken)=>{
        token.value = newToken
    }

    //3.函数,移除token的值
    const removeToken = ()=>{
        token.value=''
    }
    function $reset() {
        token.value=''
      }
    

    return {
        token,setToken,removeToken,$reset
    }
    
},
{
    persist: true 
});