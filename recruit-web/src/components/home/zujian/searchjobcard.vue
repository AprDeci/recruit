<script setup>
import {ref,onMounted} from 'vue'
import card from './card.vue';
import { useRouter } from 'vue-router';
const router = useRouter();
const props = defineProps({
    job: Object,
})
const tags = ref([])
const salary = ref('')

const gettags = () => {
    const requirements = props.job.requirements;
    const requirementArray = requirements.split(',');
    tags.value = requirementArray;
    const maxSalary = Math.floor(props.job.maxSalary / 1000);
    const minSalary = Math.floor(props.job.minSalary / 1000);
    const salaryRange = `${minSalary}K-${maxSalary}K`;
    salary.value = salaryRange;
}
onMounted(()=>{
    gettags();
})

const getjobdetials = (id) => {
    router.push(
         '/job_detail/'+id,
    )
}
</script>

<template>

    <card class="jobcard" style="padding: 20px;position: relative;" @click="getjobdetials(job.id)">
        <div>
           <span style="margin-right: 10px; "> {{ job.title }}</span>
            <span style="color: var(--salary-color);">{{ salary }}</span>
            <div class="infocontainer" style="margin-top: 20px;">
                <span >截止日期{{ job.postingDate }}</span>
                <span>本科</span>
                <span>3-5年</span>    
                <div style="margin-top: 2ch;">
                <i style="font-size: 14px; color: var(--ppcolor); margin-right: 10px;" class="iconfont">&#xe957;</i>
                <span>李先生</span>
            </div>
            <div style="position: absolute; right: 10px; top: 20px;">
                <i style="font-size: 36px; color: var(--ppcolor);" class="iconfont">&#xe838;</i>
                <span style="font-size: 22px;">公司</span>
            </div>
            </div>

        </div>
        <div class="foot">
            <span v-for="tag in tags" :key="tag">{{ tag }}</span>
        </div>
    </card>

</template>

<style scoped>
.card:hover{
    box-shadow: 3px 0px 20px 0px #00000059;
    cursor: pointer;
}
.foot{
    box-sizing: border-box;
    left:0;
    width: 100%;
    position: absolute;
    bottom: 0;
    padding: 10px;
    border-radius: 5px;
    background:linear-gradient(90deg,#f5fcfc,#fcfbfa) ;
    border: 1px solid var(--card-color);
    box-shadow: 0 0 5px var(--card-color);
    padding-left: 20px;
}
.foot span{
    margin-right:8px;
    font-size: 14px;
    color: gray;
}
.infocontainer span{
    font-size: 14px;
    margin-right: 10px;
    background-color: #f5fcfc;
}
</style>