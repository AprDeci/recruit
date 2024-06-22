<script setup>
import { ref,onMounted } from 'vue';



const props = defineProps({
    job:Object
})
const tags=ref([])
const salary=ref('')

const gettags = ()=>{
   const requirements = props.job.job_requirements;
   const requirementArray = requirements.split(',');
   tags.value = requirementArray;
const maxSalary = Math.floor(props.job.maxSalary/ 1000) ;
const minSalary = Math.floor(props.job.minSalary/ 1000) ;
const salaryRange = `${maxSalary}K-${minSalary}K`;
salary.value = salaryRange;
}

onMounted(()=>{
    gettags();
})

</script>



<template>
    <el-card shadow="hover" style="cursor: pointer;" >
        <div class="nameandsalary"><span class="name">{{ job.job_title }}</span><span class="salary">{{ salary }}</span></div>
            <el-tag color="#fff" size="small" v-for="tag in tags" :key="tag">{{tag}}</el-tag>
        <template #footer>
            <div class="foot" style="display: flex; justify-content: space-between;"><span class="footertext">{{ job.company_name }}</span>
            <span class="footertext">{{ job.job_location.slice(0, 2) }}</span>
            </div>
        </template>
    </el-card>
</template>

<style scoped>
.el-card {
    border-radius: 10px;
}

.nameandsalary{
    margin-bottom: 10px;
    display: flex;
    justify-content: space-between;
}
.name{
    font-size: 16px;
    font-weight: 600;
}
.salary{
    color: #ff6700;
}
.el-tag{
    margin-right: 10px;
    padding: 0;
}
.el-tag:deep .el-tag__content{
    font-size: 14px;
}
.el-card:deep .el-card__footer{
    background: linear-gradient(90deg,#f5fcfc 0,#fcfbfa 100%)
}
.footertext{
    font-size: 14px;
    font-weight: 600;
}
</style>