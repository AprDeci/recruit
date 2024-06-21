<script setup>
import hotcompanycard from './zujian/hotcompanycard.vue';
</script>


<template>
  <div>
    <div class="hotcampanycontainer">
      <hotcompanycard v-for="i in 9"></hotcompanycard>
    </div>
    <div class="morebuttondiv"><el-button plain color="#6469f5b5" size="larger" style="padding: 0 50px; height: 50px; font-weight: bold;">查看更多</el-button></div>
  </div>
</template>



<style scoped>
.hotcampanycontainer{
    display: grid;
    grid-template-columns: repeat(3,1fr);
    grid-gap: 20px;
}
.morebuttondiv{
    display: flex;
    justify-content: center;
    margin-top: 20px;
    color: #6469f5b5;
}
</style>