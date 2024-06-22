<script setup>
import { useRouter } from 'vue-router';
const props= defineProps({
    company: {
        type: Object,
        required: true
    }
})
const router = useRouter()
console.log(props.company)

const gotopage=(id)=>{
    router.push('/company/jobs/'+id+'/type/')
}
// 随机查询一个公司和与他相关联的工作
</script>

<template>
    <el-card>
        <template #header>
            <div>{{ company.company.name }}</div>
        </template>
        <div class="com-positions" v-for="job in company.jobs">
            <div class="simple-job-info">
                <div class="nameandsalary">
                <span class="name">{{ job.title }}</span>
                <span class="salary">{{ job.minSalary }}</span>
            </div>
            <el-tag  color="#fff" size="small">郑州金水区FFF区</el-tag>
            <el-tag color="#fff" size="small">经验不限</el-tag>
            <el-tag color="#fff" size="small">本科</el-tag>
            </div>
        </div>
        <div class="btcon"><el-button plain type="primary" color="#626aef" style="padding: 0 40px;" @click="gotopage(company.company.id)">更多职位</el-button> </div>
    </el-card> 
</template>



<style scoped>
.simple-job-info{
    padding: 5px;
    width: 100%;
    margin-bottom: 10px;
}
.simple-job-info:hover{
    cursor: pointer;
}
.simple-job-info:hover .name{
    transition: cubic-bezier(0.075, 0.82, 0.165, 1) 0.3s;
    color: #626aef;
}
/* 选择最后一个simple-job-info */
.positions:last-child{
    margin-bottom: 0;
}
.nameandsalary{
    margin-bottom: 10px;
    display: flex;
    justify-content: space-between;
}
.name{
    font-weight: 600;

}
.salary{
    color: #ff6700; 
    font-size: large;
}
.com-positions{
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    height: 100px;
}
.el-tag{
    margin-right: 10px;
    padding: 0;
}
.el-tag:deep .el-tag__content{
    font-size: 14px;
}
.btcon{
    display: flex;
    justify-content: center;
}
</style>