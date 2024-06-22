<script setup>
import { onMounted,ref ,onUnmounted,watch} from 'vue';
import headmenu from '../../components/home/header.vue';
import {getJobCompanyByIdService,getJobCompanyByRandomService} from '@/api/job'
import { BMap } from 'vue3-baidu-map-gl'
import { useWindowScroll } from '@vueuse/core'
import foot from "@/components/footer.vue"
const props = defineProps({
    id:String
})
const jobinfo=ref({})
const job_related_info=ref([])

const { x, y } = useWindowScroll()
watch(y, () => {
    if (y.value > 400) {
        cansee.value = false
    } else {
        cansee.value = true
    }
})
const cansee=ref(true)


onMounted( async()=>{
    await getJobCompanyByIdService(props.id).then(res=>{
        jobinfo.value=res.data
    })
    await getJobCompanyByRandomService(5).then(res=>{
        job_related_info.value=res.data
    })

})


import { useRouter } from 'vue-router';
const router = useRouter();

const toCompanyInfo=(id)=>{
    router.push(
       {
        path:'/job_detail/'+id,
    }
    )

}

</script>

<template>
<headmenu></headmenu>
<div class="topinfo" :class="{'topinfofixed':!cansee}" ref="box">
    <div :class="{'topmove':!cansee}">
    <div class="div1">最新</div>
    <div class="titlesalarytag">
        <div>
        <span class="jobtitle">{{jobinfo.job_title}}</span>
        <span class="salary">{{ jobinfo.salary }}</span>
    </div>
        <div>
        <el-tag style=" border:none; background:  rgba(0, 0, 0, 0.3); color: white; padding: 12px 8px;" v-for="tag in jobinfo.tags" :key="tag">{{ tag }}</el-tag>
    </div>
    </div>
    <div class="jobposition">
        <el-icon style="margin-right: 5px; vertical-align: middle;"><LocationFilled /></el-icon>
        <span>{{ jobinfo.job_location }}</span>
    </div>
    <div class="topinfobuttons">
        <el-button style="background-color: rgba(0, 0, 0, 0.3); border: var(--ppcolor) 1.5px solid; color: white; " type="primary" plain><el-icon style="margin-right: 5px;"><Star /></el-icon>感兴趣</el-button>
        <el-button type="primary">立即沟通</el-button>
    </div>
</div>
</div>
<div class="main-container">
    <div class="main inner">
        <div class="left-container">
            <el-card style="width: 100%; margin: 20px 0;">
                <div style="display: flex; justify-content: space-between;">
                    <span class="subtitle" style="font-weight: bold;">职位描述</span>
                    <div class="shareandjubao">
                        <divinline>
                        <i class='iconfont'>&#xe675;</i>
                        <span>微信扫码分享</span>
                        </divinline>
                        <divinline>
                        <i class='iconfont'>&#xe652;</i>
                        <span>举报</span>
                        </divinline>
                    </div>
                    </div>
                <div class="job-sec-text textaarea" style="width: 100%;">
                    {{ jobinfo.job_description }}
                </div>
                <div>
                    <div class="subtitle" style="font-weight: bold; margin-bottom: 20px;">薪资详情</div>
                    <div class="textaarea"> 薪资范围：{{ jobinfo.minSalary }}-{{jobinfo.maxSalary}}元/月<br/>
                        底薪：{{ jobinfo.minSalary }}元/月<br/>
                        社保类型：五险<br/>
                        提成方式：销售额提成；<br/>
                        奖金补贴：年终奖，绩效奖金，全勤奖</div>
                </div>
            </el-card>
            <el-card class="companyinfo">
                <div style="font-size: 20px; font-weight: bold;margin-bottom: 20px;">公司介绍</div>
                <div style="margin-bottom: 20px;">{{ jobinfo.company_description }}</div>
            </el-card>
                <el-card>
                <div style="font-size: 20px; font-weight: bold;margin-bottom: 10px;">公司地址</div>
                <div style="margin-bottom: 5px; font-size: 12px;"><i style="color:var(--pink);font-size: 16px;" class="iconfont">&#xe6db;</i>{{ jobinfo.company_location }}</div>
                <div>
                    <BMap
                    ak="TqYwwFNTRV7P6mDcejCVaftVKxJRp1Ua"
                    mapStyleId="ee66c61531e8df3c2fd0374e96e58e81"
                    :center="jobinfo.company_location"
                    :zoom="19"
                    style="height: 200px;"
                    />
                </div>
            </el-card>

        </div>
        <div class="right-container">
            <el-card id="companyinfo-card">
                <div style="margin-bottom: 20px;">公司基本信息</div>
                <div class="companyinfo" style="display: flex; flex-direction: column;gap: 10px; padding-left: 5px;">
                    <div>
                            <img style="width: auto; height: 50px; border-radius: 10px; vertical-align: middle;" src="@/imgs/company_default_ava.jpg">
                        {{ jobinfo.company_name }}
                    </div>
                    <div>
                        <i class='iconfont'>&#xedf8;</i>
                        <span>不需要融资</span>
                    </div>
                    <div>
                        <i class='iconfont'>&#xe838;</i>
                        {{ jobinfo.company_industry }}
                    </div>
                    <div>
                        <i class='iconfont'>&#xe7b9;</i>
                        {{ jobinfo.company_location}}
                    </div>
                    <el-button plain >查看所有职位</el-button>
                </div>
            </el-card>
            <el-card class="related-job-card">
                <div class="container">
                    <div style="margin-bottom: 20px; display: flex; justify-content: space-between;"><span>相似职位</span><span style="cursor:pointer; font-size: 15px; color: var(--ppcolor);">更多相似职位</span></div>
                    <div   v-for="job in job_related_info" :key="job.job_id" class="related-job" style="display: flex;gap: 20px;flex-direction: column; margin-bottom: 20px;">
                        <div style="display: flex;justify-content: space-between;">
                            <span style="font-size: 16px;">{{ job.job_title}}</span>
                            <span style="color: rgb(251, 105, 57); font-size: 16px;">{{ job.salary }}</span>
                        </div>
                        <div style="display: flex;justify-content: space-between;">
                            <span style="font-size: 12px;">{{ job.company_name }}</span>
                            <span style="font-size: 12px;">{{ job.job_location }}</span>
                        </div>
                        <el-button color="#945befb7" plain @click="toCompanyInfo(job.job_id)" >查看详情</el-button>
                    </div>
                </div>
            </el-card>
            <el-card style="padding: 0;" class="ad-card">
                <img width="100%" src="@/imgs/adp1.png" alt="">
            </el-card>
        </div>
    </div>
</div>
 <foot></foot>
</template>

<style scoped>
*{
    box-sizing: border-box;
}
.el-card{
    margin-top: 20px;
    border-radius: 10px;
}
.topinfo{
    Box-sizing: border-box;
    width: 100%;
    background: #885b85;
    height: 235px;
    padding: 20px 70px;
    color: white;


}

.topinfofixed{
    position: fixed;
    top: 0;
    height: 190px;
    z-index: 2;
}

.topmove{
    position: relative;
    bottom: 40px;
}
.titlesalarytag{
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-top: 20px;
    margin-bottom: 20px;
}
.jobtitle{
    font-size: 36px;
    font-weight: bold;

}
.salary{
    font-size: 24px;
    font-weight: 600;
    margin-left: 30px;
    color: rgb(251, 105, 57);
}
.el-tag{
    margin-left: 10px;
}
.el-tag:deep(.el-tag__content){
    font-size: 14px;
  
    font-weight: 500;
}
.jobposition {
    margin-bottom: 20px;
}
.jobposition span{
    font-size: 16px;
}
.topinfobuttons .el-button{
    padding: 22px 40px;
    font-size: 24px;
    border-radius: 10px;
}
.main-container{
    width: 100%;
    display: flex;
    justify-content: center;
}
.main{
    width: 1200px;
    max-width: 1200px;
    display: flex;
    justify-content: space-between;
    gap: 15px;
}
.left-container{
    flex-grow: 2;
    max-width: 900px;
    width: 900px;

}
.right-container{
    flex-grow: 1;
    max-width: 300px;
    width: 300px;

}
.shareandjubao divinline{
    margin-left: 10px;
    cursor: pointer;
    
}
.shareandjubao divinline:hover span,
.shareandjubao divinline:hover i{
    color: var(--ppcolor);
}
.shareandjubao span{
    font-size: 14px;
}
.job-sec-text,
.textaarea{
    width: 500px;
    white-space: pre-wrap;
    word-break: break-all;
    margin-top: 20px;
    margin-bottom: 20px;
    line-height: 28px;
    color: #333;
    font-size: 15px;
    text-align: justify;
    letter-spacing: 0;
}
.companyinfo *{
    line-height: 20px;
    color: #333;
    font-size: 14px;
    text-align: justify;
    letter-spacing: 0;
    white-space: pre-wrap;
    word-break: break-all;
}
.subtitle{
    font-size: 20px;
}
.companyinfo i{
    margin-right: 5px;;
}
.companyinfo div,
.companyinfo span{
    font-size: 16px;
}
.ad-card:deep(.el-card__body){
    padding: 0;
}
.map {
  width: 100%;
  height: 400px;
}
</style>