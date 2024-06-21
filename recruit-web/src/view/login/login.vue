<script setup>
import { ref } from 'vue'
import {userLoginService} from '@/api/user.js'
const form = ref({
    username: '',
    password: ''
})

//校验
const rules = ref({
    username: [
        { required: true, message: '请输入用户名', trigger: 'blur' },
        { min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur' }
    ],
    password: [
        { required: true, message: '请输入密码', trigger: 'blur' },
        { min: 6, max: 18, message: '长度在 6 到 18 个字符', trigger: 'blur' }
]
})
//登陆
import { useTokenStore } from '../../store/tokenStore';
import { useRouter } from 'vue-router';
import { useUserStore } from '../../store/UserStore';
const router = useRouter();
const tokenStore = useTokenStore();
const userStore = useUserStore();
const login =async ()=>{
    //调用接口,完成登录
   let result =  await userLoginService(form.value);
   ElMessage.success(result.msg ? result.msg : '登录成功')
   //把得到的token存储到pinia中
   tokenStore.setToken(result.data.token)
   userStore.setRole(result.data.role)
   //跳转到首页 路由完成跳转
   router.push('/')
}
//注册
const changepage = () => {
    router.push('/register')
}
</script>


<template>
    <div class="container">
        <div style="display: flex;justify-content: center;align-items: center;font-size: 30px;font-weight: bold;margin-bottom: 20px">登录</div>
<el-form :model="form" label-width="auto" style="max-width: 600px" :rules="rules">
    <el-form-item label="用户名" prop="username">
        <el-input v-model="form.username"></el-input>
    </el-form-item>
    <el-form-item label="密码" prop="password">
        <el-input v-model="form.password"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="login">登陆</el-button>
      <el-button @click="changepage">注册</el-button>
    </el-form-item>
  </el-form>
</div>
</template>

<style scoped>
.container{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background-color: #f5f5f5;
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
}
</style>
