<script setup>
import { onMounted, ref, watch} from 'vue';
import hhead from '@/components/home/header.vue'
import foooter from '@/components/footer.vue'
import {CompanyinfoByidService} from '@/api/company'
import {useRoute} from 'vue-router'
const props=defineProps({
  id:String
})
const companyinfo=ref({})

onMounted(()=>{
  CompanyinfoByidService(props.id).then((res) => {
    companyinfo.value = res.data
  })
})
</script>


<template>
    <div class="outer">
    <hhead></hhead>
    <div class="topinfo">
        <div style="display: flex; justify-content: space-around;">
        <div>
            <img class="touxiang" style="width: 80px; border-radius: 12px; margin-right: 10px;" src="@/imgs/company_default_ava.jpg" alt="">
            <span style="font-size: 32px; font-weight: bold; color: white">{{companyinfo.name}}</span>
        </div>
        <div style="position: relative; top: 30px;">
            <span style="font-size: 36px; font-weight: bold;margin-right: 8px; color: white;">1000</span><span style="color: white;">在招职位</span>
            <span style="font-size: 36px; font-weight: bold;margin-right: 8px; color: white;">10</span><span style="color: white;">位BOSS</span>
        </div>
    </div>
    </div>

    <div class="main">
        <div class="inner">
    <div class="linkmeanu" style="margin-top: 10px;">
            <div class="linkemeanu_container" style="display: flex;">
                <router-link :to="'/company/info/'+id">公司简介</router-link>
                <router-link :to="'/company/jobs/'+id">招聘职位</router-link>
            </div>
    </div>
    <div>
        <router-view></router-view>
    </div>
</div>
    </div>
    <foooter></foooter>
</div>
</template>

<style scoped>
*{
    box-sizing: border-box;
}
.el-card{
    border-radius: 15px;
}
.outer{
    background-color: #f0f0f0;
}
.topinfo{
    width: 100%;
    height: 170px;
    background-color:#885b85 ;
}
.touxiang{
    position: relative;
    top: 20px;
}
.main{
    width: 100%;
    background-color: #f0f0f0;
    display: flex;
    justify-content: center;
}
.inner{
    width: 1200px;
    max-width: 1200px;
}
.linkemeanu_container{
    gap:30px;
    height: 50px;
    padding: 0px 30px;
    width: 100%;
    display: flex;
    align-items: center;
    border-radius: 10px;
    background-color: white;
    /* 添加阴影 */
    box-shadow: 0 0 10px rgb(0, 0, 0, 0.1);
}
.linkmenu el-card:deep(.el-card__body){
    padding: 0;
}
</style>