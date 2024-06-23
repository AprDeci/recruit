<script setup>
import { ref } from 'vue';
import {useRouter} from 'vue-router'
const router=useRouter()

const input = ref('');
const search=()=>{
    router.push({path:'/search',query:{query:input.value}})
}
</script>
<template>
    <div>
    <el-input
    class="selectinput"
    v-model="input"
    style="width: 700px;"
    size="large"
    placeholder="输入想要的工作"
    clearable
    @keydown.enter="search"
    />
    <el-button style="padding: 25px 40px; position: relative; bottom: 4px; right: 10px;" color="#626aef" size="large" @click='search' >search</el-button>
</div>
<div class="tags">
    <el-tag type="primary" @click="handleClick" >JAVA</el-tag>
    <el-tag type="success">C++</el-tag>
    <el-tag type="info">Python</el-tag>
    <el-tag type="warning">Dart</el-tag>
    <el-tag type="danger">Golang</el-tag>
  </div>
</template>

<style scoped>
    div{
        display: flex;
        justify-content: center;
        align-items: center;
        margin-bottom: 10px;
    }
    .selectinput:deep .el-input__wrapper{
        height: 48px;
    }
    div.tags{
        position: relative;
        display: flex;
        right: 100px;
        /* 调整每个元素之间的间距 */
        gap: 10px;

    }
</style>