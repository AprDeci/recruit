<script setup>
import {ref} from 'vue'
import {useRouter,useRoute} from 'vue-router'
import { useRouterStore } from '../../store/routerStore';
const routerStore = useRouterStore()

const routes = routerStore.routerList

const indexroute = (route)=>{
    return "/background/"+route.path
}
</script>

<template>
<el-menu
    class="back-vertical-menu"
    default-active="indexroute(routes[0])"
    @open="handleOpen"
    @close="handleClose"
    router>
    <el-menu-item v-for="route in routes" :key="route.path" :index="indexroute(route)" style="display: flex;justify-content: center;">
        <component  :is="route.meta.icon"> </component>
        <span>{{route.meta.title}}</span>

    </el-menu-item>
    </el-menu>
</template>

<style scoped>
.el-menu-item svg{
    width: 20px;
    margin-right: 15px;
}
</style>