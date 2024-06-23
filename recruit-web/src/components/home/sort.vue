<script setup>
import { ref,onMounted } from 'vue';
import {getjobtypes} from '@/api/job';
import { useRouter } from 'vue-router';

import card from '@/components/home/zujian/card.vue';
const nowtypes=ref([])
const alltypes=ref([])
const length=ref(0)
onMounted(() => {
    getjobtypes().then(res => {
        alltypes.value=res.data
        length.value= res.data.length
        // 取alltype前五项
        nowtypes.value=alltypes.value.slice(0,10)
    })
})
const changepage=(page,index)=>{
    nowtypes.value=alltypes.value.slice((page-1)*10,page*10)
    console.log(page,index)
}
const router = useRouter();
const search=(type)=>{
    router.push({
        path:'/search',
        query:{
            query:type
        }
    })
}
</script>


<template>
    <card style="width: 400px;">
        <div style="font-size: 14px; " class="fenleicontainer" v-for="type in nowtypes"><span @click="search(type.name)">{{ type.name }}</span></div>
        <div style="position: absolute; bottom: 5px;">
            <el-pagination size="small" layout="prev, pager, next" :total="length" :page-size="10" @change="changepage"></el-pagination>
            </div>
    </card>
</template>

<style scoped>
.card {
    padding: 20px 20px 0 30px;
    border-radius: 12px;
    height:400px ;
    position: relative;
}

.fenleicontainer {
    height: 25px;
    border-radius: 10px;
    background-color: #fff;
    margin-bottom: 10px;
}
span{
    font-size: 14px;
    cursor: pointer;
}
span:hover{
    color: var(--ppcolor);
}
</style>