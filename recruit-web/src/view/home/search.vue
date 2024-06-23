<script setup>
import { onMounted, ref } from 'vue';
import hheader from '@/components/home/header.vue'
import { searchjobList } from '../../api/job';
import search from '../../components/home/search.vue';
import card from '../../components/home/zujian/card.vue';
import json from '@/assets/dist.json'
import searchjobcard from '../../components/home/zujian/searchjobcard.vue'
import footter from '../../components/footer.vue';
const props = defineProps({
    query: {
        type: String,
        default: ''
    }
})
const cityselected = ref('')
const cityszone = ref([])
const activaName = ref('first')
const size = ref(10)
const page = ref(1)
const joblist = ref([])
const total = ref(0)
onMounted(() => {
    searchjobList(props.query, size.value, page.value).then(res => {
        joblist.value = res.data.data
        total.value = res.data.total
    })
})
const selectcity = (city, i) => {
    cityselected.value = city
    if (city === '全国') {
        cityszone.value = []
    } else {
        if (json.filter(item => item.name === city)[0].children.slice(0, 10)[0].name != "市辖区")
            cityszone.value = json.filter(item => item.name === city)[0].children.slice(0, 10)
        else {
            cityszone.value = json.filter(item => item.name === city)[0].children.slice(0, 10)[0].children
        }
    }

}
const pagechange=(page,size)=>{
    searchjobList(props.query, size, page).then(res => {
        joblist.value = res.data.data
    })
}



</script>

<template>
    <div class="outer">
        <hheader></hheader>
        <div class="main">
            <div class="inner">
                <card style="padding: 20px;">
                    <div style="position: relative;">
                        <search style="position: relative; right: 40px;"></search>
                    </div>
                    <div>
                        <el-tabs v-model="activaName">
                            <el-tab-pane label="城市和区域" name="first">
                                <div class="zoneselector" style="padding-left: 10px;">
                                    <span @click="selectcity('全国', 0)" :class="{ 'active': cityselected === '全国' }">全国</span>
                                    <span v-for="i in json.slice(0, 10)" @click="selectcity(i.name)" :key="i.index"
                                        :class="{ 'active': cityselected === i.name }">{{ i.name }}</span>
                                    <span> 更多城市</span>
                                    <div v-if="cityselected !== '全国'" style="margin-top: 10px;">
                                        <span v-for="i in cityszone.slice(0, 10)">{{ i.name }}</span>
                                    </div>
                                </div>
                            </el-tab-pane>
                        </el-tabs>
                    </div>
                </card>
                <div class="container">
                    <searchjobcard v-for="i in joblist" :key="i.id" :job="i"></searchjobcard>
                </div>
                <div style="display: flex; justify-content: center;"> <el-pagination size="small" background
                        layout="prev, pager, next" :total="total" @change="pagechange"/></div>
            </div>
        </div>
        <footter></footter>
    </div>
</template>

<style scoped>
.outer {
    background-color: #f6f6f8;
}

.main {
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: center;
}

.inner {
    width: 1200px;

}

.zoneselector span {
    font-size: 14px;
    margin-right: 15px;
    cursor: pointer;
}

.zoneselector .active {
    color: var(--ppcolor);
}

.container {
    width: 100%;
    display: flex;
    justify-content: space-between;
    flex-wrap: wrap;
}

.container .card {
    width: 49%;
    height: 200px;
    margin-bottom: 20px;
}

.container .card:nth-child(odd) {
    margin-right: 2%;
}

.container .card:nth-child(even) {}
</style>