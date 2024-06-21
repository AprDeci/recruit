import {defineStore} from 'pinia'
import { ref } from 'vue'

export const useUserStore = defineStore('user',()=> {
    const role = ref('')

    const info = ref({})

    const setRole = (newrole) => {
        role.value = newrole
    }

    const setInfo = (newinfo) => {
        info.value = newinfo
    }
    const removerole = () => {
        role.value = ''
    }
    const removeinfo = () => {
        info.value = {}
    }
    function $reset() {
        role.value = ''
        info.value = {}
      }
    
    
    return {role,info,setRole,setInfo,removeinfo,removerole,$reset}
   

},{
    persist: true, // 开启持久化
})
