<script>
import { ref } from 'vue'
import { useUserStore } from '../../store/UserStore';
import { useRouter } from 'vue-router';
import { useRouterStore } from '../../store/routerStore';
import { useTokenStore } from '../../store/tokenStore';

const tokenStore = useTokenStore();
const userStore = useUserStore()
const routeStore = useRouterStore()
const router = useRouter()

import sidemenu from '../../components/background/sidemenu.vue';

const logout = ()=>{
  tokenStore.$reset();
  userStore.$reset();
  routeStore.$reset()
  router.push('/')
}
</script>

<template>
    <div class="common-layout">
      <el-container>
        <el-header>
            <el-menu
    :default-active="activeIndex"
    class="el-menu-demo"
    mode="horizontal"
    :ellipsis="false"
    @select="handleSelect"
    router
  >
    <el-menu-item >
      <span><img style="width: 20%;" src="@/imgs/logo.png" alt=""/></span>
    </el-menu-item>
    <div class="flex-grow" />
    <el-menu-item index="/">返回首页</el-menu-item>
    <el-menu-item @click="logout">退出登录</el-menu-item>
  </el-menu>
        </el-header>
        <el-container>
          <el-aside width="200px">
            <!-- 侧边栏菜单 -->
             <sidemenu></sidemenu>
          </el-aside>
          <el-main>
            <RouterView></RouterView>
        </el-main>
        </el-container>
      </el-container>
    </div>
  </template>
  

  <style scoped>
.flex-grow {
  flex-grow: 1;
}
  </style>