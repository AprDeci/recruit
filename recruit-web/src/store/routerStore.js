import { defineStore } from "pinia";
import {ref} from "vue";


export const useRouterStore = defineStore("routerStore", () => {
    const routerList = ref([])

    const setrouterList = (data) => {
        routerList.value = data
    }

    const removerouterList = (data) => {
        routerList.value = []
    }
    function $reset() {
        routerList.value = []
      }
    

    return {routerList,setrouterList,removerouterList,$reset}
},{
    persist: true //开启持久化
})