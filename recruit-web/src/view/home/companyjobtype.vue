<script setup>
import { onMounted,ref } from 'vue';
import jobcard from'@/components/home/zujian/jobcard.vue'
import {getinfoBypageByjobcompanyid,getjobinfobyidService} from '@/api/job'
import { CompanyListService } from '../../api/company';
import { useWindowScroll } from '@vueuse/core'
import card from '@/components/home/zujian/card.vue'
import { BMap } from 'vue3-baidu-map-gl'
import { useRouter } from 'vue-router';
const { x, y } = useWindowScroll()
const props = defineProps({
type:{
    type:String,
    required:false
  },
id:String
})
const router=useRouter()
const loading=ref(true)
const activename=ref('company')
const currentjobinfo=ref({})
const page = ref(1)
const scrollMenuRef = ref(null)
const joblist = ref([])
const total = ref(0)
const companyList=ref([])

// // 查询
// onMounted(()=>{
//     window.addEventListener("scroll", scrollContent);
// })
// // 页面滚动时触发
// const scrollContent=()=> {
//     if (y>400){
//     let scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
//     // 页面滚动条滚动时，el-scrollbar内滚动条按比例跟随一起滚动
//     scrollMenuRef.value.wrapRef.scrollTop = scrollTop / document.body.scrollHeight * scrollMenuRef.value.wrapRef.scrollHeight
//     }
//   console.log(scrollMenuRef.value.wrapRef)

// }

onMounted(()=>{
    getinfoBypageByjobcompanyid(props.id,10,1,props.type).then(res=>{
        joblist.value = res.data.data;
        total.value = res.data.total;
        getjobinfo(joblist.value[0].id)
    })
    CompanyListService(10).then(res=>{
        companyList.value=res.data
    })
    
})
const changepage=(currentPage,pageSize)=>{

    console.log(currentPage,pageSize)
    getinfoBypageByjobcompanyid(props.id,pageSize,currentPage).then(res=>{
        if(res.code===200){
            joblist.value=res.data.data
            total = res.data.total

        }else{
            ElMessage.error(res.msg)
        }
    })
}
const getjobinfo=(id)=>{
    loading.value=true
    getjobinfobyidService(id).then(res=>{
        if(res.code===200){
            currentjobinfo.value=res.data
            loading.value=false
        }else{
            ElMessage.error(res.msg)
        }
    })
}
</script>

<template>
    <div class="jobselect_container">
        <el-scrollbar height="860px" class="jobselector" ref="scrollMenuRef">
        <jobcard class="jobcard" v-for="(item,index) in joblist" :key="index" :job="item" @click="getjobinfo(item.id)"></jobcard>
        <el-pagination
            size="small"
            background
            layout="prev, pager, next"
            :total="total"
            v-model="page"
            @change="changepage"
        />
        </el-scrollbar>
        <card class="infocard" style="height: 860px; padding: 20px 30px;"> 
            <el-skeleton :loading="loading" :throttle="500"  style="width: 100%; height: 860px;"animated :rows="20">
                <template #template>
                    <el-skeleton-item variant="h3" style="width: 30%;margin-bottom: 10px;" />
                    <el-skeleton-item v-for="i in 10" variant="text" style="margin-right: 16px;height: 20px;margin-bottom: 10px;"  />
                    <el-skeleton-item variant="h3" style="width: 30%" />
                    <el-skeleton-item v-for="i in 6" variant="text" style="margin-right: 16px;height: 20px;margin-bottom: 10px;"  />
                    <el-skeleton-item variant="image" style="width: 100%;height: 200px;" />
                </template>
                <template #default>
            <div class="infohead">
                <div style="display: flex; justify-content: space-between; margin-bottom: 10px; ">
                    <div>
                    <span style="font-size: 22px; font-weight: bold;margin-right: 16px;">{{ currentjobinfo.title }}</span>
                    <span style="color:var(--salary-color) ; font-size: 20px;font-weight: bold;">{{ currentjobinfo.maxSalary }}</span>
                    </div>
                    <div >
                        <el-button plain style="padding: 10px 30px;"><i class="iconfont">&#xe600;</i>感兴趣</el-button>
                        <el-button color="#945befb7" plain>立即沟通</el-button>
                    </div>
                </div>
                <div class="smallinfo">
                    <i style="color:var(--pink);font-size: 16px;" class="iconfont">&#xe6db;</i><span>{{ currentjobinfo.location }}</span>
                </div>
            </div>
            <hr style="opacity: 0.2; margin: 10px 0;">
            <el-scrollbar height="740px">
            <div class="describtion">
                <div style="font-size: 18px; font-weight: bold; margin-bottom: 10px;">职位描述</div>
                <div>
                    {{ currentjobinfo.description }}
                </div>
                    <hr style="opacity: 0.2; margin: 10px 0;">
                    <div  style="font-size: 18px; font-weight: bold; margin-bottom: 10px;">
                        工作地址
                    </div>
                    <div>
                            <BMap
                            ak="TqYwwFNTRV7P6mDcejCVaftVKxJRp1Ua"
                            mapStyleId="ee66c61531e8df3c2fd0374e96e58e81"
                            :center="currentjobinfo.location"
                            :zoom="19"
                            tilt="75"
                            height="200px"
                            />
                        </div>
                </div>
                <div style="display: flex; justify-content: center; margin:20px 20px;">
                    <el-button @click="router.push('/job_detail/' + currentjobinfo.id)" plain >查看详情</el-button>
                </div>
            </el-scrollbar>
        </template>
        </el-skeleton>
        </card>
</div>
<div>
    <card class="company_receommend" style="height: 200px; padding: 20px 30px;">
        <!-- <div style="font-size: 18px; font-weight: bold; margin-bottom: 10px;">推荐公司</div>
        <div>
            <span v-for="item in companyList">{{ item.name }}</span>
        </div> -->
    <el-tabs v-model="activename" @tab-click="handleClick" style="height: 100%; width: 100%;">
    <el-tab-pane label="推荐公司" name="company">
        <div style="display: flex; height: 100%; width: 100%;flex-wrap: wrap; ">
            <span class="comname" style="width: 240px; font-size: 14px; margin-right: 10px;margin-bottom: 10px;color: gray;" v-for="item in companyList">{{ item.name }}</span>
        </div> 
    </el-tab-pane>
  </el-tabs>
    </card>
</div>
<div>
</div>
</template>

<style scoped>
*{
    box-sizing: border-box;
}
.jobselect_container{
    width:1200px;
    margin: 15px 0;
    display: flex;
    justify-content: space-between;
    

}
.jobselector{
    flex: 1;
    margin-right: 20px;
}
.jobcard{
    margin-bottom: 10px;

}
.infocard{
    margin: 0;
    flex:2;
}
.smallinfo span{
    font-size: 14px;
}
.describtion *{
    line-height: 28px;
    color: #333;
    font-size: 14px;
    text-align: justify;
    letter-spacing: 0;
    white-space: pre-wrap;
    word-break: break-all;
}
.bmap-container{
    height: 200px;
}
.BMap :deep(.anchorBL){
    display: none;
}
.comname:hover{
    color: var(--ppcolor);
}
.comname{
    cursor: pointer;
}
</style>