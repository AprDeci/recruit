<script setup>
import { ref,onMounted } from 'vue'
import hotcard from './zujian/hotcard.vue';
import {getjobListByRandomService} from '@/api/job'
const activeName = ref('first')

const handleClick = (tab, event) => {
    console.log(tab, event);
}
const jobList=ref([])
onMounted(()=>{
    getjobListByRandomService(9).then(res=>{
        jobList.value=res.data
    })
})
</script>
<template>
    <div>
        <el-tabs v-model="activeName" @tab-click="handleClick" >
        <el-tab-pane label="User" name="first" class="cardcontainer">
            <hotcard v-for="item in jobList" key="job.id" :job=item></hotcard>
        </el-tab-pane>
    </el-tabs>
    <div class="morebuttondiv"><el-button plain color="#626aef" size="larger" style="padding: 0 50px; height: 50px; font-weight: bold; color: #626aef;">查看更多</el-button></div>
</div>
</template>
<style scoped>
.cardcontainer{
    display: grid;
    grid-template-columns: repeat(3, 1fr);
    gap: 20px; 
}
.morebuttondiv{
    display: flex;
    justify-content: center;
    margin-top: 20px;
    color: #7e84efb5;
}


</style>