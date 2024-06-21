<script setup>
import { Position } from '@element-plus/icons-vue';
import { onMounted, ref } from 'vue';
import { useUserStore } from '@/store/UserStore';
import {EmplyeeDtoInfoService,EmployeeinfoUpdateService} from '@/api/user'
const large = ref('large')
const userStore = useUserStore()
const userinfo = userStore.info



onMounted(() => {
   // const userStore = useUserStore()
   EmplyeeDtoInfoService().then(res => {
        userStore.setInfo(res.data)
    })
})

const onSubmit=()=>{
    EmployeeinfoUpdateService(userinfo).then(res => {
        if(res.code===200){
            ElMessage.success('修改成功')
        }
        else{
            ElMessage.error(res.msg)
        }
    })
}

const onCancel=()=>{
    EmplyeeDtoInfoService().then(res => {
        userStore.setInfo(res.data)
    })
}

</script>



<template>
<div class="inside">
<div>个人信息编辑</div>
<div class="infoform">

    <el-form :model="userinfo" :size="large" style="width: 50%;" :label-position= 'left' >
        <el-form-item label="uid">
            <span>{{ userinfo.userId }}</span>
        </el-form-item> 
        <el-form-item label="用户名">
            <el-input v-model=userinfo.username></el-input>
        </el-form-item>
        <el-form-item label="姓名">
            <el-input v-model="userinfo.fullname"></el-input>
        </el-form-item>
        <el-form-item label="邮箱">
            <el-input v-model="userinfo.email"></el-input>
        </el-form-item>
        <el-form-item  label="电话">
            <el-input v-model="userinfo.phone"></el-input>
        </el-form-item>
        <el-form-item label="性别">
            <el-select v-model="userinfo.gender" placeholder="选择性别">
                <el-option label="男" value="男"></el-option>
                <el-option label="女" value="女"></el-option>
                <el-option label="坦克" value="坦克"></el-option>
                <el-option label="飞机" value="飞机"></el-option>
                <el-option label="大炮" value="大炮"></el-option>
                <el-option label="半男半女" value="半男半女"></el-option>
                <el-option label="外星人" value="外星人"></el-option>
                <el-option label="第三性别" value="第三性别"></el-option>
                <el-option label="保密" value="保密"></el-option>
                <el-option label="其他" value="其他"></el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="简历">
            <el-input v-model="userinfo.resumeUrl"></el-input>
        </el-form-item>
        <el-form-item label="技能">
            <el-input v-model="userinfo.skills"></el-input>
        </el-form-item>
        <el-form-item></el-form-item>
        <el-form-item>
            <el-button type="primary" @click="onSubmit" :size="large">保存</el-button>
            <el-button>取消</el-button>
        </el-form-item>
    </el-form> 
</div> 
</div>
</template>

<style scoped>
.inside{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 100%;
    height: 100%;
}
.infoform{
    width: 80%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}
.el-form-item :deep(.el-form-item__label){
    font-size: large;
    font-weight: bold;
}
.el-form-item :deep(.el-form-item__content){
    font-size: large;
    font-weight: bold;
}
.el-form-item :deep(.el-input__inner){
    font-size: large;
    font-weight: bold;
}
.el-form-item :deep(.el-select__input){
    font-size: large;
    font-weight: bold;
}
</style>