<script setup>
import { onMounted, ref } from 'vue'
import {getJobrecordList} from '@/api/job.js'

onMounted(()=>{
  getJobrecordList().then(res=>{
    if(res.code!==200){
       ElMessage.error(res.msg)
    }
    recordList.value = res.data
    recordList.value.forEach(item=>{
      item.maxsalary = item.minsalary+'-'+item.maxsalary
    })
    loading.value = false
  })
})
const recordList = ref([])
const loading = ref(true)

const tableRowClassName = ({row,rowIndex}) => {
  if (row.status === "ture") {
    return 'success-row';
  } else if (row.status === 'false') {
    return 'warning-row';
  }
  return '';
};

</script>

<template>
<el-table
    v-loading="loading"
    :data="recordList"
    style="width: 100%"
    :row-class-name="tableRowClassName" 
    :header-cell-style="{ background: '#eef1f6', color: '#606266' }"
  >
    <el-table-column prop="job_title" label="职位" width="180" />
    <el-table-column prop="employee_fullname" label="申请人姓名" width="180" />
    <el-table-column prop="employer_name" label="HR姓名" width="180" />
    <el-table-column prop="company_name" label="公司姓名" width="180" />
    <el-table-column prop="maxsalary" label="薪水" width="180" />
  </el-table>
</template>

<style scoped>
.el-table .warning-row {
  --el-table-tr-bg-color: var(--el-color-warning-light-9);
}

.el-table-column:deep(.success-row) {
  --el-table-tr-bg-color: #e3ffe0;
}
</style>