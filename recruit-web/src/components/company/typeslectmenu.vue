<script setup>
import card from '@/components/home/zujian/card.vue';
import { getJobtypesByCompanyIdService } from '../../api/job';
import { onMounted, ref } from 'vue';
const props=defineProps({
    id:{
        type:String,
        required:true
    }
})
const types=ref([])
onMounted(() => {
    getJobtypesByCompanyIdService(props.id).then(res=>{
        types.value=res.data
    })
})
</script>

<template>
<card style="padding: 10px 20px;">
    <div style="display: flex;">
        <div style="font-weight: 500;flex-shrink: 0;margin-right: 20px;color: #464644;">
            职位类型
        </div>
        <div style="display: flex; flex-wrap: wrap; gap: 20px;">
        <routerLink class="routerlink" :to="`/company/jobs/`+id+`/type/`">全部</routerLink>
        <routerLink class="routerlink" :to="`/company/jobs/`+id+`/type/`+type.id" v-for="type in types">{{ type.name }}({{ type.count }})</routerLink>
    </div>
    </div>
</card>
</template>

<style scoped>
.routerlink{
    text-decoration: none;
    color: #696969;
    font-size: 14px;
    font-weight: 400;
    margin-right: 10px;

}

.el-input .el-input__inner {

font-size: 12px;

font-weight: bolder;

padding: 0 4px;

}
</style>