<script setup>
import { ref,onMounted } from 'vue';
import Addresspicker from '../../../components/background/addresspicker.vue';
import json from '@/assets/dist.json'
import { useUserStore } from '../../../store/UserStore';
import {addjobSerice,getjobListPageService,deletejobByidService} from '@/api/job'

const loading = ref(true)
const userStore = useUserStore();
const dialogFormVisible = ref(false)
const address1=ref('')
const address2=ref('')
const JobList=ref([]);
const newJobinfo=ref({
    employerId:'',
    companyId:'',
    title:'',
    description:'',
    requirements:'',
    location:'',
    postingDate:'',
    maxSalary:'',
    minSalary:'',
})
const addressget=()=>{
    newJobinfo.value.location=address1.value+address2.value
    console.log(newJobinfo.value.address)
}
const addnewjob=()=>{
    newJobinfo.value.companyId=userStore.info.companyId
    newJobinfo.value.employerId=userStore.info.id
    addjobSerice(newJobinfo.value).then(res=>{
        if(res.code===200){
            ElMessage.success('添加成功')
            dialogFormVisible.value=false
            newJobinfo.value=''
        }else{
            ElMessage.error(res.msg)
        }
    })
}

let size=ref(10)
let total = ref()
let page = ref(1)
const eid = userStore.info.id
onMounted(()=>{
    getjobListPageService(size.value,page.value,eid).then(res=>{
        if(res.code===200){
            JobList.value=res.data.data
            total = res.data.total
            loading.value=false
        }else{
            ElMessage.error(res.msg)
        }
    })
})

const paginationchange=(currentPage,pageSize)=>{
    console.log(currentPage,pageSize)
    getjobListPageService(pageSize,currentPage,eid).then(res=>{
        if(res.code===200){
            JobList.value=res.data.data
            total = res.data.total
        }else{
            ElMessage.error(res.msg)
        }
    })
}

const deletettt = (id)=>{
    deletejobByidService(id).then(res=>{
        if(res.code===200){
            ElMessage.success('删除成功')
           location.reload()
        }else{
            ElMessage.error(res.msg)
        }
    })
}
</script>

<template>
    <div style="margin-bottom: 20px">
    <el-button type="primary" @click="dialogFormVisible = true">添加职位</el-button>
</div>

  <el-table :data="JobList" border="true" style="width: 100%" v-loading="loading">
    <el-table-column prop="title" label="职位名称" width="180" />
    <el-table-column show-overflow-tooltip prop="description" label="职位描述" width="180" />
    <el-table-column prop="requirements" label="职位要求" />
    <el-table-column prop="location" label="工作地点" />
    <el-table-column prop="postingDate" label="截止日期" />
    <el-table-column prop="maxSalary" label="最大薪水" />
    <el-table-column prop="minSalary" label="最小薪水" />
    <el-table-column prop="address" label="操作" >
        <template #default="scope">
            <div style="display:flex;justify-content:space-around;">
            <el-button type="primary" @click="deletettt(scope.row.id)">编辑</el-button>
            <el-button type="danger" @click="deletettt(scope.row.id)">删除</el-button>
        </div>
        </template>
    </el-table-column>
  </el-table>
  <div style="display: flex; justify-content: center; align-self: center;">
  <el-pagination background layout="prev, pager, next" v-model="size" :total=total @change="paginationchange" style="margin-top: 20px;"/>
</div>








<el-dialog v-model="dialogFormVisible">
    <template #header>
        <div>添加职位</div>
    </template>
    <div style="padding: 0 50px;">
    <el-form v-model="newJobinfo" label-position="top" size="large">
        
        <el-form-item label="职位名称" prop="title">
        <el-input v-model="newJobinfo.title" placeholder="请输入职位名称"></el-input>
        </el-form-item>
        <el-form-item label="职位描述" prop="description">
        <el-input v-model="newJobinfo.description" placeholder="请输入职位描述"></el-input>
        </el-form-item>
        <el-form-item label="职位要求" prop="requirements">
        <el-input v-model="newJobinfo.requirements" placeholder="请输入职位要求"></el-input>
        </el-form-item>
        <el-row :gutter="20">
            <el-col :span="10">
                <el-form-item label="工作地点" prop="location">
            <el-cascader @change="addressget" v-model="address1"  filterable :options="json" :props="{checkStrictly: true,value:'name',label:'name',children:'children'}" />
        </el-form-item>
            </el-col>
            <el-col :span="14">
                
        <el-form-item label="详细地点" @change="addressget">
            <el-input v-model="address2"></el-input>
        </el-form-item>
            </el-col>
        </el-row>

        <el-form-item label="截止日期" prop="postingDate">
            <el-date-picker formant="YYYY/MM/DD" value-format="YYYY-MM-DD" v-model="newJobinfo.postingDate" type="date" placeholder="Pick a day"/>
        </el-form-item>
        <el-row :gutter="20">
            <el-col :span="8">
                <el-form-item label="最大薪水" prop="maxSalary">
                <el-input v-model="newJobinfo.maxSalary" placeholder="请输入最大薪水"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="8">
                <el-form-item label="最小薪水" prop="minSalary">
                <el-input v-model="newJobinfo.minSalary" placeholder="请输入最小薪水"></el-input>
                </el-form-item>
            </el-col>
        </el-row>

        <el-form-item>
            <el-button @click="addnewjob" type="primary">提交</el-button>
            <el-button @click="dialogFormVisible = false" type="warn">关闭</el-button>
        </el-form-item>
    </el-form>
</div>
</el-dialog>


</template>

<style scoped>
</style>