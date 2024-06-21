<script setup>
import {onMounted, ref} from 'vue'
import { userInfoService,EmployerinfoUpdateService } from '../../../api/user';
import { useUserStore } from '../../../store/UserStore';
const userStore = useUserStore()
onMounted(() => {
   // const userStore = useUserStore()
   userInfoService().then(res => {
        userStore.setInfo(res.data)
    })
})
const info = userStore.info

const updateinfo = ()=>{
    EmployerinfoUpdateService(info).then(res => {
        if(res.code === 200){
            //userStore.setInfo(info)
            ElMessage.success('修改成功')
        }else{
            ElMessage.error(res.msg)
        }
    })
}
</script>

<template>
<el-form>
    <el-form-item label="uid">{{ info.userId }}</el-form-item>
    <el-form-item label="名称">
        <el-input v-model="info.name">
        </el-input>
    </el-form-item>
    <el-form-item label="性别">
        <el-select v-model="info.gender" placeholder="请选择性别" allow-create filterable="true">
            <el-option label="男" value="男"></el-option>
            <el-option label="女" value="女"></el-option>
        </el-select>
    </el-form-item>
    <el-form-item label="手机号">
        <el-input v-model="info.telephone"></el-input>
    </el-form-item>
    <el-form-item label="邮箱">
        <el-input v-model="info.email"></el-input>
    </el-form-item>
    <el-form-item label="职位">
        <el-input v-model="info.position"></el-input>
    </el-form-item>
    <el-form-item>
        <el-button type="primary" @click="updateinfo">保存</el-button>
    </el-form-item>

</el-form>
</template>

<style scoped>

</style>