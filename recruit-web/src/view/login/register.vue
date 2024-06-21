<script setup>
import { ref } from 'vue'
import {userregisterService} from '@/api/user.js'
const form = ref({
    username: '',
    password: '',
    role: '',
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
    ],
    role: [
        { required: true, message: '请选择职责', trigger: 'change' }
    ]

})
//注册
import { useTokenStore } from '../../store/tokenStore';
import { useRouter } from 'vue-router';
const router = useRouter();


//返回登录
const changepage = () => {
    router.push('/login')
}

//注册
const register = () => {
    userregisterService(form.value).then(res => {
        if(res.code === 200){
            ElMessage.success('注册成功')
            router.push('/login')
        }
        else{
            ElMessage.error(res.msg)
            form.value.username = ''
            form.value.password = ''
            form.value.role = ''
        }
    })
}


</script>


<template>
    <div class="container">
        <div style="display: flex;justify-content: center;align-items: center;font-size: 30px;font-weight: bold;margin-bottom: 50px">注册</div>
<el-form :model="form" label-width="auto" style="max-width: 600px" :rules="rules">
    <el-form-item label="用户名" prop="username">
        <el-input v-model="form.username"></el-input>
    </el-form-item>
    <el-form-item label="密码" prop="password">
        <el-input v-model="form.password"></el-input>
    </el-form-item>
    <el-form-item label="职责" prop="role">
        <el-radio-group v-model="form.role">
            <el-radio value="employee">求职者</el-radio>
            <el-radio value="employer">HR</el-radio>
        </el-radio-group>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="register">注册</el-button>
      <el-button @click="changepage">登陆</el-button>
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
