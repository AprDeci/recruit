
<script setup>
import { computed, ref } from 'vue'
import { useTokenStore } from '../../store/tokenStore';
import { useUserStore } from '../../store/UserStore';
import { useRouterStore } from '../../store/routerStore';
import { useRouter } from 'vue-router';
const tokenStore = useTokenStore();
const userStore = useUserStore()
const routeStore = useRouterStore()
const router = useRouter()

// 判断tokenStore.token是否为空
const isgoin = computed(()=>{
  return tokenStore.token === ''
//没登录则为真
})



const logout = ()=>{
  tokenStore.$reset();
  userStore.$reset();
  routeStore.$reset()
  isgoin.value = true;
  router.push('/')
}

</script>

<template>
    <el-menu
      class="el-menu-demo"
      mode="horizontal"
      :ellipsis="false"
      router
    >
    <div class="logo">
      <el-menu-item index="/">
        <img src="@/imgs/logo.png" alt="logo" width="200px" height="60px">
      </el-menu-item>
    </div>

      <div class="center">  
        <el-menu-item index="/"><span>首页</span></el-menu-item>
        <el-menu-item index="/company/jobs/1/type"><span>热门企业</span></el-menu-item>
        <el-menu-item index="/job_detail/39"><span>热门工作</span></el-menu-item>
    </div>
      <el-menu-item index="/login" v-if="isgoin"><span>登陆/注册</span></el-menu-item>
      <el-menu-item  v-else>
      <el-dropdown>
        <span class="el-dropdown-link">
          个人中心
          <el-icon class="el-icon--right">
            <arrow-down />
          </el-icon>
        </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item @click="router.push('/background')">个人中心</el-dropdown-item>
            <el-dropdown-item @click="logout">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </el-menu-item>
    </el-menu>

  </template>
  

  <style>
  .logo{
    display: flex;
    flex-grow: 0.1; /* 设置flex-grow属性为1，以占满剩余空间 */
  }
  .center {
    display: flex;
    flex-grow: 0.7; /* 设置flex-grow属性为1，以占满剩余空间 */
  }
  span{
    font-size: large;
  }

  </style>
  